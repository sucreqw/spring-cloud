package com.youmi.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: ZuulFilter
 * @Package
 * @Description:
 * @date 2019-03-15 16:37
 */

@Component
public class ZuulFilterDemo extends ZuulFilter {

    /**
     * 过滤器类型，一共有四种
     * FilterConstants.PRE_TYPE    ="pre"   //这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     *                 ROUTE_TYPE  ="route" //这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     *                 POST_TYPE   ="post"  //这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     *                 ERROR_TYPE  ="error" //在其他阶段发生错误时执行该过滤器。 除了默认的过滤器类型，Zuul还允许我们创建自定义的过滤器类型。例如，我们可以定制一种STATIC类型的过滤器，直接在Zuul中生成响应，而不将请求转发到后端的微服务。
     * @return
     */
    public String filterType() {
        return FilterConstants.POST_TYPE;

    }

    /**
     * filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
     * @return
     */
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     * @return
     */
    public boolean shouldFilter() {
        return true;
    }

    /**
     *  filter需要执行的具体操作
     *
     * 例如：本filter实际执行的逻辑 是验证所有的访问请求中，是否包含安全信息auth
     * @return
     * @throws ZuulException
     */
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String auth = request.getParameter("auth");
        //TODO 此处可以做日志记录
        //System.out.println("zuul拦截--请求前验证---auth："+auth);

        //成功的情况
        if (!(null ==auth)){
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        }else {
            //失败的情况
            System.out.println("worng...");
            ctx.setSendZuulResponse(false);//不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess",false);
        }

        return null;
    }
}
