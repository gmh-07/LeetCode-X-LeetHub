# Write your MySQL query statement below
-- WITH cte AS(
--     SELECT s.product_id,p.product_name 
--     FROM Sales s
--     JOIN Product p 
--     ON s.product_id  = p.product_id
--     WHERE s.sale_date >= '2019-01-01' AND s.sale_date < '2019-04-01'
-- )

-- SELECT * FROM cte
-- WHERE product_id NOT IN(
--     SELECT product_id FROM Sales
--     WHERE sale_date < '2019-01-01' OR sale_date > '2019-03-31'
-- );


-- My above Written query was not accepted
SELECT 
    p.product_id,
    p.product_name
FROM Product p
JOIN Sales s
    ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name
HAVING 
    MIN(s.sale_date) >= '2019-01-01'
    AND MAX(s.sale_date) <= '2019-03-31';
