import CopyJavaTool.MyList;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        MyList<Integer> myList = new MyList<>();
        for (int i = 0; i < 10; i++) {
            try {
                myList.add(i);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        MyList<String> myList1 = new MyList<>();
        for (int i = 0; i < 10; i++) {
            try {
                myList1.add("第" + i + "个");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(myList);
        System.out.println(myList1);
    }
}
