USE `classicmodels`;

-- 1.Lấy ra thông tin khách hàng và các oder mà khách hàng đó đã mua
SELECT customerName,orderNumber FROM customers c
INNER JOIN orders o
   ON c.customerNumber = o.customerNumber ; 
   
-- 2.Lấy ra các nhân viên làm việc tại USA   
   
SELECT 
    *
FROM
    customers,
    orders
WHERE
    employees.officeCode = offices.officeCode
        AND offices.country = 'usa';
        
-- 3.Thống kê mỗi khách hàng đã thực hiện bao nhiêu order

SELECT 
    customers.customerName,
    COUNT(orders.customerNumber) AS 'Soluong'
FROM
    customers
LEFT JOIN orders 
ON customers.customerNumber = orders.customerNumber
GROUP BY customers.customerNumber
ORDER BY COUNT(orders.customerNumber);

-- 4.Thống kê mỗi khách hàng đã tiêu bao nhiêu tiền
SELECT 
    customers.customerName,
    SUM(orderdetails.priceEach*orderdetails.quantityOrdered) AS 'Tong tien'
FROM
    customers
LEFT JOIN orders 
ON customers.customerNumber = orders.customerNumber 
LEFT JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber 
GROUP BY customers.customerNumber;

-- 5.Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004
SELECT*FROM orders;
SELECT 
    SUM(orderdetails.priceEach*orderdetails.quantityOrdered) AS 'Tong tien'
FROM
    orders
JOIN orderdetails 
ON orders.orderNumber = orderdetails.orderNumber 
WHERE orders.`status` = 'Shipped' AND (orders.ShippedDate BETWEEN '2004-08-01' AND '2004-08-31' );

-- 6.Tính lợi nhuận (profit) thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện. Liệt kê theo tên khách hàng
SELECT 
    customers.customerName,
    SUM((orderdetails.priceEach*orderdetails.quantityOrdered)-(products.buyPrice*orderdetails.quantityOrdered)) AS 'Lợi nhuận'
FROM
    customers
LEFT JOIN orders 
ON customers.customerNumber = orders.customerNumber 
LEFT JOIN orderdetails
ON orders.orderNumber = orderdetails.orderNumber
LEFT JOIN products
ON orderdetails.productCode = products.productCode 
GROUP BY customers.customerNumber
ORDER BY (customerName);

-- 7.Tính doanh thu (revenue) mà mỗi sản phẩm mang lại. Liệt kê theo tên sản phẩm.
SELECT 
    products.productName,
    SUM(orderdetails.priceEach*orderdetails.quantityOrdered) AS 'Doanh thu'
FROM
    products
LEFT JOIN orderdetails 
ON products.productCode = orderdetails.productCode 
GROUP BY products.productName;

SELECT productName FROM products;


SELECT 
    customers.customerName,
    SUM((products.MSRP - products.buyPrice) * orderdetails.quantityOrdered)
FROM
    customers
        LEFT JOIN
    orders ON customers.customerNumber = orders.customerNumber
		LEFT JOIN
    orderdetails ON orders.orderNumber = orderdetails.orderNumber
		LEFT JOIN
    products ON orderdetails.productCode = products.productCode
GROUP BY (customers.customerNumber)
ORDER BY (customerName);

   


