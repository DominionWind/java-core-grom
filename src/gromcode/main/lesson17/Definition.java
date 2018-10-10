package gromcode.main.lesson17;

public class Definition {

    private void notifyUsers(String[] userEmails){

        for (String email:userEmails){

            try {
                System.out.println("Email " + email + " was sent");
            } catch (Exception e){

                // how should I handle exception
                System.out.println("Email " + email + " was not sent");
//            } catch (type2 e){
//
            }
            finally {
            }
        }
    }
}
