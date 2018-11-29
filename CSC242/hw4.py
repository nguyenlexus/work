################################################
# CSC 242 Section 504 Winter 2017              #
# Starter code for homework assignment 4       #
#                                              #
#       LEXUS NGUYEN                           #
#                                              #
# Please see the lab write-up for examples     #
# which illustrate how each method should work #
################################################
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
        self.string + other.string
        return self

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

    def __add__(self, other):
        return String(self.string + other.string)

    def __radd__(self, other):
       return self.string == self.string + self.other

    def __getitem__(self, i):
        return String(self.string[i])

    def __setitem__(self, i, other):
        if i in range(0,len(str(self.string))):
            if len(str(other.string)) == 1:
                self.string = self.string[:i] + other.string + self.string[i+1:]
            else:
                print('String input != 1 character')
        else:
            print ('Invalid index')
    
 
