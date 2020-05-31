package Tool;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertTool {


    public static <T> ArrayList<T> String2Array(String s, Class clazz, ArrayList<T> array) throws DevException {
        String[] params = s.substring(1, s.length() - 1).split(",");
        Arrays.stream(params).forEach(param -> {
            if (clazz.equals(Integer.class)) {
                array.add((T) Integer.valueOf(Integer.parseInt(param)));
            } else if (clazz.equals(String.class)) {
                array.add((T)param);
            } else {
                //TODO JSON转对象
                return;
            }
        });
        if (params.length != 0 && params.length > array.size()) {
            throw new DevException();
        }
        return array;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String s = "[1,2,3]";
        try {
            String2Array(s, String.class, arrayList);
            System.out.println(arrayList);
        } catch (DevException e) {
            System.out.println(e.description);
        }

    }

    public static ListNode String2ListNode(String s) {
        String[] params = s.substring(1, s.length() - 1).split(",");
        ListNode head = new ListNode(Integer.parseInt(params[0]));
        ListNode tmp = head;
        for (int i = 1; i < params.length; ++i) {
            tmp.next = new ListNode(Integer.parseInt(params[i]));
            tmp = tmp.next;
        }
        return head;
    }
}
