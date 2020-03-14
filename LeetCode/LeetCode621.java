package LeetCode;

import java.util.*;

public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        temp.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                    time++;
                    if (queue.isEmpty() && temp.size() == 0)
                        break;
                    i++;
                }
                for (int l : temp) {
                    queue.add(l);
                }
        }
        return time;
    }

    /**
     *  可以从任务执行时间和依据n，从空闲时间的角度思考。
     *  当最多任务及其须有的空闲时间用尽，则说明所有任务都饱满完成无需额外时间，则time为任务总数。
     *  否则，为任务总数加上剩余的空闲时间。
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int maxVal = map[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idleSlots -= Math.min(maxVal, map[i]);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
