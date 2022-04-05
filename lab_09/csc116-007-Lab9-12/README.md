# CSC116: Lab 9 Journal - For Loops & Testing Update

Names: Anthony Du, Shuhao Liu

## Series of Numbers Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

We are required to output all non-zero perfect squares less than the square of the number provided. Input should be requested after every time the user puts in an invalid value. We are also required to not use multiplication or Math methods in our program. 

What knowledge concepts from pre-lab would help you solve this problem?

For loops

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

main
1. print starting message
2. keep getting integers using getInteger until a positive integer is retrieved (using do-while loop)
3. output result from getSeries method

getInteger(Scanner in)
1. print a message and ask for user input with Scanner
2. ask for input until an integer is retrieved
3. return that integer

getSeries(int max)
1. throw IllegalArgumentException if a max with value less than 0 is passed in
2. declare outString and iSquared to store temporary values
3. use a for loop to square i and add every iSquared to outString
4. remove trailing space
5. return outString

## Series of Numbers Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our program passed all unit, integration, and system tests. The output met the expectations and works flawlessly.

How did you apply the pre-lab concepts in this exercise?

We used a for loop to increment and get every number expected to be squared and added them each to the output.

What are some new insights that you learned from this exercise?

We learned to properly use for loops in a real programming environment. We learned to nest for loops and to use temporary variables to store values that are not supposed to be changed.

Estimate how much time (minutes) you spent on this exercise.

180 minutes.
