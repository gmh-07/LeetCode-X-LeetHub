
-- 💡 Interview-favorite (No LIMIT/OFFSET)
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    SELECT DISTINCT salary
    FROM (
      SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS salary_rank
      FROM Employee
    ) t
    WHERE salary_rank = N
  );
END;










-- You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '- 1;
--   RETURN result;
-- END' at line 9

-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
--   DECLARE result INT;

--   SELECT DISTINCT salary
--   INTO result
--   FROM Employee
--   ORDER BY salary DESC
--   LIMIT 1 OFFSET N - 1;

--   RETURN result;
-- END;
