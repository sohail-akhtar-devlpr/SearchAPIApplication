package com.search.suppliers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// since i am not using any data source as i am using dummy data
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SuppliersinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuppliersinfoApplication.class, args);
	}

}
