# Project #1: Player Cache

* Author: Carson Keller
* Class: CS321 - 4001
* Semester: Spring 2023

## Overview

Using predefined Player and PlayerGenerator classes to create and serialize files
containing player objects, this program reads in and deserializes those player 
objects, instantiates a cache object to store and monitor the access of them, and 
prints the stats and results following a successful use.

## Reflection

I'm pleasantly surprised by how straightforward I found this project. Not that I
was necessarily expecting something more convoluted, but I felt like the objective
and relevance of this project was easy to comprehend. I was actually able to write
most of the Cache and CacheTest classes within a couple of hours, and it only took 
a couple more hours to debug, ensure correct output, deal with unexpected 
challenges, and write proper documentation and this README. I opted to begin the 
Cache class by writing an interface to implement which really helped me understand
the expections of the class and the assignment. This part got a lot easier when one
of the tutors suggested I take a closer look at the LinkedList API.

The real challenges came when I was trying to write the CacheTest class. The tutor
really helped me understand serialization, and that made it a lot easier to adapt
the provided example code to this use case. Additionally, they helped me correct the
type of my ObjectInputStream to correctly read in the files and add them to the
cache which has significantly stumped me for a while. I really enjoyed this project,
especially the face that its scope was more limited and felt like sort of a warm-up
before the more difficult projects come later in the semester. That being said, there
weren't really any major challenges or less desirable aspects. It was nice to start
off with a more simple, readily relevant project to kick of the semester.

## Compiling & Using

The following files are included and, with the exception of this README, all are 
required to run and test this program:

* Cache.java - source file
* CacheInterface.java - source file
* CacheTest.java - source file
* Player.java - source file
* PlayerGenerator.java - source file
* README.md
* run-tests.sh - shell script
* the file of test-cases - test files

From the directory containing all the required source, interface, and test files, run
the following command to compile all the necessary java source code:

> $ javac *.java

Run the compiled source code using the shell script using the command:

> $ ./run-tests.sh

Console output will return the results of the test script.

## Results

Per the console output after running the shell script, all output from my program
matches the expected outcomes, results, and statistics.

## Sources Used

Aside from the provided Player and PlayerGenerator class files, shell script, and 
test files, the only outside sources I utilized were the tutors during their tutor 
sessions and the Java LinkedList API.