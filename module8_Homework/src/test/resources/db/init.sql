CREATE TABLE IF NOT EXISTS PERSONS (
id INT(20) NOT NULL AUTO_INCREMENT,
F_NAME VARCHAR(20) NOT NULL,
L_NAME VARCHAR(20),
DOB DATE DEFAULT SYSDATE);

INSERT INTO PERSONS(F_NAME,L_NAME)VALUES('Tom','Anderson');
INSERT INTO PERSONS(F_NAME, L_NAME)VALUES('Dan','Hudson');