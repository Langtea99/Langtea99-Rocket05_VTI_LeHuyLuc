USE testingsystem;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó

-- Cách làm 1
DROP PROCEDURE IF EXISTS question1;
DELIMITER $$ 
CREATE PROCEDURE question1 (IN Department1 VARCHAR(30),OUT accountID VARCHAR(30),OUT departmentID VARCHAR(30))
BEGIN
SELECT account.accountID,account.departmentID INTO accountID,departmentID FROM department 
 LEFT JOIN account
 ON department.DepartmentID = account.DepartmentID
 WHERE department.DepartmentName = Department1
 ORDER BY department.departmentID;
END $$
DELIMITER ;
SET @accountID = '';
SET @departmentID = '';
CALL question1('Marketing',@accountID,@departmentID);
SELECT @accountID,@departmentID;

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

DROP PROCEDURE IF EXISTS question2;
DELIMITER $$ 
CREATE PROCEDURE question2 (IN GroupID VARCHAR(30), OUT IDGroup INT, OUT GroupName VARCHAR(30),OUT soluongaccount INT)
BEGIN
SELECT `group`.GroupID,`group`.GroupName,COUNT(*)AS slaccount INTO IDGroup,GroupName,soluongaccount FROM `group`
LEFT JOIN groupaccount
ON `group`.GroupID = groupaccount.GroupID
WHERE `group`.groupID = GroupID 
GROUP BY `group`.GroupID 
ORDER BY `group`.GroupID;
END $$
DELIMITER ;

SET @IDGroup = '';
SET @GroupName = '';
SET @soluongaccount = '';
CALL question2('1',@IDGroup,@GroupName,@soluongaccount);
SELECT @IDGroup,@GroupName,@soluongaccount;

-- Cách làm 2
DROP PROCEDURE IF EXISTS question2;
DELIMITER $$ 
CREATE PROCEDURE question2 (IN GroupID VARCHAR(30))
BEGIN
DECLARE IDgroup INT;
DECLARE GroupName VARCHAR(30);
DECLARE soluongaccount INT;
SELECT `group`.GroupID,`group`.GroupName,COUNT(*)AS slaccount INTO IDGroup,GroupName,soluongaccount FROM `group`
LEFT JOIN groupaccount
ON `group`.GroupID = groupaccount.GroupID
WHERE `group`.groupID = GroupID 
GROUP BY `group`.GroupID 
ORDER BY `group`.GroupID;
SELECT IDGroup,GroupName,soluongaccount;
END $$
DELIMITER ;

CALL question2('1');

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại


DROP PROCEDURE IF EXISTS question3;
DELIMITER $$ 
CREATE PROCEDURE question3 (IN CreateDateNow VARCHAR(30))
BEGIN
DECLARE TypeID INT;
DECLARE Soluong INT;
SELECT q3.TypeID,IFNULL(Sl,0)INTO TypeID,Soluong  FROM
(SELECT typequestion.TypeID,COUNT(*)AS Sl,question.CreateDate 
FROM typequestion
LEFT JOIN question 
ON typequestion.TypeID = question.TypeID
WHERE MONTH(question.CreateDate) = CreateDateNow
GROUP BY typequestion.TypeID
ORDER BY typequestion.TypeID) AS q3;
SELECT TypeID,Soluong;
END $$
DELIMITER ;

CALL question3('2020-04-05');

SELECT typequestion.TypeID,COUNT(*) FROM typequestion
LEFT JOIN question 
ON typequestion.TypeID = question.TypeID
WHERE question.CreateDate LIKE "2020-04-%"
GROUP BY typequestion.TypeID
ORDER BY typequestion.TypeID;


-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

DROP PROCEDURE IF EXISTS question4;
DELIMITER $$ 
CREATE PROCEDURE question4 ()
BEGIN
DECLARE IDQuestion INT;
DECLARE slm INT;
SELECT QuestionID, MAX(sl) AS az INTO IDQuestion,slm FROM(
SELECT question.QuestionID,COUNT(*) sl FROM question
JOIN typequestion
ON question.TypeID = typequestion.TypeID
GROUP BY typequestion.TypeID)AS q4;
SELECT IDQuestion;
END $$
DELIMITER ;

CALL question4();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question


DROP PROCEDURE IF EXISTS question5;
DELIMITER $$ 
CREATE PROCEDURE question5()
BEGIN
DECLARE sTypeName INT;
DECLARE slm INT;
SELECT TypeName, MAX(sl) AS az INTO sTypeName,slm FROM(
SELECT typequestion.TypeName,COUNT(*) sl FROM question
JOIN typequestion
ON question.TypeID = typequestion.TypeID
GROUP BY typequestion.TypeID)AS q5;
SELECT sTypeName;
END $$
DELIMITER ;

