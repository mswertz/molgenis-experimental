package org.molgenis.generate.data;
//package org.molgenis.generate;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class AppConfig
//{
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
//	{
//		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//		factoryBean.setDataSource(this.getDataSource());
//		factoryBean.setPackagesToScan(new String[]
//		{ "test.fields", "test.inheritance", "test.composit_keys" });
//		
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);
//		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//		factoryBean.setJpaVendorAdapter(vendorAdapter);
//		
//		factoryBean.setJpaProperties(getAdditionalProperties());
//
//		return factoryBean;
//	}
//
//	@Bean
//	public DataSource getDataSource()
//	{
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost/molgenis?innodb_autoinc_lock_mode=2");
//		dataSource.setUsername("molgenis");
//		dataSource.setPassword("molgenis");
//		return dataSource;
//	}
//	
//	private Properties getAdditionalProperties()
//	{
//		Properties additionalProperties = new Properties();
////		additionalProperties.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver" );
////		additionalProperties.put("hibernate.connection.url","jdbc:mysql://localhost/molgenis?innodb_autoinc_lock_mode=2");
////		additionalProperties.put("hibernate.connection.username", "molgenis");
////		additionalProperties.put("hibernate.connection.password", "molgenis");
//		additionalProperties.put("hibernate.hbm2ddl.auto", "update");
//		additionalProperties.put("hibernate.c3p0.min_size", "5");
//		additionalProperties.put("hibernate.c3p0.max_size", "200");
//		additionalProperties.put("hibernate.c3p0.max_statements", "0");
//		additionalProperties.put("hibernate.c3p0.acquire_increment", "1");
//		additionalProperties.put("hibernate.c3p0.idle_test_period", "20");
//		additionalProperties.put("hibernate.c3p0.timeout", "120");
//		additionalProperties.put("hibernate.c3p0.preferredTestQuery", "select 1;");
//		additionalProperties.put("hibernate.connection.provider_class",
//				"org.hibernate.service.jdbc.connections.internal.C3P0ConnectionProvider");
//		additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		additionalProperties.put("hibernate.show_sql", "true");
//		additionalProperties.put("hibernate.format_sql", "false");
//		additionalProperties.put("hibernate.query.substitutions", "true=1, false=0");
//		additionalProperties.put("hibernate.jdbc.batch_size", "50");
//		additionalProperties.put("hibernate.dynamic-insert", "true");
//		additionalProperties.put("hibernate.dynamic-update", "true");
//		additionalProperties.put("hibernate.order_inserts", "true");
//		additionalProperties.put("hibernate.order_updates", "true");
//		additionalProperties.put("hibernate.cache.use_query_cache", "false");
//		additionalProperties.put("hibernate.cache.use_second_level_cache", "false");
//		additionalProperties.put("hibernate.search.default.directory_provider",
//				"org.hibernate.search.store.RAMDirectoryProvider");
//		additionalProperties.put("hibernate.search.default.indexBase", "/tmp/lucene");
//		additionalProperties.put("hibernate.hbm2ddl.auto", "update");
//		return additionalProperties;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager()
//	{
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setDataSource(getDataSource());
//		transactionManager.setEntityManagerFactory(this.entityManagerFactoryBean().getObject());
//
//		return transactionManager;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
//	{
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//}
