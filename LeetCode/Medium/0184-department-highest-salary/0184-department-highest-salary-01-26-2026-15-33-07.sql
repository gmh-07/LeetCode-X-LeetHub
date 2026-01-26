# Write your MySQL query statement below
WITH department_wise_max_sal_cte AS(
    SELECT d.id AS deptId,d.name AS deptName,MAX(e.salary) AS maxSal
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
    GROUP BY d.name,d.id
)
SELECT cte.deptName AS Department,
        e.name AS Employee,
        e.salary AS Salary
FROM Employee e
JOIN department_wise_max_sal_cte cte
ON e.departmentId = cte.deptId
WHERE e.salary = cte.maxSal;








-- 🏆 Bonus: Interview-favorite alternative (window function)
-- SELECT d.name AS Department,
--        e.name AS Employee,
--        e.salary AS Salary
-- FROM (
--     SELECT *,
--            DENSE_RANK() OVER (
--              PARTITION BY departmentId
--              ORDER BY salary DESC
--            ) AS rnk
--     FROM Employee
-- ) e
-- JOIN Department d
--   ON e.departmentId = d.id
-- WHERE e.rnk = 1;
