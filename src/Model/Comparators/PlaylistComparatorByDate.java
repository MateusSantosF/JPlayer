
package Model.Comparators;

import java.util.Comparator;

import Model.interfaces.IPlaylist;

public class PlaylistComparatorByDate implements Comparator<IPlaylist> {

    @Override
    public int compare(IPlaylist o1, IPlaylist o2) {
        return o1.getCreateData().compareTo(o2.getCreateData());
    }
}
