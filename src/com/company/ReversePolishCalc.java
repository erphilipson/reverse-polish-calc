package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ethan on 7/20/17.
 */

public class ReversePolishCalc {
    
    private double stackTop = 0;

    // array of the input string split up
    private String[] tokens;

    List<String> stack = new ArrayList<>();

    public double calculate(String input) {

        // split the string into tokens at the commas
        tokens = input.split(",");

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

        // return result
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
