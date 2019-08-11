/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloRemote
 * Author:   Administrator
 * Date:     2019/8/3 0003 下午 5:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@FeignClient(name="spring-cloud-producer",fallback=HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value="/hello")
    public String hello(@RequestParam(value="name") String name);
}
