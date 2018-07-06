package com.techprimers.springbatchexample1.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ConnectBooksDTO {
	private String vbid;
	private String kind;
	private List<String> identifiers;
	private String title; 
	private String format;
	private String publisher;
	private Integer edition;
	private List<ConnectBookAuthorDTO> contributors;
	private String language;
	private Date created;
	private Date offSaleDate;
	private Integer printRestrictions;
	private Integer copyRestrictions;
	private List<String> resourceLinks;
	private List<String> relatedProducts;
	private List<BookVariantDTO> variants;
	private List<String> salesRights;
	private List<String> excludeSalesRights;
	
	public String getVbid() {
		return vbid;
	}
	public void setVbid(String vbid) {
		this.vbid = vbid;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public List<String> getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(List<String> identifiers) {
		this.identifiers = identifiers;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public List<ConnectBookAuthorDTO> getContributors() {
		return contributors;
	}
	public void setContributors(List<ConnectBookAuthorDTO> contributors) {
		this.contributors = contributors;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public Integer getPrintRestrictions() {
		return printRestrictions;
	}
	public void setPrintRestrictions(Integer printRestrictions) {
		this.printRestrictions = printRestrictions;
	}
	public Integer getCopyRestrictions() {
		return copyRestrictions;
	}
	public void setCopyRestrictions(Integer copyRestrictions) {
		this.copyRestrictions = copyRestrictions;
	}
	public List<String> getResourceLinks() {
		return resourceLinks;
	}
	public void setResourceLinks(List<String> resourceLinks) {
		this.resourceLinks = resourceLinks;
	}
	public List<String> getRelatedProducts() {
		return relatedProducts;
	}
	public void setRelatedProducts(List<String> relatedProducts) {
		this.relatedProducts = relatedProducts;
	}
	public List<BookVariantDTO> getVariants() {
		return variants;
	}
	public void setVariants(List<BookVariantDTO> variants) {
		this.variants = variants;
	}
	public List<String> getSalesRights() {
		return salesRights;
	}
	public void setSalesRights(List<String> salesRights) {
		this.salesRights = salesRights;
	}
	public List<String> getExcludeSalesRights() {
		return excludeSalesRights;
	}
	public void setExcludeSalesRights(List<String> excludeSalesRights) {
		this.excludeSalesRights = excludeSalesRights;
	}
	
}
