package com.tpizza.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {

    @Bean
    public UrlBasedViewResolver viewResolver(){
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();

        urlBasedViewResolver.setViewClass(TilesView.class);
        urlBasedViewResolver.setOrder(-2);

        return urlBasedViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
}
