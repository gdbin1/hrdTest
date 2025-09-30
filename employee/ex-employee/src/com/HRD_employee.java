package com;

import com.ex.Ex1;
import com.ex.Ex2;
import com.ex.Ex3;
import com.ex.Ex4;

public class HRD_employee {

	public static void main(String[] args) {
		
//		(1) 사원 등록: Employee 테이블에 다음 데이터를 삽입하시오.
//		(홍길동, 영업부, 2020-03-01, 2500000)
//		(이순신, 인사부, 2019-07-15, 3200000)
//		(강감찬, 개발부, 2021-01-10, 2800000)
		
//		Ex1 ex1 = new Ex1();
//		ex1.result();
		
//		(2) 조회:
//			- 부서가 '개발부'인 사원의 사번, 이름, 급여를 조회하시오.
//			- 급여가 3,000,000원 이상인 사원의 이름과 부서를 조회하시오.
		
		Ex2 ex2 = new Ex2();
		ex2.result();
		
//		(3) 수정:
//			- 이순신의 급여를 3,500,000원으로 수정하시오.
		
		Ex3 ex3 = new Ex3();
		ex3.result();
		
//		(4) 삭제:
//			사번이 1번인 사원의 정보를 삭제하시오.
		
		Ex4 ex4 = new Ex4();
		ex4.result();
	}

}
