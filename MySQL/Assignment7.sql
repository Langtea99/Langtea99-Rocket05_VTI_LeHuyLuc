USE testingsystem;

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước

DROP TRIGGER IF EXISTS question1;
DELIMITER $$

CREATE  TRIGGER question1
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
IF DATEDIFF(NOW(),NEW.CreateDate) >= 365 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_text =' Không insert được :)';
END IF;
END $$
DELIMITER ;

INSERT INTO `group`(  GroupName			, CreatorID		, CreateDate) VALUES(N'Testing System1'		,   5			,'2020-03-05');
