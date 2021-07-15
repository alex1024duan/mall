package org.djh.mall.config;

import org.djh.mall.filter.AdminCheckFilter;
import org.djh.mall.filter.LoginCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author alex1024duan
 */
@Configuration
public class FilterConfig {

    private LoginCheckFilter loginCheckFilter;
    private AdminCheckFilter adminCheckFilter;

    @Autowired
    public void setLoginCheckFilter(LoginCheckFilter loginCheckFilter) {
        this.loginCheckFilter = loginCheckFilter;
    }

    @Autowired
    public void setAdminCheckFilter(AdminCheckFilter adminCheckFilter) {
        this.adminCheckFilter = adminCheckFilter;
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        return new CharacterEncodingFilter("UTF-8", true, true);
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> characterEncodingFilterConfig() {
        FilterRegistrationBean<CharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(characterEncodingFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoginCheckFilter> loginCheckFilterConfig() {
        FilterRegistrationBean<LoginCheckFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(loginCheckFilter);
        filterRegistrationBean.addUrlPatterns("/user/update");
        filterRegistrationBean.addUrlPatterns("/admin/category/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminCheckFilter> adminCheckFilterConfig() {
        FilterRegistrationBean<AdminCheckFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(adminCheckFilter);
        filterRegistrationBean.addUrlPatterns("/admin/category/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
