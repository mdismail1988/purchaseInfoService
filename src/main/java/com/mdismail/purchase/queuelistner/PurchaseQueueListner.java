package com.mdismail.purchase.queuelistner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mdismail.purchase.model.PurchaseInfo;
import com.mdismail.purchase.service.PurchaseInfoService;

@Service
public class PurchaseQueueListner {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PurchaseInfoService purchaseInfoService;
	
	/*@KafkaListener(topics = "test-topic", groupId = "group_id")
	public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }*/
	
	@KafkaListener(topics = "purchase-info-topic", groupId = "group_json",containerFactory = "purchaseInfoListenerFactory")
    public void consumePurchaseInfo(PurchaseInfo purchaseInfo) {
		try {
			LOGGER.info("Received messgae ::: Purchase Info " + purchaseInfo.getProductCode());
			purchaseInfoService.addPurchaseInfo(purchaseInfo);
		}catch(Exception e) {
			LOGGER.error("Error in message comsumer "+ e.getMessage());
		}
    }

}
