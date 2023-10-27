# CSC116: Lab 16 Journal - File Output

Names: Om Pandey, Anthony Du

## Collapse Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

This program is supposed to collapse all consecutive spaces into single spaces and write it to a file.

What knowledge concepts from pre-lab would help you solve this problem?

The knowledges of Scanner, FileInputStream, FileOutputStream, and PrintWriter should help solve this problem.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

main
* All the method callings and file controllings.

collapseSpaces
* Each time the Scanner has a next line, the PrintWriter needs to print the return of the collapseLine method to the output file.

collapseLine
* Every time the created Scanner has a next token. The created String needs to tack on that lineScanner's next token.

getInput
* Tries to create FileInputStream and Scanner objects unless file does not exist.

getOutput
* Tries to create FileOutputStream and PrintWriter objects unless file already exists.

## Collapse Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our code perfectly addressed the requirements of the exercise.

How did you apply the pre-lab concepts in this exercise?

We used Scanner to read through lines, console and file content.
FileInputStream, FileOutputStream, and PrintWriter are used to get the content and write content to new files. 

What are some new insights that you learned from this exercise?

We can use java.nio.file.Files.exists to check if a file already exists in order to prevent overwriting of files.

Estimate how much time (minutes) you spent on this exercise.

We spent about 100 minutes on this lab exercise.
