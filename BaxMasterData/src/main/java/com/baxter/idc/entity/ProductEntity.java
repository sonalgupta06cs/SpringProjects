package com.baxter.idc.entity;

public class ProductEntity {
	
	private String GTIN;
	private String drugName;
	private String manufacturer;
	private String dosageForm;
	private String strength;
	private String containerSize;
	private String packageType;
	private String ndc;
	private String longItemNumber;
	private int shortItemNumber;
	private String description;
	private String productCode;
	
	public String getGTIN() {
		return GTIN;
	}
	public void setGTIN(String gTIN) {
		GTIN = gTIN;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDosageForm() {
		return dosageForm;
	}
	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(String containerSize) {
		this.containerSize = containerSize;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getNdc() {
		return ndc;
	}
	public void setNdc(String ndc) {
		this.ndc = ndc;
	}
	public String getLongItemNumber() {
		return longItemNumber;
	}
	public void setLongItemNumber(String longItemNumber) {
		this.longItemNumber = longItemNumber;
	}
	public int getShortItemNumber() {
		return shortItemNumber;
	}
	public void setShortItemNumber(int shortItemNumber) {
		this.shortItemNumber = shortItemNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}	
		
}
