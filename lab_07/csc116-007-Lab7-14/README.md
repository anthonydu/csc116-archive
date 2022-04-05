# CSC116: Lab 07 Journal - Unit and Integration Testing

Names: Anthony Du, Shuhao Liu

## Secret Message Bugs

    From
    swapSubstrings(message);
    moveCharacter(message);
    swapCharacter(message ;
    To
    message = swapSubstrings(message);
    message = moveCharacter(message);
    message = swapCharacter(message);

    From
    char last = message.charAt(length);
    To
    char last = message.charAt(length - 1);

    From
    message.substring(indexOfSecond, indexOfNextToLast)
    To
    message.substring(indexOfSecond + 1, indexOfNextToLast)

    From
    return message.substring(length - 2) + message.substring(length - 1)
    To
    return message.substring(0, length - 2) + message.charAt(length - 1)        

    From
    return message.substring(mid) + message.charAt(mid) + message.substring(0, mid);
    To
    return message.substring(mid + 1) + message.charAt(mid) + message.substring(0, mid);

    From
    message = swapCharacter(message);
    message = swapSubstrings(message);
    To
    message = moveCharacter(message);
    message = swapSubstrings(message);

## Secret Message Reflection (***After*** writing code)

How well did your code address the requirements of this exercise?

Perfectly. We used all 18 tests that we wrote and fixed all the bug in SecretMessage.java.

How did you apply the pre-lab concepts in this exercise?

The ways to use org.junit.jupiter.api as a testing and debugging tool in actual programs.

What are some new insights that you learned from this exercise?

Read the instruction carefully because we may omit some important details, which lead us make mistake.

We can find every mistake we made in SecretMessage.java through test. Therefore, we know how to fix them.

Estimate how much time (minutes) you spent on this exercise.

Around 2 hours
