###################################################
# CSC 242 Section 602 Spring 2017
# Test file for Lab 4
###################################################

from lab4 import *
from copy import copy

string = None

def test_lab4():
    global string
    while (True):
        string = input('Type a string, or \'quit\'\n')
        if string == 'quit':
            return
        s = String(string)
        print('str(s) = \'{}\''.format(str(s)))
        print('repr(s) = \'{}\''.format(repr(s)))
        s.upper()
        print('s.upper( ) = \'{}\''.format(s))
        s = String(string)
        print('s set back to \'{}\''.format(s))
        sub = String(input('Type a substring\n'))
        print('s.find(\'{}\') = {}'.format(sub,s.find(sub)))
        s2 = String(input('Type another string\n'))
        s.concat(s2)
        print('s.concat(\'{}\') = \'{}\''.format(s2, s))
        s = String(string)
        print('s set back to \'{}\''.format(s))
        index = int(input('Type an integer\n'))
        s.insert(index, s2)
        print('s.insert(\'{}\',\'{}\') = \'{}\''.format(index, s2, s))
        s = String(string)
        print('s set back to \'{}\''.format(s))
        s.reverse()
        print('s.reverse() = \'{}\''.format(s))
        s = String(string)
        print('s set back to \'{}\''.format(s))
        s2 = String(str(s))
        print('\'{}\'.equals(\'{}\')? {}'.format(s, s2, s.equals(s2)))
        print('s.copy() = \'{}\''.format(s.copy()))

test_lab4()
