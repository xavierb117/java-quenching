import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Practice {
    /**
     * Returns the sum of the odd numbers in the array.
     * 
     * Returns 0 if the array is null or has no odd numbers.
     * 
     * @param nums an array of numbers
     * @return the sum of the odd numbers in the array
     */
    public static int oddSum(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int sum = 0;

        for (int num:nums) {
            if (num % 2 == 1 || num % 2 == -1) {
                sum += num;
            }
        }

        return sum;
    }

    /**
     * Returns the shortest word in the Set.
     * 
     * If multiple words are tied for shortest, returns the one that is smallest
     * lexicographically.
     * 
     * @param words a set of words
     * @return the shortest word in the set with a lexicographic tiebreaker
     * @throws IllegalArgumentException if words is empty
     * @throws NullPointerException if words is null
     */
    public static String shortestWord(Set<String> words) {
        if (words == null) {
            throw new NullPointerException();
        }
        
        if (words.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int shortestCount = Integer.MAX_VALUE;
        String shortestWord = "";

        for (String word : words) {
            if (word.length() < shortestCount) {
                shortestCount = word.length();
                shortestWord = word;
            }
            else if (word.length() == shortestCount) {
                for (int i = 0; i < shortestCount; i++) {
                    char first = word.charAt(i);
                    char second = shortestWord.charAt(i);

                    if (first < second) {
                        shortestWord = word;
                        break;
                    }
                    else if (first > second) {
                        break;
                    }
                }
            }
        }

        return shortestWord;
    }

    /**
     * Returns a set of all the names of people that are 18 years of age or older.
     * 
     * The input maps name to age in years.
     * 
     * @param ages mapping of name to age
     * @return the set of all names of people >= 18 years old
     * @throws NullPointerException if ages is null
     */
    public static Set<String> adults(Map<String, Integer> ages) {
        if (ages == null) {
            throw new NullPointerException();
        }

        Set<String> adults = new HashSet<>();

        for (String name : ages.keySet()) {
            if (ages.get(name) >= 18) {
                adults.add(name);
            }
        }
        
        return adults;
    }

    /**
     * Returns the biggest number in a linked list.
     * 
     * @param head the head of the linked list
     * @return the biggest number in the list
     * @throws IllegalArgumentException if head is null
     */
    public static int biggestNumber(ListNode<Integer> head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        int biggestNum = Integer.MIN_VALUE;

        ListNode<Integer> curr = head;

        while (curr != null) {
            if (curr.data > biggestNum) {
                biggestNum = curr.data;
            }
            curr = curr.next;
        }

        return biggestNum;
    }

    /**
     * Returns a frequency map counting how frequently items appear in a linked list.
     * 
     * Example:
     *   Input: a -> x -> a -> a -> x -> y
     *   Output: {a:3, x:2, y: 1}
     * 
     * Returns an empty map if head is null
     * 
     * @param <T> the type of data held by the list
     * @param head the head of the list
     * @return a frequency map of values in the list
     */
    public static <T> Map<T, Integer> frequencies(ListNode<T> head) {
        Map<T, Integer> frequency = new HashMap<>();

        ListNode<T> curr = head;

        while (curr != null) {
            if (frequency.containsKey(curr.data)) {
                frequency.put(curr.data, frequency.get(curr.data) + 1);
            }
            else{
                frequency.put(curr.data, 1);
            }
            curr = curr.next;
        }

        return frequency;
    }


    /**
     * Returns the number of levels in the tree.
     * 
     * An empty tree has 0 levels, a tree with only a root has 1 level.
     * 
     * @param root the root of the tree
     * @return the number of levels in the tree
     */
    public static int levelCount(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        }

        int level = 0;

        ArrayList<BinaryTreeNode<?>> arr = new ArrayList<>(); 
        Queue<ArrayList<BinaryTreeNode<?>>> queue = new LinkedList<>();

        arr.add(root);
        queue.offer(arr);

        while(!queue.isEmpty()) {
            ArrayList<BinaryTreeNode<?>> curr = queue.poll();
            ArrayList<BinaryTreeNode<?>> next = new ArrayList<>();

            for (BinaryTreeNode<?> node : curr) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            if (!next.isEmpty()) {
                queue.offer(next);
            }
            level += 1;
        }

        return level;
    }


    /**
     * Returns the sum at a specified level in a binary tree.
     * 
     * For example, if the given level was 3:
     *       5
     *     /   \
     *    8     4
     *   / \   / 
     *  7  9  2
     *    /
     *   1
     * 
     * Nodes at level 3: 7, 9, and 2
     * Sum of nodes at level 3: 18 
     * 
     * The root is considered to be at level 1.
     * 
     * Returns 0 if the tree is empty or if the level is not present in the tree.
     * 
     * @param root the root of the binary tree
     * @param level the level to sum
     * @return the sum of the nodes at the given level
     */
    public static int sumAtLevel(BinaryTreeNode<Integer> root, int level) {
        return 0;
    }


    /**
     * Returns true if the sum of the values in a given tree is equal to the sum
     * of the values in the given list. 
     * 
     * An empty tree or list is considered to have a sum of 0.
     * 
     * @param root The root of the binary tree
     * @param head The head of the linked list
     * @return true if the sums are equal, false otherwise
     */
    public static boolean sumMatch(BinaryTreeNode<Integer> root, ListNode<Integer> head) {
        return false;
    }

    /**
     * Returns the sum of all the vertices in a graph that are reachable from a given
     * starting vertex.
     * 
     * Returns 0 if the starting vertex is null.
     * 
     * @param start the starting vertex
     * @return the sum of all the vertices
     */
    public static int graphSum(Vertex<Integer> start) {
        return 0;
    }

    /**
     * Returns the count of vertices in a graph that have an outdegree of 0.
     * 
     * Returns 0 if the starting vertex is null.
     * 
     * @param start the entrypoint to the graph
     * @return the count of vertices with outdegree 0
     */
    public static int sinkCount(Vertex<Integer> start) {
        return 0;
    }
}