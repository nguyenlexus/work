from lab5 import *
from copy import copy

words = ['books', 'brokerage', 'ants', 'texting', 'thrifts', 'facetiously']
words_copy = copy(words)
vowel_words = ['inane', 'relate', 'infer', 'exit', 'exiting']
names = ['Ljubomir Perkovic', 'Steve Lytinen', 'Amber Settle']
titles = ['United States of America', 'DePaul University', \
          'the University of Illinois at Chicago']
course = 'CSC 242 Section 602'
caps = ['DePaul', 'CSC242', 'Ph.D.', 'UIC', 'University']
# 1
print('print_plurals({})'.format(words))
print_plurals(words)

# 2
for word in words:
     print('first_vowel(\'{}\') returns {}'.format(word, first_vowel(word)))

# 3
print('plurals({})\n\treturns {}'.format(words, plurals(words)))

# 4
for word in caps:
     print('to_upper({})\n\t returns {}'.format(word, to_upper(word)))

# 5
print('in_order({})\n\treturns {}'.format(words, in_order(words)))
words_copy.sort()
print('in_order({})\n\treturns {}'.format(words_copy, in_order(words_copy)))

# 6
print('first_names({})\n\treturns {}'.format(names, first_names(names)))

# 7
print('squares(7) returns {}'.format(squares(7)))

# 8
for word in  caps:
     print('only_caps({})\n\t returns {}'.format(word, only_caps(word)))

# 9
for word in words:
     print('absent_vowels(\'{}\') returns \'{}\''.format(word, absent_vowels(word)))

# 10
for i in range(2, 28, 5):
     print('is_prime({}) returns {}'.format(i, is_prime(i)))
