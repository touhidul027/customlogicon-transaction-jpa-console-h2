package project.controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import project.dao.AccountDao;
import project.dao.AccountDaoJpaImpl;
import project.service.AccountService;
import project.service.AccountServiceImpl;

@Configuration
@EnableTransactionManagement
public class Config {

	// for h2 database 
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
	
	//for mysql database 
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource ; 
//	}	
	
	
	private Map<String,?> jpaProperties() {
        Map<String,String> jpaPropertiesMap = new HashMap<String,String>();
        jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect"); // for h2 database
        //jpaPropertiesMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");// for mysql
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", "update");
        return jpaPropertiesMap;
    }
	
		@Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        LocalContainerEntityManagerFactoryBean factoryBean = 
	            new LocalContainerEntityManagerFactoryBean();
	        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	        factoryBean.setDataSource(dataSource());
	        factoryBean.setPackagesToScan("project");
	        factoryBean.setJpaPropertyMap(jpaProperties());
	        return factoryBean;
	    }
	
		@Bean
	    @Autowired
	    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    }
	
		@Bean
		public AccountDao accountDao() {
			AccountDaoJpaImpl accountDaoJpaImpl = new AccountDaoJpaImpl() ; 
	 		return  accountDaoJpaImpl;
		}
	
	    @Bean
	    @Autowired
	    public AccountService accountService(AccountDao accountDao) {
	        AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	        accountServiceImpl.setAccountDao(accountDao());
	        
			return accountServiceImpl;
	        
	    }

		
}
