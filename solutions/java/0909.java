/*
 * Leetcode 909: Snakes and Ladders. Java. Medium.
 * O(n^2) runtime and O(n^2) space complexity.
 * Nasty Problem. Use BFS to find the shortest path to board[0][0], using a HashSet to track visited squares. 
 * 5/28/2024 Winston Tsui
*/

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

class Solution {
    public int snakesAndLadders(int[][] board) {

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(1);
        HashSet<Integer> visited = new HashSet<Integer>();
        int numMoves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            numMoves++;

            while (size > 0) {
                int currSquare = queue.remove();
                for (int i = 1; i < 7; i++) {
                    int newSquare = currSquare + i;

                    int[] newCords = convertToCords(newSquare, board.length);
                    if (board[newCords[0]][newCords[1]] != -1)
                        newSquare = board[newCords[0]][newCords[1]];
                    if (newSquare == board.length * board.length)
                        return numMoves;
                    if (!visited.contains(newSquare)) {
                        visited.add(newSquare);
                        queue.add(newSquare);
                    }
                }
                size--;
            }

        }
        return -1;
    }

    private int[] convertToCords(int square, int boardlen) {
        int row = boardlen - 1 - (square - 1) / boardlen;
        int column = (square - 1) % boardlen;

        // For column positions, this handles rows with desending squares.
        if ((boardlen - 1 - row) % 2 == 1)
            column = boardlen - 1 - column;
        return new int[] { row, column };
    }

}
