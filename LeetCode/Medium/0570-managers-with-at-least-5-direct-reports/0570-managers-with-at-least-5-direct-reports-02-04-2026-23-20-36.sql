# Write your MySQL query statement below
WITH cte_count AS(
    SELECT managerId
    FROM Employee
    WHERE managerId IS NOT NULL
    GROUP BY managerId
    HAVING COUNT(id)>=5
)
SELECT name
FROM Employee
WHERE id IN(
    SELECT managerId FROM cte_count
);