/*
 * *** Dan Le - Section 1 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

    /**
    * Method different()
    *
    * Given two TreeSets of integers, return a TreeSet containing all elements 
    * that are NOT in both sets. In other words, return a TreeSet of all the
    * elements that are in one set but not the other.
    */

    /*
     * We can think of this problem as a Set Theory problem with the sets A and B.
     * If we want the elements that are in one set, but not the other, we can find through the formula
     * ( (A union B) set difference (A intersection B) )
     * We can use addAll() for union, retainAll() for intersection, and removeAll() for set difference.
     */

    public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

        Set<Integer> aUnionB = new TreeSet<>(setA);
        aUnionB.addAll(setB); // Set of elements in setA and in setB
        Set<Integer> aIntersectionB = new TreeSet<>(setA);
        aIntersectionB.retainAll(setB); // Set of elements in both setA and setB
        
        // Creating another TreeSet for clarity purposes. We could use aUnionB here as well.
        Set<Integer> setDifference = new TreeSet<>(aUnionB);
        setDifference.removeAll(aIntersectionB); // Set of elements in setA and setB, but not in both

        return setDifference;
    
    }


    /**
    * Method removeEven()
    *
    * Given a treeMap with the key as an integer, and the value as a String,
    * remove all <key, value> pairs where the key is even. 
    */

    public static void removeEven(Map<Integer, String> treeMap) {

        Set<Integer> keys = treeMap.keySet(); // Keep in mind that this is a Set of POINTERS to the keys inside of treeMap

        Iterator<Integer> i = keys.iterator();

        while (i.hasNext()) {

            Integer key = i.next();

            if (key % 2 == 0) {

                i.remove(); // If the key is even, the iterator will remove it from the variable keys, which in turn will remove it from the treeMap due to pointers.

            }

        }

        return;

    }


    /**
    * Method treesEqual()
    *
    * Given two treeMaps, each with the key as an integer, and the value as a String,
    * return a boolean value indicating if the two trees are equal or not.
    */

    /*
     * Simple use of the Map interface, which inherits the .equals() method from java.lang.Object
     */

    public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {

        return tree1.equals(tree2);

    }

 } // end treeProblems class
