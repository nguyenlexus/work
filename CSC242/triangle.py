#############################################
# CSC 242 Section 602 Spring 2017
# Lab 3: User-defined classes
#
# LEXUS NGUYEN
#
# Fill in the 4 methods below.  Also,
# be sure to define the distance method
# in the Point class (in the point.py file)
#############################################

from point import *

class Triangle:
    # make a triangle whose corners are defined by the points p1, p2, and p3
    def __init__(self, p1, p2, p3):
        self.p1 = p1        # change these
        self.p2 = p2
        self.p3 = p3
        self.p1top2 = p1.distance(p2)
        self.p2top3 = p2.distance(p3)
        self.p3top1 = p3.distance(p1)
    # this method is complete.  You do not need to write or modify it.
    def __str__(self):
        return '({},{},{})'.format(self.p1, self.p2, self.p3)
    
    # determine if the points p1, p2, and p3 make a triangle.  They
    # do not if there is a straight line that connects all 3 points.
    def is_triangle(self):
        if self.p1top2 + self.p2top3 > self.p3top1:
            if self.p2top3 + self.p3top1 > self.p1top2:
                if self.p3top1 + self.p1top2 > self.p2top3:
                    return True
                else:
                    return False
            else:
                return False
        else:
            return False
    
    # return the perimeter of the triangle
    def perimeter(self):
        self.p = self.p1top2 + self.p2top3 + self.p3top1
        return self.p

    # return the area of the triangle.  Please see the lab write-up
    # for the formula to compute the area.
    def area(self):
        s = 0.5 * self.p
        area = sqrt(s*(s-self.p1top2)*(s-self.p2top3)*(s-self.p3top1))
        return area
