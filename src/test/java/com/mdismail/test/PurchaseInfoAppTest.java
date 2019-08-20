package com.mdismail.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.mdismail.purchase.dao.PurchaseInfoDAO;
import com.mdismail.purchase.model.PurchaseInfo;
import com.mdismail.purchase.service.PurchaseInfoService;
import com.mdismail.purchase.service.PurchaseInfoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseInfoAppTest {
	
	@InjectMocks
	private PurchaseInfoService purchaseInfoService = new PurchaseInfoServiceImpl();
	
	@Mock
	private PurchaseInfoDAO purchaseInfoDAO;
	

	
	@Test
	public void contextLoads() {
	}
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void addPurchaseInfoTest() {
		try {
			PurchaseInfo purchaseInfo = new PurchaseInfo(1,"PD0001","SHIRT",534,"Ismail",500.00,1);
			purchaseInfoService.addPurchaseInfo(purchaseInfo);
			PurchaseInfo purchaseInfo2 = purchaseInfoService.getPurchaseInfoByProdCd("PD0001");
			assertNotNull(purchaseInfo);
			assertEquals(purchaseInfo.getProductName(), purchaseInfo2.getProductName());
		}catch(Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
	}

}
