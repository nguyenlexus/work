################################################
# CSC 242 Section 602 Spring 2017              #
# Starter code for Homework assignment 3       #
#                                              #
# Lexus Nguyen                                 #
#                                              #
# Please see the lab write-up for examples     #
# which illustrate how each method should work #
################################################
class Date:
    # constructor
    def __init__(self, m, d, y):
        self.m = m
        self.d = d
        self.y = y
        if (self.m == 6) and (self.d > 30):
            if self.d == 31:
                self.m += 1
                self.d = 1
            else:
                print ("Invalid input")
                self.m = 0
                self.d = 0
                self.y = 0
        elif (self.m == 2) and (self.d > 28):
            if self.d == 29:
                if self.y == 2016:
                    pass
                else:
                    self.m += 1
                    self.d = 1
            elif self.d == 30:
                if self.y == 2016:
                    self.m += 1
                    self.d = 1
                else:
                    print ("Invalid input")
                    self.m = 0
                    self.d = 0
                    self.y = 0
            else:
                print ("Invalid input")
                self.m = 0
                self.d = 0
                self.y = 0
        elif (self.m == 12) and (self.d == 32):
            self.m = 1
            self.d = 1
            self.y += 1
        

    def __str__(self):        
        return "{}/{}/{}".format(self.m,self.d,self.y)                 

    def __repr__(self):
        return "Date({},{},{})".format(self.m,self.d,self.y)

    def next_date(self):
        return Date(self.m,self.d + 1,self.y)  

    def earlier_date(self, other):
        if self.y < other.y:
            return True
        elif self.y > other.y:
            return False
        else:
            if self.m < other.m:
                return True
            elif self.m > other.m:
                return False
            else:
                if self.d < other.d:
                    return True
                else:
                    return False

    def same_date(self, other):
        if self.y == other.y:
            if self.m == other.m:
                if self.d == other.d:
                    return True
                else:
                    return False
            else:
                return False
        else:
            return False

        
