package LeetCode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LeetCode705 {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
    }
}

class MyHashSet {
    int[] datas;

    /** Initialize your data structure here. */
    public MyHashSet() {
        datas = new int[1000001];
        Arrays.fill(datas, -1);
    }

    public void add(int key) {
        if (datas[key] != -1) {
            return;
        }
        datas[key] = 1;
    }

    public void remove(int key) {
        datas[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return datas[key] == 1;
    }
}

class BetterHashSet {
    private static final  int BASE = 769;   // 需要设计合适的哈希函数，这里用mod，选择质数可以尽可能避免冲突
    private LinkedList[] data;

    public BetterHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
