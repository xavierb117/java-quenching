import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

public class PracticeTest {

    // ===== oddSum ============================================================

    @Test
    void oddSum_mixedOddsEvensAndNegatives() {
        int[] nums = {17, -4, 0, 22, 13, -7, 8, 2, 11};
        // odds: 17 + 13 + (-7) + 11 = 34
        assertEquals(34, Practice.oddSum(nums));
    }

    @Test
    void oddSum_allEvens() {
        int[] nums = {12, 44, 100, 2, 8, 6};
        assertEquals(0, Practice.oddSum(nums));
    }

    @Test
    void oddSum_nullArrayReturnsZero() {
        int[] nums = null;
        assertEquals(0, Practice.oddSum(nums));
    }

    @Test
    void oddSum_onlyOneOdd() {
        int[] nums = {24, 50, 92, 7, 18};
        assertEquals(7, Practice.oddSum(nums));
    }

    // ===== shortestWord =====================================================

    @Test
    void shortestWord_basicShortest() {
        Set<String> words = new HashSet<>(Arrays.asList(
            "kumquat", "date", "fig", "grape", "cherry"
        ));
        assertEquals("fig", Practice.shortestWord(words));
    }

    @Test
    void shortestWord_lexicographicTiebreaker() {
        Set<String> words = new HashSet<>(Arrays.asList(
            "turnip", "as", "be", "to", "melon"
        ));
        // shortest length = 2 ; among {"as","be","to"} lexicographically smallest is "as"
        assertEquals("as", Practice.shortestWord(words));
    }

    @Test
    void shortestWord_allSameLength() {
        Set<String> words = new HashSet<>(Arrays.asList(
            "ape", "arc", "bat", "bay"
        ));
        // all length 3; smallest lexicographically is "ape"
        assertEquals("ape", Practice.shortestWord(words));
    }

    // ===== adults ============================================================

    @Test
    void adults_mixedAgesWithBoundaryIncluded() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Ana", 17);
        ages.put("Ben", 18);
        ages.put("Caz", 41);
        ages.put("Dee", 16);
        ages.put("Eli", 18);

        Set<String> result = Practice.adults(ages);
        Set<String> expected = new HashSet<>(Arrays.asList("Ben", "Caz", "Eli"));

