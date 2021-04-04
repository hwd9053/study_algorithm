package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class _207_课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int predecessor = queue.poll();
            idx++;
            List<Integer> successors = map.get(predecessor);
            if (successors != null) {
                for (Integer successor : successors) {
                    if (--inDegree[successor] == 0) {
                        queue.offer(successor);
                    }
                }
            }
        }
        return idx == numCourses;
    }
}
