package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethan on 7/20/17.
 */

public class ReversePolishCalc {

    // You'll need a variable here to keep track of the top of the stack
    private double stackTop = 0;

    // The array of the input string split up
    private String[] tokens;

    // The stack
    List<String> stack = new ArrayList<>();

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
//        stack = new String[tokens.length];

        // 3. write the algorithm
        String operators = "+-*/";
        for (String token : tokens) {
            // calls to push() and pop() and do the math here
            if (!operators.contains(token)) {
                push((token));
                System.out.println(stack);
            } else if (token.equals("+")) {
                push((pop() + pop()));
            } else if (token.equals("-")) {
                push((-pop() + pop()));
            } else if (token.equals("*")) {
                push((pop() * pop()));
            } else if (token.equals("/")) {
                push((1/pop() * pop()));
            }

        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        // push on the stack
            stack.add(0, number);
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        String numString = Double.toString(d);
        push(numString);

    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        stackTop = Double.parseDouble(stack.get(0));
        stack.remove(0);
        return stackTop;
    }
}
