package com.fuy.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by userFly on 2018/5/18.
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.err.println(String.format("%s >>> %s", request.getMethod(),request.getRequestURI().toString()));
        // 获取请求的参数
        Object accessToken = request.getParameter("token");
        // 如果请求的参数不为空，则通过
        if (accessToken == null) {
            System.err.println("token is empty");
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            // 返回错误内容  ctx.setResponseBody("{\"result\":\"username is not correct!\"}");
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
