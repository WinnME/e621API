package de.furryhome.e621api;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class postObject {
	private final String baseurl = "http://www.e621.net";
	private int
		file_size, id, parent_id, creator_id, height, width, sample_height, sample_width, preview_height, preview_width, change, score;
	private String
		md5, file_url, sample_url, preview_url, status, source, rating, tags, created_at, author;
	private boolean
		has_children, has_notes, has_comments;
	private boolean
		file_size_set = false, md5_set = false, id_set = false, parent_id_set = false, creator_id_set = false, height_set = false, width_set = false,
		file_url_set = false, sample_height_set = false, sample_width_set = false, sample_url_set = false, preview_height_set = false,
		preview_width_set = false, preview_url_set = false, has_children_set = false, has_notes_set = false, has_comments_set = false,
		status_set = false, source_set = false, rating_set = false, tags_set = false, created_at_set = false, author_set = false, change_set = false,
		score_set = false;

	public void setFile_size(int file_size) throws postObjectException {
		if (!file_size_set) {
			this.file_size = file_size;
			file_size_set=true;
		} else {
			throw new postObjectException("File_size was already initialized");
		}
	}
	public void setMd5(String md5) throws postObjectException {
		if (!md5_set) {
			this.md5 = md5;
			md5_set=true;
		} else {
			throw new postObjectException("Md5 was already initialized");
		}
	}
	public void setId(int id) throws postObjectException {
		if (!id_set) {
			this.id = id;
			id_set=true;
		} else {
			throw new postObjectException("Id was already initialized");
		}
	}
	public void setParent_id(int id) throws postObjectException {
		if (!parent_id_set) {
			this.parent_id = id;
			parent_id_set=true;
		} else {
			throw new postObjectException("Parent_id was already initialized");
		}
	}
	public void setCreator_id(int id) throws postObjectException {
		if (!creator_id_set) {
			this.creator_id = id;
			creator_id_set=true;
		} else {
			throw new postObjectException("Creator_id was already initialized");
		}
	}
	public void setFile_url(String file_url) throws postObjectException {
		if (!file_url_set) {
			this.file_url = file_url;
			file_url_set=true;
		} else {
			throw new postObjectException("File_url was already initialized");
		}
	}
	public void setSample_url(String sample_url) throws postObjectException {
		if (!sample_url_set) {
			this.sample_url = sample_url;
			sample_url_set=true;
		} else {
			throw new postObjectException("Sample_url was already initialized");
		}
	}
	public void setPreview_url(String preview_url) throws postObjectException {
		if (!preview_url_set) {
			this.preview_url = preview_url;
			preview_url_set=true;
		} else {
			throw new postObjectException("Preview_url was already initialized");
		}
	}
	public void setStatus(String status) throws postObjectException {
		if (!status_set) {
			this.status = status;
			status_set=true;
		} else {
			throw new postObjectException("Status was already initialized");
		}
	}
	public void setSource(String source) throws postObjectException {
		if (!source_set) {
			this.source = source;
			source_set=true;
		} else {
			throw new postObjectException("Source was already initialized");
		}
	}
	public void setRating(String rating) throws postObjectException {
		if (!rating_set) {
			this.rating = rating;
			rating_set=true;
		} else {
			throw new postObjectException("Rating was already initialized");
		}
	}
	public void setTags(String tags) throws postObjectException {
		if (!tags_set) {
			this.tags = tags;
			tags_set=true;
		} else {
			throw new postObjectException("Tags was already initialized");
		}
	}
	public void setCreated_at(String created_at) throws postObjectException {
		if (!created_at_set) {
			this.created_at = created_at;
			created_at_set=true;
		} else {
			throw new postObjectException("Created_at was already initialized");
		}
	}
	public void setAuthor(String author) throws postObjectException {
		if (!author_set) {
			this.author = author;
			author_set=true;
		} else {
			throw new postObjectException("Author was already initialized");
		}
	}
	public void setChange(int change) throws postObjectException {
		if (!change_set) {
			this.change = change;
			change_set=true;
		} else {
			throw new postObjectException("Change was already initialized");
		}
	}
	public void setScore(int score) throws postObjectException {
		if (!score_set) {
			this.score = score;
			score_set=true;
		} else {
			throw new postObjectException("Score was already initialized");
		}
	}
	public void setHeight(int height) throws postObjectException {
		if (!height_set) {
			this.height = height;
			height_set=true;
		} else {
			throw new postObjectException("Height was already initialized");
		}
	}
	public void setWidth(int width) throws postObjectException {
		if (!width_set) {
			this.width = width;
			width_set=true;
		} else {
			throw new postObjectException("Width was already initialized");
		}
	}
	public void setSample_height(int sample_height) throws postObjectException {
		if (!sample_height_set) {
			this.sample_height = sample_height;
			sample_height_set=true;
		} else {
			throw new postObjectException("Sample_height was already initialized");
		}
	}
	public void setSample_width(int sample_width) throws postObjectException {
		if (!sample_width_set) {
			this.sample_width = sample_width;
			sample_width_set=true;
		} else {
			throw new postObjectException("Sample_width was already initialized");
		}
	}
	public void setPreview_height(int preview_height) throws postObjectException {
		if (!preview_height_set) {
			this.preview_height = preview_height;
			preview_height_set=true;
		} else {
			throw new postObjectException("Preview_height was already initialized");
		}
	}
	public void setPreview_width(int preview_width) throws postObjectException {
		if (!preview_width_set) {
			this.preview_width = preview_width;
			preview_width_set=true;
		} else {
			throw new postObjectException("Preview_width was already initialized");
		}
	}
	public void setHas_children(boolean has_children) throws postObjectException {
		if (!has_children_set) {
			this.has_children = has_children;
			has_children_set=true;
		} else {
			throw new postObjectException("Has_children was already initialized");
		}
	}
	public void setHas_notes(boolean has_notes) throws postObjectException {
		if (!has_notes_set) {
			this.has_notes = has_notes;
			has_notes_set=true;
		} else {
			throw new postObjectException("Has_notes was already initialized");
		}
	}
	public void setHas_comments(boolean has_comments) throws postObjectException {
		if (!has_comments_set) {
			this.has_comments = has_comments;
			has_comments_set=true;
		} else {
			throw new postObjectException("Has_comments was already initialized");
		}
	}
	
	public int getFile_size() throws postObjectException {
		if (file_size_set) {
			return file_size;
		} else {
			throw new postObjectException("File_size is not initialized yet");
		}
	}
	public String getMd5() throws postObjectException {
		if (md5_set) {
			return md5;
		} else {
			throw new postObjectException("Md5 is not initialized yet");
		}
	}
	public int getId() throws postObjectException {
		if (id_set) {
			return id;
		} else {
			throw new postObjectException("Id is not initialized yet");
		}
	}
	public int getParent_id() throws postObjectException {
		if (parent_id_set) {
			return parent_id;
		} else {
			throw new postObjectException("Parent_id is not initialized yet");
		}
	}
	public int getCreator_id() throws postObjectException {
		if (creator_id_set) {
			return creator_id;
		} else {
			throw new postObjectException("Creator_id is not initialized yet");
		}
	}
	public String getFile_url() throws postObjectException {
		if (file_url_set) {
			return file_url;
		} else {
			throw new postObjectException("File_url is not initialized yet");
		}
	}
	public String getSample_url() throws postObjectException {
		if (sample_url_set) {
			return sample_url;
		} else {
			throw new postObjectException("Sample_url is not initialized yet");
		}
	}
	public String getPreview_url() throws postObjectException {
		if (preview_url_set) {
			return preview_url;
		} else {
			throw new postObjectException("Preview_url is not initialized yet");
		}
	}
	public String getStatus() throws postObjectException {
		if (status_set) {
			return status;
		} else {
			throw new postObjectException("Status is not initialized yet");
		}
	}
	public String getSource() throws postObjectException {
		if (source_set) {
			return source;
		} else {
			throw new postObjectException("Source is not initialized yet");
		}
	}
	public String getRating() throws postObjectException {
		if (rating_set) {
			return rating;
		} else {
			throw new postObjectException("Rating is not initialized yet");
		}
	}
	public String getTags() throws postObjectException {
		if (tags_set) {
			return tags;
		} else {
			throw new postObjectException("Tags is not initialized yet");
		}
	}
	public String getCreated_at() throws postObjectException {
		if (created_at_set) {
			return created_at;
		} else {
			throw new postObjectException("Created_at is not initialized yet");
		}
	}
	public String getAuthor() throws postObjectException {
		if (author_set) {
			return author;
		} else {
			throw new postObjectException("Author is not initialized yet");
		}
	}
	public int getChange() throws postObjectException {
		if (change_set) {
			return change;
		} else {
			throw new postObjectException("Change is not initialized yet");
		}
	}
	public int getScore() throws postObjectException {
		if (score_set) {
			return score;
		} else {
			throw new postObjectException("Score is not initialized yet");
		}
	}
	public int getHeight() throws postObjectException {
		if (height_set) {
			return height;
		} else {
			throw new postObjectException("Height is not initialized yet");
		}
	}
	public int getWidth() throws postObjectException {
		if (width_set) {
			return width;
		} else {
			throw new postObjectException("Width is not initialized yet");
		}
	}
	public int getSample_height() throws postObjectException {
		if (sample_height_set) {
			return sample_height;
		} else {
			throw new postObjectException("Sample_height is not initialized yet");
		}
	}
	public int getSample_width() throws postObjectException {
		if (sample_width_set) {
			return sample_width;
		} else {
			throw new postObjectException("Sample_width is not initialized yet");
		}
	}
	public int getPreview_height() throws postObjectException {
		if (preview_height_set) {
			return preview_height;
		} else {
			throw new postObjectException("Preview_height is not initialized yet");
		}
	}
	public int getPreview_width() throws postObjectException {
		if (preview_width_set) {
			return preview_width;
		} else {
			throw new postObjectException("Preview_width is not initialized yet");
		}
	}
	public boolean isHas_children() throws postObjectException {
		if (has_children_set) {
			return has_children;
		} else {
			throw new postObjectException("Has_children is not initialized yet");
		}
	}
	public boolean isHas_notes() throws postObjectException {
		if (has_notes_set) {
			return has_notes;
		} else {
			throw new postObjectException("Has_notes is not initialized yet");
		}
	}
	public boolean isHas_comments() throws postObjectException {
		if (has_comments_set) {
			return has_comments;
		} else {
			throw new postObjectException("Has_comments is not initialized yet");
		}
	}

	public InputStream getImage() {
		HttpParams params = new BasicHttpParams();
			
		params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, false);
		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		    
		HttpClient httpclient = new DefaultHttpClient(params);
		HttpGet httpget;
		try {
			System.out.println("GET: " + baseurl + this.getFile_url());
			httpget = new HttpGet(baseurl + this.getFile_url());
		} catch (postObjectException e1) {
			e1.printStackTrace();
			return null;
		}
		    
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
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
}
