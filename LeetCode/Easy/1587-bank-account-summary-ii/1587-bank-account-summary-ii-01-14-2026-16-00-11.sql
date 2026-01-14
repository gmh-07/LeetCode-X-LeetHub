-- Write your PostgreSQL query statement below
WITH cte AS(
    SELECT account,SUM(amount) AS balance
    FROM Transactions
    GROUP BY account
)

SELECT 
    u.name AS name,
    cte.balance
FROM cte 
JOIN Users u
ON cte.account = u.account
WHERE cte.balance > 10000;
    