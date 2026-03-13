/*
 * Copyright (c) 2026 UlinkaTech.
 *
 * Author: Idélio Teófilo Mata
 * Project: brewer
 * Created: 3/13/2026 3:25 PM
 *
 * This source code is the proprietary property of UlinkaTech.
 * Unauthorized copying, modification, distribution, or use
 * of this file, via any medium, is strictly prohibited.
 *
 * All rights reserved.
 */

package com.ulinkatech.brewersystem.config.init;

import com.ulinkatech.brewersystem.config.WebConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Configuração root: global da aplicação (serviços, banco de dados, etc.)
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[0]; // Nenhum root config por enquanto
    }

    // Configuração específica do Spring MVC
    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // Configuração dos controlers MVC
    }


    // Mapeamento de URLs para o DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // Pega todas as requisições
    }
}