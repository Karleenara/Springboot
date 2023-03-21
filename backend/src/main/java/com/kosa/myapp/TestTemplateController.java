package com.kosa.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class TestTemplateController {
	@GetMapping("/template1")
	public String template1(Model model, HttpServletRequest req) {
		model.addAttribute("msg", "SpringBoot template");
		model.addAttribute("name","나라");
		
		List<String> sList = new ArrayList<String>();
		sList.add("장미");
		sList.add("동백");
		
		model.addAttribute("sList", sList);
		
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		boardList.add(new BoardDto("1", "제목1", "내용1", "작성자1", "11", "21"));
		boardList.add(new BoardDto("2", "제목2", "내용2", "작성자2", "12", "22"));
		model.addAttribute("boardList",boardList);
		
		HttpSession session = req.getSession();
		session.setAttribute("userid", "test1");
		session.setAttribute("username", "나라");
		
		
		// template1.html로 찾아감
		return "template1";
	}
	
	@GetMapping("/board/list")
	public String board_list(Model model, HttpServletRequest req) {
		return "board_list";
	}
}
