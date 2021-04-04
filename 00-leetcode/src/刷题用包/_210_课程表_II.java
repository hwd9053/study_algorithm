package 刷题用包;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class _210_课程表_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] inDegree = new int[numCourses];
        // key:前继节点，value:前继节点对应的所有后继
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 建立入度表，以及建立每门必修课的后继课程的对应关系
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[numCourses];
        int idx = 0;

        // 入度为0的课程先入队
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 更新入度表，以及更新结果
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans[idx++] = course;
            List<Integer> succeedCourses = map.get(course);
            if (succeedCourses != null) {
                for (Integer succeedCourse : succeedCourses) {
                    if (--inDegree[succeedCourse] == 0) {
                        queue.offer(succeedCourse);
                    }
                }
            }
        }
        if (idx != numCourses) return new int[] {};

        return ans;
    }
}
