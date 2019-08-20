package com.mdismail.purchase.dao;

import com.mdismail.purchase.model.PurchaseInfo;

public interface PurchaseInfoDAO {
	
	void addPurchaseInfo(PurchaseInfo purchaseInfoDAO) throws Exception ;
	PurchaseInfo getPurchaseInfoByProdCd(String productCode) throws Exception;

}
