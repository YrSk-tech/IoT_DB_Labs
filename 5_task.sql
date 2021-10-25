SELECT maker 
FROM labor_sql.product
WHERE EXISTS(SELECT * 
	FROM labor_sql.pc
	WHERE pc.model = product.model)