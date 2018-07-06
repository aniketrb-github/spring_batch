package com.techprimers.springbatchexample1.dto;

import java.util.List;

public class ConnectBooksResponseDTO {
	private Integer numItems;	
	private Integer page;
	private Integer perPage;
	private Integer totalPages;
	private List<ConnectBooksDTO> items;
	
	public Integer getNumItems() {
		return numItems;
	}
	public void setNumItems(Integer numItems) {
		this.numItems = numItems;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPerPage() {
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public List<ConnectBooksDTO> getItems() {
		return items;
	}
	public void setItems(List<ConnectBooksDTO> items) {
		this.items = items;
	}
	
}
