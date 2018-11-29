import fraction

f1 = fraction.fraction(1,2)
f2 = fraction.fraction(1,3)
f3 = fraction.add(f1, f2)
print('{} + {} = {}'.format(fraction.tostring(f1), fraction.tostring(f2), fraction.tostring(f3)))

from fraction import *

f4 = fraction(2,3)
f5 = fraction(1,2)
f6 = multiply(f4, f5)
print('{} + {} = {}'.format(tostring(f1), tostring(f2), tostring(f3)))
print('{} * {} = {}'.format(tostring(f4), tostring(f4), tostring(f6)))
                            

