package lesson19.HomeWork;

public class Controller {

    public void put(Storage storage, File file) {

    }

    public void delete(Storage storage, File file) {

    }

    public void transferAll(Storage storageFrom, Storage storageTo) {

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {

    }

    private boolean checkFormat(Storage storage, File file) throws Exception {
        String mesage = "Storage ID# " + storage.getId() + "doesn`t support " + file.getName() + file.getFormat() + " format. Everybody Dies=(";

        for (int i=0; i<storage.getFormatsSupported().length; i++){
            if (file.getFormat().equals(storage.getFormatsSupported())) {
                return true;
            }
            throw new Exception(mesage);
        }
        return false;

    }
}
