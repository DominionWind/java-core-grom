package gromcode.main.lesson4;

public class HomeWork1 {
    public static void main(String[] args) {
        //System.out.println(sum(1,11));
        //System.out.println(sum(1,12));
        System.out.println(compareSums(0,15,1,12));
    }

    public static boolean compareSums (int a, int b, int c, int d){
        boolean res;
        return res = sum(a, b) > sum(c, d);
    }

    public static long sum(int from, int to){

        return (long) (to * (to + 1) / 2 - from * (from + 1) / 2 + from);
    }
}
