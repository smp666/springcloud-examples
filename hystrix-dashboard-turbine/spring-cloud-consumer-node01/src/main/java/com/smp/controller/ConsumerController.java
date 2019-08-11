/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConsumerController
 * Author:   Administrator
 * Date:     2019/8/6 0006 上午 10:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.controller;

import com.smp.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ConsumerController {
    @Autowired
    private HelloRemote helloRemote;
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable(name="name") String name){
        return helloRemote.hello(name);
    }

}
