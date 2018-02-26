package com.appstarter.kit.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfig {

  @Bean
  public ReloadableResourceBundleMessageSource  messageSource() {
      ReloadableResourceBundleMessageSource messageBundled = new ReloadableResourceBundleMessageSource();
            messageBundled.setBasename("classpath:messages/messages");
            messageBundled.setDefaultEncoding("UTF-8");
            return messageBundled;
  }

}
