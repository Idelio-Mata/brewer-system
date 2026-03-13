/*
 * Copyright (c) 2026 UlinkaTech.
 *
 * Author: Idélio Teófilo Mata
 * Project: brewer
 * Created: 3/13/2026 3:57 PM
 *
 * This source code is the proprietary property of UlinkaTech.
 * Unauthorized copying, modification, distribution, or use
 * of this file, via any medium, is strictly prohibited.
 *
 * All rights reserved.
 */

package com.ulinkatech.brewersystem.config;

import com.ulinkatech.brewersystem.controller.CervejasController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan(basePackageClasses = {CervejasController.class})
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // ThymeleafViewResolver, integra Spring MVC com Thymeleaf | Recebe o nome da view do controller
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    // SpringTemplateEngine, processa o template,os arquivos HTML | Disponibiliza as paginas
    @Bean
    public SpringTemplateEngine templateEngine () {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    // Template Resolver : Mostra a localização dos Arquivos HTML | Encontra o arquivo HTML
    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/"); // pasta onde ficam os templates
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }
}

