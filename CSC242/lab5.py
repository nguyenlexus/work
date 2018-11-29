###############################################################
# CSC 242 Section 602 Spring 2017
# Sample Solutions for Lab 5:  Recursion
# May 3, 2017
#
# LEXUS NGUYEN
#
###############################################################
#
# Please upload your solutions for this lab onto D2L by the
# date and time specified on the D2L Lab 6 dropbox folder.
# You are strongly encouraged to work in groups of 2 or 3
# for all labs.  Please place a comment at the top of your .py 
# file which includes your name, and the names of any students 
# you worked with.  Each student should upload solutions to the 
# D2L dropbox, even if you worked in a group.
#
###############################################################
# Your task is to complete the 10 functions below.
# Each function can be completed in 5-10 lines of code or less.
# You may recognize some of these problems from a previous lab.
#
# For this lab, you must write each function RECURSIVELY.
# I have provided a template for each problem; however if
# you find a different solution for any problem, you can delete
# my code and rewrite it in whatever way you'd like, except
# YOUR SOLUTION MUST BE RECURSIVE -- NO LOOPS ARE ALLOWED!
#
# For some functions, I have provided a template which
# reflectf the number of base cases and recursive
# cases that I wrote when I completed it.
# For any "elif" statements, I have written "elif False:".
# Obviously, False is a condition which is never met, so
# you should be sure to replace "False" with the condition
# which you think is correct for the function.
#
# You may test your code by running it with the file lab5_test.py
# In order to do so, hit F5 on the window displaying lab5_test.py
# and it will load lab5.py through the import statement
# at the top.
#
# The lab is worth a total of 2 points.  Each correct solution
# is worth .2 points.  Partial credit of .1 point will be given
# for functions which do not have syntax errors, and which
# work correctly on one or more of the test cases I am
# providing.
#
###############################################################
# 1. Write a function which prints all the plural 
# words in a list of words.  For our purposes, plural words 
# end in 's'. For example,
#
# >>> print_plurals(['computer', 'computers', 'science,', 'sciences'])
# computers
# sciences

def print_plurals(words):
    if words == [ ]:                # base case
        return
    elif (words[0])[-1] == 's':                     # recursive case -- replace "False"
        print(words[0])
        print_plurals(words[1:])
    else:                           # you may need a second recursive case
        print_plurals(words[1:])
    
# 2. Write a function which returns the first vowel 
# in a word. For example:
#
# >>> first_vowel('computer')
# o
# >>> first_vowel('science')
# i

def first_vowel(word):
     if word == '':                     # base case 1
          return ''
     elif word[0] in 'aeiou':           # base case 2 -- replace "False"
          return word[0]
     else:                              # recursive case
          return first_vowel(word[1:])

# 3. Write a function which **returns** all the plural words in a list of words
#
# >>> plurals(['computer', 'computers', 'science', 'sciences'])
# ['computers', 'sciences']
def plurals(words,lst = []):
    if words == []:              # base case
        return lst
    elif words[0][-1] == 's':    # recursive case 1
        lst.append(words[0])
        return plurals(words[1:])
        
    else:                        # recursive case 2
        return plurals(words[1:])

# 4.  Write a function called to_upper.  It is passed a str object,
# and returns a str object in which all of the lower case letter
# in the parameter string have been changed to upper case.
# You may NOT use the built-in method upper of the Python str class.
#
# For example:
# >>> s = 'CSC 242 Intro to Computer Science II'
# >>> s = to_upper(s)
# >>> s
'CSC 242 INTRO TO COMPUTER SCIENCE II'

def to_upper(word):
    lower = 'abcdefghijklmnopqrstuvwxyz'
    upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    # you might find it helpful to use d in your code below
    d = dict()
    for i in range(26):
        d[lower[i]] = upper[i]
    # continue here with your own code to complete the function
    if len(word) == 0:
        return ''
    elif word[0].islower():
        return d[word[0]] + to_upper(word[1:])
    else:
        return word[0] + to_upper(word[1:])

# 5.  Write a function called in_order, which returns True if a
#     list of words is in lexicographical order (i.e., they
#     appear in the same order in which they would appear in
#     the dictionary).  Do not use the sort function.  Assume the
#     words are all lower case.  For example:
#
# >>> in_order(['apple', 'grape', 'grapefruit', 'orange', 'pear'])
# True
# >>> in_order(['apple', 'grape', 'pear', 'banana'])
# False
#

def in_order(words):
    sortedWords = sorted(words)
    if words == []:
        return True
    elif words[0] == sortedWords[0]:
        return in_order(words[1:])
    elif words[0] != sortedWords[0]:
        return False
    

# 6.  Write a function called first_names.  It takes a list of strings.
#     Each string is someone's full name.  The function returns
#     a list of the people's first names.
#
# >>> first_names(['Ljubomir Perkovic', 'Steve Lytinen', 'Amber Settle'])
# ['Ljubomir', 'Steve', 'Amber']
#

def first_names(names,lst=[]):
    if names == []:
        return lst
    else:
        fname = names[0].split(sep=' ')
        lst.append(fname[0])
        return first_names(names[1:],lst)

# 7.  Write a function called squares, which passed an integer n
#     and returns the squares of each of the first n positive integers
#
# >>> squares(5)
# [1, 4, 9, 16, 25]
#
def squares(n,lst=[]):
    if n == 0:
        lst.sort()
        return lst
    else:
        lst.append(n*n)
        return squares(n-1,lst)

# 8.  Write a function called only_caps, which is passed a word
# (i.e., a Python str) and returns a string with only the
# capital letters in the original word.  For example:
#
# >>> only_caps('DePaul')
# 'DP'
# >>> only_caps('UIC')
# 'UIC'
# >>> only_caps('programming')
# ''
# >>> only_caps('CSC242')
# 'CSC'
# >>> only_caps('Ph.D.')
# 'PHD'

def only_caps(word):
    if word == '':
        return ''
    elif word[0].isupper():
        return word[0] + only_caps(word[1:])
    else:
        return only_caps(word[1:])

# 9. Write a function which returns all the vowels which do not appear
#    in the word that is passed as a parameter
#
#    for example,
#
# >>> absent_vowels('computer')
# 'ai'
# >>> absent_vowels('science')
# 'aou'
#
# Here I suggest that you use an optional parameter, "vowels",
# whose default value is 'aeiou'.  Recursive calls should
# have 2 parameters:  the word, and the vowels which have not
# yet been found in the word

def absent_vowels(word, vowels = 'aeiou'):
    if vowels == '':                # base case
        return ''
    elif vowels[0] in word:                     # recursive case 1: replace "False"
        return absent_vowels(word,vowels[1:])
    else:                           # recursive case 2
        return vowels[0] + absent_vowels(word,vowels[1:])
    
# 10.  Write a function called is_prime.  It is passed a parameter n
#      and returns True is n is a prime number or False otherwise.
#      Recall that a number n is prime if only 1 and n divide evenly
#      into n.

# i is an optional parameter whose default value is 2
# recursive calls to is_prime should pass 2 parameters

def is_prime(n, i=2):
    if i == n:
        return True
    else:
        if n % i == 0:
            return False
        else:
            return is_prime(n,i+1)
    
