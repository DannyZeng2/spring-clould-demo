package com.oocl.zuulapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    /**
     * filterType 方法的返回值为过滤器的类型，过滤器的类型决定了过滤器在哪个生命周期执行，
     * pre 表示在路由之前执行过滤器，其他值还有 post、error、route 和 static，当然也可以自定义。
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder 方法表示过滤器的执行顺序，当过滤器很多时，我们可以通过该方法的返回值来指定过滤器的执行顺序。
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter 方法用来判断过滤器是否执行，true 表示执行，false 表示不执行。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");

        if (token == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);

            ctx.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            ctx.setResponseBody("非法访问");
        }

        return null;
    }
}