package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	/**
	 * 通用的页面跳转方法
	 * 如果通过浏览器访问 /hello 斜杠后的hello
	 * 会被 /{page}中的 page 变量接收
	 * @PathVariable 会将方法上声明的 page变量
	 * 的值 赋值给 page参数
	 * 最后 return page
	 */
	@RequestMapping("/{page}")
    public String page(
    		@PathVariable String page){
        return page;
    }
}
