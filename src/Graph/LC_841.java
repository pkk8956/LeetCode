package Graph;

import java.util.List;

public class LC_841 {

    // LeetCode 841. Keys and Rooms

    /* You are given an array rooms where rooms[i] is a list of keys in room i.
    Initially, you are in room 0, and all the rooms are locked except for room 0.
    You can walk back and forth between rooms freely.
    Return true if you can enter every room, or false otherwise.*/

    public static void main(String[] args) {
        LC_841 obj = new LC_841();
        List<List<Integer>> rooms = List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of());
        boolean result = obj.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms: " + result); 
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) if (!v) return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) dfs(rooms, visited, key);
        }
    }
}
