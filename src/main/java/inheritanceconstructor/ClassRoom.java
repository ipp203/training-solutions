package inheritanceconstructor;

public class ClassRoom extends Room {
    private Facility facility;

    public ClassRoom(String location, int capacity, Facility facility) {
        super(location, capacity);
        this.facility = facility;
    }

    public Facility getFacility() {
        return facility;
    }

    public boolean isSuitable(Course course) {
        return facility == course.getFacilityNeeded() &&
                super.getCapacity() >= course.getParticipants();
    }

}
