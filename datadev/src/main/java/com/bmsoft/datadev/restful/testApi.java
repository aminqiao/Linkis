package com.bmsoft.datadev.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : wuzm
 * Date : 2019/11/14 下午5:35
 */
@RestController
@RequestMapping("/datadev1")
public class testApi {

	@RequestMapping("/test")
	public String test(){
		return "ssssss";
	}

}
