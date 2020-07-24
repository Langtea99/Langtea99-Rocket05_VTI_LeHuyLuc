USE Project;

-- Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.

SELECT * FROM customer;
<<<<<<< HEAD
<<<<<<< HEAD
SELECT * FROM car_order;
SELECT * FROM car;

SELECT customer.`Name`,SUM(car_order.Amount) AS Soluongdamua FROM customer
LEFT JOIN car_order
ON customer.CustomerID = car_order.CustomerID
GROUP BY customer.CustomerID
ORDER BY soluongdamua;
=======
=======
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
SELECT COUNT(*) FROM car_order;
SELECT * FROM car;

SELECT customer.CustomerID,COUNT(*)AS Soluongdamua FROM customer
LEFT JOIN car_order
ON customer.CustomerID = car_order.CustomerID
GROUP BY customer.CustomerID
ORDER BY soluongdamua,customer.CustomerID;
<<<<<<< HEAD
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
	
--  Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.

SELECT car.Maker,COUNT(*) AS Soluongdaban FROM car
LEFT JOIN car_order
ON car.CarID = car_order.CarID
LEFT JOIN customer
ON car_order.CustomerID = customer.CustomerID
<<<<<<< HEAD
<<<<<<< HEAD
WHERE YEAR(car_order.Delivercustomer.CustomerID,yDate) LIKE '2000%'
=======
WHERE YEAR(car_order.DeliveryDate) LIKE '2000%'
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
WHERE YEAR(car_order.DeliveryDate) LIKE '2000%'
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
GROUP BY car.Maker
HAVING Soluongdaban = (SELECT 
        MAX(ab)
    FROM
        (SELECT 
<<<<<<< HEAD
<<<<<<< HEAD
            SUM(Amount) AS ab
=======
            COUNT(carID) AS ab
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
            COUNT(carID) AS ab
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
        FROM
            car_order
        GROUP BY carID) AS abc);
        
<<<<<<< HEAD
<<<<<<< HEAD
DROP FUNCTION IF EXISTS question3;
=======
DROP PROCEDURE IF EXISTS question3;
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
DROP PROCEDURE IF EXISTS question3;
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
DELIMITER $$ 
CREATE FUNCTION question3() RETURNS CHAR(30)
BEGIN
DECLARE carMaker CHAR(30);
<<<<<<< HEAD
<<<<<<< HEAD
SELECT 
    abc.Maker INTO carMaker
FROM
    (SELECT 
        car.Maker, SUM(car_order.amount) AS tong
    FROM
        car
    JOIN car_order ON car.CarID = car_order.carID
    WHERE
        YEAR(car_order.DeliveryDate) = 2000
    GROUP BY car.Maker) AS abc
WHERE
    abc.tong = (SELECT 
            MAX(ab.tong)
        FROM
            (SELECT 
                car.Maker, SUM(car_order.amount) AS tong
            FROM
                car
            JOIN car_order ON car.CarID = car_order.carID
            WHERE
                YEAR(car_order.DeliveryDate) = 2000
            GROUP BY car.Maker) AS ab);
=======
=======
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
DECLARE soluong INT;
SELECT car.Maker,COUNT(*) AS Soluongdaban INTO carMaker,soluong FROM car
LEFT JOIN car_order
ON car.CarID = car_order.CarID
LEFT JOIN customer
ON car_order.CustomerID = customer.CustomerID
WHERE YEAR(car_order.DeliveryDate) LIKE '2000%'
GROUP BY car.Maker
HAVING Soluongdaban = (SELECT 
        MAX(ab)
    FROM
        (SELECT 
            COUNT(carID) AS ab
        FROM
            car_order
        GROUP BY carID) AS abc);
<<<<<<< HEAD
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
RETURN carMaker;
END $$
DELIMITER ;

SELECT question3();

-- Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.

DROP PROCEDURE IF EXISTS question4;
DELIMITER $$ 
CREATE PROCEDURE question4()
BEGIN
DECLARE sobanghibixoa INT;
SELECT COUNT(*)AS sobanghixoa INTO sobanghibixoa  FROM car_order
WHERE Staus = 2 AND YEAR(OrderDate) < YEAR(NOW());
DELETE  FROM car_order 
WHERE Staus = 2 AND YEAR(OrderDate) < YEAR(NOW());
SELECT sobanghibixoa;
END $$
DELIMITER ;

CALL question4();

-- Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất

SELECT customer.`Name`,car_order.OrderID,car_order.Amount,car.Maker  FROM car
LEFT JOIN car_order
ON car.CarID = car_order.CarID
LEFT JOIN customer
ON car_order.CustomerID = customer.CustomerID
WHERE car_order.staus = '0';

DROP PROCEDURE IF EXISTS question5;
DELIMITER $$ 
<<<<<<< HEAD
<<<<<<< HEAD
CREATE PROCEDURE question5(IN CustomerID INT )
=======
CREATE PROCEDURE question5(CustomerID INT )
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
CREATE PROCEDURE question5(CustomerID INT )
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
BEGIN
SELECT customer.`Name`,car_order.OrderID,car_order.Amount,car.Maker  FROM car
LEFT JOIN car_order
ON car.CarID = car_order.CarID
LEFT JOIN customer
ON car_order.CustomerID = customer.CustomerID
WHERE car_order.staus = '0' AND car_order.CustomerID = CustomerID;
END $$
DELIMITER ;

CALL question5(1);

-- Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15)

DROP TRIGGER IF EXISTS question6;
DELIMITER $$ 
CREATE TRIGGER question6
BEFORE INSERT ON car_order
FOR EACH ROW
BEGIN
	IF DATEDIFF(new.DeliveryDate,new.OrderDate)<15 then
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT='Loi khong duoc nhap nam nay';
    END IF;
END $$
<<<<<<< HEAD
<<<<<<< HEAD
DELIMITER $$ ;



=======
DELIMITER $$ ;
>>>>>>> 67dfa0a2afdaf28aeb7d67d3f1caa0d2a4ae9900
=======
DELIMITER $$ ;
>>>>>>> bb6f075ed26c86f919bca9a9f0f796e1573c988d
