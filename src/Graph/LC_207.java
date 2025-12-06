package Graph;

import java.util.ArrayList;
import java.util.List;

public class LC_207 {

    //Course Schedule

    /*There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
    prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.*/

    public static void main(String[] args) {
        LC_207 obj = new LC_207();  
        int[][] prerequisites = {{1,0},{0,1}};
            
        System.out.println(obj.canFinish(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited) {
        if (visited[node] == 1) return false;
        if (visited[node] == 2) return true;  

        visited[node] = 1;

        for (int next : graph.get(node)) {
            if (!dfs(next, graph, visited)) return false;
        }
        visited[node] = 2; 
        return true;
    }
}
