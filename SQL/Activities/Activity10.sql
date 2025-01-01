-----------Activity 10----------
---Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.---
Select * from Salesman
Select * from Orders where SALESMAN_ID=(Select DISTINCT SALESMAN_ID from Customers Where CUSTOMER_ID=3007)

-- Write a query to find all orders attributed to a salesman in New York.---
Select * from Orders where SALESMAN_ID IN (select SALESMAN_ID from Salesman where SALESMAN_CITY = 'New York')

-- Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE salesman_city='New York');

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders
WHERE salesman_id IN( SELECT salesman_id FROM salesman
WHERE commission=( SELECT MAX(commission) FROM salesman));
