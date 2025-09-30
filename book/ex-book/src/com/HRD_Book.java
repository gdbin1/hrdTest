package com;

import com.ex.Ex1;
import com.ex.Ex2;
import com.ex.Ex3;
import com.ex.Ex4;
import com.ex.Ex5;

public class HRD_Book {

	public static void main(String[] args) {
		
//		(1) 2020년 이상 (>=) 출판된 도서를 검색하시오.
		Ex1 ex1 = new Ex1();
		ex1.result();
		
//		(2) '홍길동' 회원이 대출한 도서 목록을 출력하시오.
		Ex2 ex2 = new Ex2();
		ex2.result();
		
//		(3) 반납하지 않은 도서를 검색하시오.
		Ex3 ex3 = new Ex3();
		ex3.result();
		
//		(4) 도서별 대출 횟수를 출력하시오.
		Ex4 ex4 = new Ex4();
		ex4.result();
		
//		(5) 가격이 가장 비싼 도서를 출력하시오.
		Ex5 ex5 = new Ex5();
		ex5.result();
	}

}
