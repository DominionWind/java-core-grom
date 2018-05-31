package lesson19.HomeWork;

import lesson9.HomeWork.User;

public class Controller {

    public void put(Storage storage, File file) {

    }

    public void delete(Storage storage, File file) {

    }

    public void transferAll(Storage storageFrom, Storage storageTo) {

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {

    }

//    public User save(User user) {
//        if (findById(user.getId()) == null)
//            for (int i = 0; i < users.length; i++)
//                if (users[i] == null) {
//                    users[i] = user;
//                    return user;
//                }
//        return null;
//    }
//
//    public User update(User user) {
//        if (user != null)
//            return null;
//        for (int i = 0; i < users.length; i++) {
//            if (users[i].equals(findById(user.getId()))){
//                users[i] = user;
//                return users[i];
//            }
//            return null;
//        }
//        return null;
//    }
//
//
//    public void delete(long id) {
//        if (findById(id) != null)
//            for (int i = 0; i < users.length; i++)
//                if (users[i].equals(findById(id)))
//                    users[i] = null;
//    }


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

    private boolean checkSize(Storage storage, File file) {
        if (storage.getStorageSize() - storage.getFiles().length > 0) {
            return true;
        }
        return false;
    }
}
