package com.kosa.myapp.guestbook.service;

import java.util.List;

import com.kosa.myapp.guestbook.GuestbookDto;

public interface GuestbookService {
	List<GuestbookDto> getList(GuestbookDto dto);
	int getTotalCnt(GuestbookDto dto);
	GuestbookDto getView(GuestbookDto dto);
	void insert(GuestbookDto dto);
	
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
}
