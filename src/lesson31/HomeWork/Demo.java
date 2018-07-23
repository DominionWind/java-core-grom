package lesson31.HomeWork;

public class Demo {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String text = "10aaaaaaaaaa 9bbbbbbbbb 8 cccccccc 7 ddddddd 6 ffffff 5 rrrrr yzx yzx yzxyzx w";
        String test = "Тестируем вторую задачу в уроке номер тридцатьодин один один";

        System.out.println(solution.countSymbols(text));
        System.out.println(solution.words(test));
    }
}
