package com.qing.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.qing.entity.User;
import com.qing.mapper.UserMapper;
import com.qing.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public Page<Map<Object, Object>> selectUserPage(
			Page<Map<Object, Object>> page, String search) {
		page.setRecords(baseMapper.selectUserList(page, search));
		return page;
	}
	
}
