########################################
# CSC 242 Section 602 Spring 2017
# Lab 6:  Recursion with embedded data
########################################
#
# Please upload your solutions for this lab onto D2L by the
# end of today's lab session.  You are strongly encouraged to
# work in groups of 2 or 3 for all labs.  Please place a comment
# at the top of your .pyfile which includes your name, and the
# names of any students you worked with.  Each student should
# upload solutions to the D2L dropbox, even if you worked in a
# group.
#
######################################################################
#
# Your task is to complete the 4 functions below.  YOUR
# SOLUTIONS MUST BE RECURSIVE -- NO LOOPS ARE ALLOWED!
# I have provided a template for each problem; however if
# you find a different solution for any problem, you can delete
# my code and rewrite it in whatever way you'd like, except
# YOUR SOLUTION MUST BE RECURSIVE -- NO LOOPS ARE ALLOWED!
#
# Each of the functions are passed a parameter which can be any
# kind of object.  If the parameter is a list, it may contain
# embedded lists, which themselves may contain lists, etc.
#
# You may test your code by running it with the file lab6_test.py
# In order to do so, hit F5 on the Idle window displaying lab6_test.py
# and it will load lab6.py through the import statement
# at the top.
#
# The lab is worth a total of 2 points.  Therefore, each correct
# solution is worth .5 points.  Partial credit of .25 points will
# be given for functions which do not have syntax errors, and which
# work correctly on one or more of the test cases I am providing.

######################################################################
# 1.  Write a funtion which returns the "depth" of the parameter
#     x.  x may be any type of object. If is not a list, then the
#     function should return 0.  If x is a list but does not contain
#     any embedded lists, then the function should return 1.
#     Otherwise, it should return the maximum level of embedding
#     of x.  For example:
#
#     >>> depth_embed(1)
#     0
#     >>> depth_embed([ ])
#     1
#     >>> depth_embed([1, 2, 3])
#     1
#     >>> depth_embed([1, [2, 3], 4])
#     2
#     >>> depth_embed([[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]])
#     3
#     >>> depth_embed([1, [[[[2, [3]]]]]])
#     6
######################################################################

def depth_embed(x):
    if not isinstance(x, list):        # base case 1
        return 0                     # change this
    elif x == [ ]:                     # base case 2
        return 1                    # change this this
    else:
        if type(x[0]) == list:
            return max( 1 + depth_embed(x[0]), depth_embed(x[1:]))
        else:
            return depth_embed(x[1:])
        
        
#2.  Write a function called nth_embed.  The function returns
#     the object at position n in x.  The function should return None
#     if n < 0 or n >= len_embed(x) (note that you can find the
#     len_embed function at the bottom of this file).  Otherwise,
#     the function returns the nth item in x.  For example:
#
#     >>> nth_embed(0, 'x')
#     'x'
#     >>> nth_embed(1, 10)     # this returns None, so nothing is printed
#     >>> nth_embed(0, [10, 20])
#     10
#     >>> nth_embed(4, [[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]])
#     6
#     >>> nth_embed(8, [[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]])
#     0
#     >>> nth_embed(3, ['a', ['b', 'c']])  # returns None
######################################################################

def nth_embed(n, x):
    x_len = len_embed(x)
    if n < 0 or n >= x_len:          # base case 1
        return                       # no need to change this
    elif not isinstance(x, list):    # base case 2
        return x
    else:
        if depth_embed(x) == 1:
            return x[n]
        else:
    
        

######################################################################
# 3.  Write a function called find_embed.  The function is passed
#     2 parameters:  an object called "item", and another object
#     called "x".  x may or may not be a list, and if it is
#     a list, it may contain embedded lists as in the previous
#     problems.  The function should return the index at which item
#     can be found in x, or else -1 if item is not in x.  For example:
#
#     >>> find_embed(4,4)
#     0  # position 0
#     >>> find_embed(4, 1)
#     -1 # because 4 != 1
#     >>> find_embed(0, [3, 2, 1, 0])
#     3
#     >>> find_embed(0, [1, 2, 3])
#     -1 # because 0 is not in x
#     >>> find_embed(3, [4, [2, [1, 5, 3], 6]])
#     4
#     >>> find_embed(0, [[3, 1, 2],[[3, 6, 2],[6, 1, 0, 6]]])
#     8
#     >>> find_embed(7, [[3, 1 ,2], [[3, 6, 2],[6, 1, 0, 6]]])
#     -1
######################################################################
    
def find_embed(item, x):
    if len_embed(x) == 0:           # base case 1
        return -1                   # no need to change this
    elif not isinstance(x, list):   # base case 2
        return -1                   # modify this:  -1 is not always correct
    else:                           # recursive case
        return -1                   # replace this
    
######################################################################
# 4.  Write a function called reverse_embed.  The function is passed
#     1 parameter called "x".  Just as with the previous problems,
#     x may or may not be a list, and if it is a list, it may
#     contain embedded lists.  If x is not a list, then function
#     should return x.  If x is a list, a new list should be returned
#     in which the order of items in x is reversed.  If x contains
#     embedded lists, the order of items in those lists should be
#     reversed as well.  For example:
#
#     >>> reverse_embed(10)
#     10
#     lst1 = [ ]
#     >>> lst2 = reverse_embed([ ])
#     >>> lst2
#     [ ]
#     >>> lst2 is lst1  # test to see that lst2 is a new empty list
#     False
#     >>> reverse_embed([1, 2, 3])
#     [3, 2, 1]
#     >>> reverse_embed([1, [2, 3], 4])
#     [4, [3, 2], 1]
#     >>> reverse_embed([[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]])
#     [[[6, 0, 1, 6], [2, 6, 3]], [2, 1, 3]]
######################################################################

def reverse_embed(x):
    if not isinstance(x, list):    # base case 1
        pass                       # replace this
    if x == [ ]:                   # base case 2
        pass                       # replace this
    else:                          # recursive case
        pass                       # replace this

#####################################################################
#####################################################################
# End of lab
#####################################################################
#####################################################################

# We wrote this function during lecture on 5/6.  You might
# find it useful to use in one or more of the above functions.
# return the number of items in x.  x may be a list, in which case
# it may contain embedded lists, or it may be some other kind of
# object.
def len_embed(x):
    if not isinstance(x, list):
        return 1
    elif x == [ ]:
        return 0
    else:
        return len_embed(x[0]) + len_embed(x[1:])

