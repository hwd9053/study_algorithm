package 堆._面试题_17_14;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class _最小K个数 {
    // 大顶堆
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> maxHeap = new PriorityQueue<>((m1, m2) -> {return m2 - m1;});

        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }

    // 快排
    public int[] smallestK2(int[] arr, int k) {
        if (k == 0) return new int[0];
        int target = k - 1;
        int l = 0, r = arr.length - 1;

        while (true) {
            int index = partition(arr, l, r);
            if (index > target) {
                r = index - 1;
            } else if (index < target) {
                l = index + 1;
            } else {
                return Arrays.copyOf(arr, k);
            }
        }
    }

    private int partition(int[] arr, int l, int r) {
        int index = (int) (Math.random() * (r - l + 1) + l);
        int pivot = arr[index];
        swap(arr, l, index);

        while (l < r) {
            while (l < r) {
                if (arr[r] <= pivot) {
                    arr[l++] = arr[r];
                    break;
                } else {
                    r--;
                }
            }
            while (l < r) {
                if (arr[l] >= pivot) {
                    arr[r--] = arr[l];
                    break;
                } else {
                    l++;
                }
            }
        }

        arr[l] = pivot;

        return l;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
