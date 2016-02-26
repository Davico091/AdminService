package com.example.admin.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

import com.example.admin.service.constants.DataBaseConstants;


@Controller
public class DatabaseConfiguration {

	@Primary
	@Bean(name="dataSourceOrigen")
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(DataBaseConstants.DB_ORIGEN_URL);
		driverManagerDataSource.setDriverClassName(DataBaseConstants.DB_DRIVER_CLASS_NAME);
		driverManagerDataSource.setUsername(DataBaseConstants.DB_USER_NAME);
		driverManagerDataSource.setPassword(DataBaseConstants.DB_PASSWORD);
		return driverManagerDataSource;
	}
}
