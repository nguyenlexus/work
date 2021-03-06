/*
	Books.sql
	Eric J. Schwabe
	April 11th, 2018

	Script to set up LIBRARY, BOOKORDER, LINEITEM, BOOK tables
	for CSC 355 Assignment 3

	Sample data modified from Modern Database Management (7th edition),
		Hoffer, Prescott, McFadden
	
	For use in assignment only -- do not copy...
*/

-- drop tables

DROP TABLE LINEITEM CASCADE CONSTRAINTS;

DROP TABLE BOOKORDER CASCADE CONSTRAINTS;

DROP TABLE BOOK CASCADE CONSTRAINTS;

DROP TABLE LIBRARY CASCADE CONSTRAINTS;

-- create and link tables

CREATE TABLE LIBRARY
(
	ID		INTEGER,
	Name		VARCHAR2(40),
	City		VARCHAR2(20),
	State		CHAR(2),
	Zip		CHAR(5),

	CONSTRAINT PK_LIBRARY
		PRIMARY KEY (ID)
);

CREATE TABLE BOOK
(
	ISBN		CHAR(10),
	Title		VARCHAR2(30),
	Author		VARCHAR2(30),
	Price		NUMBER(5,2),

	CONSTRAINT PK_BOOK
		PRIMARY KEY (ISBN)
);

CREATE TABLE BOOKORDER
(	ID		INTEGER,
	OrderDate	DATE,
	LibraryID	INTEGER,

	CONSTRAINT PK_BOOKORDER
		PRIMARY KEY (ID),

	CONSTRAINT FK_BOOKORDER_LIBRARY
		FOREIGN KEY (LibraryID)
		REFERENCES LIBRARY(ID)
);

CREATE TABLE LINEITEM
(
	OrderID		INTEGER,
	BookISBN	CHAR(10),
	Quantity	INTEGER,

	CONSTRAINT PK_LINEITEM
		PRIMARY KEY (OrderID, BookISBN),

	CONSTRAINT FK_LINEITEM_BOOKORDER
		FOREIGN KEY (OrderID)
		REFERENCES BOOKORDER(ID),

	CONSTRAINT FK_LINEITEM_LIBRARY
		FOREIGN KEY (BookISBN)
		REFERENCES BOOK(ISBN)
);

-- populate tables

INSERT INTO LIBRARY VALUES
	(1, 'Newburgh Free Library', 'Newburgh', 'NY', '12550');
INSERT INTO LIBRARY VALUES
	(2, 'Hauppuage Library', 'Hauppauge', 'NY', '11788');
INSERT INTO LIBRARY VALUES
	(3, 'Three Rivers Library', 'Pittsburgh', 'PA', '15213');
INSERT INTO LIBRARY VALUES
	(4, 'Hawaii Public Library (Kaneohe Branch)', 'Kaneohe', 'HI', '96744');
INSERT INTO LIBRARY VALUES
	(5, 'John Wayne Library', 'Irvine', 'CA', '92612');
INSERT INTO LIBRARY VALUES
	(6, 'Santa Fe Public Library', 'Santa Fe', 'NM', '87507');
INSERT INTO LIBRARY VALUES
	(7, 'The Peoples Library', 'San Francisco', 'CA', '94121');
INSERT INTO LIBRARY VALUES
	(8, 'Central Library of Miami', 'Miami', 'FL', '33101');
INSERT INTO LIBRARY VALUES
	(9, 'OC Branch, Library of Oregon', 'Oregon City', 'OR', '97045');
INSERT INTO LIBRARY VALUES
	(10, 'Albany NY Library (Main Branch)', 'Albany', 'NY', '12209');
INSERT INTO LIBRARY VALUES
	(11, 'South Hills Library', 'Bethel Park', 'PA', '15228');
INSERT INTO LIBRARY VALUES
	(12, 'Lee County Library, Beachside Branch', 'Fort Myers', 'FL', '33901');
INSERT INTO LIBRARY VALUES
	(13, 'Free Public Library of Boulder', 'Boulder', 'CO', '80514');
INSERT INTO LIBRARY VALUES
	(14, 'Ann Arbor Library', 'Ann Arbor', 'MI', '48103');
INSERT INTO LIBRARY VALUES
	(15, 'Public Library of Newark', 'Newark', 'NJ', '07201');
INSERT INTO LIBRARY VALUES
	(16, 'Fair Lawn Library', 'Fair Lawn', 'NJ', '07410');
