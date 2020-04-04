package LeetCode;

public class LeetCode984 {
    public String strWithout3a3b(int A, int B) {
        int ANumber = A;
        int BNumber = B;
        boolean turn2A = A > B ? true : false;
        StringBuilder sb = new StringBuilder();

        while (ANumber > 0 || BNumber > 0) {
            if (turn2A) {
                String tmp = (ANumber - BNumber >= 2 ? "aa" : "a");
                ANumber -= tmp.length();
                sb.append(tmp);
            } else {
                String tmp = (BNumber - ANumber >= 2 ? "bb" : "b");
                BNumber -= tmp.length();
                sb.append(tmp);
            }

            turn2A = !turn2A;
        }
        return sb.toString();
    }
}
