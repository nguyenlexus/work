###########################################################
# CSC 242 Section 602 Spring 2017
# Lab assignment 4
#
# Lexus Nguyen
#
###########################################################

class String:

    def __init__(self, s):
        self.s = s

    def __str__(self):
        return str(self.s)       
  
    def __repr__(self):
        return 'String({})'.format(self.s)

    def upper(self):
        self.s = self.s.upper()

    def find(self, substring):
        return self.s.find(str(substring))

    def concat(self, other):
        self.s = self.s + other.s

    def insert(self, index, s2):
        self.s = self.s[:index] + str(s2) + self.s[index:]

    def reverse(self):
        reverseStr = ''
        while self.s != '':
            reverseStr += self.s[-1]
            self.s = self.s[:-1]
        self.s = reverseStr

    def equals(self, other):
        if self.s == other.s:
            return True
        else:
            return False

    def copy(self):
        return String(self.s)
