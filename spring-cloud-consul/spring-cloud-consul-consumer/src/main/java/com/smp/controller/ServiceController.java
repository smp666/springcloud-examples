/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ServiceController
 * Author:   Administrator
 * Date:     2019/8/8 0008 上午 10:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestController
public class ServiceController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 查询所有服务
     * @return
     */
    @RequestMapping("/services")
    public Object services(){
        return discoveryClient.getInstances("service-producer");
    }

    /**
     * 选择一个服务（轮询）
     * @return
     */
    @RequestMapping("/discover")
    public Object discover(){
        return loadBalancer.choose("service-producer").getUri().toString();
    }

}
