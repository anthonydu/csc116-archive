# CSC116: Lab 15 Journal - File Input (Line-Based Processing)

Names: Anthony Du, Bowen Deng

## Weather Reporter Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

The text file is going to have a format of comma separated values.
We need to read, extract, and process each of the values and do stuff with them.

What knowledge concepts from pre-lab would help you solve this problem?

Using fileInputStream and scanner to read through the contents of a file.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

processFile:
1. create scanner that reads console input
2. pass scanner to getInput to get a valid file scanner
3. print out the result from processFile

processLine:
1. create scanner that scans through the line
2. set the delimiter to comma
3. decleare relevant variables
4. use Scanner.next to get each comma-separated value
5. put the values into the correct variables
6. return concatenated string

getInput:
1. create a null scanner
2. use while loop to keep prompting users for a valid input.
3. use try/catch inside the while loop to throw errors.
4. return the scanner

## Weather Reporter Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our code perfectly addressed the requirements of the exercise.

How did you apply the pre-lab concepts in this exercise?

We applied the knowledge of Scanners to read files, and each individual line of files. We use fileInputStream to pass the content of the file into a scanner.

What are some new insights that you learned from this exercise?

We can use while loops for scanners to read very single line individually from a file.
We use scanner delimiter to skip the commas.

Estimate how much time (minutes) you spent on this exercise.

We spent about 70 minutes on this exercise.
