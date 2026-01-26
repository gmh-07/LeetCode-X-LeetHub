CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
RETURNS TABLE (Salary INT) AS $$
BEGIN
    IF N<=0 THEN
        RETURN;
    END IF;
  RETURN QUERY
    SELECT DISTINCT e.salary
    FROM Employee e
    ORDER BY e.salary DESC
    LIMIT 1 OFFSET N - 1;
END;
$$ LANGUAGE plpgsql;



-- column reference "salary" is ambiguous
-- LINE 1: SELECT DISTINCT salary
--                         ^
-- DETAIL:  It could refer to either a PL/pgSQL variable or a table column.
-- QUERY:  SELECT DISTINCT salary
--     FROM Employee
--     ORDER BY salary DESC
--     LIMIT 1 OFFSET N - 1
-- CONTEXT:  PL/pgSQL function nthhighestsalary(integer) line 3 at RETURN QUERY

-- Ahh yep — this is a classic PL/pgSQL gotcha 😄
-- PostgreSQL thinks salary might be your output column (RETURNS TABLE (Salary INT)), not the table column.

-- So it’s like two people named Alex in the same room — Postgres asks: “which one do you mean?”

-- ✅ Fix: Qualify the column with the table name (or alias)
-- Correct & Safe Version
-- CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
-- RETURNS TABLE (Salary INT) AS $$
-- BEGIN
--   RETURN QUERY
--     SELECT DISTINCT e.salary
--     FROM Employee e
--     ORDER BY e.salary DESC
--     LIMIT 1 OFFSET N - 1;
-- END;
-- $$ LANGUAGE plpgsql;

-- 🧠 Why this error happens (analogy)

-- Think of salary as:

-- 🧍 Local variable (your function output column)

-- 🧾 Table column (Employee.salary)

-- Postgres sees:

-- SELECT salary


-- and says:

-- “Do you mean the variable or the table field?”

-- By writing e.salary, you’re pointing clearly:

-- “I mean the value from the Employee table.”