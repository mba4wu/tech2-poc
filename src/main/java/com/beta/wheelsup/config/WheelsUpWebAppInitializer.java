package com.beta.wheelsup.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by mburns on 1/19/16.
 */
public class WheelsUpWebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext appCtx = new AnnotationConfigWebApplicationContext();
        appCtx.register(AppConfig.class, WebAppConfig.class);
        appCtx.setServletContext(servletContext);
        servletContext.addListener(new ContextLoaderListener(appCtx));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                "dispatcher", new DispatcherServlet(appCtx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}

