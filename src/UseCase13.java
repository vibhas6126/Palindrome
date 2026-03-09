// UC13: Performance Comparison of Palindrome Algorithms

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13 {

    // Method 1: Two Pointer Technique
    public static boolean twoPointerCheck(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Method
    public static boolean stackCheck(String word) {

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Method 3: Deque Method
    public static boolean dequeCheck(String word) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String word = "racecar";

        // Two Pointer Timing
        long startTime = System.nanoTime();
        boolean result1 = twoPointerCheck(word);
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Stack Timing
        startTime = System.nanoTime();
        boolean result2 = stackCheck(word);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Deque Timing
        startTime = System.nanoTime();
        boolean result3 = dequeCheck(word);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("Palindrome Results:");
        System.out.println("Two Pointer: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Stack: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Deque: " + result3 + " | Time: " + time3 + " ns");
    }
}