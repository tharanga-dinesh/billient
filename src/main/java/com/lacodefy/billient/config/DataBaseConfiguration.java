package com.lacodefy.billient.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Tharanaga Dinesh
 */
@Configuration
@EnableJpaRepositories( basePackages = {"com.lacodefy.billient.dao"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager" )
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DataBaseConfiguration {

	@Autowired
	private Environment environment;

	@Bean()
	public DataSource dataSource () {
		final HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSourceConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(environment.getProperty("spring.datasource.name"));
		dataSourceConfig.setPassword(environment.getProperty("spring.datasource.password"));
		return new HikariDataSource(dataSourceConfig);
	}

	@Bean()
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.lacodefy.billient.model");
		entityManagerFactoryBean.setJpaProperties(getJpaProperties());
		return entityManagerFactoryBean;
	}

	/**
	 * @return Properties
	 */
	private Properties getJpaProperties() {
		final Properties jpaProperties = new Properties();
		//Configures the used database dialect. This allows Hibernate to create SQL that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		//If the value of this property is true, Hibernate writes all SQL statements to the console.
		jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		//If the value of this property is true, Hibernate will format the SQL that is written to the console.
		jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return jpaProperties;
	}

	@Bean()
	JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

}
