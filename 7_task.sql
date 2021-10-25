SELECT  pc.model, AVG(price) AS avarage_price, COUNT(model) AS pc_amount
FROM labor_sql.pc
GROUP BY model
HAVING AVG(price) < 800
