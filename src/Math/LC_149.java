package Math;

import java.util.HashMap;
import java.util.Map;

public class LC_149 {

    // Max Points on a Line

    /*Given an array of points where points[i] = [xi, yi] represents a point 
    on the X-Y plane, return the maximum number of points that lie on the same straight line. */

    public static void main(String[] args) {
        LC_149 obj = new LC_149();
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(obj.maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicates = 1;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                if (dx == 0) dy = 1;
                if (dy == 0) dx = 1;

                String key = dx + "," + dy;
                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                localMax = Math.max(localMax, count);
            }

            answer = Math.max(answer, localMax + duplicates);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }
    
}
