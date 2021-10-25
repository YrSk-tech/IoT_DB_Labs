SELECT name , launched FROM labor_sql.ships
WHERE launched >= '1920'
AND launched <= '1942'
ORDER BY launched DESC;