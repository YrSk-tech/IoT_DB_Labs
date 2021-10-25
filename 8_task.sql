SELECT maker, MIN(speed) AS min_speed 
FROM pc JOIN product ON pc.model = product.model
WHERE speed > 500
GROUP BY maker