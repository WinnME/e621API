package de.furryhome.e621api;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.furryhome.e621api.Exceptions.postObjectException;

class ListParser extends DefaultHandler {
	private ArrayList<ListItem> postList;
	private ListItem post;
	private int count, offset;
	
	public ListParser() {
		super();
	}

	public void startDocument() throws SAXException {
		super.startDocument();
		postList = new ArrayList<ListItem>();
	}
	
	public void startElement (String uri, String name, String qName, Attributes atts) {
		if (name == "posts") {
			try {
				this.count = Integer.valueOf(atts.getValue("count"));
			} catch (NumberFormatException e) {
				this.count = 0;
			}
			try {
				this.offset = Integer.valueOf(atts.getValue("offset"));
			} catch (NumberFormatException e) {
				this.offset = 0;
			}
		}
		
		if (name == "post") {
			post = new ListItem();
			try {
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
	}
	
	protected final ArrayList<ListItem> getListObject() {
		return postList;
	}
	
	protected final int getCount() {
		return count;
	}
	
	protected final int getOffset() {
		return offset;
	}
	
}
