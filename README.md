Scrambler
---
#### A CS1331 Interactive Polymorphism Example

Here's what I plan to do for my recitation. **I'd recommend looking at the Driver.java file as you read along with this, so that you can see what I'm talking about**

1. Give your students the premise of the problem: you want a program that allows you to scramble input in various ways, and prints it back out. Show them the `Scrambler` abstract class, containing the `scramble` method.
1. Run the program and walk them through the the two options it presents as input, `(c)hoose a scrambler` and `(e)nter text to scramble`
2. Show them the main method of the code in Driver.java, and give them a general overview of the different helper methods. Briefly walk them through the helper methods creating what they see in the terminal. Skip over the `showScramblerOutput` method for now.
3. Choose option `c`, and select `UppercaseScrambler`.
4. Then choose option `e`, and enter *"C3 recitation is the best!"* or whatever string you want.
5. Show them how the output now shows the `UppercaseScrambler` acting on the inputted string.
5. Choose option `c` again, and select `BackwardsScrambler`. Show how the output instantly changes from an uppercase string to a backwards string. **Stress the fact that you were able to do this without recompiling the program or changing the code!**
6. Go back to the main method in the Driver class, and work with them to figure out how this works. Suggest that you take a look at the `showScramblerOutput` method. 
7. Look at the `showScramblerOutput` method, namely the line containing `chosenScrambler.scramble(chosenText)`. Note that even though chosenScrambler was given the type `Scrambler`, which is abstract, we are still able to call the `scramble` method! How? Let's trace through main to find more code referencing the scramblers.
8. Trace the main method's code down to `chooseScrambler()` and look at that method next.
9. Find the subclass instantiations and show them how this is the part of the code that makes it all possible. Remind them that Scrambler is abstract, but a `BackwardsScrambler` is-a `Scrambler`, so we can say Scrambler `chosenScrambler = new BackwardsScrambler()`.
10. *(If you have more time / if the students seem comfortable with what you have so far.)* Mention that there is another Scrambler type that we didn't include in the list of options, and thus there's no way to get to it with the code given. Show how you can add a Scrambler[] array to the Driver class and let the user pick any scrambler out of the array to use instead, to reduce hardcoding.


Short demo:

![short demo](https://lh6.googleusercontent.com/ukLd70Oh63hHn6_Q2zZQ0CCQSEh6poYhQ0vRutj6upSyeKEtA7kv9xSq7LrphGWWYcmqlxg6EnLN05Y=w900-h433)
