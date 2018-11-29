/*
Lexus Nguyen
CSC 355 SEction 602
Assignment 6 Problem 2
May 23, 2018
*/

DROP TABLE ASSIGNMENT CASCADE CONSTRAINTS;
DROP TABLE JOB CASCADE CONSTRAINTS;

CREATE TABLE JOB
(
 JobID 		CHAR(3),
 Name			VARCHAR2(30),
 EmployeeCount	NUMBER(1,0) DEFAULT 0,

 CONSTRAINT PK_JOB 
		PRIMARY KEY (JobID)
);

CREATE TABLE ASSIGNMENT
(
 JobID			CHAR(3),
 EmployeeID		CHAR(9),
 Hours			NUMBER(8,2),

 CONSTRAINT PK_ASSIGNMENT 
		PRIMARY KEY (JobID, EmployeeID),

 CONSTRAINT FK_ASSIGNMENT_JOB 
		FOREIGN KEY (JobID)
		REFERENCES JOB (JobID)
);
 
INSERT INTO JOB (JobID, Name) VALUES ( '222', 'Logistics Management' );
INSERT INTO JOB (JobID, Name) VALUES ( '753', 'Human Resources' );
INSERT INTO JOB (JobID, Name) VALUES ( '143', 'Performance Testing' );
INSERT INTO JOB (JobID, Name) VALUES ( '690', 'Structural Engineering' );
SELECT * FROM JOB;
COMMIT;

CREATE OR REPLACE TRIGGER newAssignment
    AFTER INSERT ON ASSIGNMENT
FOR EACH ROW

BEGIN
    UPDATE JOB
    SET EMPLOYEECOUNT = EMPLOYEECOUNT + 1
    WHERE JobID = :new.JobID;
    
END;

CREATE OR REPLACE TRIGGER newUpdate
    AFTER UPDATE ON ASSIGNMENT
FOR EACH ROW

BEGIN

    UPDATE ASSIGNMENT
    SET EMPLOYEEID = :old.EMPLOYEEID,
        JobID = :old.JobID,
        Hours = :old.Hours;
    dbms_output.put_line ('ERROR : no updates are permitted to existing rows of ASSIGNMENT');
    
    
END;

CREATE OR REPLACE TRIGGER newDelete
    AFTER DELETE ON ASSIGNMENT
FOR EACH ROW

BEGIN
    
    UPDATE JOB
    SET EMPLOYEECOUNT = EMPLOYEECOUNT - 1
    WHERE JOBID = :old.JOBID;
    
END;