import java.util.Stack;

/**
 * Assignment 4 - Stacks and Queues
 * Name: Amalia Karaman
 * Course: Intro to Algorithms
 * Decodes a string with k[encoded_string] format using stacks.
 * Expands nested structures and returns the decoded string.
 */

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // stack for repeat counts
        Stack<StringBuilder> stringStack = new Stack<>(); // stack for substrings
        StringBuilder currentString = new StringBuilder(); // current operating string
        int k = 0; // repeat count
        for (char ch : s.toCharArray()) { // loop through each character
            if (Character.isDigit(ch)) { // if digit, update k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') { // if opening bracket
                countStack.push(k); // push k to stack
                stringStack.push(currentString); // push current string to stack
                currentString = new StringBuilder(); // reset current string
                k = 0; // reset k
            } else if (ch == ']') { // if closing bracket
                StringBuilder decoded = stringStack.pop(); // get last string
                int repeatTimes = countStack.pop(); // get repeat count
                decoded.append(String.valueOf(currentString).repeat(repeatTimes)); // repeat and append
                currentString = decoded; // update current string
            } else { //
                currentString.append(ch); // add to current string
            }
        }
        return currentString.toString(); // return final string
    }
    public static void main(String[] args) {
        System.out.println("Decoded output for '3[a]2[bc]': " + decodeString("3[a]2[bc]"));  // aaabcbc
        System.out.println("Decoded output for '3[a2[c]]': " + decodeString("3[a2[c]]"));   // accaccacc
        System.out.println("Decoded output for '2[abc]3[cd]ef': " + decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }
}
