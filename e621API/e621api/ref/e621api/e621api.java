package de.furryhome.e621api;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

public class e621api {
	public static enum Type {List, Post}
	private static final String postUrl = "http://www.e621.net/post/show.xml";
	private static final String listUrl = "http://www.e621.net/post/index.xml";
	Type type;
	private int id = 0, limit = 0, page = 1;
	private String atags[] = {};
	private String stags = "", Username = "", PasswordHash = "";
	private boolean isLoginCredentialsSet = false;
	
	private List<postObject> cachedPostList = new ArrayList<postObject>();
	
	/*
	 * Konstruktoren
	 */
	public e621api(int Value, Type typeID) {
		switch(typeID) {
		case List:
			this.page = Value;
			this.type = Type.List;
			break;
		case Post:
			this.id = Value;
			this.type = Type.Post;
			break;
		}
		this.init();
	}
	public e621api(int Page, int Limit, String Tags[]) {
		this.page = Page;
		this.limit = Limit;
		this.atags = Tags;
		this.tagArraytoString();
		this.type = Type.List;
		this.init();
	}
	public e621api(int Page, int Limit, String Tags, String TagLimiter) throws e621apiObjectException {
		this.page = Page;
		this.limit = Limit;
		this.stags = Tags;
		this.tagStringtoArray(TagLimiter);
		this.type = Type.List;
		this.init();
	}
	public e621api(int Page, int Limit) {
		this.page = Page;
		this.limit = Limit;
		this.type = Type.List;
		this.init();
	}
	public e621api(int Page, String Tags[]) {
		this.page = Page;
		this.atags = Tags;
		this.tagArraytoString();
		this.type = Type.List;
		this.init();
	}
	public e621api(int Page, String Tags, String TagLimiter) throws e621apiObjectException {
		this.page = Page;
		this.stags = Tags;
		this.tagStringtoArray(TagLimiter);
		this.type = Type.List;
		this.init();
	}
	public e621api(String Tags[]) {
		this.atags = Tags;
		this.tagArraytoString();
		this.type = Type.List;
		this.init();
	}
	public e621api(String Tags, String TagLimiter) throws e621apiObjectException {
		this.stags = Tags;
		this.tagStringtoArray(TagLimiter);
		this.type = Type.List;
		this.init();
	}
	
	private void init() {
		System.out.println("e621api: init");
	}
	
	/*
	 * Getter
	 */
	public int getPostID() { return this.id; }
	public int getListPage() { return this.page; }
	public int getListLimit() { return this.limit; }
	public String[] getTagsAsArray() { return this.atags; }
	public String getTagsAsString() { return this.stags; }
	public boolean isContentCached() {
		System.out.println("e621api: Content is cached: " + !this.cachedPostList.isEmpty());
		return !this.cachedPostList.isEmpty();
	}
	public postObject GetPostObject() throws e621apiObjectException {
		this.GetPostObjecListHelper();
        return this.cachedPostList.get(0);
	}
	public postObject GetPostObject(int index) throws e621apiObjectException {
		if (type == Type.Post && index > 0) { throw new e621apiObjectException("Class was constructed to retrieve single posts, index may never be greater than 0!"); }
		if (index < 0) {throw new e621apiObjectException("Index may never be smaller than 0!");}
		this.GetPostObjecListHelper();
        return this.cachedPostList.get(index);
	}
	public List<postObject> GetPostObjectList() throws e621apiObjectException {
		this.GetPostObjecListHelper();
        return this.cachedPostList;
	}
	
	/*
	 * Setter
	 */
	public void setLogincredentials(String Username, String Password) throws e621apiObjectException {
		if (Username.length() == 0 || Password.length() == 0) { throw new e621apiObjectException("Username or password may not be empty."); }
		this.Username = Username;
		this.PasswordHash = this.HashPassword(Password);
		this.isLoginCredentialsSet = true;
	}
	public void setTags(String Tags[]) {
		this.atags = Tags;
		this.tagArraytoString();
	}
	public void setTags(String Tags, String TagLimiter) throws e621apiObjectException {
		this.stags = Tags;
		this.tagStringtoArray(TagLimiter);
	}
	
	/*
	 * öffnetliche Funktionen
	 */
	public void clearContentCache() { this.cachedPostList.clear(); }
	
