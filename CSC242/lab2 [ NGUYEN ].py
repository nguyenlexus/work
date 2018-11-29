###################################
# CSC 242 Section 602 Spring 2017
# Lab assignment 2
###################################
#
# LEXUS NGUYEN
# 
# Your assignment is to complete the 5 functions
# below.  Please refer to the lab write-up for
# details about grading, etc.
#
# 1.  

def factors(x):
     factors = set()
     for i in range(1,x+1):
          if x % i == 0:
               factors.add(i)
     return factors

# 2. 

def out_of_order(items):
     items2 = []
     for i in items:
          items2.append(i)
     items2.sort()
     done = False
     errorPair = ()
     for index in range(0,len(items)):
          if items[index] != items2[index]:
               
               first = items2[index + 1]
               second = items2[index]
               errorPair = (first, second)
               break
          elif items == items2:
               pass
          else:
               pass
     return errorPair
# 3. 

def read_wiktionary():
     answer = dict()
     f = open('wiktionary.txt')
     for line in f:
          line = line.split()
          if float(line[1]) >= 500000:
               answer[line[0]] = float(line[1])
     return answer

# 4. 

def count_words(file):
     answer = dict()          
     f = open(file)
     words = f.read().split() 
     wordList = []
     for word in words:
          if word not in wordList:
               wordList.append(word)
          else:
               pass
     for each in wordList:
          count = 0
          for word in words:
               if each == word:
                    count += 1
               else:
                    pass
          answer[each] = count
     return answer

# 5. 

def starts_with(file):
     answer = dict()
     f = open(file)
     words = f.read().split()
     letterList = []
     for word in words:
          if word[0] not in letterList:
               letterList.append(word[0])
          else:
               pass
     for letter in letterList:
          valueList = set()
          for word in words:
               if word[0] == letter:
                    valueList.add(word)
               else:
                    pass
          answer[letter] = valueList
     return answer

