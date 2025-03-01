import java.util.Stack;

/**
 * Assignment 4 - Stacks and Queues
 * Name: Amalia Karaman
 * Course: Intro to Algorithms
 * Converts an infix expression to postfix using a stack.
 * Follows operator precedence and outputs postfix notation.
 */

public class InfixToPostfix {
    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder(); // final expression
        Stack<Character> stack = new Stack<>(); // stack tht holds operators
        for (char ch : expression.toCharArray()) { // loop through each character
            if (Character.isLetterOrDigit(ch)) { // if operand adds to result
                result.append(ch);
            } else if (ch == '(') { // if opening bracket pushes to stack
                stack.push(ch);
            } else if (ch == ')') { // if closing bracket
                while (!stack.isEmpty() && stack.peek() != '(') { // pop until '('
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            } else { // if operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) { // pop higher precedence
                    result.append(stack.pop());
                }
                stack.push(ch); // push current operator
            }
        }
        while (!stack.isEmpty()) { // pop remaining operators
            result.append(stack.pop());
        }
        return result.toString(); // return final postfix expression
    }
    private static int precedence(char ch) { // defines precedences
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); // abcd^e-fgh*+^*+i-
    }
}
