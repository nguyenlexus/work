# CSC 242 Section 602 Spring 2017
# fraction module

# will be of use in reducing a fraction
def gcd(x, y):
    if x % y == 0:
        return y
    else:
        return gcd(y, x%y)

def fraction(num,den):
    return [ num , den ]

def reduce(f):
    d = gcd(f[0],f[1])
    num = f[0] // d
    den = f[1] // d
    return [ num , den ]

def add(f1, f2):
    pass

def sub(f1, f2):
    pass    

def mult(f1, f2):
    pass

def tostring(f):
    pass
