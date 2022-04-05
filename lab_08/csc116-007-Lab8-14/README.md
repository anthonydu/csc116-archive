# CSC116: Lab 8 Journal - While & Do-While Loops

Names: Anthony Du, Shuhao Liu

## All Digits Odd? Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

02468 are even numbers. 13579 are odd numbers.  
The user is not perfect so check input!!!

Are all number odd in user input number?

What knowledge concepts from pre-lab would help you solve this problem?

Loops (while, do-while), check user input

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

main
1. ask user for an integer numbers
2. check if the number is valid, if not, ask again (using a while loop with Scanner.hasNextInt)
3. integrate areAllDigitsOdd method

areAllDigitsOdd
1. using a while loop to iterate every number in user input
2. check if that number is odd
3. use a variable to record the number of odd numbers
4. if that variable is equal to user input number length, then all numbers are odd
5. return true or false

## All Digits Odd? Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Very well. Our code was very concise. We found out if the number consists of only odd digits.

How did you apply the pre-lab concepts in this exercise?

We used a while loop to check if the user input is valid.
We used another while loop to check each digit of the given number.

What are some new insights that you learned from this exercise?

The condition in while must me true to run. We put in the opposite condition the first time.
Don't convert the number into string. It gets way more complicated than just dividing numbers

Estimate how much time (minutes) you spent on this exercise.

30 minutes
