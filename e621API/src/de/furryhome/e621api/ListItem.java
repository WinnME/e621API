package de.furryhome.e621api;

import de.furryhome.e621api.Exceptions.PostObjectException;

public final class ListItem {
	private int
		id, parent_id, creator_id, height, width, sample_height, sample_width, preview_height, preview_width, change, score;
	private String
		md5, file_url, sample_url, preview_url, status, source, rating, tags, created_at, author;
	private boolean
		has_children, has_notes, has_comments;
	private boolean
		md5_set = false, id_set = false, parent_id_set = false, creator_id_set = false, height_set = false, width_set = false,
		file_url_set = false, sample_height_set = false, sample_width_set = false, sample_url_set = false, preview_height_set = false,
		preview_width_set = false, preview_url_set = false, has_children_set = false, has_notes_set = false, has_comments_set = false,
		status_set = false, source_set = false, rating_set = false, tags_set = false, created_at_set = false, author_set = false, change_set = false,
		score_set = false;

	protected final void setMd5(String md5) throws PostObjectException {
		if (!md5_set) {
			this.md5 = md5;
			md5_set=true;
		} else {
			throw new PostObjectException("Md5 was already initialized");
		}
	}
	protected final void setId(int id) throws PostObjectException {
		if (!id_set) {
			this.id = id;
			id_set=true;
		} else {
			throw new PostObjectException("Id was already initialized");
		}
	}
	protected final void setParent_id(int id) throws PostObjectException {
		if (!parent_id_set) {
			this.parent_id = id;
			parent_id_set=true;
		} else {
			throw new PostObjectException("Parent_id was already initialized");
		}
	}
	protected final void setCreator_id(int id) throws PostObjectException {
		if (!creator_id_set) {
			this.creator_id = id;
			creator_id_set=true;
		} else {
			throw new PostObjectException("Creator_id was already initialized");
		}
	}
	protected final void setFile_url(String file_url) throws PostObjectException {
		if (!file_url_set) {
			this.file_url = file_url;
			file_url_set=true;
		} else {
			throw new PostObjectException("File_url was already initialized");
		}
	}
	protected final void setSample_url(String sample_url) throws PostObjectException {
		if (!sample_url_set) {
			this.sample_url = sample_url;
			sample_url_set=true;
		} else {
			throw new PostObjectException("Sample_url was already initialized");
		}
	}
	protected final void setPreview_url(String preview_url) throws PostObjectException {
		if (!preview_url_set) {
			this.preview_url = preview_url;
			preview_url_set=true;
		} else {
			throw new PostObjectException("Preview_url was already initialized");
		}
	}
	protected final void setStatus(String status) throws PostObjectException {
		if (!status_set) {
			this.status = status;
			status_set=true;
		} else {
			throw new PostObjectException("Status was already initialized");
		}
	}
	protected final void setSource(String source) throws PostObjectException {
		if (!source_set) {
			this.source = source;
			source_set=true;
		} else {
			throw new PostObjectException("Source was already initialized");
		}
	}
	protected final void setRating(String rating) throws PostObjectException {
		if (!rating_set) {
			this.rating = rating;
			rating_set=true;
		} else {
			throw new PostObjectException("Rating was already initialized");
		}
	}
	protected final void setTags(String tags) throws PostObjectException {
		if (!tags_set) {
			this.tags = tags;
			tags_set=true;
		} else {
			throw new PostObjectException("Tags was already initialized");
		}
	}
	protected final void setCreated_at(String created_at) throws PostObjectException {
		if (!created_at_set) {
			this.created_at = created_at;
			created_at_set=true;
		} else {
			throw new PostObjectException("Created_at was already initialized");
		}
	}
	protected final void setAuthor(String author) throws PostObjectException {
		if (!author_set) {
			this.author = author;
			author_set=true;
		} else {
			throw new PostObjectException("Author was already initialized");
		}
	}
	protected final void setChange(int change) throws PostObjectException {
		if (!change_set) {
			this.change = change;
			change_set=true;
		} else {
			throw new PostObjectException("Change was already initialized");
		}
	}
	protected final void setScore(int score) throws PostObjectException {
		if (!score_set) {
			this.score = score;
			score_set=true;
		} else {
			throw new PostObjectException("Score was already initialized");
		}
	}
	protected final void setHeight(int height) throws PostObjectException {
		if (!height_set) {
			this.height = height;
			height_set=true;
		} else {
			throw new PostObjectException("Height was already initialized");
		}
	}
	protected final void setWidth(int width) throws PostObjectException {
		if (!width_set) {
			this.width = width;
			width_set=true;
		} else {
			throw new PostObjectException("Width was already initialized");
		}
	}
	protected final void setSample_height(int sample_height) throws PostObjectException {
		if (!sample_height_set) {
			this.sample_height = sample_height;
			sample_height_set=true;
		} else {
			throw new PostObjectException("Sample_height was already initialized");
		}
	}
	protected final void setSample_width(int sample_width) throws PostObjectException {
		if (!sample_width_set) {
			this.sample_width = sample_width;
			sample_width_set=true;
		} else {
			throw new PostObjectException("Sample_width was already initialized");
		}
	}
	protected final void setPreview_height(int preview_height) throws PostObjectException {
		if (!preview_height_set) {
			this.preview_height = preview_height;
			preview_height_set=true;
		} else {
			throw new PostObjectException("Preview_height was already initialized");
		}
	}
	protected final void setPreview_width(int preview_width) throws PostObjectException {
		if (!preview_width_set) {
			this.preview_width = preview_width;
			preview_width_set=true;
		} else {
			throw new PostObjectException("Preview_width was already initialized");
		}
	}
	protected final void setHas_children(boolean has_children) throws PostObjectException {
		if (!has_children_set) {
			this.has_children = has_children;
			has_children_set=true;
		} else {
			throw new PostObjectException("Has_children was already initialized");
		}
	}
	protected final void setHas_notes(boolean has_notes) throws PostObjectException {
		if (!has_notes_set) {
			this.has_notes = has_notes;
			has_notes_set=true;
		} else {
			throw new PostObjectException("Has_notes was already initialized");
		}
	}
	protected final void setHas_comments(boolean has_comments) throws PostObjectException {
		if (!has_comments_set) {
			this.has_comments = has_comments;
			has_comments_set=true;
		} else {
			throw new PostObjectException("Has_comments was already initialized");
		}
	}
	
