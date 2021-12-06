DROP FUNCTION IF EXISTS get_rating;
DROP FUNCTION IF EXISTS get_password;

/*Task 1*/
DELIMITER //
CREATE FUNCTION get_rating() RETURNS INT
DETERMINISTIC
BEGIN 
     RETURN(SELECT AVG(rating) FROM user);
END//

SELECT id, rating FROM user
	WHERE rating > average_rating;
DELIMITER ;

 
 /*Task 2*/
DELIMITER //
DROP FUNCTION IF EXISTS get_password //
CREATE FUNCTION get_password(password_id INT)
RETURNS VARCHAR(45)
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE password_to_return VARCHAR(45);
	SELECT password FROM `syvak_lab_7`.`password`
    WHERE id = password_id
    LIMIT 1
    INTO password_to_return;
    RETURN password_to_return;
END //

DELIMITER ;

SELECT id, get_password(password_id) as password
FROM `syvak_lab_7`.`user`;
