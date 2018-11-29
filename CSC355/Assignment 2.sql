/*Lexus Nguyen
  CSC 355 SECTION 602
  Assignment 2
  11 April, 2018
*/


drop table assignment;
drop table employee;
drop table office;


create table employee (
    EID         char(5) not null,
    FirstName   varchar(40),
    LastName    varchar(40),
    CellPhone   number(10),
    
    primary key (EID)
    );

create table office (
    ONumber     number(3) not null,
    City        varchar(40),
    State       char(2),
    Country     varchar(3),
    
    primary key (ONumber)
    
    );
    
create table assignment (
    EmployeeID      char(5) not null,
    OfficeNumber    number(3),
    StartDate       date not null,
    EndDate         date,
    
    foreign key (EmployeeID) references employee(EID),
    foreign key (OfficeNumber) references office(ONumber)
    );
    
    
    
insert into office
    values ( 313, 'Chicago', 'IL', 'USA');
insert into office
    values ( 864, 'Los Angeles', 'CA', 'USA');
insert into office
    values ( 209, 'Miami', 'FL', 'USA');
insert into office
    values ( 444, 'New York City', 'NY', 'USA');

insert into employee
    values ( '07251', 'Lexus', 'Nguyen', 773072512 );
insert into employee
    values ( '07252', 'Amy', 'Tran', 7736668888 );
insert into employee
    values ( '75980', 'Reinaldo', 'Ramos', 3122348901 );
    
insert into assignment
    values ( '75980', 209, '09-Mar-17', '25-Jun-17' );   
insert into assignment
    values ( '75980', 444, '14-Aug-17', '03-Feb-18' );
insert into assignment
    values ('07252', 864, '12-Oct-17', '22-Jan-18' );
insert into assignment
    values ('07251', 313, '10-Sep-17', '25-Dec-18' );
insert into assignment
    values ('07252', 313, '09-Mar-18', '25-Dec-18' );
    
    
select * from office;
select * from employee;
select * from assignment;



    