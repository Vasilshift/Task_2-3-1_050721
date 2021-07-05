package web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.model.User;
import javax.sql.DataSource;
import java.util.Properties;

    @Configuration
    @PropertySource("classpath:db.properties")
    @EnableTransactionManagement
    @ComponentScan(value = "web")
    public class AppHiberConfig {

        @Autowired
        private Environment environment;

        @Bean
        public DataSource dataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
            dataSource.setUrl(environment.getRequiredProperty("db.url"));
            dataSource.setUsername(environment.getRequiredProperty("db.username"));
            dataSource.setPassword(environment.getRequiredProperty("db.password"));
            return dataSource;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean getSessionFactory() {
            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
            factoryBean.setDataSource(dataSource());
            factoryBean.setPackagesToScan("web");

            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            factoryBean.setJpaVendorAdapter(vendorAdapter);

            Properties properties = new Properties();

            //if decomment this string wich add dialect show Error artefact !!!!!!!!!
            //properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
            
            properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
            properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
            factoryBean.setJpaProperties(properties);
            return factoryBean;
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(getSessionFactory().getObject());
            return transactionManager;
        }

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
            return new PersistenceExceptionTranslationPostProcessor();
        }
    }

