package com.kosa.myapp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// 기본생성자
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ScoreDto {
	private String name = "";
	private int kor = 0;
	private int eng = 0;
	private int mat = 0;
	private int total = 0;
	private int avg = 0;
}
