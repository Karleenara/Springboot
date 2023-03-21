package com.kosa.myapp.guestbook.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.guestbook.GuestbookDto;
import com.kosa.myapp.guestbook.service.GuestbookService;

import jakarta.annotation.Resource;

@RestController
public class GuestbookController {
	@Resource(name="guestbookService")
	GuestbookService service;
	
	@GetMapping("/guestbook/list/{pg}")
	public HashMap<String, Object> getList(@PathVariable("pg")int pg, GuestbookDto dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		dto.setPg(pg);
		
		resultMap.put("totalCnt", service.getTotalCnt(dto));
		resultMap.put("data", service.getList(dto));
		
		return resultMap;
	}
	
	@PostMapping("/guestbook/insert")
	public HashMap<String, Object> insert(@RequestBody GuestbookDto dto){
		HashMap<String, Object>resultMap = new HashMap<String,Object>();
		
		try {
			service.insert(dto);
			resultMap.put("result","success");
			
		} catch(Exception e) {
			// 실제 운영시에는 없애기
			e.printStackTrace();
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