CALL question5();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào

DROP PROCEDURE IF EXISTS question6;
DELIMITER $$ 
CREATE PROCEDURE question6(IN Chuoi VARCHAR(30) )
BEGIN
SELECT * FROM `group` WHERE GroupName = Chuoi;
SELECT * FROM `account` WHERE Username = Chuoi;
END $$
DELIMITER ;

CALL question6('');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán username sẽ giống email nhưng bỏ phần @..mail đi positionID: sẽ có default là developer departmentID: sẽ được cho vào 1 phòng chờ .Sau đó in ra kết quả tạo thành công


DROP PROCEDURE IF EXISTS question7;
DELIMITER $$
CREATE PROCEDURE question7(	IN	in_email VARCHAR(30), IN in_fullName NVARCHAR(30))						
BEGIN
	DECLARE Username VARCHAR(30) DEFAULT SUBSTRING_INDEX(in_email,'@',1);
    DECLARE PositionID TINYINT UNSIGNED DEFAULT 1;
    DECLARE DepartmentID TINYINT UNSIGNED DEFAULT 10;
    DECLARE CreateDate DATETIME DEFAULT NOW();
	
	INSERT INTO `Account` 	(Email		,Username, FullName		, DepartmentID,	PositionID,	CreateDate)
    VALUE					(in_email	,Username, in_fullName	, DepartmentID, PositionID, CreateDate);
	
    SELECT 	*
    FROM 	`Account`A
    WHERE	A.Username = Username;
	
END$$
DELIMITER ;
CAll question7();

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS question8;
DELIMITER $$ 
CREATE PROCEDURE question8(IN Chuoi VARCHAR(30))
BEGIN
IF (Chuoi = 'Essay') THEN
		SELECT	Content, MAX(LENGTH(Content))
		FROM	Question
		WHERE	TypeID = 1;
	ELSEIF (Chuoi = 'Multiple-Choice') THEN
		SELECT	Content, MAX(LENGTH(Content))
		FROM	Question
		WHERE	TypeID = 2;
	END IF;
END $$
DELIMITER ;

CALL question8('');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

DROP PROCEDURE IF EXISTS question9;
DELIMITER $$ 
CREATE PROCEDURE question9(IN IDexam INT)
BEGIN
DELETE FROM Exam WHERE ExamID = IDexam;
END $$
DELIMITER ;

CALL question9('1');

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa), sau đó in số lượng record đã remove từ các table liên quan trong khi removing

DROP PROCEDURE IF EXISTS question10;
DELIMITER $$ 
CREATE PROCEDURE question10()
BEGIN
DECLARE RecordXoa INT;
DECLARE IDExam    INT;
SELECT ExamID,COUNT(*)AS z INTO IDExam,RecordXoa FROM Exam WHERE(YEAR(NOW()) - YEAR(CreateDate)) > 3;
DELETE FROM Exam  WHERE(YEAR(NOW()) - YEAR(CreateDate)) > 3 ;
SELECT RecordXoa;
END $$
DELIMITER ;

CALL question10();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc

DROP PROCEDURE IF EXISTS question11;
DELIMITER $$ 
CREATE PROCEDURE question11(IN NameDepartment VARCHAR(30))
BEGIN
DELETE FROM department WHERE DepartmentName = NameDepartment ;
UPDATE department SET DepartmentName = 'phong ban cho viec' WHERE DepartmentName = NameDepartment ;
END $$
DELIMITER ;

CALL question11('');

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay

DROP PROCEDURE IF EXISTS quesstion12;
DELIMITER $$
CREATE PROCEDURE quesstion12()
BEGIN
		SELECT abc.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
             SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
        ) AS abc
		LEFT JOIN Question ON abc.MONTH = MONTH(CreateDate)
		GROUP BY abc.MONTH
		ORDER BY abc.MONTH ASC;
END$$
DELIMITER ;
SELECT *FROM question;

CALL question12();

-- queston 13

DROP PROCEDURE IF EXISTS question13;
DELIMITER $$
CREATE PROCEDURE question13()
BEGIN
		SELECT abc.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
			SELECT MONTH(CURRENT_DATE - INTERVAL 5 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 4 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 3 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 2 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AS MONTH
			UNION
			SELECT MONTH(CURRENT_DATE - INTERVAL 0 MONTH) AS MONTH
        ) AS abc
		LEFT JOIN Question ON abc.MONTH = MONTH(CreateDate)
		GROUP BY abc.MONTH
		ORDER BY abc.MONTH ASC;
END$$
DELIMITER ;