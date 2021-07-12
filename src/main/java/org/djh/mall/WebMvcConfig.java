package org.djh.mall;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author alex1024duan
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");

        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        fastJsonConverter.setDefaultCharset(StandardCharsets.UTF_8);
        fastJsonConverter.setFastJsonConfig(config);

        converters.add(0, fastJsonConverter);
    }

}
