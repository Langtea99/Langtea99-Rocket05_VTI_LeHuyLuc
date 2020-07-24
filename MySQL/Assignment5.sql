 USE testingsystem;

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
SELECT * FROM question 
GROUP BY QuestionID
HAVING LENGTH(content) >300;

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