	public final String getMd5() throws PostObjectException {
		if (md5_set) {
			return md5;
		} else {
			throw new PostObjectException("Md5 is not initialized yet");
		}
	}
	public final int getId() throws PostObjectException {
		if (id_set) {
			return id;
		} else {
			throw new PostObjectException("Id is not initialized yet");
		}
	}
	public final int getParent_id() throws PostObjectException {
		if (parent_id_set) {
			return parent_id;
		} else {
			throw new PostObjectException("Parent_id is not initialized yet");
		}
	}
	public final int getCreator_id() throws PostObjectException {
		if (creator_id_set) {
			return creator_id;
		} else {
			throw new PostObjectException("Creator_id is not initialized yet");
		}
	}
	public final String getFile_url() throws PostObjectException {
		if (file_url_set) {
			return file_url;
		} else {
			throw new PostObjectException("File_url is not initialized yet");
		}
	}
	public final String getSample_url() throws PostObjectException {
		if (sample_url_set) {
			return sample_url;
		} else {
			throw new PostObjectException("Sample_url is not initialized yet");
		}
	}
	public final String getPreview_url() throws PostObjectException {
		if (preview_url_set) {
			return preview_url;
		} else {
			throw new PostObjectException("Preview_url is not initialized yet");
		}
	}
	public final String getStatus() throws PostObjectException {
		if (status_set) {
			return status;
		} else {
			throw new PostObjectException("Status is not initialized yet");
		}
	}
	public final String getSource() throws PostObjectException {
		if (source_set) {
			return source;
		} else {
			throw new PostObjectException("Source is not initialized yet");
		}
	}
	public final String getRating() throws PostObjectException {
		if (rating_set) {
			return rating;
		} else {
			throw new PostObjectException("Rating is not initialized yet");
		}
	}
	public final String getTags() throws PostObjectException {
		if (tags_set) {
			return tags;
		} else {
			throw new PostObjectException("Tags is not initialized yet");
		}
	}
	public final String getCreated_at() throws PostObjectException {
		if (created_at_set) {
			return created_at;
		} else {
			throw new PostObjectException("Created_at is not initialized yet");
		}
	}
	public final String getAuthor() throws PostObjectException {
		if (author_set) {
			return author;
		} else {
			throw new PostObjectException("Author is not initialized yet");
		}
	}
	public final int getChange() throws PostObjectException {
		if (change_set) {
			return change;
		} else {
			throw new PostObjectException("Change is not initialized yet");
		}
	}
	public final int getScore() throws PostObjectException {
		if (score_set) {
			return score;
		} else {
			throw new PostObjectException("Score is not initialized yet");
		}
	}
	public final int getHeight() throws PostObjectException {
		if (height_set) {
			return height;
		} else {
			throw new PostObjectException("Height is not initialized yet");
		}
	}
	public final int getWidth() throws PostObjectException {
		if (width_set) {
			return width;
		} else {
			throw new PostObjectException("Width is not initialized yet");
		}
	}
	public final int getSample_height() throws PostObjectException {
		if (sample_height_set) {
			return sample_height;
		} else {
			throw new PostObjectException("Sample_height is not initialized yet");
		}
	}
	public final int getSample_width() throws PostObjectException {
		if (sample_width_set) {
			return sample_width;
		} else {
			throw new PostObjectException("Sample_width is not initialized yet");
		}
	}
	public final int getPreview_height() throws PostObjectException {
		if (preview_height_set) {
			return preview_height;
		} else {
			throw new PostObjectException("Preview_height is not initialized yet");
		}
	}
	public final int getPreview_width() throws PostObjectException {
		if (preview_width_set) {
			return preview_width;
		} else {
			throw new PostObjectException("Preview_width is not initialized yet");
		}
	}
	public final boolean isHas_children() throws PostObjectException {
		if (has_children_set) {
			return has_children;
		} else {
			throw new PostObjectException("Has_children is not initialized yet");
		}
	}
	public final boolean isHas_notes() throws PostObjectException {
		if (has_notes_set) {
			return has_notes;
		} else {
			throw new PostObjectException("Has_notes is not initialized yet");
		}
	}
	public final boolean isHas_comments() throws PostObjectException {
		if (has_comments_set) {
			return has_comments;
		} else {
			throw new PostObjectException("Has_comments is not initialized yet");
		}
	}
}
