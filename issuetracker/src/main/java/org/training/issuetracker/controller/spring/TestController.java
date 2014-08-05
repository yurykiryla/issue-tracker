package org.training.issuetracker.controller.spring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/index")
	public String temp(Map<String, Object> map) {
		map.put("test", "testing");
		
		return "main";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
}
