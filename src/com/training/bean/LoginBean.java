package com.training.bean;

public class LoginBean {
	private String productName;
	private String model;
	private String price;
	private String quantity;
	private String metatag;
	
	
	

	public LoginBean() {
	}

	public LoginBean(String productName, String model,String price,String quantity,String metatag) {
		super();
		this.productName = productName;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
		this.metatag = metatag;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getMetatag() {
		return metatag;
	}

	public void setMetatag(String metatag) {
		this.metatag = metatag;
	}

	@Override
	public String toString() {
		return "LoginBean [productName=" + productName + ", model=" + model + ",price=" + price + " , quantity=" + productName + ",metatag=" + metatag + " ]";
	}

}
