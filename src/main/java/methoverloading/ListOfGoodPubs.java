package methoverloading;

import java.util.List;

public class ListOfGoodPubs {
    List<Pub> pubs;

    public ListOfGoodPubs(List<Pub> pubs) {
        if (pubs == null || pubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.pubs = pubs;
    }

    public Pub findTheBest() {
        Pub bestPub = pubs.get(0);
        for (Pub pub : pubs) {
            if (pub.getOpenFrom().isEarlier(bestPub.getOpenFrom())) {
                bestPub = pub;
            }
        }
        return bestPub;
    }
}
