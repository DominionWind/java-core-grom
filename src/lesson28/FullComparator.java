package lesson28;

import java.util.Comparator;

public class FullComparator<T> implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {

        if (o1.getChannelName() == null || o2.getChannelName() == null) {
            check(o1.getChannelName(), o2.getChannelName())
        }

        if (!o1.getChannelName().equals(o2)) {
            return o1.getChannelName().compareTo(o2.getChannelName());
        }

        if (o1.getFingerprint() == null || o2.getFingerprint() == null) {
            check(o1.getFingerprint(), o2.getFingerprint())
        }

        if (!o1.getFingerprint().equals(o2)){
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        }

        return (int) (o1.getDateCreated().getTime() - o2.getDateCreated().getTime());
    }
}

    private int check(T a, T b) {

        if (a == null && b == null) {
            return 0;
        } else if (a == null) {
            return 1;
        } else
            return -1;
    }
}
