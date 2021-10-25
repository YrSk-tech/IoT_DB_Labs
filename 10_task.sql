SELECT product.maker, pc.model, product.type, pc.price   
FROM labor_sql.pc
JOIN labor_sql.product
ON pc.model = product.model
AND maker = 'B'
UNION
SELECT product.maker, laptop.model, product.type, laptop.price   
FROM labor_sql.laptop
JOIN labor_sql.product
ON laptop.model = product.model
AND maker = 'B'
UNION
SELECT product.maker, printer.model, product.type, printer.price   
FROM labor_sql.printer
JOIN labor_sql.product
ON printer.model = product.model
AND maker = 'B'

