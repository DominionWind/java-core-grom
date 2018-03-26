package lesson8.HomeWorkAA;

public class Arithmetic {
    int getMax (int[]array){
        int max;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[n] < array[i]) {
                n = i;
            }
        }
        return max = array[n];
    }

    int getMin (int[]array){
        int min;
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[n] > array[i]) {
                n = i;
            }
        }
        return min = array[n];
    }

    boolean check(int[]array){
        if ((getMin(array) + getMax(array)) <= 100)
            return false;
        else
            return true;
    }
}
