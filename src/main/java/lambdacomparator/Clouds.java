package lambdacomparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clouds {


    // a szolgáltató neve alapján betűrendben a legelső CloudStorage. Kis-nagybetű nem számít.
    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        List<CloudStorage> result = new ArrayList<>(storages);
        result.sort(Comparator.comparing(CloudStorage::getProvider,
//                (s1,s2) -> s1.toLowerCase().compareTo(s2.toLowerCase())));
                Comparator.comparing(String::toLowerCase)));
        return result.get(0);
    }

    //: a legrövidebb időszakra vonatkozó legolcsóbb CloudStorage. Ha van ingyenes, akkor azok közül bármelyik megadható.
    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        List<CloudStorage> result = new ArrayList<>(storages);
        result.sort(Comparator.comparing(CloudStorage::getPeriod,Comparator.nullsFirst(Comparator.naturalOrder()))
                .thenComparing(CloudStorage::getPrice));
        return result.get(0);
    }

    //  a természetes rendezettség szerinti 3 legrosszabb ajánlat.
    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> result = new ArrayList<>(storages);
        result.sort(Comparator.reverseOrder());
        int resultLength = Math.min(result.size(),3);
        return result.subList(0,resultLength);
    }

}
