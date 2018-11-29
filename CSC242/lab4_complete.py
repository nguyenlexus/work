###########################################################
# CSC 242 Section 602L Spring 2017
# Lab 4:  The String class
#
# In this lab, you will complete the String class below.
# In essence, String is a mutable version of str.
# Since the str class has many method, I haven't asked
# you to implement them all.  Also, I have added
# some destructive methods which are not part of the
# str class.  In particular, note that the concat,
# insert, and reverse methods below are meant to be
# destructive (that is, they change the String on which
# they operate).
#
# Please see the lab write-up for more details about each
# method.  Also, note that I have NOT provided a template
# for the last 5 methods (concat, insert, reverse, equals,
# or copy).  It is up to you to determine what the proper
# parameter list is for each of these methods.
#
# NOTE:  For many of the methods below, you can utilize
# similar methods/functions from the Python str class.
# This will drastically simplify your code for some of
# the methods below.  As a a result, many of the methods
# below will require only one or two lines of code.
###########################################################
class String:
    def __init__(self, s):
        self.string = s

    def __str__(self):
        return self.string

    def __repr__(self):
        return 'String(\'{}\')'.format(self.string)

    def upper(self):
        self.string = self.string.upper()

    def find(self, substring):
        return self.string.find(substring.string)

    def concat(self, other):
        self.string += other.string

    def insert(self, index, other):
        self.string = self.string[:index] + str(other) + self.string[index:]

    def reverse(self):
        s = ''
        for i in range(len(self.string)-1,-1,-1):
            s += self.string[i]
        self.string = s

    def equals(self, other):
        return self.string == other.string

    def copy(self):
        return String(self.string)
        
