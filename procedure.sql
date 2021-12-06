DROP PROCEDURE IF EXISTS insert_into_password;
DROP PROCEDURE IF EXISTS insert_into_book;
DROP PROCEDURE IF EXISTS create_copy_book;
/*Task 1*/
DELIMITER //
CREATE PROCEDURE insert_into_password(
IN 
	`password` VARCHAR(45) 
 )
BEGIN 
  INSERT INTO password(password)
  VALUES (password);
END//
DELIMITER ;

/*Task 2*/
DELIMITER //
CREATE PROCEDURE insert_into_book(
 )
BEGIN 
  DECLARE x INT;
  SET x = 0;
  label1: WHILE x < 10 DO
    SET x = x + 1;
    INSERT INTO book(name)
    VALUES (CONCAT('Noname', x));
  END WHILE;
END//
DELIMITER ;

/*Task 3*/
DELIMITER //
CREATE PROCEDURE create_copy_book()
BEGIN 

DECLARE nameT VARCHAR(45);
DECLARE run INT DEFAULT false;
DECLARE iterator INT;

DECLARE book_cursor CURSOR
FOR SELECT name FROM book;
DECLARE CONTINUE HANDLER
FOR NOT FOUND SET run=true;
 
    OPEN book_cursor;
    book_loop:
    LOOP
        FETCH book_cursor INTO nameT;  
        IF run=true THEN
            LEAVE book_loop;
        END IF;

        
   SET @column = CONCAT('DROP DATABASE if exists ', nameT);
    PREPARE queryT FROM @column;
    EXECUTE queryT;
    DEALLOCATE PREPARE queryT;
   
   SET @column = CONCAT('CREATE DATABASE ', nameT);
   PREPARE queryT FROM @column;
   EXECUTE queryT;
   DEALLOCATE PREPARE queryT;
  
  SET iterator = 0;
     WHILE iterator < 10 DO
     SET iterator = iterator + 1;
       IF RAND() > 0.5 THEN BEGIN
        SET @table = CONCAT('create table ', nameT,".",nameT, iterator, '(id int primary key auto_increment)');
        PREPARE queryT from @table;
        EXECUTE queryT;
        DEALLOCATE PREPARE queryT;
        END;
       END IF;
     END WHILE;
    END LOOP;
    CLOSE book_cursor;
END//
DELIMITER ;

