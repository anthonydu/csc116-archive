# CSC116: Lab 13 Journal - Testing Arrays

Names: Anthony Du, Bowen Deng

## Sorted Arrays Bug

[Document each bug fixed]
sequentialSearch for-loop: extra parentheses after arr.length.
swap temp definition: wrong order of operation of using temp variable.
swap if-statement: if statement for null is put in front of everything else to fix NullPointerException.
selectionSort indexOfMinValue call: index out of range, added -1
selectionSort if-statement: changed comparison between indexes to comparison between array values
sequentialSearch if-statement: add ! when checking for unsorted array
indexOfMinValue for-loop: change i = indexA + 1 to i = indexA
indexOfMinValue if-statement inside for-loop: changed <= to <
indexOfMinValue if-statement: if statement for null is put in front of everything else to fix NullPointerException.
sequentialSearch index definition: change 1 to 0
addElement if (indexToAdd < 0): added parentheses for indexToAdd + 1
GetNewArray if-statement: change NumElements <= 0, to NumElements < 0
addElement if-statement inside for-loop condition: changed <= to <
isSorted: added test for array with length 0 (returns false)

## Sorted Arrays Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Our code addressed the requirements of the exercise really well.

How did you apply the pre-lab concepts in this exercise?

we used numerous assertArrayEquals and assertThrows methods to test if SortedDoubleArray is correct.

What are some new insights that you learned from this exercise?

It is important to write correct tests.
Tests are excellent ways to help you locate errors in your code.

Estimate how much time (minutes) you spent on this exercise.

It takes us about 180 minutes.
