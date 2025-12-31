# Write your MySQL query statement below
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email)>1;



--  Wrong Syntax
-- # Write your MySQL query statement below
-- SELECT email AS Email
-- FROM Person
-- HAVING COUNT(email)>1
-- GROUP BY email
-- ;