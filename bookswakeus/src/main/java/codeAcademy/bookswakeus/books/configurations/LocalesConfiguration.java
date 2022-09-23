package codeAcademy.bookswakeus.books.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class LocalesConfiguration implements WebMvcConfigurer{


//    cookie resolver
//    @Bean
//    public LocaleResolver localeResolver(){
//        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//        localeResolver.setDefaultLocale(Locale.US);
//        return localeResolver;
//    }


//    session resolver
    @Bean
    public LocaleResolver localeResolver(){

        LocaleResolver localeResolver = new SessionLocaleResolver();
        return localeResolver;
    }


    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){

        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());

    }

//    Nežinau, kam čia. Reikalingas get validator metodui
//    @Bean
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages/messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

//    Validation messages. Greičiausiai reiks ištrint
//    @Bean
//    @Override
//    public Validator getValidator() {
//        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
//        localValidatorFactoryBean.setValidationMessageSource(messageSource());
//        return localValidatorFactoryBean;
//    }
    //
}
