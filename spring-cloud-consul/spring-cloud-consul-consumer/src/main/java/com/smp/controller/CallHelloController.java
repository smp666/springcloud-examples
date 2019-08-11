/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CallHelloController
 * Author:   Administrator
 * Date:     2019/8/8 0008 上午 10:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestController
public class CallHelloController {
    @Autowired
    private LoadBalancerClient  loadBalancer;
    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance=loadBalancer.choose("service-producer");
        System.out.println("地址："+serviceInstance.getUri());
        System.out.println("服务名称："+serviceInstance.getServiceId());
        String callResult=new RestTemplate().getForObject(serviceInstance.getUri()+"/hello",String.class);
        System.out.println("结果："+callResult);
        return callResult;
    }
}
