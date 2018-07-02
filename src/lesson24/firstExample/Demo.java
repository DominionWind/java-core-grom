package lesson24.firstExample;

public class Demo <T>{

//    private printUser(User user){
//
//    }

//    private printSolution(Solution solution){
//
//    }

//    private printChannel(Channel channel){
//
//    }\

    public void print(T t){
        System.out.println(t);
    }

    private static void calculatePrice(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());
    }

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());


    }



}
