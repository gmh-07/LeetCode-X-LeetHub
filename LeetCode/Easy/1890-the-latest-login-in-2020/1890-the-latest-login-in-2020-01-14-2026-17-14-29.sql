-- Write your PostgreSQL query statement below

-- NOT working this query beacuse of upper limit date 
-- SELECT 
--     user_id,
--     MAX(time_stamp) AS last_stamp
-- FROM Logins
-- WHERE time_stamp >= '2020-01-01' AND time_stamp <= '2020-12-31'
-- GROUP BY user_id;



SELECT 
    user_id,
    MAX(time_stamp) AS last_stamp
FROM Logins
WHERE time_stamp >= '2020-01-01' AND time_stamp < '2021-01-01'
GROUP BY user_id;