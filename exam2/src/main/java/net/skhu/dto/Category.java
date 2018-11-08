package net.skhu.dto;

import java.io.Serializable;

public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	int id;
	String categoryName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
