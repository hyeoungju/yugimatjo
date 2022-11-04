package com.matjo.rsrs.user;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int point;
		String grade;
		
		System.out.println("회원님의 포인트를 입력하세요");
		point = input.nextInt();
		
		if (point >= 1200) {
			grade = "독수리알";
		}
		else if (point >=700) {
			grade = "타조알";
		}
		else if (point >= 300) {
			grade = "계란";
		}
		else {
			grade = "메추리알";
		}
		System.out.println("회원님의 포인트는 " +grade+ " 입니다.");

	}

}
