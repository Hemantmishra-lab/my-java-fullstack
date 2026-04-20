package com.booksphere.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Database aur Business Logic config
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Web/MVC config (FreeMarker, Controllers)
        return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // Saari requests "/" se start hone wali Spring handle karega
        return new String[] { "/" };
    }
}
