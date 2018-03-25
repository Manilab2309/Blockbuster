/**
 * CLASE QUE CONFIGURA LA JPA CONNECTION A TRAVES DE HIBERNATE
 */
package com.blockbuster.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * @author Ramón Cigüenza
 *
 */
public class DatabaseConfig {

		/**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver"));
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));
	    return dataSource;
	  }

	  /**
	   * Declare the JPA entity manager factory.
	   */
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory =
	        new LocalContainerEntityManagerFactoryBean();
	    
	    entityManagerFactory.setDataSource(dataSource);
	    
	    // Classpath scanning of @Component, @Service, etc annotated class
	    entityManagerFactory.setPackagesToScan(
	        env.getProperty("entitymanager.packagesToScan"));
	    
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
	    	    
	    return entityManagerFactory;
	  }

	  /**
	   * Declare the transaction manager.
	   */
	  @Bean
	  public JpaTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = 
	        new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(
	        entityManagerFactory.getObject());
	    return transactionManager;
	  }
	  
	  /**
	   * PersistenceExceptionTranslationPostProcessor is a bean post processor
	   * which adds an advisor to any bean annotated with Repository so that any
	   * platform-specific exceptions are caught and then rethrown as one
	   * Spring's unchecked data access exceptions (i.e. a subclass of 
	   * DataAccessException).
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }

	  // Private fields
	  
	  @Autowired
	  private Environment env;

	  @Autowired
	  private DataSource dataSource;

	  @Autowired
	  private LocalContainerEntityManagerFactoryBean entityManagerFactory;
}
