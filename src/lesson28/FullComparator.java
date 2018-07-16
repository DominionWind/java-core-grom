package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {


        if (o1.getChannelName() == null && o2.getChannelName() == null) {
            return 0;
        } else if (o1.getChannelName() == null) {
            return 1;
        } else if (o2.getChannelName() == null) {
            return -1;
        } else if (!o1.getChannelName().equals(o2)) {
            return o1.getChannelName().compareTo(o2.getChannelName());
        } else if (o1.getFingerprint() == null && o2.getFingerprint() == null) {
            return 0;
        } else if (o1.getFingerprint() == null) {
            return 1;
        } else if (o2.getFingerprint() == null) {
            return -1;
        } else if (!o1.getFingerprint().equals(o2))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else if (o1.getDateCreated() == null && o2.getDateCreated() == null) {
            return 0;
        } else if (o1.getDateCreated() == null) {
            return 1;
        } else if (o2.getDateCreated() == null) {
            return -1;
        } else {
            return (int) (o1.getDateCreated().getTime() - o2.getDateCreated().getTime());
        }
    }
}
