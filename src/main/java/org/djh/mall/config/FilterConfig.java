package org.djh.mall.config;

import org.djh.mall.filter.AdminCheckFilter;
import org.djh.mall.filter.RequestCharacterEncodingFilter;
import org.djh.mall.filter.LoginCheckFilter;
import org.djh.mall.filter.ResponseContentTypeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alex1024duan
 */
@Configuration
public class FilterConfig {

    private RequestCharacterEncodingFilter requestCharacterEncodingFilter;
    private ResponseContentTypeFilter responseContentTypeFilter;
    private LoginCheckFilter loginCheckFilter;
    private AdminCheckFilter adminCheckFilter;

    @Autowired
    public void setRequestCharacterEncodingFilter(RequestCharacterEncodingFilter requestCharacterEncodingFilter) {
        this.requestCharacterEncodingFilter = requestCharacterEncodingFilter;
    }

    @Autowired
    public void setResponseContentTypeFilter(ResponseContentTypeFilter responseContentTypeFilter) {
        this.responseContentTypeFilter = responseContentTypeFilter;
    }

    @Autowired
    public void setLoginCheckFilter(LoginCheckFilter loginCheckFilter) {
        this.loginCheckFilter = loginCheckFilter;
    }

    @Autowired
    public void setAdminCheckFilter(AdminCheckFilter adminCheckFilter) {
        this.adminCheckFilter = adminCheckFilter;
    }

    @Bean
    public FilterRegistrationBean<RequestCharacterEncodingFilter> requestCharacterEncodingFilterConfig() {
        FilterRegistrationBean<RequestCharacterEncodingFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(requestCharacterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<ResponseContentTypeFilter> responseContentTypeFilterConfig() {
        FilterRegistrationBean<ResponseContentTypeFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(responseContentTypeFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<LoginCheckFilter> loginCheckFilterConfig() {
        FilterRegistrationBean<LoginCheckFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(loginCheckFilter);
        filterRegistrationBean.addUrlPatterns("/user/update");
        filterRegistrationBean.addUrlPatterns("/admin/category/*");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminCheckFilter> adminCheckFilterConfig() {
        FilterRegistrationBean<AdminCheckFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(adminCheckFilter);
        filterRegistrationBean.addUrlPatterns("/admin/category/*");
        filterRegistrationBean.setOrder(3);
        return filterRegistrationBean;
    }

}
