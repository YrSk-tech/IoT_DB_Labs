DROP TRIGGER IF EXISTS book_link_insert;
DROP TRIGGER IF EXISTS book_link_update;
DROP TRIGGER IF EXISTS book_link_delete;

DROP TRIGGER IF EXISTS tree_catalog_book_insert;
DROP TRIGGER IF EXISTS tree_catalog_book_update;
DROP TRIGGER IF EXISTS tree_catalog_book_delete;

DROP TRIGGER IF EXISTS user_has_book_insert;
DROP TRIGGER IF EXISTS user_has_book_update;
DROP TRIGGER IF EXISTS user_has_book_delete;

DROP TRIGGER IF EXISTS user_password_insert;
DROP TRIGGER IF EXISTS user_password_update;
DROP TRIGGER IF EXISTS user_password_delete;
DROP TRIGGER IF EXISTS book_has_user_delete;

DROP TRIGGER IF EXISTS check_surname_trigger;

DROP TRIGGER IF EXISTS birth_place_trigger;
/*Task 1*/
DELIMITER //
CREATE TRIGGER book_link_insert
BEFORE INSERT
ON `book` FOR EACH ROW
BEGIN
	IF NEW.link_id NOT IN (SELECT id FROM `link`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'LINK WITH THIS ID DOESNT EXIST';
        END IF;
END //

CREATE TRIGGER book_link_update
BEFORE UPDATE
ON `book` FOR EACH ROW
BEGIN
	IF NEW.link_id NOT IN (SELECT id FROM `link`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'BOOK WITH THIS ID DOESNT EXIST';
        END IF;
END //

CREATE TRIGGER book_link_delete
BEFORE DELETE
ON `link` FOR EACH ROW
BEGIN
	IF OLD.id IN (SELECT link_id FROM `book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CANT DELETE ROW REFERENCED BY OTHER TABLE';
        END IF;
END //


CREATE TRIGGER tree_catalog_book_insert
BEFORE INSERT
ON `tree_catalog` FOR EACH ROW
BEGIN
	IF NEW.book_id NOT IN (SELECT id FROM `book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'BOOK WITH THIS ID DOESNT EXIST';
        END IF;
END //


CREATE TRIGGER tree_catalog_book_update
BEFORE UPDATE
ON `tree_catalog` FOR EACH ROW
BEGIN
	IF NEW.book_id NOT IN (SELECT id FROM `book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'BOOK WITH THIS ID DOESNT EXIST';
        END IF;
END //


CREATE TRIGGER tree_catalog_book_delete
BEFORE DELETE
ON `book` FOR EACH ROW
BEGIN
	IF OLD.id IN (SELECT book_id FROM `tree_catalog`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CANT DELETE ROW REFERENCED BY OTHER TABLE';
        END IF;
END //



CREATE TRIGGER user_has_book_insert
BEFORE INSERT
ON `user_has_book` FOR EACH ROW
BEGIN
	IF NEW.book_id NOT IN (SELECT id FROM `book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'BOOK WITH THIS ID DOESNT EXIST';
	END IF;
	IF NEW.user_id NOT IN (SELECT id FROM `user`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'USER WITH THIS ID DOESNT EXIST';
	END IF;
END //


CREATE TRIGGER user_has_book_update
BEFORE UPDATE
ON `user_has_book` FOR EACH ROW
BEGIN
	IF NEW.book_id NOT IN (SELECT id FROM `book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'BOOK WITH THIS ID DOESNT EXIST';
	END IF;
	IF NEW.user_id NOT IN (SELECT id FROM `user`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'USER WITH THIS ID DOESNT EXIST';
	END IF;
END //


CREATE TRIGGER user_has_book_delete
BEFORE DELETE
ON `user` FOR EACH ROW
BEGIN
	IF OLD.id IN (SELECT user_id FROM `user_has_book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CANT DELETE ROW REFERENCED BY OTHER TABLE';
        END IF;
END //


CREATE TRIGGER book_has_user_delete
BEFORE DELETE
ON `book` FOR EACH ROW
BEGIN
	IF OLD.id IN (SELECT book_id FROM `user_has_book`)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CANT DELETE ROW REFERENCED BY OTHER TABLE';
        END IF;
END //


CREATE TRIGGER user_password_insert
BEFORE INSERT
ON `user` FOR EACH ROW
BEGIN
	IF NEW.password_id NOT IN (SELECT id FROM password)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'PASSWORD WITH THIS ID DOESNT EXIST';
        END IF;
	IF NEW.password_id IN (SELECT password_id FROM user)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'PASSWORD WITH THIS ID ALREADY USED';
        END IF;
END //


CREATE TRIGGER user_password_update
BEFORE UPDATE
ON `user` FOR EACH ROW
BEGIN
	IF NEW.password_id NOT IN (SELECT id FROM password)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'PASSWORD WITH THIS ID DOESNT EXIST';
        END IF;
	IF NEW.password_id IN (SELECT password_id FROM user)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'PASSWORD WITH THIS ID ALREADY USED';
        END IF;
END //


CREATE TRIGGER user_password_delete
BEFORE DELETE
ON `password` FOR EACH ROW
BEGIN
	IF OLD.id IN (SELECT password_id FROM user)
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'CANT DELETE ROW REFERENCED BY OTHER TABLE';
        END IF;
END //

DELIMITER ;

/*Task 2*/
DELIMITER //

CREATE TRIGGER check_surname_trigger
BEFORE INSERT
ON `user` FOR EACH ROW
BEGIN
	IF NEW.surname LIKE 'Ю%' OR NEW.surname LIKE 'Я%'
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'SURNAME CANNOT START WITH Ю OR Я';
	END IF;
 END //
DELIMITER ;

/*Task 3*/
DELIMITER //


CREATE TRIGGER birth_place_trigger
BEFORE INSERT
ON `syvak_lab_7`.`user` FOR EACH ROW
BEGIN
	IF (NEW.birth_place NOT IN ('Харків', 'Вінниця', 'Дніпропетровськ', 'Ужгород'))
		THEN SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'NOT ALLOWED RESIDENCE((';
	END IF;
END //

DELIMITER ;
