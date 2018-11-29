###########################################
# CSC 242 Section 602 Spring 2017         #
# Test code for homework assignment 3     #
#                                         # 
# NOTE:  This code will produce run-time  #
# errors until you have complete at least #
# part of the Date class.                 #
###########################################
from hw3 import *

hw3_due = Date(4, 24, 2017)
midterm = Date(4, 26, 2017)
feb_29 = Date(2, 29, 2016)
feb_28 = Date(2, 28, 2017)
ny_eve = Date(12, 31, 2017)
ny_day = Date(1, 1, 2018)
memorial_day = Date(5, 29, 2017)

def test_str():
    errors = 0
    if '4/24/2017' != str(hw3_due):
        errors += 1
    if '4/26/2017' != str(midterm):
        errors += 1
    if '2/29/2016' != str(feb_29):
        errors += 1
    print('str {} errors out of {}'.format(errors, 3))

def test_repr():
    errors = 0
    for date in [ hw3_due, midterm, feb_29, ny_eve]:
        if date.same_date(eval(repr(date))) == False:
            errors += 1
    print('repr {} errors out of {}'.format(errors, 4))
        
def test_next_date():
    errors = 0
    tuesday = hw3_due.next_date()
    if tuesday.same_date(Date(4,25,2017)) == False:
        print(tuesday)
        errors += 1
    if midterm.next_date().same_date(Date(4,27,2017)) == False:
        print(midterm)
        errors += 1                             
    if Date(3,1,2016).same_date(feb_29.next_date()) == False:
        print(Date(3,1,2016))
        errors += 1
    if Date(2,29,2016).same_date(Date(2,28,2016).next_date()) == False:
        print(Date(2,29,2016))
        errors += 1
    if Date(3,1,2017).same_date(Date(2,28,2017).next_date()) == False:
        print(Date(3,1,2017))
        errors += 1
    if ny_eve.next_date().same_date(ny_day) == False:
        print(ny_eve)
        errors += 1
    print('next_date {} errors out of {}'.format(errors, 6))

def test_earlier_date():
    errors = 0
    if hw3_due.earlier_date(midterm) == False:
        errors += 1
    if ny_day.earlier_date(ny_eve):
        errors += 1
    if feb_29.earlier_date(feb_28) == False:
        errors += 1
    if memorial_day.earlier_date(ny_day) == False:
        errors += 1
    print('earlier_date {} errors out of {}'.format(errors, 4))

def test_hw3():
    test_str()
    test_repr()
    test_next_date()
    test_earlier_date()

test_hw3()
