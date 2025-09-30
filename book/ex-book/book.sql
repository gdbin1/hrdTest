show tables;

select * from member;



SELECT title FROM book
WHERE Pubyear >= 2020;

SELECT title, PubYear FROM book
WHERE Pubyear >= 2020;

SELECT m.NAME AS 이름, b.Title AS 도서
FROM member m
INNER JOIN rental r ON m.MemberID = r.memberID
INNER JOIN book b ON r.BookID = b.BookID
WHERE m.NAME = '홍길동';









