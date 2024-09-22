
/*
 * Dan Le - COMP 272 001
 *
 * Homework # 1 (Programming Assignment). This Java class defines some basic
 * manipulation operations on Linked-Lists and Stacks.
 *
 * Additionally, there are two algorithm analysis methods where you need
 * to return a specified number as provided in comments of each method indicating
 * the complexity of the code shown. The testing routine will be looking for a
 * specific number returned.
 */

import java.util.Stack;

public class HW1 {

    /*
     * Class LinkedList
     *
     * This class builds a singly linked list. Each node of the linked-list
     * contains a single integer values.
     *
     * Methods:
     *  - void   sortInserted(val)     - Inserts value 'val' into the linked-list in
     *                                   sorted fashion
     *  - void   removeElementsLT(val) - Removed values in the linked-list that are less
     *                                   than 'val'
     *  - void   removeElement(val)    - Removes all values in the linked list of
     *                                   value 'val'
     *  - String toString()            - coverts and returns the linked-lists as a string
     *                                   delimited by brackets []
     *
     */

    static class LinkedList {
        static class Node {
            int data;
            Node next;

            Node(int d)       // Constructor
            {
                data = d;
                next = null;
            }
        }
        Node head;            // head of Linked-list

        /*
         * Method sortedInsert() - this method will insert a new node to the
         * linked list containing the value specific in the parameter 'data'.
         * The newly inserted node will be inserted in sorted order within
         * the linked-list.
         *
         */
        public void sortedInsert ( int data )
        {
            Node new_node = new Node(data);

            new_node.next = null;

            // Special case for head node.
            if (this.head == null || head.data >= new_node.data ) {
                new_node.next = head;
                head = new_node;
            } else {
                // locate the node before the point of insertion
                Node current = this.head;

                // Identify where to place the item to insert
                while (current.next != null && current.next.data < data) {
                    current = current.next;
                }
                new_node.next = current.next;
                current.next = new_node;
            }

            return;
        }

        /*
         * Method removeElementsLT() - the method removes all nodes that contain a
         * value that is less than the provided parameter 'ltValue'.
         *
         * The method will invoke the method removeElements for each element
         * found in the linked-list that is less than thr parameter value passed.
         */
        public void removeElementsLT ( int ltValue ){

            // YOUR CODE GOES HERE; THIS METHOD SHOULD CALL 'removeElement()'

            /*
            There are a couple ways of doing this, because the list is sorted, the easiest seems to be

            while (this.head != null && this.head.data < ltValue) {

                this.head = this.head.next;

            }

            Another way is to simply make the first node with a value more than ltValue be the head node, making it null
            if all values are under ltValue.

            A way of doing this by calling removeElement is similar to the last way described, but we can move the current
            node to the head after the previous head is removed.
             */

            Node currentNode = head;

            while (currentNode != null && currentNode.data < ltValue) {

                removeElement(currentNode.data);
                currentNode = head;

            }


            return;
        }

        /*
         * Method removeElement() - the method removes all nodes that contain a
         * value equal to the value the provided parameter 'value'.
         */
        public void removeElement ( int value ){

            // YOUR CODE GOES HERE

            /*
            To remove an element that has "value":, we iterate through the list, checking the data of the next node.
            Everytime the next node has the specified value we want to remove, we simply point the current node to the node
            following the next node. We repeat this until we traverse the list.
            This process naturally allows for empty lists to be passed through.
            In this method, we must consider the special case where the head has the specified value. In this scenario,
            we can simply move the head to the next value until the head does not have the specified value.
             */

            // Special case where the head is the specified value
            while (this.head != null && this.head.data == value) {

                this.head = head.next;

            }

            Node currentNode = head;

            while (currentNode != null && currentNode.next != null) {

                if (currentNode.next.data == value) {

                    currentNode.next = currentNode.next.next;

                } else {

                    currentNode = currentNode.next;

                }

            }

            return;
        }

        /*
         * Method toString() - this is a helper method for printing / constructing
         * a string object from the linked-list.
         */
        public String toString () // Method to output the LinkedList as a String
        {
            String output = "[";
            Node currNode = this.head;
            while (currNode != null) {
                output += currNode.data + " ";
                currNode = currNode.next;
            }
            return output.trim() + "]";
        }

    } // End class LinkedList




