package com.mdismail.purchase.service;

import com.mdismail.purchase.model.PurchaseInfo;

public interface PurchaseInfoService {
	
	 void addPurchaseInfo(PurchaseInfo purchaseInfo)  throws Exception;
	 PurchaseInfo getPurchaseInfoByProdCd(String productCode)  throws Exception;

}
