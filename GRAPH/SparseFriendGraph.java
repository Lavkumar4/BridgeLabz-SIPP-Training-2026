/**
Graph Layout:
User (0) <---> User (1)
  ^               ^
  |               |
  v               v
User (2) <---> User (3)

Adjacency List + HashSet Structure:
Map Key    Set Values (Neighbors)
[ 0 ]  -->  { 1, 2 }
[ 1 ]  -->  { 0, 3 }
[ 2 ]  -->  { 0, 3 }
[ 3 ]  -->  { 1, 2 }
/**

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SparseFriendGraph {

    // Map each User ID to a Set of their Friend IDs
    private final Map<Integer, Set<Integer>> friendGraph;

    public SparseFriendGraph() {
        this.friendGraph = new HashMap<>();
    }

    // O(1) average time
    public void addFriendship(int u, int v) {
        // Friendships are bidirectional (undirected graph)
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    // O(1) average time
    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    // O(1) average time
    public int getFriendCount(int u) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).size();
    }
}