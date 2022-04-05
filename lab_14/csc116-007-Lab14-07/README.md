# CSC116: Lab 14 Journal - File Input

Names: Anthony Du and Bowen Deng

## Process File for Integers Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

The stats array stores four values: number of integers in scanner, minimum integer value in scanner, maximum integer value in scanner, and sum of all integer values in scanner.
We only care about integers, ignore the rest of the content of the file.

What knowledge concepts from pre-lab would help you solve this problem?

FileNotFoundException, FileInputStream, Scanner

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

main:
1. print error message and exit if the command line argument array doesn't have a length of 1
2. print the result of processFile(args[0]);

processFile:
1. create new scanner with argument FileInputStream
2. initiate stats int array with the result of process method
3. close file scanner
4. return statsToString(stats)

statsToString:
1. create an if statement to test whether the count of integers is 0
2. calculate the average using the values at index of sum and index for count.
3. return a string composed of maximum, minimum, sum, count, and average

process:
1. declare and initialize max/min/count/sum.
2. use a while loop to get next element through a scanner, if the scanner hasNextInt, count +1, use max/min method to update the new max/min value
3. skip non-integer values
4. return {0,0,0,0} if count equals to 0, else return an array with count, min, max, and sum.

## Process File for Integers Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our code perfectly addressed the requirements of this exercise.

How did you apply the pre-lab concepts in this exercise?

We applied the knowledge of Scanners to read files. We use fileInputStream to pass the content of the file into a scanner.

What are some new insights that you learned from this exercise?

We can use while loops for scanners to read through every single word/next from a file.

Estimate how much time (minutes) you spent on this exercise.

60 minutes. 
