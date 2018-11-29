####################################################
# CSC 242 Section 602 Spring 2017 Lab assignment 7
# Please refer to the lab write-up for a descripion
# of the goal of this lab
#
# LEXUS NGUYEN
#
####################################

from html import unescape
from urllib.request import *
from urllib.error import *
from html.parser import *
from urllib.parse import urljoin

class Headlines(HTMLParser):

    def __init__(self, url):
        HTMLParser.__init__(self)
        self.headlineSet = [set(),set(),set()]
        self.h1Check = False
        self.h2Check = False
        self.h3Check = False
        self.url = url
        self.contents = urlopen(url).read().decode()
        self.feed(self.contents)
        
    def handle_starttag(self, tag, attrs):
        if tag in ['h1','h2','h3']:
            if tag == 'h1':
                self.h1Check = True
            elif tag == 'h2':
                self.h2Check = True
            elif tag == 'h3':
                self.h3Check = True
        else:
            pass
        
    def handle_data(self, data):
        if self.h1Check == True:
            data = data.strip()
            self.headlineSet[0].add(data)
        elif self.h2Check == True:
            data = data.strip()
            self.headlineSet[1].add(data)
        elif self.h3Check == True:
            data = data.strip()
            self.headlineSet[2].add(data)
        else:
            pass

    def handle_endtag(self, tag):
        if tag in ['h1','h2','h3']:
            if tag == 'h1':
                self.h1Check = False
            elif tag == 'h2':
                self.h2Check = False
            elif tag == 'h3':
                self.h3Check = False
        else:
            pass
            
    def headlines(self, level=3):
        if level > 3:
            return 'False Input'
        elif level <= 0:
            return 'False Input'
        else:
            if level == 3:
                for eachHead in self.headlineSet:
                    for line in eachHead:
                        print(line)
            elif level == 2:
                for eachHead in self.headlineSet[:2]:
                    for line in eachHead:
                        print(line)
            elif level == 1:
                for line in self.headlineSet[0]:
                    print (line)

# example call to this program
# >>> h = Headlines('http://www.nytimes.com')
# h.headlines()

