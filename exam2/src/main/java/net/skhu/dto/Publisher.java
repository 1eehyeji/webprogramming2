package net.skhu.dto;

import java.io.Serializable;

public class Publisher implements Serializable{

	private static final long serialVersionUID = 1L;

	int id;
	String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
