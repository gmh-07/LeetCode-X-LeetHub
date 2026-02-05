WITH cte AS(
    SELECT 
        product_id,
        MAX(change_date) AS latest_date
    FROM Products
    WHERE change_date < '2019-08-17'
    GROUP BY product_id
),
p_all_cte AS(
    SELECT DISTINCT product_id FROM Products
)

SELECT 
    p_all_cte.product_id,
    IFNULL(p.new_price,10) AS price
FROM p_all_cte
LEFT JOIN cte
ON p_all_cte.product_id = cte.product_id
LEFT JOIN Products p
ON p.product_id = cte.product_id AND cte.latest_date = p.change_date;