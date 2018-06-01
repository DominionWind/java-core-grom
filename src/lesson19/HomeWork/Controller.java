package lesson19.HomeWork;

public class Controller {

    public File put(Storage storage, File file) throws Exception {
        String mesage = "Storage #ID " + storage.getId() + " is full. U have 2 to do some thing";
        if (storage == null || file == null) {
            return null;
        }

        if (checkFormat(storage, file))

            if (checkId(storage, file))

//                if (checkSize(storage, file))

                    for (int i = 0; i < storage.getFiles().length; i++) {
                        if (storage.getFiles()[i] == null) {
                            storage.getFiles()[i] = file;
                            return file;
                        }
                    }
        throw new Exception(mesage);
    }

    public Storage delete(Storage storage, File file) throws Exception {

        if (storage == null || file == null) {
            return null;
        }
        if (checkFormat(storage, file))

            if (checkId(storage, file))

//                if (checkSize(storage, file))

                    for (int i = 0; i < storage.getFiles().length; i++) {
                        if (storage.getFiles()[i].getId() == file.getId()) {
                            storage.getFiles()[i] = null;
                            break;
                        }

                    }
        return storage;
    }

    public Storage transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        if (storageFrom == null || storageTo == null) {
            return null;
        }
        if (storageFrom.getFiles().length > storageTo.getFiles().length) {
            throw new Exception("Storage #ID " + storageFrom.getId() + " leight more than Storage #ID" + storageTo.getId() + " .Can`t make transfer");
        }

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            storageTo.getFiles()[i] = storageFrom.getFiles()[i];
        }
        return storageTo;
    }

    public Storage transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        if (storageFrom == null || storageTo == null) {
            return null;
        }
        File transferFile = null;

        for (File f : storageFrom.getFiles()) {
            if (f.getId() == id) {
                transferFile = f;
                break;
            }
        }
        put(storageTo, transferFile);

        return storageTo;
    }

    private boolean checkFormat(Storage storage, File file) throws Exception {
        String mesage = "Storage ID# " + storage.getId() + "doesn`t support " + file.getName() + file.getFormat() + " format. Everybody Dies=(";

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported())) {
                return true;
            }
            throw new Exception(mesage);
        }
        return false;
    }

    private boolean checkId(Storage storage, File file) throws Exception {
        String mesage = "Fatal Error. File whith ID" + file.getId() + " already in Storage ID#" + storage.getId();
        for (int i = 0; i < storage.getFiles().length; i++) {
            for (File f : storage.getFiles()) {
                if (file.getId() == f.getId()) {
                    return false;
//                    throw new Exception(mesage);
                }
            }
        }
        return true;
    }

//    private boolean checkSize(Storage storage, File file) {
//        if (storage.getStorageSize() - storage.getFiles().length > 0) {
//            return true;
//        }
//        return false;
//    }
}
