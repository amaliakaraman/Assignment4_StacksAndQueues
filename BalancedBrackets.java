import java.util.LinkedList;

/**
 * Assignment 4 - Stacks and Queues
 * Name: Amalia Karaman
 * Course: Intro to Algorithms
 * Checks if a string of brackets is balanced using a stack.
 * Returns "YES" if balanced, otherwise "NO".
 */

public class BalancedBrackets {
    public static String isBalanced(String s) {
        LinkedList<Character> stack = new LinkedList<>(); // stack to store brackets
        for (char ch : s.toCharArray()) { // loop through each character
            if (ch == '(' || ch == '{' || ch == '[') { // if opening bracket push to stack
                stack.add(ch);
            } else { // if closing bracket
                if (stack.isEmpty()) return "NO"; // if stack is empty return no
                char last = stack.removeLast(); // get last added bracket
                if ((ch == ')' && last != '(') ||
                        (ch == '}' && last != '{') ||
                        (ch == ']' && last != '[')) { // check for valid match
                    return "NO"; // return no if mismatch
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO"; // if stack is empty, return yes, else no
    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));  // yes
        System.out.println(isBalanced("{[(])}"));  // no
        System.out.println(isBalanced("{{[[(())]]}}"));  // yes
    }
}
