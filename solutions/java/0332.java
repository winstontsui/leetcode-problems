/*
 * Leetcode 332: Reconstruct Itinerary. Java. Hard.
 * O(E log E) runtime and O(E) space complexity.
 * Uses Hierholzer’s algorithm to find an Eulerian path in a directed graph with lexical order.
 *
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],
 *                   ["ATL","JFK"],["ATL","SFO"]]
 *
 * Graph (lexical min priority queues):
 *   "JFK" -> ["ATL", "SFO"]
 *   "SFO" -> ["ATL"]
 *   "ATL" -> ["JFK", "SFO"]
 *
 * Start at "JFK"
 * - Remove "ATL" → dfs("ATL")
 * - Remove "JFK" → dfs("JFK")
 * - Remove "SFO" → dfs("SFO")
 * - Remove "ATL" → dfs("ATL")
 * - Remove "SFO" → dfs("SFO") → no more → add "SFO"
 * Backtrack: add "ATL", add "SFO", add "JFK", add "ATL", add "JFK"
 * Reverse: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 *
 * 4/17/2025 Winston Tsui
 */

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> flight : tickets) {
            graph.computeIfAbsent(flight.get(0), k -> new PriorityQueue<>()).add(flight.get(1));
        }

        dfs("JFK", graph, ans);
        return ans;
    }

    private void dfs(String curr, Map<String, PriorityQueue<String>> graph, LinkedList<String> ans) {
        PriorityQueue<String> nextFlights = graph.get(curr);
        while (nextFlights != null && !nextFlights.isEmpty()) {
            dfs(nextFlights.poll(), graph, ans);
        }
        ans.addFirst(curr); // Add airport after exploring all paths from it
    }
}
