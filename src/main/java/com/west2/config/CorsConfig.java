package com.west2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 * @author 天狗
 * @date 2022/11/25
 */
@Configuration
public class CorsConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1允许任何域名使用
        corsConfiguration.addAllowedOriginPattern("*");
        // 2允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 3允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        // 允许跨域带上cookies
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    /**
     * 将跨域过滤器配置并注入Spring容器管理
     * @return  CorsFilter
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路由匹配
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}