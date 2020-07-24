-- Tạo và sử dụng database

DROP DATABASE IF EXISTS QuanLyDiem;
CREATE DATABASE QuanLyDiem;
USE QuanLyDiem;

-- Tạo bảng Student

DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
	RN  		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name` 		VARCHAR(50) NOT NULL,
    Age 		INT ,
    Gender		ENUM('1','0','Null')
);

-- Tạo bảng Subject

DROP TABLE IF EXISTS `Subject`;
CREATE TABLE `Subject`
(
	sID  		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sName 		VARCHAR(50) NOT NULL
);

-- Tạo bảng StudentSubject

DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE StudentSubject
(
	RN  		INT UNSIGNED NOT NULL,
    sID 		INT UNSIGNED NOT NULL,
    Mark 		DECIMAL(4,2) NOT NULL,
    `Date` 		DATE DEFAULT '2020-07-17',
    PRIMARY KEY(RN,sID),
	CONSTRAINT 	RNfk 	FOREIGN KEY (RN) REFERENCES Student (RN) ON DELETE CASCADE,
	CONSTRAINT 	sIDfk 	FOREIGN KEY (sID) REFERENCES `Subject` (sID) ON DELETE CASCADE
);

-- INSERT giá trị vào bảng Student

INSERT INTO Student	(`Name`,				 Age,		Gender) 
VALUES 				('Le Huy Luc',	   		'20',		   '1'),
					('Le Thi Thuy',	  		'20',		   '0'),
					('Pham Van Truong',	   	'20',		   '1'),
                    ('Pham Hong Son',	   	'20',		'Null'),
                    ('Do Thanh Cong',	   	'20',		   '1');

-- INSERT giá trị vào bảng `Subject`

INSERT INTO `Subject`(sName)
VALUES               ('Math'),
					 ('Physical'),
                     ('Chemistry'),
                     ('Biological'),
                     ('Philosophy');

-- INSERT giá trị vào bảng StudentSubject

INSERT INTO StudentSubject (RN,				sID,			Mark,			`Date`)
VALUES                     ('1',			'1',			'9.5' ,	  '2020-07-17'),
						   ('1',			'4',			'9.0' ,	  '2020-07-17'),
                           ('1',			'5',			'9.75',	  '2020-07-17'),
                           ('2',			'1',			'9.0',	  '2020-07-17'),
                           ('3',			'3',			'8.5',	  '2020-07-17'),
                           ('5',			'3',			'9.0',	  '2020-07-17'),
                           ('5',			'5',			'9.0',	  '2020-07-17'),
                           ('3',			'5',			'8.75',	  '2020-07-17'),
                           ('3',			'4',			'7.5',	  '2020-07-17'),
                           ('4',			'4',			'8.0',	  '2020-07-17');
                           
-- Lấy tất cả các môn học không có bất kì điểm nào

SELECT * FROM `Subject` 
LEFT JOIN StudentSubject 
ON   `Subject`.sID = StudentSubject.sID 
GROUP BY `Subject`.sName
HAVING StudentSubject.sID IS NULL;

-- Lấy danh sách các môn học có ít nhất 2 điểm

SELECT  `Subject`.sName,COUNT(*)AS Soluongdiem FROM `Subject` 
JOIN StudentSubject 
ON   `Subject`.sID = StudentSubject.sID 
GROUP BY `Subject`.sName
HAVING Soluongdiem >=2
ORDER BY `Subject`.sID;

-- Tạo "StudentInfo" view có các thông tin về học sinh bao gồm: RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho null

CREATE OR REPLACE VIEW StudentInfo AS
SELECT Student.RN,`Subject`.sID,Student.`Name`,Student.Age,
CASE Student.Gender 
WHEN '0'THEN 'Male'
WHEN '1' THEN 'Female'
ELSE 'Unknow'
END AS Gender,
`Subject`.sName,StudentSubject.Mark,StudentSubject.`Date`FROM Student 
JOIN StudentSubject
ON   Student.RN = StudentSubject.RN
JOIN `Subject`
ON   StudentSubject.sID =`Subject`.sID
ORDER BY StudentSubject.RN;

SELECT * FROM StudentInfo;

-- Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của cột sID của table StudentSubject cũng thay đổi theo

DROP TRIGGER IF EXISTS CasUpdate ;
DELIMITER $$
CREATE TRIGGER CasUpdate 
AFTER UPDATE ON `Subject`
FOR EACH ROW
BEGIN 
UPDATE  StudentSubject1
SET  sID = NEW.sID
WHERE
sID =  OLD.sID;
END $$
DELIMITER ;

-- Trigger casDel: Khi xóa 1 subject , các dữ liệu của table StudentSubject cũng sẽ bị xóa theo

DROP TRIGGER IF EXISTS CasDel ;
DELIMITER $$
CREATE TRIGGER CasDel
BEFORE DELETE ON Subject
FOR EACH ROW
BEGIN 
DELETE FROM StudentSubject WHERE sID = OLD.sID;
END $$
DELIMITER ;

DELETE FROM `Subject`
WHERE sID = '4' ;

SELECT * FROM StudentSubject;

-- Viết 1 thủ tục (có 2 parameters: student name, mark). Thủ tục sẽ xóa tất cả các thông tin liên quan tới học sinh có cùng tên như parameter và tất cả các điểm nhỏ hơn của các học sinh đó. 
-- Trong trường hợp nhập vào "*" thì thủ tục sẽ xóa tất cả các học sinh

DELETE FROM  student WHERE `Name` = 'Le Huy Luc';
DROP PROCEDURE IF EXISTS PROCEDURE_DELETE;
DELIMITER $$ 
CREATE PROCEDURE PROCEDURE_DELETE(IN student_name VARCHAR(35),IN mark VARCHAR(35))
BEGIN
DELETE FROM student WHERE `Name` = student_name;
WITH 
Diemnhohon AS(
SELECT student.`Name`,studentsubject.RN,studentsubject.sID,studentsubject.Mark,studentsubject.`Date` 
FROM student,studentsubject
WHERE student.RN = studentsubject.RN)
DELETE FROM Diemnhohon WHERE Diemnhohon.`Name`=student_name AND Diemnhohon.Mark < mark ;
IF mark ='*' THEN DELETE FROM Diemnhohon;
END $$
DELIMITER ;

CALL PROCEDURE_DELETE('Le Huy Luc','8.5');