    /*
     * Class Stacks
     *
     * This class utilizes the Java Common Framework Library Stack class.
     *
     * The intent of this class is to write methods which utilize the Java
     * library's Stack class. You need to utilize this library class in
     * your solution.
     *
     * Methods:
     *  - boolean isPalindrome(string)   - method returns true or false if 'string'
     *                                     is a palindrome
     *  - int     findlargestK(stack, k) - method accepts a stack and returns
     *                                     the largest index in the stack containing
     *                                     value 'k' (stack index starts at 0)
     *
     */

    static class Stacks {

        /*
         * Method isPalindrome() - This method will return the boolean value 'true'
         * or 'false' on if the passed in parameter string is a palindrome or not.
         *
         * The routine should be case insensitive! Meaning 'RaCe cAr' is a palindrome.
         * Moreover, spaces are ignore, so both 'race car' and 'racecar' are plaindromes.
         *
         * The method should utilize the provided Stack class.
         */
        public static boolean isPalindrome(String input) {

            /*
            This method functions by taking in the string "input" and creating a new string from it, where each letter
            is converted to lowercase and all its whitespace removed.
            We can then add this string to stack by character, and test for a palindrome using a stack's
            first-in, last-out nature.
             */

            Stack<Character> stack = new Stack<>();
            input = input.toLowerCase().replaceAll("\\s+", "");


            for (int i = 0; i < input.length(); i++) {

                stack.add(input.charAt(i));

            }

            for (int i = 0; i < input.length(); i++) {

                if (stack.peek() != input.charAt(i)) {
                    return false;
                } else {
                    stack.pop();
                }

            }

            return true;
        }


        /*
         * Method findLargestk() - This method will return the largest index
         * position in the stack for the value specified by the parameter 'k'.
         *
         * Note that the bottom of the stack is index location 0. So if you push
         * on to the stack the values 3 4 9 4 4 7 4, in that order. And you pass the
         * value '4' for the parameter k, then the largest index position is index
         * location 6.
         *
         * The method should utilize the provided Stack class. This method should NOT
         * destroy the passed in stack, meaning when the method returns, the passed in
         * stack should be identical to when this method is passed. One trick as you
         * pop elements off the passed in stack, place them in a temp stack. Then when
         * completed, place them all back in teh original stack.
         */
        public static int findLargestK(Stack<Integer> stack, int k) {

            /*
            We can find the largest index (closest to the top) where k is by transferring the stack to a temporary stack.
            With this, we can keep a counter while we return the elements to the original stack, incrementing it each
            element. We can change the largest index to the tempIndex whenever we see the value k.
             */

            int largestIndex = -1;      // initially set to -1 indicating not in stack
            int tempIndex = 0;
            Stack<Integer> tempStack = new Stack<>();

            // YOUR CODE GOES HERE

            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }

            while (!tempStack.isEmpty()) {
                if (tempStack.peek() == k) {
                    largestIndex = tempIndex;
                }
                tempIndex++;
                stack.push(tempStack.pop());
            }

            return largestIndex;
        }

    }  // End class Stacks


    /*******************************
     *
     * Algorithm Analysis
     *
     * Below are two methods, algorithmAnalysis1 and algorithmAnalysis2.
     * Modify the return statement to return the correct option number.
     *
     *********************************/

    public static int algorithmAnalysis1(int n, int m) {
        int a = 0, b = 0;

        for (int i=0; i < n; i++)
            a+= Math.random();

        for (int j=0; j < m; j++)
            b+= Math.random();

        /*
         * Select the correct option listed below:
         *   1. O(N * M) time, O(1) space
         *   2. O(N + M) time, O(N + M) space
         *   3. O(N + M) time, O(1) space - 2 non-nested loops. 2 integer values.
         *   4. O(N * M) time, O(N + M) space
         *
        */

        return 3;
    }


    public static int algorithmAnalysis2(int n) {
        int i, j, k = 0;
        for (i = n/2; i <= n; i++)
            for ( j = 2; j <= n; j = j*2 )
                k+= n/2;

        /*
         * Select the correct option listed below:
         *   1. O(N) time
         *   2. O(N log N) time - Outer loop magnitude of 1, inner loop magnitude of log(n), nested together
         *   3. O(N^2) time
         *   4. O(N^2Log n) time
         *
         */

        return 2;
    }

}