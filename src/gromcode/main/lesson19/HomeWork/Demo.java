package gromcode.main.lesson19.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        Controller controller = new Controller();

        File file1 = new File(123, "LongLong", "txt", 32167);
        File file2 = new File(234, "somePDF", "pdf", 258);
        File file3 = new File(2342, "somePNG", "png", 888);
        File file4 = new File(456, "someEXE", "exe", 456);
        File file5 = new File(567, "someTXT", "txt", 231);

        File file6 = new File(7777, "someTXT", "txt", 231);
        File file7 = new File(2346, "someTXT", "txt", 231);
        File file8 = new File(2345, "someTXT", "txt", 231);

        File[] array1 = {file1, file2, file3, file4, file5, null, null};
        File[] array2 = {file6, file7, file8, null, null, null, null};

        Storage storage1 = new Storage(1111, array1, new String[]{"txt", "pdf", "png", "exe"}, "Ukraine", 999999);
        Storage storage2 = new Storage(2222,array2,new String[]{"txt", "pdf", "png", "exe"},"Ukraine",326598742);

        System.out.println(storage1.toString());
        System.out.println("================");
        System.out.println(storage2.toString());
        System.out.println("================");
        controller.transferAll(storage1,storage2);
        System.out.println(storage2.toString());
//        controller.put(storage1,file6);
//        System.out.println(controller.put(storage1,file6));
//        System.out.println(Arrays.(controller.put(storage1,file7)));
//        System.out.println(storage1.toString());
//        controller.delete(storage1, file1);
//        System.out.println(storage1.toString());
//        System.out.println(file7);


    }
}