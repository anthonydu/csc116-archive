# CSC116: Lab 10 Journal - Array Basics

Names: Anthony Du, Shuhao Liu

## Processing Exam Scores Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

We are requied to create a class that contains methods for finding 

1) the first, last or all student id with a given score 

2) the difference between the maximum and minimum score + 1 

3) the number of students within a score range (inclusive) 

We don't have any questions about the problem it's pretty easy to follow. 

What knowledge concepts from pre-lab would help you solve this problem?

Arrays, for loop

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

indexOf

run through the entire array from index 0 using a for loop, and if the value is found, return its index immediately. 

lastIndexOf

run through the entire array from the last index using a for loop, and if the value is found, return its index immediately. 

listOfIndexWithValue

1. create an empty string
2. run through the entire array from the first index using a for loop, and if the value is found, add its index to the empty string followed by ", "
3. remove the last two characters using String.substring

range

1. create a min and a max variable
2. set them both equal to the first element of the Array
3. run through the entire array from the first index using a for loop, and compare the values of min and max with every element in the Array, replace the min and max if a smaller or bigger value is found
4. return max - min + 1

countInRange

1. create a count variable
2. run through the entire array from the first index using a for loop, add 1 to count every time a value between max and min is found
3. return count

## Processing Exam Scores Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Very well. Our code past all unit and system tests and style check. 

How did you apply the pre-lab concepts in this exercise?

use arrays to save the value and use for loop to calculate and find the value.  

What are some new insights that you learned from this exercise?

dont forget to return. for loop is important to solve the problem.

Estimate how much time (minutes) you spent on this exercise.

30 minutes. 
