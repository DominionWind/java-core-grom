package lesson19.HomeWork;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File(long id, String name, String format, long size)  {
        if (name.length()>10){
            String mesage = "File lengths more then 10 symbols";
            throw new RuntimeException(mesage);
        }

        this.id = id;
        this.name = name;
        this.format = format;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }
}
