-----------Activity 9-----
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL
--------Write an SQL statement to know which salesman are working for which customer.-------
Select a.CUSTOMER_NAME,a.SALESMAN_ID,b.SALESMAN_NAME from Customers a
Inner JOin salesman b 
ON a.salesman_id=b.salesman_id;
-----------Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman.----
SELECT a.customer_name, a.grade, b.salesman_name FROM customers a 
LEFT JOIN salesman b 
ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;
----Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%
SELECT a.customer_name,b.salesman_name,b.commission FROM customers a 
    LEFT JOIN salesman b ON a.salesman_id=b.salesman_id
WHERE b.commission>12;
-- Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.------------
Select a.ORDER_NO,a.ORDER_DATE,a.PURCHASE_AMOUNT,b.CUSTOMER_NAME,c.SALESMAN_NAME from Orders a
Inner Join customers b ON a.customer_id = b.customer_id
Inner Join salesman c ON a.salesman_id=c.salesman_id