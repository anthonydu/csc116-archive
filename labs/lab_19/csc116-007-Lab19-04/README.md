# CSC116: Lab 19 Journal - Interacting Classes

Names: Om Pandey, Anthony Du

## Pack Bakery Planning (***Before*** writing code)

### Initial Planning - Problem Analysis

What are the requirements of this problem?

* What is already known about the problem?
* What questions do you have about the problem?

The bakery has a variable menu size each day. Every sandwich has a name, a bread, and a filling. Every bread has its own description, and the number of calories per piece. Every filling has its own description, and the number of calories per serving. Every class has its own name, fields, and methods, to be used to interact with each other.

What knowledge concepts from pre-lab would help you solve this problem?

The knowledge of how objects and classes are used to interact with each other should help solve this problem.

### Initial Planning - Solution Plan

What algorithms will be needed to address the problem? Describe the algorithms using English statements or sentences. You should not write out Java code yet.

1 (Bread): Getter methods are included for getting the type of bread and the number of calories per piece of bread. toString method for converting to string and equals method used to check equivalency.
2 (SandwichFilling): Getter methods are included for getting the type of sandwich filling and the number of calories per serving of sandwich filling. toString method for converting to string and equals method used to check equivalency.
3 (Sandwich): Includes a SandwichFilling and a Bread objects. Getter methods are included for getting the name of the sandwich and the total calories based on the amount of Bread and SandwichFilling. toString method for converting to string and equals method used to check equivalency. Methods in the Bread and SandwichFilling classes should be used for Sandwich methods. 
4 (PackBakery): Add, remove, or get a sandwich from a menu list. For add, for loop is used to find the first null spot in the menu. For the remove and getter, for loop is used to find a match in the menu.

All of these classes will have equals and toString methods.

## Pack Bakery Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

We think our code addressed the requirements of this exercise very well.

How did you apply the pre-lab concepts in this exercise?

The concepts of how classes can use constructors and other class names/objects to interact with each other helped us in this exercise.

What are some new insights that you learned from this exercise?

A new insight we learned is how to create an private object instance of a certain class's type to be able to call that other class' methods.

Estimate how much time (minutes) you spent on this exercise.

We spent about 195 minutes on this exercise.
