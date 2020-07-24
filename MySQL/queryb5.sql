USE testingsystem;

-- Viết lệnh để lấy ra các câu hỏi được sử dụng nhiều nhất trong đề thi
SELECT 
    MAX(b)
FROM
    (SELECT 
        COUNT(QuestionID) AS b
    FROM
        examquestion
    GROUP BY QuestionID) AS a;


SELECT*FROM question;
SELECT*FROM examquestion;

SELECT COUNT(QuestionID) FROM examquestion 
GROUP BY QuestionID;
        
CREATE TABLE Vovan
(Truongvovan INT );
insert into Vovan values (1);
SELECT 
    *
FROM
    account
WHERE NOT EXISTS(SELECT*FROM Vovan WHERE Truongvovan=1);

CREATE OR REPLACE VIEW vv AS
SELECT 
    *
FROM
    question
WHERE
    QuestionID = ANY (SELECT 
            questionID
        FROM
            answer
        WHERE
            questionID >5);
SELECT*FROM vv;

-- Lấy ra Question có nhiều câu trả lời nhất
SELECT 
    question.QuestionID, COUNT(*) AS Sctt
FROM
    question
        LEFT JOIN
    answer ON question.QuestionID = answer.QuestionID
GROUP BY question.QuestionID
HAVING Sctt = (SELECT 
        MAX(ab)
    FROM
        (SELECT 
            COUNT(QuestionID) AS ab
        FROM
            answer
        GROUP BY QuestionID) AS abc);
 
SELECT COUNT(QuestionID) FROM answer
GROUP BY QuestionID;
 SELECT 
	QuestionID,Max(b)
FROM
    (SELECT 
        QuestionID,COUNT(QuestionID) AS b
    FROM
        answer
    GROUP BY QuestionID) AS a;
    
-- Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT *FROM department CROSS JOIN position
LEFT JOIN 
 (SELECT 
    d.departmentID,
    departmentName,
    positionName,
    COUNT(a.PositionID) AS soluong
FROM
    position p
        RIGHT JOIN
    Account a ON p.PositionID = a.PositionID
        RIGHT JOIN
    department d ON d.departmentID = a.DepartmentID
GROUP BY a.departmentID , p.PositionID)AS acb


SELECT *FROM department CROSS JOIN position
WHERE position.PositionName IN ('Dev','Test','Scrum Master','PM');


-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale 

CREATE OR REPLACE VIEW question1 AS
    SELECT 
        account.AccountID,
        account.Email,
        account.Username,
        account.FullName,
        account.DepartmentID,
        account.PositionID,
        account.CreateDate,
        department.DepartmentName
    FROM
        account
            LEFT JOIN
        department ON account.DepartmentID = department.DepartmentID
    GROUP BY account.AccountID
    HAVING department.DepartmentName = 'Sale'
    ORDER BY account.AccountID;

SELECT*FROM question1;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW question2 AS
SELECT account.AccountID,
        account.Email,
        account.Username,
        account.FullName,
        account.DepartmentID,
        account.PositionID,
        account.CreateDate,
        COUNT(*) AS Sogroupthamgia
FROM account 
JOIN groupaccount
ON account.AccountID = groupaccount.AccountID
GROUP BY account.AccountID
HAVING Sogroupthamgia = (
SELECT Max(abc)
FROM
        (SELECT 
            COUNT(AccountID) AS abc 
        FROM
            groupaccount
        GROUP BY AccountID) AS abcd);
        
SELECT*FROM question2;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW question3 AS
SELECT * FROM question WHERE content > LENGTH(300);

DROP VIEW question3;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW question4 AS
SELECT department.DepartmentID,department.departmentName,COUNT(*)AS Soluongnhanvien FROM department
JOIN account
ON department.DepartmentID = account.DepartmentID
GROUP BY department.DepartmentID
HAVING Soluongnhanvien = (
SELECT Max(sl)
FROM
        (SELECT 
            COUNT(DepartmentID) AS sl
        FROM
            account
        GROUP BY DepartmentID) AS abcde);

SELECT*FROM question4;

