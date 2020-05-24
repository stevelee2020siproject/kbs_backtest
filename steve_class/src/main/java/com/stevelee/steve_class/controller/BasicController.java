package com.stevelee.steve_class.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@Autowired
	private SqlSession sqlSession;
	
	@GetMapping("/")
	public void getUserMail (HttpServletRequest request) throws Exception {
		
		String userMail = request.getParameter("userMail");
		List<Map<String, Object>> selectList = sqlSession.selectList("basicMapper.getUserMail", userMail);
		
		System.out.println(selectList);
	}
	
	@GetMapping("/classOffline")
	public void classOffline() throws Exception {
		List<Map<String, Object>> selectList = sqlSession.selectList("basicMapper.getClassOffline");
		
		
		System.out.println(selectList);
	}
}
