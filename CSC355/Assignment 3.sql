/*  Lexus Mguyen
    CSC 355 - 602
    Assignment 3
    April 19, 2018
*/

/* Problem 1 */

    select Name 
    from LIBRARY
    order by name;
    
/* Problem 2 */

    select city, state, zip
    from LIBRARY
    where state = 'FL' or state = 'CA';
    
/* Problem 3 */

    select isbn, title, price
    from BOOK
    where author = 'Jeff Vandermeer'
    order by price desc;
    
/* Problem 4 */

    select name, city
    from LIBRARY
    where name like '%Branch%';
    
/* Problem 5 */

    select state, count(state)
    from LIBRARY
    group by state
    order by state;
    
/* Problem 6 */

    select orderdate, MAX(ID)
    from BOOKORDER
    group by orderdate
    order by orderdate;
    
/* Problem 7 */

    select libraryid, MIN(orderdate)
    from BOOKORDER
    group by libraryid
    order by libraryid;
    
/* Problem 8 */

    select orderid, SUM(quantity)
    from LINEITEM
    group by orderid
    order by SUM(quantity);
    
/* Problem 9 */
    
    select BOOKORDER.ID, name, zip
    from BOOKORDER join LIBRARY
    on BOOKORDER.libraryid = LIBRARY.ID
    order by BOOKORDER.ID;
    
/* Problem 10 */

    select BOOK.isbn, COUNT(LINEITEM.bookisbn)
    from BOOK LEFT JOIN LINEITEM
    on BOOK.isbn = LINEITEM.bookisbn
    group by BOOK.isbn
    order by COUNT(LINEITEM.bookisbn) desc;
    
    