package com.stevelee.steve_user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.parser.JSONParser;

@RestController
public class RestTestController {
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/userAllList")
	public String userAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONParser parser;
		List<Map<String, Object>> selectList = sqlSession.selectList("userMapper.getUserList");

		return selectList.toString();
	}
	
	@RequestMapping("/userList")
	public Map<String, Object> userList(HttpServletRequest request) throws Exception {
		
		String userName = request.getParameter("username");
		
		Map<String, Object> selectOne = sqlSession.selectOne("userMapper.getUser", userName);
		
		System.out.println(selectOne);
		
		return selectOne;
	}
}
