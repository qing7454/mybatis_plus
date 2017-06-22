package com.qing.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.qing.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControler {
	
	@Autowired
	private UserService userService;

	/**
	 * 分页查询用户
	 */
    @RequestMapping("/list/{pageNumber}")  
    public JSONObject list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize,String search){
		if(StringUtils.isNotBlank(search)){
//			model.addAttribute("search", search);
		}
		JSONObject json = new JSONObject();
    	Page<Map<Object, Object>> page = new Page(pageNumber,pageSize);
//    	model.addAttribute("pageSize", pageSize);
    	Page<Map<Object, Object>> pageData = userService.selectUserPage(page, search);
//    	model.addAttribute("pageData", pageData);
    	json.put("data", pageData.getRecords());
    	json.put("total", pageData.getPages());
    	return json;
    } 
}
