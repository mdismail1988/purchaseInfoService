package com.mdismail.purchase.queueconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.mdismail.purchase.model.PurchaseInfo;

@EnableKafka
@Configuration
public class PurchaseInfoQueueConfig {
	
	@Value("${kafka.url}")
	private String kafkaUrl;

	/*@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		return new DefaultKafkaConsumerFactory<String, String>(config);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		 ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
		 
	}*/
	
	public ConsumerFactory<String, PurchaseInfo> purchaseInfoConsumerFactory() {
		Map<String, Object> config = new HashMap<String, Object>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		
		DefaultKafkaConsumerFactory<String, PurchaseInfo> consumerFactory =  new DefaultKafkaConsumerFactory<String, PurchaseInfo>(config, new StringDeserializer(),new JsonDeserializer<PurchaseInfo>(PurchaseInfo.class));
        return consumerFactory;   
		
		//return new DefaultKafkaConsumerFactory<String, PurchaseInfo>(config, new StringDeserializer(),new JsonDeserializer<PurchaseInfo>(PurchaseInfo.class));
		
	}
	
	@Bean
    public ConcurrentKafkaListenerContainerFactory<String, PurchaseInfo> purchaseInfoListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PurchaseInfo> factory = new ConcurrentKafkaListenerContainerFactory<String, PurchaseInfo>();
        factory.setConsumerFactory(purchaseInfoConsumerFactory());
        return factory;
    }
	
	@Bean
    public ProducerFactory<String, PurchaseInfo> purchaseInfoproducerFactory() {
        Map<String, Object> config = new HashMap<String, Object>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        config.put(ProducerConfig.CLIENT_ID_CONFIG, "purchaseInfoproducer");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<String, PurchaseInfo>(config);
    }
	
	 @Bean
	 public KafkaTemplate<String, PurchaseInfo> purchaseInfoTemplate() {
		 return new KafkaTemplate<>(purchaseInfoproducerFactory());
	 }

	public void setKafkaUrl(String kafkaUrl) {
		this.kafkaUrl = kafkaUrl;
	}

}
