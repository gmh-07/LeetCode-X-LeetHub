# Write your MySQL query statement below
WITH first_order_cte AS(
    SELECT *,
        ROW_NUMBER() OVER(
            PARTITION BY customer_id
            ORDER BY order_date ASC
        ) AS rnk
    FROM Delivery
)

SELECT ROUND(AVG(
    CASE
        WHEN order_date = customer_pref_delivery_date THEN 1
        ELSE 0
    END
)*100,2) AS immediate_percentage 
FROM first_order_cte
WHERE rnk = 1;