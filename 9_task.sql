SELECT  maker,
CASE
    WHEN COUNT(laptop.model) = 0
        THEN "no"

    WHEN COUNT(laptop.model) >= 1
        THEN CONCAT("yes(", COUNT(laptop.model), ")")

END AS laptop
FROM product 
LEFT JOIN laptop ON product.model = laptop.model
GROUP BY maker
ORDER BY maker ASC;