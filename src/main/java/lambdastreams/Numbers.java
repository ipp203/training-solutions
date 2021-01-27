package lambdastreams;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> list;

    public Numbers(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public Optional<Integer> min() {
        return list.stream().min(Integer::compareTo);
    }

    public Integer sum() {
        return list.parallelStream().reduce(0, Numbers::add, Numbers::add);
    }

    private static Integer add(Integer i1, Integer i2) {
        return i1 + i2;
    }

    public boolean isAllPositive() {
        return list.stream().allMatch(i -> i >= 0);
    }

    public Set<Integer> getDistinctElements(){
        //return list.stream().collect(Collectors.toCollection(HashSet::new));
        //return list.stream().collect(Collectors.toSet());
        return list.stream().collect(HashSet::new,HashSet::add,HashSet::addAll);
    }
}
