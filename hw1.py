# LEXUS NGUYEN

# For this assignment, I did not collaborate with anyone else.

def sums(list1, list2):
    answer = [ ]
    for i in list1:
        for e in list2:
            answer.append(i+e)
    if len(answer) == (len(list1) * len(list2)):
        return answer

def pairs(string):
    answer = [ ]
    strLength = len(string)
    for pair1 in range(strLength):
        for pair2 in range(strLength):
            if pair1 != pair2:
                pairStr = string[pair1] + string[pair2]
                answer.append(pairStr)
    return answer


def substrings(string):
    answer = [ ]
    for each in range(len(string)):

        done = False
        index = each
        while done == False:
            subStr = string[each:index + 1]
            answer.append(subStr)
            if len(subStr) == len(string[each:]):
                done = True
            else:
                index += 1
    return answer

def largest_prime(n):
    if n > 1:
        testNum = n
        foundPrime = False
        while foundPrime == False:
            primeProof = False
            isPrime = True
            while primeProof == False:
                for i in range(2,testNum):
                    primeTest = testNum % i
                    if primeTest == 0:
                        isPrime = False
                        primeProof = True
                    elif i == (testNum - 1):
                        primeProof = True
                    else:
                        pass
            if isPrime == True:
                foundPrime = True
            else:
                testNum -= 1
        return testNum
                        
                    
                
                    
    else:
        print ("Invalid input")

