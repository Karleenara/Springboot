package com.kosa.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 접근 허가를 받는 사이트의 도메인이 저장되어야 함 
// 	localhost 나 127.0.0.1 브라우저에 따라서 다르게 동착
// 	* 접속요청 나오는걸 모두 받겠다
// 	실제 운영시, 도메인명 적어야함
@CrossOrigin(origins="*")
@RestController
public class BoardController {
	@GetMapping("/board/list/{pg}")
	public HashMap<String, Object> 
		getList(@PathVariable("pg")String pg, BoardDto dto){
			HashMap<String, Object> map = new HashMap<String, Object>();
			List<BoardDto> list = new ArrayList<BoardDto>();
			for(int i=1; i<=20; i++) {
				list.add(new BoardDto(""+i, "제목"+i, "작성자"+i, "내용"+i, "파일"+i, "이미지"+i));
			}
		map.put("totalCnt", 20);
		map.put("list", list);
		
		return map;
	}
}
