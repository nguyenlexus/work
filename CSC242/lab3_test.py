#########################################################
# CSC 242 Section 602 Spring 2017
# Test file for Lab 3
#########################################################
#
# To use this test file, simply press F5 while the
# cursor is over the file.  There is no need for
# you to load the point or rectangle modules,
# because this file has import statements to load them.
#
#########################################################
from point import *
from math import sqrt
from triangle import *

p1 = Point(1,1)
p2 = Point(2,3)
p3 = Point(4,1)
t1 = Triangle(p1,p2,p3)
print('\nIs {} a triangle?'.format(t1))
print(t1.is_triangle())
if t1.is_triangle():
    print('Its perimeter is {}'.format(t1.perimeter()))
if t1.is_triangle():
    print('Its area is {}'.format(t1.area()))

p1 = Point(1.5,0)
p2 = Point(2,3)
p3 = Point(4,2)
t2 = Triangle(p1,p2,p3)
print('\nIs {} a triangle?'.format(t2))
print(t2.is_triangle())
if t2.is_triangle():
    print('Its perimeter is {}'.format(t2.perimeter()))
if t2.is_triangle():
    print('Its area is {}'.format(t2.area()))  

p1 = Point(1,1)
p2 = Point(2.,1.5)
p3 = Point(3,2)
t3 = Triangle(p1,p2,p3)
print('\nIs {} a triangle?'.format(t3))
print(t3.is_triangle())
if t3.is_triangle():
    print('Its perimeter is {}'.format(t3.perimeter()))
if t3.is_triangle():
    print('Its area is {}'.format(t3.area()))

p1 = Point(1,1)
p2 = Point(4,1)
p3 = Point(4,5)
t4 = Triangle(p1,p2,p3)
print('\nIs {} a triangle?'.format(t4))
print(t4.is_triangle())
if t4.is_triangle():
    print('Its perimeter is {}'.format(t4.perimeter()))
if t4.is_triangle():
    print('Its area is {}'.format(t4.area()))
    
p1 = Point(1,0)
p2 = Point(6,-4)
p3 = Point(2,1)
t5 = Triangle(p1,p2,p3)
print('\nIs {} a triangle?'.format(t5))
print(t5.is_triangle())
if (t5.is_triangle()):
    print('Its perimeter is {}'.format(t5.perimeter()))
if (t5.is_triangle()):
    print('Its area is {}'.format(t5.area()))

