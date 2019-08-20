package com.mdismail.purchase.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mdismail.purchase.model.PurchaseInfo;

@Repository
public class PurchaseInfoDAOImpl implements PurchaseInfoDAO {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public void addPurchaseInfo(PurchaseInfo purchaseInfo) throws Exception {
		try {
			LOGGER.info("Adding purcase info");
			entityManager.persist(purchaseInfo);
		}catch(Exception se) {
			LOGGER.error("addPurchaseInfo Exception :"+se.getMessage());
			throw new Exception(se);
			
		}
	}
	
	@Override
    public PurchaseInfo getPurchaseInfoByProdCd(String productCode) throws Exception {
		try {
			return entityManager.find(PurchaseInfo.class, productCode);
		}catch(Exception se) {
			LOGGER.error("getPurchaseInfoByProdCd Exception :"+se.getMessage());
			throw new Exception(se);
			
		}
    }

}
