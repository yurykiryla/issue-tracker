package org.training.issuetracker.controller.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.issuetracker.model.bean.Type;
import org.training.issuetracker.model.dao.exception.DAOException;
import org.training.issuetracker.model.service.Service;

@Controller
@RequestMapping("/")
public class TestController {
	
	@Autowired
	private Service<Type> typeService;

	@RequestMapping("/index")
	public String temp(Map<String, Object> map) {
		map.put("test", "testing");
		
		try {
			map.put("types", typeService.getObs());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/")
    public String home() {
        return "/index";
    }
}
