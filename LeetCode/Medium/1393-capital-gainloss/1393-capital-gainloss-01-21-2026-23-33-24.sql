-- Write your PostgreSQL query statement below
WITH buy_cte AS(
    SELECT stock_name , SUM(price) AS total_buy
    FROM Stocks
    WHERE operation = 'Buy'
    GROUP BY stock_name
),

-- WITH sell_cte AS

sell_cte AS(
    SELECT stock_name , SUM(price) AS total_sell
    FROM Stocks
    WHERE operation = 'Sell'
    GROUP BY stock_name
)

SELECT b.stock_name, s.total_sell - b.total_buy AS capital_gain_loss 
FROM buy_cte b
JOIN sell_cte s
ON b.stock_name = s.stock_name;