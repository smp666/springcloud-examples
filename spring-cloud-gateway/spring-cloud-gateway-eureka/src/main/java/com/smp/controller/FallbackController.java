/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FallbackController
 * Author:   Administrator
 * Date:     2019/8/10 0010 下午 5:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.controller;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestController
public class FallbackController {
    @RequestMapping("/fallback")
    @ResponseStatus
    public Mono<Map<String,Object>> fallback(ServerWebExchange exchange, Throwable throwable){
        Map<String,Object> result=new HashMap<>(8);
        ServerHttpRequest request=exchange.getRequest();
        result.put("path",request.getPath().pathWithinApplication().value());
        result.put("method",request.getMethodValue());
        if(throwable!=null&&throwable.getCause()!=null){
            result.put("message",throwable.getCause().getMessage());
        }else{
            result.put("message",throwable.getMessage());
        }
        return Mono.just(result);
    }

}