-- Question 5: Tạo view có chứa tất các các câu hỏi có user họ Nguyễn
CREATE OR REPLACE VIEW question5 AS
SELECT question.QuestionID,question.Content,question.CategoryID,question.TypeID,question.CreateDate,account.FullName AS Creator FROM question
JOIN account
ON question.CreatorID = account.AccountID
GROUP BY question.QuestionID
HAVING account.FullName LIKE '%Nguyen%'
ORDER BY question.QuestionID;

SELECT*FROM question5;

SELECT dp.DepartmentName,dp.PositionName,IFNULL(c.soluong,0) FROM
(SELECT d.departmentID,p.PositionID,d.DepartmentName,p.PositionName,COUNT(*)AS soluong FROM department d
LEFT JOIN account a
ON d.DepartmentID = a.DepartmentID
LEFT JOIN position p
ON a.PositionID = p.PositionID
GROUP BY a.PositionID,d.DepartmentID)AS c
RIGHT JOIN 
(SELECT*FROM department CROSS JOIN position)AS dp
ON c.departmentID = dp.departmentID AND c.positionID = dp.PositionID
ORDER BY dp.DepartmentID;
--
DROP PROCEDURE IF EXISTS VD;
DELIMITER $$ 
CREATE PROCEDURE VD (IN Department1 VARCHAR(30),IN PositionName1 VARCHAR(30))
BEGIN
DECLARE soluong INT ;
SELECT IFNULL(c.soluong,0) INTO soluong FROM
(SELECT d.departmentID,p.PositionID,d.DepartmentName,p.PositionName,COUNT(*)AS soluong FROM department d
LEFT JOIN account a
ON d.DepartmentID = a.DepartmentID
LEFT JOIN position p
ON a.PositionID = p.PositionID
GROUP BY a.PositionID,d.DepartmentID)AS c
RIGHT JOIN 
(SELECT*FROM department CROSS JOIN position)AS dp
ON c.departmentID = dp.departmentID AND c.positionID = dp.PositionID
WHERE dp.departmentName = Department1 AND dp.PositionName = PositionName1 
ORDER BY dp.DepartmentID;
SELECT soluong;
END $$
DELIMITER ;
CALL VD('Marketing','Test');

-- Viết function lấy ra số 'test' của 2 phòng ban
DROP FUNCTION IF EXISTS VD1;
DELIMITER $$ 
CREATE FUNCTION VD1 (Department1 VARCHAR(30), Department2 VARCHAR(30) ) RETURNS INT
BEGIN
DECLARE soluong1 INT ;
DECLARE soluong2 INT;
DECLARE Tong INT;
SELECT IFNULL(c.soluong,0) INTO soluong1 FROM
(SELECT d.departmentID,p.PositionID,d.DepartmentName,p.PositionName,COUNT(*)AS soluong FROM department d
LEFT JOIN account a
ON d.DepartmentID = a.DepartmentID
LEFT JOIN position p
ON a.PositionID = p.PositionID
GROUP BY a.PositionID,d.DepartmentID)AS c
RIGHT JOIN 
(SELECT*FROM department CROSS JOIN position)AS dp
ON c.departmentID = dp.departmentID AND c.positionID = dp.PositionID
WHERE dp.departmentName = Department1 AND dp.PositionName = 'Test' 
ORDER BY dp.DepartmentID;

SELECT IFNULL(c.soluong,0) INTO soluong2 FROM
(SELECT d.departmentID,p.PositionID,d.DepartmentName,p.PositionName,COUNT(*)AS soluong FROM department d
LEFT JOIN account a
ON d.DepartmentID = a.DepartmentID
LEFT JOIN position p
ON a.PositionID = p.PositionID
GROUP BY a.PositionID,d.DepartmentID)AS c
RIGHT JOIN 
(SELECT*FROM department CROSS JOIN position)AS dp
ON c.departmentID = dp.departmentID AND c.positionID = dp.PositionID
WHERE dp.departmentName = Department1 AND dp.PositionName = 'Test' 
ORDER BY dp.DepartmentID;
SET tong= soluong1+soluong2;
RETURN tong;
END $$
DELIMITER ;

SELECT VD1('Marketing','Sale');


























   
