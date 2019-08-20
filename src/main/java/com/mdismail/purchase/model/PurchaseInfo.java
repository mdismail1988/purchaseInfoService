package com.mdismail.purchase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE_INFO")
public class PurchaseInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseInfoId;
	
	@Column(name="PRODUCT_ID")
	private int productId;
	
	@Column(name="PRODUCT_CD")
	private String productCode;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	
	@Column(name="QTY")
	private int qty;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPurchaseInfoId() {
		return purchaseInfoId;
	}
	public void setPurchaseInfoId(int purchaseInfoId) {
		this.purchaseInfoId = purchaseInfoId;
	}
	
	public PurchaseInfo() {
	}
	
	public PurchaseInfo(int productId, String productCode,String productName ,int customerId, String customerName, double unitPrice,int qty) {
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.customerId = customerId;
		this.customerName = customerName;
		this.unitPrice = unitPrice;
		this.qty=qty;
	}
	
}
