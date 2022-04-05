# CSC116: Lab 12 Journal - Multi-dimensional Arrays & Arrays of Objects

Names: Anthony Du and Bowen Deng

## String Arrays Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

We need to create a class containing two helper methods that checks if a string array is palindrome
We need to create a method to determine whether two arrays are equal arrays (contain all other same elements in the same order/location)


What knowledge concepts from pre-lab would help you solve this problem?

Arrays, 2D arrays, for-loops, null, exceptions

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

isPalindrome:
1. first, test if the whole array is null, if so, throw error message.
2. create a for loop that loops through each element
3. test if each element in the array is null, if so, throw error message.
4. test if the first element in the array is same with the last element and so on. If all the same, return true; if not, return false.

equals2D:
1. test if the two arrays are null, if so, throw error message
2. test if the length of the two arrays are equal, if not, throw error message
3. create a for loop that loops through the rows of both arrays.
4. test if any elements are null
5. create another for loop inside the previous one to loop through the columns.
6. compare if all the element in the same location are equal, if so, return true, if not, return false.

## String Arrays Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our code addressed the requirements of the this exercise quite well.

How did you apply the pre-lab concepts in this exercise?

We used 2D array methods and nested for loops to read through 2D arrays and compare them. 

What are some new insights that you learned from this exercise?

When using nested for loops, be aware of the use of different character than "i".
Test cases really make it a lot faster and easier to locate the problems in the code.

Estimate how much time (minutes) you spent on this exercise.

It took us about 40 minutes to complete.