	/*
	 * Helferfunktionen
	 */
	private void tagStringtoArray(String Delimiter) throws e621apiObjectException {
		if (Delimiter.length() == 0) { throw new e621apiObjectException("The tag delimiter may not be an empty string."); }
		atags =  Pattern.compile(Delimiter).split(stags);
	}
	private void tagArraytoString() {
		String out = "";
		for (int i = 0; i < atags.length; i++) {	out = out + atags[i] + " "; }
		if (out.length() > 0) {
			stags = out.substring(0, out.length() - 1);
		} else {
			stags = "";
		}
	}
	private String HashPassword(String Password) {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("ERROR: Alghorithm SHA-1 not found!");
			return "";
		}
        md.update(Password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
	private InputStream DownloadEntity(String URL, Collection<? extends NameValuePair> POSTData) {
		System.out.println("e621api: download " + URL);
		System.out.println(POSTData);
		
		List<NameValuePair> nameValuePairs;
		HttpParams params;
		HttpClient httpclient;
		HttpPost httppost;
		
		params = new BasicHttpParams();
		
		params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
	    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
	    
	    httpclient = new DefaultHttpClient(params);
	    httppost = new HttpPost(URL);
	    
	    nameValuePairs = new ArrayList<NameValuePair>();
	    if (this.isLoginCredentialsSet) {
	    	nameValuePairs.add(new BasicNameValuePair("login", this.Username));
	    	nameValuePairs.add(new BasicNameValuePair("password_hash", this.PasswordHash));
	    }
	    nameValuePairs.addAll(POSTData);
	    
	    try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println("ERROR: Coding UTF-8 not found!");
			return null;
		}
	    
	    HttpResponse response = null;
		try {
			response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    HttpEntity entity = response.getEntity();
	    if (entity != null) {
	    	try {
	    		return entity.getContent();
	    	} catch (ParseException e) {
	    		e.printStackTrace();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
		return null;
	}
	private void GetPostObjecListHelper() throws e621apiObjectException {
		System.out.println("e621api: getContenthelper");
		
		String url = "";
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		SAXParserFactory factory;
		SAXParser parser;
		PostHandler handler;
		
		if (!this.isContentCached()) {
			factory = SAXParserFactory.newInstance();
			handler = new PostHandler();
			parser = null;
			try {
				parser = factory.newSAXParser();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		
			switch (type) {
			case List:
				url = listUrl;
				nameValuePairs.add(new BasicNameValuePair("page", String.valueOf(this.page)));
				nameValuePairs.add(new BasicNameValuePair("limit", String.valueOf(this.limit)));
				nameValuePairs.add(new BasicNameValuePair("tags", this.stags));
				break;
			case Post:
				url = postUrl;
				nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(this.id)));
				break;
			}
		
			try {
				parser.parse(this.DownloadEntity(url, nameValuePairs), handler);
				this.cachedPostList = handler.getPostListObject();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private class PostHandler extends HandlerBase {
		private List<postObject> postList;
		private postObject post;
		
		@Override
		public void startDocument() throws SAXException {
			System.out.println("e621api: xml parser start");
			super.startDocument();
			postList = new ArrayList<postObject>();
		}
		@Override
		public void endDocument() throws SAXException {
			System.out.println("e621api: xml parser end");
			super.endDocument();
		}
		
		@Override
		public void startElement(String localName, AttributeList atts) throws SAXException {
			System.out.println("e621api: xml parser tag found ID " + atts.getValue("id"));
			super.startElement(localName, atts);
			post = new postObject();
			
			try {
				try {post.setFile_size(Integer.valueOf(atts.getValue("file_size")));}catch(NumberFormatException e){post.setFile_size(0);}
				try {post.setId(Integer.valueOf(atts.getValue("id")));}catch(NumberFormatException e){post.setId(0);}
				try {post.setParent_id(Integer.valueOf(atts.getValue("parent_id")));}catch(NumberFormatException e){post.setParent_id(0);}
				try {post.setCreator_id(Integer.valueOf(atts.getValue("creator_id")));}catch(NumberFormatException e){post.setCreator_id(0);}
				try {post.setHeight(Integer.valueOf(atts.getValue("height")));}catch(NumberFormatException e){post.setHeight(0);}
				try {post.setWidth(Integer.valueOf(atts.getValue("width")));}catch(NumberFormatException e){post.setWidth(0);}
				try {post.setSample_height(Integer.valueOf(atts.getValue("sample_height")));}catch(NumberFormatException e){post.setSample_height(0);}
				try {post.setSample_width(Integer.valueOf(atts.getValue("sample_width")));}catch(NumberFormatException e){post.setSample_width(0);}
				try {post.setPreview_height(Integer.valueOf(atts.getValue("preview_height")));}catch(NumberFormatException e){post.setPreview_height(0);}
				try {post.setPreview_width(Integer.valueOf(atts.getValue("preview_width")));}catch(NumberFormatException e){post.setPreview_width(0);}
				try {post.setChange(Integer.valueOf(atts.getValue("change")));}catch(NumberFormatException e){post.setChange(0);}
				try {post.setScore(Integer.valueOf(atts.getValue("score")));}catch(NumberFormatException e){post.setScore(0);}
			
				post.setMd5(atts.getValue("md5"));
				post.setFile_url(atts.getValue("file_url"));
				post.setSample_url(atts.getValue("sample_url"));
				post.setPreview_url(atts.getValue("preview_url"));
				post.setStatus(atts.getValue("status"));
				post.setSource(atts.getValue("source"));
				post.setRating(atts.getValue("rating"));
				post.setTags(atts.getValue("tags"));
				post.setCreated_at(atts.getValue("created_at"));
				post.setAuthor(atts.getValue("author"));
			
				post.setHas_children(Boolean.valueOf(atts.getValue("has_children")));
				post.setHas_notes(Boolean.valueOf(atts.getValue("has_notes")));
				post.setHas_comments(Boolean.valueOf(atts.getValue("has_comments")));
			} catch(postObjectException e) {}
			
			postList.add(post);
		}
		
		public List<postObject> getPostListObject() { return postList; }
	}
}
