package gromcode.main.lesson25;

public class GeneralDAO<T> {

    private T[] DB = (T[]) new Object[10];

    public T save(T t) throws Exception {

        if (t == null) {
            return null;
        }

        int freeSlotsCount = 0;
        for (T el : DB) {
            if (el == null) ;
            freeSlotsCount++;
        }

        if (freeSlotsCount <= 0) {
            throw new Exception("Not enough free slots in DB. Can`t save " + t);
        }

        for (int i = 0; i < DB.length; i++) {
            if (DB[i] == null) {
                DB[i] = t;
                return DB[i];
            }
        }
        return t;
    }

    public T getAll() {
        int count = 0;
        for (T el : DB) {
            if (el != null)
                count++;
        }

        T[] DataBase = (T[]) new Object[count];

        int i = 0;
        for (T el : DB) {
            if (el != null) {
                DataBase[i] = el;
                i++;
            }
        }
        return (T) DataBase;
    }


    private void print(Order order) {
        System.out.println("order is:" + order.toString());
    }

    public <T extends IdEntity> void validate(T t) throws Exception {
        if (t.getId() <= 0)
            throw new Exception("id can`t be negative");
    }

    public <K> void validate(K k) {

        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

