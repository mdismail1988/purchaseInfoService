package com.mdismail.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdismail.purchase.model.PurchaseInfo;

@RestController
@RequestMapping("/kafkatest")
public class KafkaMessgaeTest {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private KafkaTemplate<String, PurchaseInfo> purchaseInfoTemplate;
	private static final String TOPIC = "purchase-info-topic";
	
	@GetMapping("/sendmessage")
    public String sendMessgae() {
		try {
			LOGGER.info("Sending Test messgae");
			purchaseInfoTemplate.send(TOPIC, new PurchaseInfo(1,"PD0001","SHIRT",534,"Ismail",500.00,1));
			return "Kafaka Messgae Sent successfully";
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			return "Error";
		}
    }

}
