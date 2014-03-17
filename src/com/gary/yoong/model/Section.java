package com.gary.yoong.model;

public class Section {
	
	public static final String GENERAL = "GENERAL";
	public static final String CONTACT = "CONTACT";
	public static final String WORK_EXPERIENCE = "WORK_EXPERIENCE";

	
	private String title;
	private String description;
	private String id;
	private String type;
	private int icon;
	
	public Section (String title, String description, String type, int icon) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.icon = icon;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String toString () {
		return this.title;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	

}
