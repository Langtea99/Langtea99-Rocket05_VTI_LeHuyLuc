USE BT;

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ

SELECT `account`.AccountID,`account`.DepartmentID,department.DepartmentName FROM `account` 
LEFT JOIN department
ON `account`.DepartmentID = department.DepartmentID
GROUP BY `account`.AccountID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 

SELECT * FROM department
RIGHT JOIN `account`
ON department.DepartmentID = `account`.DepartmentID
LEFT JOIN position
ON `account`.PositionID = position.PositionID
WHERE CreateDate > '2010-12-20' 
GROUP BY `account`.DepartmentID;

-- Question 3: Viết lệnh để lấy ra tất cả các developer

SELECT*FROM position;
SELECT*FROM `account`
LEFT JOIN position
ON `account`.PositionID = position.PositionID
WHERE position.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT DepartmentID,DepartmentName,soluongnhanvien FROM 
(SELECT department.DepartmentID,department.DepartmentName,COUNT(*)AS soluongnhanvien FROM department
JOIN `account`
ON department.DepartmentID = `account`.DepartmentID
GROUP BY department.DepartmentID)AS q4
WHERE soluongnhanvien > 3 ;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT 
    MAX(soluongcauhoi)
FROM
    (SELECT 
        COUNT(QuestionID) AS soluongcauhoi
    FROM
        examquestion
    GROUP BY QuestionID) AS a;
    
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question

SELECT categoryquestion.CategoryID,categoryquestion.CategoryName,COUNT(*) AS SoluongduocdungtrongQuestion FROM categoryquestion 
LEFT JOIN question
ON categoryquestion.CategoryID = question.CategoryID
GROUP BY categoryquestion.CategoryID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam

SELECT question.questionID,COUNT(*) AS SoluongduocdungtrongExam FROM question
LEFT JOIN categoryquestion
ON question.CategoryID = categoryquestion.CategoryID
LEFT JOIN exam
ON categoryquestion.CategoryID = exam.CategoryID
GROUP BY categoryquestion.CategoryID
ORDER BY question.questionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất

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
        
-- Question 9: Thống kê số lượng account trong mỗi group 

SELECT *FROM `group` CROSS JOIN groupaccount
LEFT JOIN (
SELECT  `group`.GroupID,`group`.groupName,COUNT(*) AS sl FROM `group`  
JOIN groupaccount
ON `group`.GroupID = groupaccount.GroupID
JOIN `account`
ON groupaccount.AccountID = `account`.AccountID
GROUP BY `group`.GroupID) AS q9
ON groupaccount.GroupID = q9.GroupID AND `group`.groupName = q9.groupName
GROUP BY `group`.GroupID,`group`.groupName;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT abc.PositionID,MIN(ab)AS Songuoi FROM(
SELECT position.positionID,COUNT(*)ab FROM `account` 
JOIN position
ON `account` .PositionID = position.PositionID
GROUP BY positionID)AS abc;

-- Question 11: thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

SELECT * FROM department CROSS JOIN position
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
GROUP BY a.departmentID , p.PositionID) AS q10
ON department.DepartmentID =q10.DepartmentID AND department.departmentName = q10.departmentName;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …

SELECT*FROM typequestion
JOIN question
ON typequestion.TypeID = question.TypeID
JOIN categoryquestion
ON question.CategoryID = categoryquestion.CategoryID;

-- Question 13: lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT typequestion.TypeName,COUNT(*)AS soluong FROM typequestion
JOIN question 
ON typequestion.TypeID =question.TypeID
GROUP BY typequestion.TypeID;

-- Question 14: Lấy ra group không có account nào
SELECT * FROM `group`
LEFT JOIN groupaccount
ON `group`.GroupID =groupaccount.GroupID
WHERE groupaccount.AccountID IS Null
GROUP BY `group`.GroupID;

-- Question 16: lấy ra question không có answer nào

SELECT * FROM question
LEFT JOIN answer 
ON question.QuestionID = answer.QuestionID
WHERE answer.Content IS Null
GROUP BY question.QuestionID;

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT * FROM `account` 
JOIN groupaccount 
ON `account`.AccountID = groupaccount.AccountID 
WHERE groupaccount.GroupID ='1'
UNION ALL
SELECT * FROM `account` 
JOIN groupaccount 
ON `account`.AccountID = groupaccount.AccountID 
WHERE groupaccount.GroupID ='2'

-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên
-- c) Ghép 2 kết quả từ câu a) và câu b)

SELECT `group`.groupID,COUNT(*)AS sl FROM `group`
JOIN groupaccount
ON `group`.groupID=groupaccount.groupID
GROUP BY `group`.groupID
HAVING sl >5
UNION
SELECT `group`.groupID,COUNT(*)AS sl FROM `group`
JOIN groupaccount
ON `group`.groupID=groupaccount.groupID
GROUP BY `group`.groupID
HAVING sl <7

