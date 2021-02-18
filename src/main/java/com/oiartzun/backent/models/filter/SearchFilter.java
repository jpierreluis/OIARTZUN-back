package com.oiartzun.backent.models.filter;

import java.io.Serializable;

public class SearchFilter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String filter;
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
}
