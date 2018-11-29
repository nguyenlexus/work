/*
LEXUS NGUYEN
CSC 355 SECTION 602
ASSINGMENT 4
APRIL 25, 2018
*/

/* Problem 1 */

SELECT FNAME, LNAME
FROM CUSTOMER
WHERE ACCOUNTID = '2'
ORDER BY LNAME;

/* Problem 2 */

SELECT AVG(COST)
FROM RIDE
WHERE DRIVERID = 'CONCHORD';

/* Problem 3 */

SELECT DRIVER.ID, DRIVER.FNAME, DRIVER.LNAME
FROM DRIVER
JOIN RIDE ON DRIVER.ID = RIDE.DRIVERID
JOIN CUSTOMER ON RIDE.CUSTOMERID = CUSTOMER.ID
WHERE CUSTOMER.ACCOUNTID = '4'
GROUP BY DRIVER.ID, DRIVER.FNAME, DRIVER.LNAME;

/* Problem 4 */

SELECT CUSTOMER.FNAME, CUSTOMER.LNAME, SUM(RIDE.COST)
FROM CUSTOMER
LEFT JOIN RIDE ON CUSTOMER.ID = RIDE.CUSTOMERID
GROUP BY CUSTOMER.FNAME, CUSTOMER.LNAME
ORDER BY SUM(RIDE.COST) DESC;

/* Problem 5 */

SELECT DRIVERID
FROM RIDE
GROUP BY DRIVERID
HAVING COUNT(DRIVERID) >= 4;

/* Problem 6 */

SELECT ACCOUNT.NAME, COUNT(RIDE.CUSTOMERID)
FROM ACCOUNT
LEFT JOIN CUSTOMER ON ACCOUNT.ID = CUSTOMER.ACCOUNTID
LEFT JOIN RIDE ON CUSTOMER.ID = RIDE.CUSTOMERID
GROUP BY ACCOUNT.NAME
ORDER BY ACCOUNT.NAME;

/* Problem 7 */

SELECT MAX(DISTANCE)
FROM RIDE
JOIN DRIVER ON RIDE.DRIVERID = DRIVER.ID
WHERE MAKE = 'Cadillac';

/* Problem 8 */

SELECT FNAME, LNAME, PHONE
FROM CUSTOMER
JOIN ACCOUNT ON CUSTOMER.ACCOUNTID = ACCOUNT.ID
JOIN RIDE ON CUSTOMER.ID = RIDE.CUSTOMERID
WHERE CUSTOMER.ACCOUNTID = '1' AND RIDE.DRIVERID = 'TALKHEAD' ;

