package com.nan.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Component
public class IpFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(IpFilter.class);

    @Value("${zuul.routes.api-hello.path}")
    private String apiHelloPath;

    /**
     * 获取过滤器类型，可以返回下面4个字符串之一
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     */
    @Override
    public String filterType() {
        //ip过滤器，表示是前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        //过滤器优先级，数字越大，优先级越低，其实就是过滤器链里面用到的
        return 0;
    }

    /**
     * 是否执行该过滤器
     * true 过滤 false 不过滤
     */
    @Override
    public boolean shouldFilter() {
        //我们要执行此过滤器，所以返回true
        return true;
    }

    /**
     * 过滤逻辑方法
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if (request.getRequestURI().startsWith(apiHelloPath.split("\\*")[0])) {
            String ip = getIpAddress(request);
            logger.info("Request real ip = " + ip);
            //ip不是127.0.0.1，禁止访问
            if (!ip.equals("127.0.0.1")) {
                //不路由该请求
                requestContext.setSendZuulResponse(false);
                //设置错误码
                requestContext.setResponseStatusCode(401);
                //设置返回内容
                requestContext.setResponseBody("Sorry,request ip forbidden");
            }
        }
        return null;
    }

    /**
     * 获取真实请求ip
     */
    private String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
