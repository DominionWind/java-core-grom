package gromcode.main.lesson19.HomeWork;

public class Controller {

    public File put(Storage storage, File file) throws Exception {
        String mesage = "Storage #ID " + storage.getId() + " is full. U have 2 to do some thing";
        if (storage == null || file == null) {
            return null;
        }

        if (checkFormat(storage, file))

            if (checkId(storage, file))

                for (int i = 0; i < storage.getFiles().length; i++) {

                    if (storage.getFiles()[i] == null) {
                        storage.getFiles()[i] = file;
                        break;
                    }
                }
        return file;
    }

    public File delete(Storage storage, File file) throws Exception {

        if (storage == null || file == null) {
            return null;
        }

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].getId() == file.getId()) {
                storage.getFiles()[i] = null;
                break;
            }
        }
        return file;
    }

    public Storage transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        if (storageFrom == null || storageTo == null) {
            return null;
        }
        if (storageFrom.getFiles().length > storageTo.getFiles().length) {
            throw new Exception("Storage #ID " + storageFrom.getId() + " leight more than Storage #ID" + storageTo.getId() + " .Can`t make transfer");
        }

        checkFreeStots(storageFrom, storageTo);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            put(storageTo,storageFrom.getFiles()[i]);
        }
        return storageTo;
    }

    public Storage transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
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
        String mesage = "Storage ID# " + storage.getId() + "doesn`t support " + file.getName() + " " + file.getFormat() + " format. Everybody Dies=(";

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkId(Storage storage, File file) throws Exception {
        String mesage = "Fatal Error. File whith ID" + file.getId() + " already in Storage ID#" + storage.getId();
        if (file == null || storage.getFiles() == null) {
            return false;
        }

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && file.getId() == storage.getFiles()[i].getId()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFreeStots(Storage storageFrom, Storage storageTo) throws Exception {
        int count = 0;
        int c = 0;

        for (File f : storageFrom.getFiles()) {
            if (f == null)
                count++;
        }

        for (File f : storageTo.getFiles()) {
            if (f == null)
                c++;
        }

        if ((storageFrom.getFiles().length - count) >= c) {
            return true;
//        }else {
//            throw new Exception("not enaught free file slot in stotage for transfer");
        }
        return false;
    }

//    private boolean checkSize(Storage storage, File file) {
//        if (storage.getStorageSize() - storage.getFiles().length > 0) {
//            return true;
//        }
//        return false;
//    }
}
