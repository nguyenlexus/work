###############################################################
# CSC 242 Section 602 Spring 2017
# Homework assignment 5:  Recursion 
# Due date:  as specified on D2L
#
# LEXUS NGUYEN
#
###############################################################
#
# Please upload your solutions for this lab onto D2L by the
# date and time specified on the D2L Homework assignment 5 
# dropbox folder.
#
# Please upload a file containing your competed code onto
# D2L by the due date. While you may discuss the assignment
# with others, you must write your code by yourself, without
# assistance from other students or anyone else, with the
# exception of the tutors, our TA, and the professor.
# Let submissions will not be accepted.
#
# Please place a comment at the top of your .py 
# file which includes your name.
#
###############################################################
# Your task is to complete the first 4 functions below.
# Each function is passed a parameter with embedded structures,
# such as embedded lists.  Each function can be completed in
# 5-10 lines of code or less.  The assignment is worth 2% of
# your overall grade, and therefore will be graded on a scale of 0-2.
# Each of the 4 functions are worth .5 points.  Partial credit
# will be given for functions which do not have syntax errors,
# and which work correctly on one or more of the test cases I am
# providing.
#
# For this assignment, you must write each function RECURSIVELY,
# and NO LOOPS ARE ALLOWED.
# You may test your code by running it with the file hw5_test.py
# In order to do so, hit F5 on the window displaying hw5_test.py
# and it will load hw5.py through the import statement
# at the top.
#
# The assignment is worth a total of 2 points.  Each correct solution
# for problems 1-4 is worth .5 points.  
#
# Note that there is also a 5th problem below.  This is an
# extra credit problem, worth .5 points.  The function must
# work correctly on my test examples in order for you to receive
# extra credit.  NO PARTIAL CREDIT WILL BE GIVEN.  For this
# problem, you may use a combination of recursion and loops.
###############################################################
# Problem 1
#
# Write a function which counts the number of times that an
# item appears in x.  x may be a list (possibly containing
# embedded lists), or it may be a non-list such as an integer.
# Your solution must be recursive, have no loops, and must
# not use the Python "in" operator.
#
# For example:
#
# >>> count(1,2)
# 0
# >>> count(1,1)
# 1
# >>> count(2, [2, [1, 3], [[2, 4], 2], 1])
# 3
###############################################################

# count the number of times item appears in x
def count(item, x):
    if type(x) != list:
        if item == x:
            return 1
        else:
            return 0
    if x == []:
        return 0
    else:
        if type(x[0]) == list:
            return count(item,x[0]) + count(item,x[1:])
        else:
            if x[0] == item:
                return 1 + count(item,x[1:])
            else:
                return 0 + count(item,x[1:])

###############################################################
# Problem 2
#
# Write a function called flatten.  The function is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer.  The function should
# return a list containing no embedded lists, and containing the
# items in x in the same order in which they appear in x.
# Your solution must be recursive and have no loops.
# For example:
#
# >>> flatten(1)
# [1]
# >>> flatten([1,2,3])
# [1, 2, 3]
# >>> flatten([[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]]])
[3, 1, 2, 3, 6, 2, 6, 1, 0, 6]
# >>> flatten([[[[[[[[1]]]], 2]]]])
# [1, 2]
###############################################################
def flatten(x):
    if x == []:
        return []
    else:
        if type(x) != list:
            return[x]
        elif type(x[0]) == list:
            return flatten(x[0]) + flatten(x[1:])
        else:
            return [x[0]] + flatten(x[1:])

    

###############################################################
# Problem 3
#
# Write a function called deepcopy_242.  It is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer.  The function should return a
# "deep copy" of x, as described during Monday's lecture.  Your solution
# must be recursive and have no loops.  You may
# NOT use the built-in Python deepcopy function.  Here
# some examples of proper behavior of deepcopy_242.
#
# >>> a = 1
# >>> deepcopy_242(a)
# 1
# >>> x = [1, [2, 3], 4]
# >>> y = deepcopy_242(x)
# >>> y
# [1, [2, 3], 4]
# >>> x is y
# False
# >>> x == y
# True
# >>> x[0] = 10
# >>> x
# [10, [2, 3], 4]
# >>> y
# [1, [2, 3], 4]
# >>> x == y
# False
# >>> x[1][0] = 0
# >>> x[1]
# [0, 3]
# >>> y[1]
# [2, 3]
###############################################################

def deepcopy_242(x):
    if x == []:
        return []
    else:
        if type(x) == int:
            if x == 0:
                return 0
            else:
                return 1 + deepcopy_242(x-1)
        elif type(x[0]) == list:
            return [deepcopy_242(x[0])] + deepcopy_242(x[1:])
        else:
            return [x[0]] + deepcopy_242(x[1:])

###############################################################
# Problem 4
#
# Write a function called strings.   It is passed a parameter
# x, which may be a list (possibly containing embedded lists), or
# a non-list such as an integer or a string.  Note that in this
# problem, lists can contain other types of data than just numbers
# The strings function returns a list of the strings in x.
#
# For example:
# >>> strings('abc')
# ['abc']
# >>> strings(0)
# []
# >>> strings([0, 'defgh'])
# ['defgh']
# >>> strings([['csc', 242], ['intro', 'to', ['python', 2]]])
# ['csc', 'intro', 'to', 'python']
###############################################################

def strings(x):
    if x == []:
        return []
    elif type(x) == str:
        return [x]
    else:
        if type(x[0]) == int:
            return strings(x[1:])
        elif type(x[0]) == list:
            return strings(x[0]) + strings(x[1:])
        else:
            return [x[0]] + strings(x[1:])

###############################################################
# Problem 5:  extra credit
#
# Other types of Python container objects may have embedded data.
# For example, we could represent an appointment calendar as a 
# dictionary of dictionaries.  Each item in the outer dictionary
# represents a day of the week, and each dictionary object 
# represents the appointments scheduled for that day.
# Your solution must be recursive, but may also contain loops.
# Here is an example:
#
# >>> monday = {'12:00' : 'Office hours', '1:30' : 'CSC 242 Lecture',
#               '4:15' : 'Office hours'. '5:45' : CSC 406 Lecture'}
# >>> tuesday = { }
# >>> wednesday = {'12:00': 'Office hours', '1:30' : 'CSC 242 Lecture',
#                  '3:10' : 'CSC 242 Lab'}
# >>> thursday = { }
# >>> friday = {'9:00' : 'Faculty committee meetings all day'}
# >>> calendar= {'monday':monday,'tuesday':tuesday, wednesday':wednesday,
# >>>            'thursday':thursday, 'friday':friday}

# Write a function called actities.  It is passed a dictionary called
# "calendar", whose structure is similar to the variable
# "calendar" above.  Your function should be written recursively,
# so that calendar may contain any number of embeddeded dictionaries,
# at any level of embedding.  The function should return a ***set*** of
# (non-dictionary) values stored in calendar.  Although your solution must
# be recursive, it may also contain loops.
#
# Given the above value for the variable calendar, here is an example
# call to activities:
#
# >>> activities(calendar)
#{'Office hours', 'CSC 242 lecture', 'CSC 242 Lab', 'CSC 406 lecture'}
#
# As is always the case with sets, the ordering of the items in the set is
# unimportant; in fact, you have no control of its ordering.
#
# For this problem, you may not use the values method of the dict class.
###############################################################
def activities(x):
    return set()           # replace
        
