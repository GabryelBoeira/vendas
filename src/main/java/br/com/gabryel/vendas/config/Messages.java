package br.com.gabryel.vendas.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class Messages {

    @Value("${spring.messages.default-locale}")
    private String defaultLocale;

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        return slr;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("label");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    public String getMessage(String message) {
        return getMessage(message, null);
    }

    public String getMessage(String message, Object... args) {
        if (defaultLocale == null) defaultLocale = "pt_BR";

        if (StringUtils.isNotBlank(message)) {
            return messageSource().getMessage(message, args,
                    new Locale(defaultLocale.split("_")[0], defaultLocale.split("_")[1]));
        }

        return "";
    }

}
