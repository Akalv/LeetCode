package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1408 {
    public List<String> stringMatching(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word + ",");
        }
        String s = sb.toString();
        List<String> list = new ArrayList<>();
        for (String word : words) {
//            遍历数组查找字符串在S中出现的位置，如果是别人的子串，那么在S中的出现次数一定 >= 2，那么起始跟结束的位置索引一定是不一样的，如果一样说明不是子串
            if (s.indexOf(word) != s.lastIndexOf(word)) {
                list.add(word);
            }
        }
        return list;
    }
}
