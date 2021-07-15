package org.djh.mall.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.djh.mall.common.ApiRestResponse;
import org.djh.mall.common.Constant;
import org.djh.mall.entity.User;
import org.djh.mall.exception.MallExceptionEnum;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author alex1024duan
 */
@Component
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        User user = (User)session.getAttribute(Constant.MALL_USER);
        if(user != null) {
            chain.doFilter(request, response);
        }

        byte[] res = JSON.toJSONString(ApiRestResponse.error(MallExceptionEnum.NEED_LOGIN), SerializerFeature.WriteMapNullValue).getBytes(StandardCharsets.UTF_8);
        response.setContentType("application/json; charset=UTF-8");
        response.getOutputStream().write(res);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
