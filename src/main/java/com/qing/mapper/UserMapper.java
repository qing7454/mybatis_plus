package com.qing.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.qing.entity.User;

public interface UserMapper extends BaseMapper<User>{

	@Select("select * from user order by id desc")
	List<Map<Object, Object>> selectUserList(Page<Map<Object, Object>> page,
			String search);

}
