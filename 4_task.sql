SELECT country, class
FROM labor_sql.classes
WHERE NOT EXISTS (SELECT country
FROM labor_sql.classes
WHERE country = 'USA')
UNION ALL   
SELECT country, class
FROM labor_sql.classes
WHERE country = 'USA'
