//package com.mySpring.myapp.common;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesView;
//import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        final TilesConfigurer configurer = new TilesConfigurer();
//
//        configurer.setDefinitions("/WEB-INF/tiles/tilesAll.xml");
//
//        return configurer;
//    }
//
//    @Bean
//    public TilesViewResolver tilesViewResolver(){
//        final TilesViewResolver tilesViewResolver = new TilesViewResolver();
//
//        tilesViewResolver.setViewClass(TilesView.class);
//        tilesViewResolver.setOrder(1);
//        return tilesViewResolver;
//    }
//}