        assertEquals(expected, result);
    }

    @Test
    void adults_emptyInputGivesEmptySet() {
        Map<String, Integer> ages = new HashMap<>();
        assertTrue(Practice.adults(ages).isEmpty());
    }

    @Test
    void adults_noAdultsAllUnder18() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Ira", 6);
        ages.put("Jay", 12);
        ages.put("Kai", 17);
        assertTrue(Practice.adults(ages).isEmpty());
    }

    // ===== biggestNumber =====================================================

    @Test
    void biggestNumber_mixedPosNegAndDuplicates() {
        /*
         * List:
         *   5 -> -11 -> 42 -> 7 -> 42 -> -3 -> 0
         */
        ListNode<Integer> head = new ListNode<>(5,
            new ListNode<>(-11,
                new ListNode<>(42,
                    new ListNode<>(7,
                        new ListNode<>(42,
                            new ListNode<>(-3,
                                new ListNode<>(0, null)))))));

        assertEquals(42, Practice.biggestNumber(head));
    }

    @Test
    void biggestNumber_singleNodeNegative() {
        /*
         * List:
         *   -8
         */
        ListNode<Integer> head = new ListNode<>(-8, null);
        assertEquals(-8, Practice.biggestNumber(head));
    }

    @Test
    void biggestNumber_allEqualValues() {
        /*
         * List:
         *   13 -> 13 -> 13
         */
        ListNode<Integer> head = new ListNode<>(13,
            new ListNode<>(13,
                new ListNode<>(13, null)));
        assertEquals(13, Practice.biggestNumber(head));
    }

    // ===== frequencies =======================================================

    @Test
    void frequencies_stringsExampleFromSpecPlusMore() {
        /*
         * List:
         *   a -> x -> a -> a -> x -> y -> z -> y
         * Expected: {a=3, x=2, y=2, z=1}
         */
        ListNode<String> head = new ListNode<>("a",
            new ListNode<>("x",
                new ListNode<>("a",
                    new ListNode<>("a",
                        new ListNode<>("x",
                            new ListNode<>("y",
                                new ListNode<>("z",
                                    new ListNode<>("y", null))))))));

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 3);
        expected.put("x", 2);
        expected.put("y", 2);
        expected.put("z", 1);

        assertEquals(expected, Practice.frequencies(head));
    }

    @Test
    void frequencies_integersArbitraryOrder() {
        /*
         * List:
         *   7 -> 9 -> 7 -> 7 -> 10 -> 9 -> 10 -> 7 -> 10 -> 10 -> 10
         * Expected: {7=4, 9=2, 10=5}
         */
        ListNode<Integer> head = new ListNode<>(7,
            new ListNode<>(9,
                new ListNode<>(7,
                    new ListNode<>(7,
                        new ListNode<>(10,
                            new ListNode<>(9,
                                new ListNode<>(10,
                                    new ListNode<>(7,
                                        new ListNode<>(10,
                                            new ListNode<>(10,
                                                new ListNode<>(10, null)))))))))));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(7, 4);
        expected.put(9, 2);
        expected.put(10, 5);

        assertEquals(expected, Practice.frequencies(head));
    }

    @Test
    void frequencies_nullHeadReturnsEmptyMap() {
        ListNode<String> head = null;
        assertTrue(Practice.frequencies(head).isEmpty());
    }

    // ===== levelCount ========================================================

    @Test
    void levelCount_nullRootIsZero() {
        BinaryTreeNode<Integer> root = null;
        assertEquals(0, Practice.levelCount(root));
    }

    @Test
    void levelCount_singleNodeIsOne() {
        /*
         *   42
         */
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(42);
        assertEquals(1, Practice.levelCount(root));
    }

    @Test
    void levelCount_balancedThreeLevels() {
        /*
         *        8
         *      /   \
         *     3     10
         *    / \      \
         *   1   6      14
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(8,
                new BinaryTreeNode<>(3,
                    new BinaryTreeNode<>(1),
                    new BinaryTreeNode<>(6)),
                new BinaryTreeNode<>(10,
                    null,
                    new BinaryTreeNode<>(14)));
        assertEquals(3, Practice.levelCount(root));
    }

    @Test
    void levelCount_unbalancedDeeperLeft() {
        /*
         *       5
         *      /
         *     4
         *    /
         *   3
         *    \
         *     2
         *    /
         *   1
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(4,
                    new BinaryTreeNode<>(3,
                        null,
                        new BinaryTreeNode<>(2,
                            new BinaryTreeNode<>(1),
                            null)),
                    null),
                null);
        assertEquals(5, Practice.levelCount(root));
    }

    // ===== sumAtLevel ========================================================

    @Test
    void sumAtLevel_exampleFromSpec_level3Is18() {
        /*
         *       5
         *     /   \
         *    8     4
         *   / \   /
         *  7  9  2
         *    /
         *   1
         * Level 3 nodes: 7, 9, 2 -> sum = 18
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(8,
                    new BinaryTreeNode<>(7),
                    new BinaryTreeNode<>(9,
                        new BinaryTreeNode<>(1),
                        null)),
                new BinaryTreeNode<>(4,
                    new BinaryTreeNode<>(2),
                    null));

        assertEquals(18, Practice.sumAtLevel(root, 3));
    }

    @Test
    void sumAtLevel_level1IsRootValue() {
        /*
         *    12
         *   /  \
         *  7    5
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(12,
                new BinaryTreeNode<>(7),
                new BinaryTreeNode<>(5));

        assertEquals(12, Practice.sumAtLevel(root, 1));
    }

    @Test
    void sumAtLevel_levelBeyondDepthIsZero() {
        /*
         *   9
         *    \
         *     2
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(9,
                null,
                new BinaryTreeNode<>(2));
        assertEquals(0, Practice.sumAtLevel(root, 5));
    }

    @Test
    void sumAtLevel_levelZeroIsNotPresentSoZero() {
        /*
         *   3
         */
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
        assertEquals(0, Practice.sumAtLevel(root, 0));
    }

    @Test
    void sumAtLevel_emptyTreeIsZero() {
        BinaryTreeNode<Integer> root = null;
        assertEquals(0, Practice.sumAtLevel(root, 2));
    }

    // ===== sumMatch ==========================================================

    @Test
    void sumMatch_equalSumsNonEmpty() {
        /*
         * Tree:
         *      6
         *     / \
         *    4   1
         *   / \
         *  -2  7
         * Tree sum = 6 + 4 + 1 + (-2) + 7 = 16
         *
         * List:
         *  10 -> 3 -> 3
         * List sum = 16
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(6,
                new BinaryTreeNode<>(4,
                    new BinaryTreeNode<>(-2),
                    new BinaryTreeNode<>(7)),
                new BinaryTreeNode<>(1));

        ListNode<Integer> head = new ListNode<>(10,
            new ListNode<>(3,
                new ListNode<>(3, null)));

        assertTrue(Practice.sumMatch(root, head));
    }

    @Test
    void sumMatch_notEqual() {
        /*
         * Tree:
         *    5
         *   / \
         *  2   2
         * Sum = 9
         *
         * List:
         *  4 -> 4
         * Sum = 8
         */
        BinaryTreeNode<Integer> root =
            new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(2),
                new BinaryTreeNode<>(2));

        ListNode<Integer> head = new ListNode<>(4,
            new ListNode<>(4, null));

        assertFalse(Practice.sumMatch(root, head));
    }

    @Test
    void sumMatch_bothEmptyAreZeroSoTrue() {
        BinaryTreeNode<Integer> root = null;
        ListNode<Integer> head = null;
        assertTrue(Practice.sumMatch(root, head));
    }

    @Test
    void sumMatch_emptyTreeNonEmptyListFalse() {
        BinaryTreeNode<Integer> root = null;
        /*
         * List:
         *   1 -> 2
         */
        ListNode<Integer> head = new ListNode<>(1, new ListNode<>(2, null));
        assertFalse(Practice.sumMatch(root, head));
    }

    // ===== graphSum & sinkCount (directed; neighbors = outgoing) =============

    @Test
    void graphSum_cyclicComponentPlusDetachedVertex() {
        /*
         * Vertices (values):
         *   v1(5), v2(7), v3(-2), v4(10), v5(1), v6(3)
         *
         * Edges (directed), includes cycles:
         *   v1 -> v2, v3
         *   v2 -> v4
         *   v3 -> v2, v5
         *   v4 -> v1           // cycle v1 -> v2 -> v4 -> v1
         *   v5 -> v3           // cycle v3 <-> v5
         *   v6 -> (none)       // detached sink (not reachable from v1)
         *
         * From v1, reachable: {v1,v2,v3,v4,v5}
         * Sum = 5 + 7 + (-2) + 10 + 1 = 21
         */
        Vertex<Integer> v1 = new Vertex<>(5);
        Vertex<Integer> v2 = new Vertex<>(7);
        Vertex<Integer> v3 = new Vertex<>(-2);
        Vertex<Integer> v4 = new Vertex<>(10);
        Vertex<Integer> v5 = new Vertex<>(1);
        Vertex<Integer> v6 = new Vertex<>(3);

        v1.neighbors.add(v2);
        v1.neighbors.add(v3);

        v2.neighbors.add(v4);

        v3.neighbors.add(v2);
        v3.neighbors.add(v5);

        v4.neighbors.add(v1);

        v5.neighbors.add(v3);

        // v6 has no neighbors

        assertEquals(21, Practice.graphSum(v1));
        assertEquals(3, Practice.graphSum(v6));  // only itself
        assertEquals(0, Practice.graphSum(null));
    }

    @Test
    void sinkCount_cyclicComponentWithOneReachableSinkAndOneUnreachableSink() {
        /*
         * Values:
         *   a(10), b(4), c(7), d(2), e(9), f(4)
         *
         * Edges (directed):
         *   a -> b, c
         *   b -> d
         *   c -> b, e
         *   d -> a              // cycle a -> b -> d -> a
         *   e -> c              // cycle c <-> e
         *   f -> (none)         // unreachable sink from a
         *
         * Also add a reachable sink g(5):
         *   g -> (none)
         *   and connect c -> g
         *
         * From a, sinks reachable: only g
         * So sinkCount(a) = 1
         * From f, sinks reachable: f itself, so sinkCount(f) = 1
         */
        Vertex<Integer> a = new Vertex<>(10);
        Vertex<Integer> b = new Vertex<>(4);
        Vertex<Integer> c = new Vertex<>(7);
        Vertex<Integer> d = new Vertex<>(2);
        Vertex<Integer> e = new Vertex<>(9);
        Vertex<Integer> f = new Vertex<>(4);
        Vertex<Integer> g = new Vertex<>(5);

        a.neighbors.add(b);
        a.neighbors.add(c);

        b.neighbors.add(d);

        c.neighbors.add(b);
        c.neighbors.add(e);

        d.neighbors.add(a);

        e.neighbors.add(c);

        // f -> (none)
        // g -> (none)
        c.neighbors.add(g); // make g reachable from a via c

        assertEquals(1, Practice.sinkCount(a)); // only g is sink and reachable
        assertEquals(1, Practice.sinkCount(f)); // f is a sink by itself
    }

    @Test
    void sinkCount_cyclicNoSinksReachable() {
        /*
         * Values:
         *   x(1), y(2), z(3)
         * Edges:
         *   x -> y
         *   y -> z
         *   z -> x   // 3-cycle, all outdegree > 0
         * From x, there are no reachable sinks.
         */
        Vertex<Integer> x = new Vertex<>(1);
        Vertex<Integer> y = new Vertex<>(2);
        Vertex<Integer> z = new Vertex<>(3);

        x.neighbors.add(y);
        y.neighbors.add(z);
        z.neighbors.add(x);

        assertEquals(0, Practice.sinkCount(x));
    }

    @Test
    void sinkCount_twoReachableSinksDifferentBranches() {
        /*
         * Values:
         *   s(8), t(6), u(5), v(7), w(3)
         * Edges:
         *   s -> t, u
         *   t -> v
         *   u -> (none)     // sink #1
         *   v -> (none)     // sink #2
         *   w -> (none)     // unreachable sink from s
         *
         * From s, reachable sinks: u, v  => 2
         */
        Vertex<Integer> s = new Vertex<>(8);
        Vertex<Integer> t = new Vertex<>(6);
        Vertex<Integer> u = new Vertex<>(5);
        Vertex<Integer> v = new Vertex<>(7);
        Vertex<Integer> w = new Vertex<>(3);

        s.neighbors.add(t);
        s.neighbors.add(u);
        t.neighbors.add(v);
        // u -> none
        // v -> none
        // w -> none (unreachable)

        assertEquals(2, Practice.sinkCount(s));
    }
}
