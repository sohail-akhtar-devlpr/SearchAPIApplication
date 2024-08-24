package com.search.suppliers.entity;

import java.util.Set;

//if i was using a database, then i have to make it as Entity.
public class Supplier {
	
	private String supplierId;
	private String companyName;
	private String website;
	private String location;
	private String natureOfBusiness;
	private Set<String> manufacturingProcesses;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierId, String companyName, String website, String location, String natureOfBusiness,
			Set<String> manufacturingProcesses) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.website = website;
		this.location = location;
		this.natureOfBusiness = natureOfBusiness;
		this.manufacturingProcesses = manufacturingProcesses;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(String natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public Set<String> getManufacturingProcesses() {
		return manufacturingProcesses;
	}

	public void setManufacturingProcesses(Set<String> manufacturingProcesses) {
		this.manufacturingProcesses = manufacturingProcesses;
	}
	
}
