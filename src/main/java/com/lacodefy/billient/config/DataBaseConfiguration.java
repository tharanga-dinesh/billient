package com.lacodefy.billient.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/**
 * @author Tharanaga Dinesh
 */
@Configuration
@EnableJpaRepositories( basePackages = {"com.lacodefy.billient.dao"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "" )
@PropertySource("classpath:database.properties")
public class DataBaseConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource billientDataSource () {
		final HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSourceConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(environment.getProperty("spring.datasource.name"));
		dataSourceConfig.setPassword(environment.getProperty("spring.datasource.password"));
		return new HikariDataSource(dataSourceConfig);
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(final DataSource billientDataSource) {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(billientDataSource);

		return entityManagerFactoryBean;
	}

	//	@Bean
	//	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	//	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	//	    transactionManager.setEntityManagerFactory(entityManagerFactory);
	//	    return transactionManager;
	//	}

}
