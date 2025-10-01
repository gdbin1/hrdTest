show tables;

select * from ShopMember;
drop table ShopMember;

CREATE TABLE ShopMember(
	CustNo INT PRIMARY KEY AUTO_INCREMENT,
	CustName VARCHAR(30) NOT NULL,
	Phone VARCHAR(13) UNIQUE,
	Address VARCHAR(50),
	JoinDate DATE NOT NULL,
	Grade CHAR(1) CHECK(Grade IN ('A','B','C')),
	City CHAR(2)
);

SELECT CustName, Phone, JoinDate
FROM shopmember
WHERE grade = 'A';

SELECT *
FROM ShopMember
WHERE YEAR(JoinDate) > 2020;

select * from sale;
drop table sale;
CREATE TABLE Sale(
	SaleNo INT PRIMARY KEY AUTO_INCREMENT,
	CustNo INT,
	PCost INT,
	Amount INT,
	Price INT,
	PCode CHAR(3),
	FOREIGN KEY (CustNo) REFERENCES ShopMember(CustNo)
);

select * from Shopmember

SELECT M.CustNo, M.CustName, SUM(S.Price * S.Amount) AS Total
FROM ShopMember M
LEFT JOIN Sale S ON M.CustNo = S.CustNo
GROUP BY M.CustNo, M.CustName;

SELECT CustName, SUM(S.Price * S.Amount) AS totalPrice
FROM shopmember M
LEFT JOIN sale S ON M.CustNo = S.CustNo
GROUP BY M.Custname, S.Price
ORDER BY totalPrice DESC
LIMIT 1;



UPDATE shopmember
SET Grade = 'A'
WHERE CustNo = 2;

select * from shopmember;

DELETE
FROM sale
WHERE CustNo = 3;

SELECT * FROM sale;

