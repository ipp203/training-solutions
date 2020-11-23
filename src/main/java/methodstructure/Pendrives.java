package methodstructure;

import java.util.List;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            if (pendrive.comparePricePerCapacity(pendrives.get(i)) > 0) {
                pendrive = pendrives.get(i);
            }
        }
        return pendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (int i = 1; i < pendrives.size(); i++) {
            if (!pendrive.cheaperThan(pendrives.get(i))) {
                pendrive = pendrives.get(i);
            }
        }
        return pendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive p : pendrives) {
            if (p.getCapacity() == capacity) {
                p.risePrice(percent);
            }
        }
    }


}
