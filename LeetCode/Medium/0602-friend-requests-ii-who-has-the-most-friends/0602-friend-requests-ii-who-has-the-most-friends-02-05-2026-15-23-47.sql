# Write your MySQL query statement below
WITH cte AS(
    SELECT requester_id AS id,COUNT(requester_id) AS request_count
    FROM RequestAccepted
    GROUP BY requester_id
),
cte2 AS(
    SELECT accepter_id AS id,COUNT(accepter_id ) AS accept_count
    FROM RequestAccepted
    GROUP BY accepter_id
),
cte_union AS(
    SELECT id,request_count AS cnt FROM cte
    UNION ALL
    SELECT id,accept_count AS cnt FROM cte2
),
cte_total AS(
    SELECT id,
        SUM(cnt) AS num
    FROM cte_union 
    GROUP BY id
)
SELECT id,num
FROM cte_total
ORDER BY num DESC LIMIT 1;

