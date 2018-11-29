###################################################
# CSC 242 Section 602 Spring 2017
# Writing your own module

# LEXUS NGUYEN

# For this assignment, I did not collaborate with any other students

# Fill in the code below
###################################################

import math                # includes the sqrt function and the constant pi
from random import random  # includes the random function (for problem 5)
import random

# 1.  Return the area of a circle whose radius is r
def circle_area(r):
    answer = math.pi * ( r ** 2)
    return answer

# 2.  Return the circumference of a circle whose radius is r
def circle_circumference(r):
    answer = 2 * math.pi * r
    return answer

# 3.  Return the length of a line segment which connects the points p1 and p2.
# The points are represented as 2-tuples (x,y).  For example, (2,1)
# represents a point whose x co-ordinate is 2 and y co-ordinate is 1.
def line_length(p1, p2):
    y = p2[1] - p1[1]
    x = p2[0]- p1[0]
    length = math.sqrt( x**2 + y**2)
    return length
    

# 4.  Return the perimeter of a triangle whose corners are at p1, p2, and p3.
# Each of these represents one of the corners of the triangle as a 2-tuple,
# as defined in the previous problem.
def triangle_perimeter(p1, p2, p3):
    
    p1p2 = math.sqrt((p2[1]-p1[1])**2 + (p2[0]-p1[0])**2)
    p2p3 = math.sqrt((p3[1]-p2[1])**2 + (p3[0]-p2[0])**2)
    p3p1 = math.sqrt((p1[1]-p3[1])**2 + (p1[0]-p3[0])**2)

    answer = p1p2 + p2p3 + p3p1
    return answer

# 5.  Estimate pi by generating p random co-ordinates (x,y) where 0 <= x < 1
# and 0 <= y <= 1.  The ratio of the points whose distance to the origin
# is <= 1 over the total number of points is an estimate of pi / 4.
def estimate_pi(p):
    amount = 0
    for trial in range(1,p + 1):
        x = random.random()
        y = random.random()
        length = math.sqrt(x ** 2 + y ** 2)
        if length <= 1:
            amount += 1
    piEstimate = 4 * (amount / p)
    return piEstimate

# 6.  Truncate the floating point number f so that it has d digits to the
# right of the decimal
def truncate(f,d):
    return float(str(f)[:d+2])

        
