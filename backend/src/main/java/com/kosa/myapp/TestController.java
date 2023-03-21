package com.kosa.myapp;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/add/{x}/{y}")
	public HashMap<String, String>add( @PathVariable("x")int x, @PathVariable("y")int y){
		int result = x + y;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("x", String.valueOf(x));
		map.put("y", String.valueOf(y));
		map.put("result", String.valueOf(result));
		
		return map;
		
	
	}
	
	@GetMapping("/calc/{a}/{b}/{no}")
	public HashMap<String, String>calc( @PathVariable("a")int a, @PathVariable("b")int b, @PathVariable("no")int no){
		HashMap<String, String> map = new HashMap<String, String>();
		int result=0;
		if(no==1) 
			result = a+b;
		else if(no==2)
			result = a-b;
		else if(no==3)
			result = a*b;
		else if(no==4)
			result = a/b;
		
		map.put("a", String.valueOf(a));
		map.put("b", String.valueOf(b));
		map.put("result", String.valueOf(result));
		return map;
	}
	
	@PostMapping("/score_json")
	public HashMap<String, Object>score_json(@RequestBody ScoreDto dto){
		HashMap<String, Object>resultMap = new HashMap<String, Object>();
		int total = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		resultMap.put("name", dto.getName());
		resultMap.put("kor", dto.getKor());
		resultMap.put("eng", dto.getEng());
		resultMap.put("mat", dto.getMat());
		resultMap.put("total", dto.getTotal());
		resultMap.put("avg", dto.getAvg());
		
		return resultMap;
	}
	
	@PostMapping("/score_json2")
	public ScoreDto score_json2(@RequestBody ScoreDto dto){
		int total = dto.getKor() + dto.getEng() + dto.getMat();
		dto.setTotal(total);
		dto.setAvg(total/3);
		
		return dto;
	}
	
}
