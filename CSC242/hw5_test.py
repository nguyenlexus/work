#########################################
# CSC 242 Section 602 Spring 2017
# Test file for Homework assignment 5
#########################################

from hw5 import *

print('Function count')

print('\nParameters 1,2\nShould return 0\nReturns {}'.format(count(1,2)))
print('\nParameters 1,1\nShould return 1\nReturns {}'.format(count(1,1)))
parm2 = [2, [1, 3], [[2, 4], 2], 1]
print('\nParameters 2, {}\nShould return 3\nReturns {}'.format(parm2,count(2,parm2)))
parm2 = [3, [1, [[3, 2], [[2, 3], 2], 3]], 4]
print('\nParameters 3, {}\nShould return 4\nReturns {}'.format(parm2,count(3,parm2)))

print('\nFunction flatten')

print('\nParameter 1\nShould return [1]\nReturns {}'.format(flatten(1)))
print('\nParameter [1,2,3]\nShould return [1,2,3]\nReturns {}'.format(flatten([1,2,3])))
parm = [[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]]
print('\nParameter {}\nShould return [3,1,2,3,6,2,6,1,0,6]\nReturns {}'.format(parm, flatten(parm)))
parm = [[[[[[[[1]]]], 2]]]]
print('\nParameter {}\nShould return [1,2]\nReturns {}'.format(parm, flatten(parm)))

print('\nFunction deepcopy_242')

print('\nParameter 1\nShould return 1\nReturns {}'.format(deepcopy_242(1)))
print('\nParameter 1\nShould return 1\nReturns {}'.format(deepcopy_242(1)))
x = [1, [2, 3], 4]
y = deepcopy_242(x)
print('\nParameter {}\nShould return {}\nReturns {}'.format(x,x,deepcopy_242(x)))
print('x == y {} x is y {}'.format(x==y, x is y))
print('x[1] == y[1] {} x[1] is y[1] {}'.format(x[1] == y[1], x[1] is y[1]))
x[0] = 10
print('x {} y {}'.format(x,y))

print('\nFunction strings')

print('\nParameter \'abc\'\nShould return [\'abc\']\nReturns {}'.format(strings('abc')))
print('\nParameter [0, \'defgh\']\nShould return [\'defgh\']\nReturns {}'.format(strings([0,'defgh'])))
x = [['csc', 242], ['intro', 'to', ['python', 2]]]
print('\nParameter {}\nShould return [\'csc\', \'intro\', \'to\', \'python\']\nReturns {}'.format(x, strings(x)))

print('\nFunction activities')

monday = {'12:00' : 'Office hours', '1:30' : 'CSC 242 Lecture',
          '4:15' : 'Office hours', '5:45' : 'CSC 406 Lecture'}
tuesday = { }
wednesday = {'12:00': 'Office hours', '1:30' : 'CSC 242 Lecture',
             '3:10' : 'CSC 242 Lab'}
thursday = { }
friday = {'9:00' : 'Faculty committee meetings all day'}
calendar= {'monday':monday,'tuesday':tuesday, 'wednesday':wednesday,
           'thursday':thursday, 'friday':friday}

print('\nactivities {}\n\nShould return {}\n\nReturns {}'.format(calendar, '{\'Office hours\', \'CSC 242 lecture\', \'CSC 242 lab\', \'Advising hours\',\'CSC 406 lecture\'}', values242(calendar)))
