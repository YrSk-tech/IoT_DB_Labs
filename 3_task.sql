SELECT code, model, hd, ram
FROM labor_sql.laptop
GROUP BY hd, ram 
HAVING COUNT(ram) > 1
AND  COUNT(hd) > 1
AND COUNT(ram) = COUNT(hd)


