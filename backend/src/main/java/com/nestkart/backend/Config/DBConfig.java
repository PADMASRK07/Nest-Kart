package com.nestkart.backend.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@ComponentScan("com.nestkart")
@EnableTransactionManagement
public class DBConfig
{
	@Bean
	DataSource myDataSource()
	{
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName("org.h2.Driver");
		d.setUrl("jdbc:h2:tcp://localhost/~/nestkart");
		d.setUsername("padma");
		d.setPassword("padma@123");
		return d;		
	}
	@Bean
	Properties setMyProperties()
	{
		Properties p=new Properties();
		p.setProperty(Environment.HBM2DDL_AUTO,"update");
		p.setProperty(Environment.DIALECT,"org.hibernate.dialect.H2Dialect");
		p.setProperty(Environment.SHOW_SQL,"true");
		return p;
	}
	@Bean("sf")
	LocalSessionFactoryBean sessionFactory()
	{
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(myDataSource());
		factoryBean.setHibernateProperties(setMyProperties());
		factoryBean.setPackagesToScan("com.nestkart.backend.Model");
		return factoryBean;
	}
	@Autowired
	@Bean
	HibernateTransactionManager enableTransaction(SessionFactory sf)
	{
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf);
		return htm;
				
	}

}
