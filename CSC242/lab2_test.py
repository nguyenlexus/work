from lab2 import *

def p1_test():
    errors = 0
    ans1 = factors(10)
    if ans1 != {1, 2, 10, 5}:
        errors += 1
    ans2 = factors(25)
    if ans2 != {1, 25, 5}:
        errors += 1
    ans3 = factors(37)
    if ans3 != {1, 37}:
        errors += 1
    ans4 = factors(100)
    if ans4 != {1, 2, 4, 5, 100, 10, 50, 20, 25}:
        errors += 1
    return errors

def p2_test():
    errors = 0
    ans1 = out_of_order((10, 15, 20))
    if ans1 != ():
        errors += 1
    ans2 = out_of_order(('intro', 'python', 'programming'))
    if ans2 != ('python', 'programming'):
        errors += 1
    ans3 = out_of_order([7, 7, 3])
    if ans3 != (7, 3):
        errors += 1
    ans4 = out_of_order((1.1, 3.3, 5.5, 4.4, 6.6))
    if ans4 !=(5.5, 4.4):
        errors += 1
    return errors
    
def p3_test():
    errors = 0
    d = read_wiktionary()
    if 'the' not in d or d['the'] != 56271872.0:
        errors += 1
    if 'my' not in d or d['my'] != 3277699.0:
        errors += 1
    if 'every' not in d or d['every'] != 704444.0:
        errors += 1
    if 'computer' in d:
        errors += 1
    return errors

def p4_test():
    errors = 0
    d = count_words('hamlet.txt')
    if 'to' not in d or d['to'] != 13:
        errors += 1
    if 'be' not in d or d['be'] != 3:
        errors += 1
    if 'or' not in d or d['or'] != 2:
        errors += 1
    if 'hamlet' in d:
        errors += 1
    return errors

def p5_test():
    errors = 0
    d = starts_with('hamlet.txt')
    if 'b' not in d or d['b'] != {'be', 'by'}:
        errors += 1
    if 'n' not in d or d['n'] != {'nobler', 'natural', 'not', 'no'}:
        errors += 1
    if 'q' not in d or d['q'] != {'question'}:
        errors += 1
    if 'x' in d:
        errrors += 1
    return errors

total_points = 0

errors = p1_test()
points = (4-errors)/10
total_points += points
print('Problem 1: {} errors {} points'.format(errors, points))

errors = p2_test()
points = (4-errors)/10
total_points += points
print('Problem 2: {} errors {} points'.format(errors, points))

errors = p3_test()
points = (4-errors)/10
total_points += points
print('Problem 3: {} errors {} points'.format(errors, points))

errors = p4_test()
points = (4-errors)/10
total_points += points
print('Problem 4: {} errors {} points'.format(errors, points))

errors = p5_test()
points = (4-errors)/10
print('Problem 5: {} errors {} points'.format(errors, points))
total_points += points

print('\nTotal points: {}'.format(total_points))
