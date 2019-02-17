# String Calculator
The following is a TDD Kata- an exercise in coding, refactoring and test-first, that you should apply daily for at least 15 minutes (I do 30).

Before you start: 
* Try not to read ahead.
* Do one task at a time. The trick is to learn to work incrementally.
* Make sure you only test for correct inputs. there is no need to test for invalid inputs for this kata

## String Calculator

1. Create a simple String calculator with a method int Add(string numbers)
    1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
    1. Start with the simplest test case of an empty string and move to 1 and two numbers
    1.  Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
    1. Remember to refactor after each passing test
1. Allow the Add method to handle an unknown amount of numbers
1. Allow the Add method to handle new lines between numbers (instead of commas).
    1. the following input is ok:  “1\n2,3”  (will equal 6)
    1. the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
1. Support different delimiters
    1. to change a delimiter, the beginning of the string will contain a separate line that looks like this:   “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
    1. the first line is optional. all existing scenarios should still be supported
1.  Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message
1. stop here if you are a beginner. Continue if you can finish the steps so far in less than 30 minutes. 
1. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
1. Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
1.  Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
1. make sure you can also handle multiple delimiters with length longer than one char