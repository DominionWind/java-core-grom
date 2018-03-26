package Lesson4;

public class MethodExample {
    public static void main(String[] args) {
        int a = 10;
        int index = 5;
        int b = 11;
        System.out.println (increaser(a, index));

        //System.out.println (increaser((a, index), b));
    }

    public static int increaser(int a, int index){
        System.out.println("method invoked");
        a += index;
        System.out.println("method before return");
        return a;
    }

    //public static int min(int a, int b,){
        /*if (a < b)
            return a;
        else
            return b;*/
    //    return a < b ? a : b;
    //}
}
