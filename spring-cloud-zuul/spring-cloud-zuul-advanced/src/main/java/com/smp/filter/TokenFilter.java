/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TokenFilter
 * Author:   Administrator
 * Date:     2019/8/7 0007 下午 12:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@Component
public class TokenFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);
    @Override
    public String filterType() {
        return "pre";//请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0;// filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext rct=RequestContext.getCurrentContext();
        HttpServletRequest request=rct.getRequest();
        logger.info("--->>>TokenFilter {},{}",request.getMethod(),request.getRequestURL().toString());
        String token=request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            rct.setSendZuulResponse(true);
            rct.setResponseStatusCode(200);
            rct.set("isSuccess",true);
            return null;
        }else{
            rct.setSendZuulResponse(false);
            rct.setResponseStatusCode(400);
            rct.set("isSuccess",false);
            rct.setResponseBody("Token is empty!");
            return null;
        }
    }
}
