################################################
# CSC 242 Section 602 Spring 2017
# Homework assignment 6 / Lab assignment 8:
# An image scraper
#
#
#   LEXUS NGUYEN
#
#
################################################


from html import unescape
from urllib.request import urlopen
from html.parser import HTMLParser
from urllib.error import *
from urllib.parse import urljoin
from http.client import *

####################################################################
# this program extracts images from a single page, using
# HTMLParser
#####################################################################    
class ImageParser(HTMLParser):
    def __init__(self, url):
        HTMLParser.__init__(self)
        self.images = set()
        self.url = url

    def extract_images(self):
        contents = unescape(urlopen(self.url).read().decode())
        self.feed(contents)
        return len(self.images)
    
    def handle_starttag(self, tag, attrs):
        if tag == 'img':
            for attr in attrs:
                if attr[0] == 'src':
                    self.images.add((attr[1]))

    def get_images(self):
        return self.images

########################################################
# this code crawls the Web and gathers all of the
# hyperlinks that it can find, up to a maximum number
#
# to run it, for example:
#
# c = Crawler('http://www.nytimes.com', 20)
# c.crawl()
#
# this will return a set of 20 URLs
########################################################

class Crawler(HTMLParser):
    def __init__(self, url, max_links = 100, visited=None):
        HTMLParser.__init__(self)
        self.url = url
        self.max_links = max_links
        if visited == None:
            self.visited = set()
        else:
            self.visited = visited
        self.href = None
        
    def crawl(self):
        if self.url in self.visited:
            print('already visited')
            return
        else:
            self.visited.add(self.url)
        try:
            page_contents = unescape(urlopen(self.url).read().decode())
            self.feed(page_contents)
        except UnicodeDecodeError:
            print('unicodedecode')
            pass
        except UnicodeEncodeError:
            print('unicodeuncode')
            pass
        except URLError:
            print('urlerror')
            pass
        except BadStatusLine:
            print('bad')
            pass

    def handle_starttag(self, tag, attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    self.href = urljoin(self.url, attr[1])
                    if len(self.visited) < self.max_links:
                        c = Crawler(self.href, self.max_links, self.visited)
                        return c.crawl()
                  
    def get_pages(self):
        return self.visited

########################################################
# YOU MUST COMPLETE THIS CLASS.
########################################################

class ImageScraper(HTMLParser):
    def __init__(self, url, max_links = 25):
        self.url = url
        self.max_links = max_links
        self.visited = set()
        self.images = [ ]
        
    def scrape(self):
        self.imageFile = open('images.html','w')
        def getUrls(url):
            self.visited.add(url)
            page = Crawler(url)
            page.crawl()
            urls = page.get_pages()
            for each in urls:
                if each not in self.visited:
                    getUrls(each)
                else:
                    pass
        def getImages(url):
            img = ImageParser(url)
            img.extract_images()
            self.pageImages = img.get_images()
            for eachIMG in self.pageImages:
                self.images.append(eachIMG)
            for each in self.pageImages:
                self.imageFile.write('<img src =' + each + '>')
            
        getUrls(self.url)
        for eachUrl in self.visited:
            self.imageFile.write('<a href = ' + eachUrl +'>')
            getImages(eachUrl)
            self.imageFile.write('</a>')

        self.imageFile.close()
            
                
        

    
