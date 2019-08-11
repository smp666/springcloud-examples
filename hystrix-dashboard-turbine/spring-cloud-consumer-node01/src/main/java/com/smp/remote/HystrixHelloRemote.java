/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HystrixHelloRemote
 * Author:   Administrator
 * Date:     2019/8/6 0006 上午 10:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.smp.remote;

import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @since 1.0.0
 */
@Component
public class HystrixHelloRemote implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello "+name+",this message send failed";
    }
}
