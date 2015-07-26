package br.com.swapper.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration 
{
	/*
	 * Parâmetros de conexão
	 */
	private static final String DB_HOST   = "localhost";
	private static final String DB_PORT   = "3306";
	private static final String DB_SCHEMA = "swapper";
	
	/*
	 * Configurações de conexão
	 */
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String DRIVER_URL   = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT +"/" + DB_SCHEMA;
	private static final String USERNAME     = "root";
	private static final String PASSWORD     = "mariaj312";
	
	/*
	 * Configurações do Hibernate
	 */
	private static final String HIBERNATE_HBM2DDL_AUTO_PROPERTY = "hibernate.hbm2ddl.auto";
	private static final String HIBERNATE_HBM2DDL_AUTO_VALUE    = "update";
	
	private static final String HIBERNATE_DIALECT_PROPERTY      = "hibernate.dialect";
	private static final String HIBERNATE_DIALECT_VALUE         = "org.hibernate.dialect.MySQL5Dialect";
	
	private static final String HIBERNATE_SHOW_SQL_PROPERTY     = "hibernate.show_sql";
	private static final String HIBERNATE_SHOW_SQL_VALUE        = "true";
	
	private static final String HIBERNATE_FORMAT_SQL_PROPERTY   = "hibernate.format_sql";
	private static final String HIBERNATE_FORMAT_SQL_VALUE      = "true";
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[]{"br.com.swapper.model"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		
		return em;
	}
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl            (DRIVER_URL);
		dataSource.setUsername       (USERNAME);
		dataSource.setPassword       (PASSWORD);
		
		return dataSource;
	}
	
	private Properties additionalProperties()
	{
		Properties properties = new Properties();
		
		properties.setProperty(HIBERNATE_HBM2DDL_AUTO_PROPERTY, HIBERNATE_HBM2DDL_AUTO_VALUE);
		properties.setProperty(HIBERNATE_DIALECT_PROPERTY     , HIBERNATE_DIALECT_VALUE);
		properties.setProperty(HIBERNATE_SHOW_SQL_PROPERTY    , HIBERNATE_SHOW_SQL_VALUE);
		properties.setProperty(HIBERNATE_FORMAT_SQL_PROPERTY  , HIBERNATE_FORMAT_SQL_VALUE);
		
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
}
