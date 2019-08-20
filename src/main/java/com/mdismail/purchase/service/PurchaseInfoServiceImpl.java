package com.mdismail.purchase.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdismail.purchase.dao.PurchaseInfoDAO;
import com.mdismail.purchase.model.PurchaseInfo;

@Service
@Transactional
public class PurchaseInfoServiceImpl implements PurchaseInfoService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PurchaseInfoDAO  purchaseInfoDAO;

	@Override
	public void addPurchaseInfo(PurchaseInfo purchaseInfo)  throws Exception {
		try {
			purchaseInfoDAO.addPurchaseInfo(purchaseInfo);
		}catch(Exception se) {
			LOGGER.error("getPurchaseInfoByProdCd Service Exception :"+se.getMessage());
			throw new Exception(se);
				
		}
	}

	@Override
	public PurchaseInfo getPurchaseInfoByProdCd(String productCode) throws Exception {
		try {
			return purchaseInfoDAO.getPurchaseInfoByProdCd(productCode);
		}catch(Exception se) {
			LOGGER.error("getPurchaseInfoByProdCd Service Exception :"+se.getMessage());
			throw new Exception(se);
			
		}
	}

}
