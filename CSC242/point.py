#########################################
# CSC 242 Section 602 Spring 2017
# Lab 3
#
# LEXUS NGUYEN
#
# Here is the Point class from lecture.
# Write a distance method for this class,
# which computes the distance between
# 2 points.  You'll find a template
# for this method at the bottom of this
# file.

# Then, also complete the
# Triangle class in the file triangle.py
#########################################
from math import sqrt

class Point:

    # the parameter "self" refers to the Point object
    # we will always give the name "self" to the
    # first parameter of a method
    def __init__(self, init_x, init_y):  
        self.x = init_x   # self.x is an instance variable  
        self.y = init_y   # self.y is an instance variable

    def __str__(self):
        return '({},{})'.format(self.x, self.y)
    
    # we can write the __str__ method however we want.
    # It determines what the built-in Python str function
    # returns for a Point object, such as
    #
    # >>> p = Point(2,3)
    # >>> str(p)
    # '(2,3)'
    def __str__(self):
        return '({},{})'.format(self.x, self.y)

    # __repr__ determines what the built-in Python repr
    # function returns for a Point object.  This must
    # conform to the Python convention for what repr
    # returns.
    def __repr__(self):
        return 'Pointv2({},{})'.format(self.x, self.y)
    
    def setx(self, new_x):
        self.x = new_x

    def sety(self, new_y):
        self.y = new_y

    def get(self):
        return (self.x, self.y) # returns a 2-tuple

    def getx(self):
        return self.x

    def gety(self):
        return self.y

    def move(self, dx, dy):
        self.x += dx
        self.y += dy

    # compute the distance between 2 points
    def distance(self, other):
        self.distance = sqrt((other.x-self.x)**2 + (other.y-self.y)**2)
        return self.distance

