USE `classicmodels`;

-- 1.Tính tổng giá trị của các order đã xuất kho (‘shipped’) trong tháng Tám năm 2004

SELECT*FROM orders;
SELECT 
    SUM(orderdetails.priceEach*orderdetails.quantityOrdered) AS 'Tong tien'
FROM
    orders
JOIN orderdetails 
ON orders.orderNumber = orderdetails.orderNumber 
WHERE orders.`status` = 'Shipped' AND (orders.ShippedDate BETWEEN '2004-08-01' AND '2004-08-31' );

-- 2.Tính lợi nhuận (profit) thu được từ mỗi khách hàng dựa trên các orders mà họ thực hiện. Liệt kê theo tên khách hàng

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

-- 3.Tính doanh thu (revenue) mà mỗi sản phẩm mang lại. Liệt kê theo tên sản phẩm.

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