package com.techprimers.springbatchexample1.dto;

import java.util.List;

public class BookVariantDTO {
	private String duration;
	private Integer onlineDuration;
	private String sku;
	private String type;
	private Boolean isDistributable;
	private List<BookPriceDTO> prices;
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getOnlineDuration() {
		return onlineDuration;
	}
	public void setOnlineDuration(Integer onlineDuration) {
		this.onlineDuration = onlineDuration;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIsDistributable() {
		return isDistributable;
	}
	public void setIsDistributable(Boolean isDistributable) {
		this.isDistributable = isDistributable;
	}
	public List<BookPriceDTO> getPrices() {
		return prices;
	}
	public void setPrices(List<BookPriceDTO> prices) {
		this.prices = prices;
	}
}
