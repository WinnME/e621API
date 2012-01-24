package de.furryhome.e621api;

import java.util.regex.Pattern;

public final class List extends ApiMain {
	@SuppressWarnings("unused")
	private static final String LIST_URL = "http://www.e621.net/post/index.xml";
	private static int count = 0;
	private int limit = 10, page = 1, offset = 0;
	private String atags[] = {};
	private String stags = "";
	
	public List() {
		super();
	}
	public List(int Limit) {
		super();
		this.limit = Limit;
	}
	public List(int Limit, String Tags[]) {
		super();
		this.limit = Limit;
		this.setTags(Tags);
	}
	public List(int Limit, String Tags, String TagLimiter) throws IllegalArgumentException {
		super();
		this.limit = Limit;
		this.setTags(Tags, TagLimiter);
	}
	public List(String Tags[]) {
		super();
		this.setTags(Tags);
	}
	public List(String Tags, String TagLimiter) throws IllegalArgumentException {
		super();
		this.setTags(Tags, TagLimiter);
	}
	
	public int getCurrentPage() { return this.page; }
	public int getLastPage() { return (int)Math.ceil(getItemCount() / getItemOffset()); }
	public int getFirstPage() { return 1; }
	
	public int getListLimit() { return this.limit; }
	public int getItemCount() { return List.count; }
	public int getItemOffset() { return this.offset; }
	
	public String[] getTagsAsArray() { return this.atags; }
	public String getTagsAsString() { return this.stags; }
	
	public void setTags(String Tags[]) {
		this.atags = Tags;
		this.tagArraytoString();
	}
	public void setTags(String Tags, String TagLimiter) throws IllegalArgumentException {
		this.stags = Tags;
		this.tagStringtoArray(TagLimiter);
	}
	
	public void gotoFirstPage() { this.page = getFirstPage(); }
	public void gotoLastPage() { this.page = getLastPage(); }
	public void gotoNextPage() { this.page++; }
	public void gotoPreviousPage() { this.page--; }
	
	private void tagStringtoArray(String Delimiter) throws IllegalArgumentException {
		if (Delimiter.length() == 0) { throw new IllegalArgumentException("empty delimiter is not allowed"); }
		atags =  Pattern.compile(Delimiter).split(this.getTagsAsString());
	}
	private void tagArraytoString() {
		String out = "";
		for (int i = 0; i < this.getTagsAsArray().length; i++) { out = out + this.getTagsAsArray()[i] + " "; }
		if (out.length() > 0) {
			stags = out.substring(0, out.length() - 1);
		} else {
			stags = "";
		}
	}
}
