package com.lihui.hibernate.single_n_n;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Integer categoryId;
	private String catregoryName;
	
	private Set<Item> items = new HashSet<Item>();

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCatregoryName() {
		return catregoryName;
	}

	public void setCatregoryName(String catregoryName) {
		this.catregoryName = catregoryName;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
	
}
