/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloController
 * Author:   Administrator
 * Date:     2019/8/3 0003 下午 4:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        logger.info("request second name is "+name);
        return "hello "+name+",this is the second message";
    }
    @RequestMapping("/foo")
    public String foo(String foo) {
        return "hello "+foo+"!!";
    }
    @RequestMapping("/add/{foo}")
    public String add(@PathVariable String foo) {
        return "add mypath 2"+ foo;
    }
}
