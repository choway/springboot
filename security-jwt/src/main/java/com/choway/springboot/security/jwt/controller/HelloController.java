package com.choway.springboot.security.jwt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "Hello 测试接口")
@RestController
public class HelloController {

	@ApiOperation("hello api")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "用户名", paramType = "query")
	})
	@GetMapping("/hello")
	public Object hello(String name) {
		return "hello " + name;
	}

}
