
--  ---------(2)
SELECT m.NAME AS 이름, b.Title AS 도서
FROM member m
INNER JOIN rental r ON m.MemberID = r.memberID
INNER JOIN book b ON r.BookID = b.BookID
WHERE m.NAME = '홍길동';



-- ------------(3)
SELECT book.Title, rental.RentDate
FROM rental
INNER JOIN book ON rental.BookID = book.BookID
WHERE rental.ReturnDate IS NULL;


-- ---------------(4)
SELECT book.Title AS 도서명, count(rental.RentalID) AS 대출횟수
FROM book
LEFT JOIN rental ON book.BookID = rental.BookID
GROUP BY title;


-- (5)
SELECT MAX(price),title
FROM book;

SELECT title, Price
FROM book
ORDER by price desc
LIMIT 1;