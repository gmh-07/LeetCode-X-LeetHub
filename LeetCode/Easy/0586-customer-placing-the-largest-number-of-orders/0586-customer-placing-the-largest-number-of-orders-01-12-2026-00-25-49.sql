# Write your MySQL query statement below
WITH cte AS (
    SELECT COUNT(order_number) AS count,customer_number FROM Orders
    GROUP BY customer_number 
)

SELECT customer_number FROM cte
ORDER BY count DESC
LIMIT 1;