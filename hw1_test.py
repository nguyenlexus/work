# CSC 242 Section 602 Spring 2017
# Test cases for Homework assignment 1.
#
# Once you have finished writing the 4 functions in hw1.py,
# you can test to see if they work properly by using this
# file.  Press F5 to load this file.  It will import the
# functions that you have defined in hw1.py

from hw1 import *

sums_parameters = [ [[5, 10], [1]], [[1, 2, 3], [3, 4]],
                    [[3, 6, 2], [6, 1, 0, 6]], [[1, 2, 3], [ ]] ]
sums_answers = [ sums([5, 10], [1]), sums([1, 2, 3], [3, 4]),
                 sums([3, 6, 2], [6, 1, 0, 6]), sums([1, 2, 3], [ ]) ]
sums_correct_answers = [ [6, 11], [4, 5, 5, 6, 6, 7],
                         [9, 4, 3, 9, 12, 7, 6, 12, 8, 3, 2, 8], [ ] ]

pairs_parameters = [ '', 'a', 'ab', 'abc' ]
pairs_answers = [ pairs(''), pairs('a'), pairs('ab'), pairs('abc') ]
pairs_correct_answers = [ [ ], [ ], ['ab', 'ba'],
                          ['ab', 'ac', 'ba', 'bc', 'ca', 'cb'] ]

substrings_parameters = [ '', 'a', 'ab', 'abc', 'abcd' ]
substrings_answers = [ substrings(''), substrings('a'), substrings('ab'),
                       substrings('abc'), substrings('abcd') ]
substrings_correct_answers = [ [ ], ['a'], ['a', 'ab', 'b'],
                               ['a', 'ab', 'abc', 'b', 'bc', 'c'],
                               ['a', 'ab', 'abc', 'abcd', 'b', 'bc', 'bcd', 'c', 'cd', 'd'] ]

largest_prime_parameters = [ 5, 10, 25, 10000 ] 
largest_prime_answers = [ largest_prime(5), largest_prime(10),
                          largest_prime(25), largest_prime(10000) ]
largest_prime_correct_answers = [ 5, 7, 23, 9973 ]

def test_hw1():
    wrong = 0
    for i in range(len(sums_parameters)):
        if sums_answers[i] != sums_correct_answers[i]:
            wrong += 1
            print('Error in sums on parameters {}, {}'.format(sums_parameters[i][0],
                                                             sums_parameters[i][1]))
    print('{} errors in sums\n'.format(wrong))                            

    wrong = 0
    for i in range(len(pairs_parameters)):
        for pair in pairs_answers[i]:
            if pair not in pairs_correct_answers[i]:
                wrong += 1
                print('Error in pairs. {} should not be in the list.'.format(pair))
    for i in range(len(pairs_parameters)):
        for pair in pairs_correct_answers[i]:
            if pair not in pairs_answers[i]:
                wrong += 1
                print('Error in pairs. {} should be in the list.'.format(pair))
            
    print('{} errors in pairs\n'.format(wrong))                            

    wrong = 0
    for i in range(len(substrings_parameters)):
        student_answer = substrings_answers[i]
        correct_answer = substrings_correct_answers[i]
        if student_answer != correct_answer:
            wrong += 1
            print('Error in substrings on parameter {}'.format(substrings_parameters[i]))
    print('{} errors in substrings\n'.format(wrong))                            

    wrong = 0

    for i in range(len(largest_prime_parameters)):
        if largest_prime_answers[i] != largest_prime_correct_answers[i]:
            wrong += 1
            print('Error in largest_prime on parameter {}'.format(largest_prime_parameters[i]))
    print('{} errors in largest_prime'.format(wrong))

test_hw1()
