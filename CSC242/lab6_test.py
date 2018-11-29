from lab6_complete import *

my_phone = [[3, 1, 2], [[3, 6, 2], [6, 1, 0, 6]]]

def test1():
    err = 0
    tests = [1, [], [1, 2, 3], [1, [2, 3], 4], my_phone, [1, [[[[2, [3]]]]]]]
    answers = [0, 1, 1, 2, 3, 6]
    for i in range(len(answers)):
        call = 'depth_embed({})'.format(tests[i])
        if eval(call) != answers[i]:
            err += 1
            print('Error: {} returned {}'.format(call, eval(call)))
            print('\tbut should have returned {}.'.format(answers[i]))
    return err

def test2():
    err = 0
    first_args = [0, 0, 1, 9, 10, 2]
    second_args = [10, [10, 20], [[10, 20]], my_phone, my_phone, ['a', ['b', 'c']]]
    answers = [10, 10, 20, 6, None, 'c']
    for i in range(len(answers)):
        call = 'nth_embed({},{})'.format(first_args[i], second_args[i])
        if eval(call) != answers[i]:
            err += 1
            print('Error: {} returned {}'.format(call, eval(call)))
            print('\tbut should have returned {}.'.format(answers[i]))
    return err
     
def test3():
    err = 0
    first_args = [10, 20, 1, 0, 7, '\'b\'']
    second_args = [10, [10, 20], [[10, 20]], my_phone, my_phone, ['a', ['b', 'c']]]
    answers = [0, 1, -1, 8, -1, 1]
    for i in range(len(answers)):
        call = 'find_embed({},{})'.format(first_args[i], second_args[i])
        if eval(call) != answers[i]:
            err += 1
            print('Error: {} returned {}'.format(call, eval(call)))
            print('\tbut should have returned {}.'.format(answers[i]))
    return err

def test4():
    err = 0
    tests = [10, [1, 2, 3], [1, [2, 3], 4], my_phone, [[[[1,2]]], [[3, 4]]]]
    answers = [10, [3, 2, 1], [4, [3, 2], 1], [[[6, 0, 1, 6], [2, 6, 3]], [2, 1, 3]], [[[4, 3]], [[[2, 1]]]]]
    for i in range(len(answers)):
        call = 'reverse_embed({})'.format(tests[i])
        if eval(call) != answers[i]:
            err += 1
            print('Error: {} returned {}'.format(call, eval(call)))
            print('\tbut should have returned {}.'.format(answers[i]))
    lst1 = [ ]
    lst2 = reverse_embed(lst1)
    if lst1 is lst2:
        err += 1
        print('Error: reverse_embed([ ]) should return a new empty list')
    return err
     
def test_lab6():
    err = 0
    err1 = test1()
    err += err1
    err2 = test2()    
    err += err2
    err3 = test3()
    err += err3
    err4 = test4()
    err += err4
    print('\nSummary\n')
    print('depth_embed produced {} errors on 6 tests'.format(err1))
    print('nth_embed produced {} errors on 6 tests'.format(err2))
    print('find_embed produced {} errors on 6 tests'.format(err3))
    print('reverse_embed produced {} errors on 6 tests'.format(err4))
    print('\n{} total errors'.format(err))

test_lab6()
    
    
