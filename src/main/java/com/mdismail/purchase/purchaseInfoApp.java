package com.mdismail.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class purchaseInfoApp 
{
	public static void main( String[] args ){
        System.out.println( "Starting purchase Info Service" );
        SpringApplication.run(purchaseInfoApp.class, args);
    }
}

