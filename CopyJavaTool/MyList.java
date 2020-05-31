package CopyJavaTool;

import Tool.DevException;

public class MyList<T> {
    private final static int defaultLength = 10;

    private T[] values;
    private int index;

    public MyList() {
        values = (T[]) new Object[10];
        index = 0;
    }

    public void add(T value) throws Exception {
        if (index == values.length) {
            //TODO 生成新数组，复制原本数据后添加
            throw new DevException();
        } else {
            values[index] = value;
            index++;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("[");
        for (T value : values) {
            out.append(value + ", ");
        }
        out.delete(out.length() - 2, out.length());
        out.append("]");
        return out.toString();
    }
}