INSERT INTO LIBRARY VALUES
	(17, 'Main Library of Seminole', 'Seminole', 'FL', '34646');

INSERT INTO BOOK VALUES
	('0374104115', 'Acceptance', 'Jeff Vandermeer', 7.99);	
INSERT INTO BOOK VALUES
	('0374104093', 'Annihilation', 'Jeff Vandermeer', 9.99);	
INSERT INTO BOOK VALUES
	('0374104107', 'Authority', 'Jeff Vandermeer', 10.99);	
INSERT INTO BOOK VALUES
	('0441011160', 'Coyote', 'Allen Steele', 4.99);
INSERT INTO BOOK VALUES
	('0441013570', 'Coyote Frontier', 'Allen Steele', 5.99);
INSERT INTO BOOK VALUES
	('0441012515', 'Coyote Rising', 'Allen Steele', 6.99);
INSERT INTO BOOK VALUES
	('0316262315', 'New York 2140', 'Kim Stanley Robinson', 12.99);	
INSERT INTO BOOK VALUES
	('0316098116', '2312', 'Kim Stanley Robinson', 8.99);
INSERT INTO BOOK VALUES
	('0374537658', 'Borne', 'Jeff Vandermeer', 11.99);

INSERT INTO BOOKORDER VALUES
	(1001, DATE '2016-07-30', 8);
INSERT INTO BOOKORDER VALUES
	(1002, DATE '2016-07-30', 5);
INSERT INTO BOOKORDER VALUES
	(1003, DATE '2016-09-28', 10);
INSERT INTO BOOKORDER VALUES
	(1004, DATE '2016-11-15', 13);
INSERT INTO BOOKORDER VALUES
	(1005, DATE '2017-02-03', 17);
INSERT INTO BOOKORDER VALUES
	(1006, DATE '2017-02-03', 4);
INSERT INTO BOOKORDER VALUES
	(1007, DATE '2017-04-04', 13);
INSERT INTO BOOKORDER VALUES
	(1008, DATE '2017-06-01', 17);
INSERT INTO BOOKORDER VALUES
	(1010, DATE '2017-06-01', 13);
INSERT INTO BOOKORDER VALUES
	(1011, DATE '2018-02-15', 10);
INSERT INTO BOOKORDER VALUES
	(1012, DATE '2018-02-15', 1);
INSERT INTO BOOKORDER VALUES
	(1013, DATE '2018-02-15', 4);

INSERT INTO LINEITEM VALUES
	(1001, '0441011160', 2);
INSERT INTO LINEITEM VALUES
	(1001, '0374104115', 1);
INSERT INTO LINEITEM VALUES
	(1001, '0374104107', 1);
INSERT INTO LINEITEM VALUES
	(1002, '0374104093', 3);
INSERT INTO LINEITEM VALUES
	(1003, '0374104093', 4);
INSERT INTO LINEITEM VALUES
	(1004, '0316262315', 1);
INSERT INTO LINEITEM VALUES
	(1004, '0374104107', 1);
INSERT INTO LINEITEM VALUES
	(1005, '0374104107', 4);
INSERT INTO LINEITEM VALUES
	(1006, '0374104107', 2);
INSERT INTO LINEITEM VALUES
	(1006, '0374104093', 2);
INSERT INTO LINEITEM VALUES
	(1006, '0374104115', 2);
INSERT INTO LINEITEM VALUES
	(1007, '0441011160', 4);
INSERT INTO LINEITEM VALUES
	(1007, '0374104115', 4);
INSERT INTO LINEITEM VALUES
	(1008, '0374104093', 1);
INSERT INTO LINEITEM VALUES
	(1008, '0316262315', 1);
INSERT INTO LINEITEM VALUES
	(1010, '0374104107', 3);
INSERT INTO LINEITEM VALUES
	(1010, '0441013570', 4);
INSERT INTO LINEITEM VALUES
	(1011, '0316262315', 3);
INSERT INTO LINEITEM VALUES
	(1012, '0441011160', 1);
INSERT INTO LINEITEM VALUES
	(1013, '0441011160', 2);
INSERT INTO LINEITEM VALUES
	(1013, '0374537658', 1);

COMMIT;

-- display tables

SELECT * FROM LIBRARY;

SELECT * FROM BOOK;

SELECT * FROM BOOKORDER;

SELECT * FROM LINEITEM;