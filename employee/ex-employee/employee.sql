SELECT EmpNo, EmpName, Salary
FROM employee
WHERE salary >= 3000000;

drop table employee;

CREATE TABLE Employee(
	EmpNo INT PRIMARY KEY AUTO_INCREMENT,
	EmpName VARCHAR(30) NOT NULL,
	Dept VARCHAR(20) NOT NULL,
	HireDate DATE NOT NULL,
	Salary INT,
	CHECK (salary >= 2000000)
);

show tables;

select * from employee;

-- 1번 --------------------------
INSERT INTO Employee VALUES (1,'홍길동', '영업부', '2020-03-01', 2500000);
INSERT INTO Employee VALUES (2,'이순신', '인사부', '2019-07-15', 3200000);
INSERT INTO Employee VALUES (3,'강감찬', '개발부', '2021-01-10', 2800000);



-- 2번- -----------------------------
SELECT EmpNo, EmpName, salary
FROM employee
WHERE Dept = '개발부';

SELECT EmpName, Dept
FROM employee
WHERE salary > 3000000;

-- 3번 --------------------------------
UPDATE employee
SET salary = 3500000
WHERE EmpNo = 2;

-- 4번 ---------------------------------
DELETE 
FROM employee
WHERE EmpNo = 1;
