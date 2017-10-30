package com.rawkitlabs.ibmtest.model;

import java.io.Serializable;

public class Article implements Serializable, Cloneable {
	private String year;
	private String title;
	private String link;

	public Article(String year, String title, String link) {
		this.year = year;
		this.title = title;
		this.link = link;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
