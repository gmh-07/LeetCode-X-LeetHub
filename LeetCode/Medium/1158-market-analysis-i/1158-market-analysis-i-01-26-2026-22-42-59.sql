-- Write your PostgreSQL query statement below
WITH cte AS(
    SELECT buyer_id,COUNT(order_id) AS orders_in_2019 
    FROM Orders
    WHERE EXTRACT(YEAR FROM order_date) = 2019
    GROUP BY buyer_id
)

SELECT u.user_id AS buyer_id,
        u.join_date AS join_date,
        COALESCE(cte.orders_in_2019,0) AS orders_in_2019
FROM Users u
LEFT JOIN cte
ON u.user_id = cte.buyer_id;