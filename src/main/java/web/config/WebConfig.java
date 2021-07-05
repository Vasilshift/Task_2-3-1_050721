//package web.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import web.model.User;
//
//import java.util.Properties;
//
//import static org.springframework.orm.hibernate5.SessionFactoryUtils.getDataSource;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan("web")
//public class WebConfig implements WebMvcConfigurer {
//
//    private final ApplicationContext applicationContext;
//
//
//    private Environment env;
//
//    public WebConfig(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Bean
//    public SpringResourceTemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setApplicationContext(applicationContext);
//        templateResolver.setPrefix("/WEB-INF/pages/");
//        templateResolver.setSuffix(".html");
//        return templateResolver;
//    }
//
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//        return templateEngine;
//    }
//
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        registry.viewResolver(resolver);
//    }
//
////    @Bean
////    public LocalSessionFactoryBean getSessionFactory() {
////        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
////        factoryBean.setDataSource(getDataSource("db.properties"));
////
////        Properties props=new Properties();
////        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
////        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
////
////        factoryBean.setHibernateProperties(props);
////        factoryBean.setAnnotatedClasses(User.class);
////        return factoryBean;
////    }
//
//}
