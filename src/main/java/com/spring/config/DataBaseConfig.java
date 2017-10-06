package com.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.dao.UserDAO;
import com.spring.dao.UserDAOImpl;


@Configuration
@ComponentScan("com.spring.model")
@EnableTransactionManagement
//@EnableWebMvc
public class DataBaseConfig {
	
	
	@Bean

	public DataSource getDataSource()

	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/test");
		ds.setUsername("sa");
		ds.setPassword("a");
		return ds;
		}
	

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	//	properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.spring");
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}
	
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
	    return new UserDAOImpl(sessionFactory);
	}
}