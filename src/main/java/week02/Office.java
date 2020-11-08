package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom room : meetingRooms) {
            System.out.println(room.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom room : meetingRooms) {
            System.out.println(room.getName() + ": " + room.getLength() + "m x " +
                    room.getWidth() + "m = " + room.getArea() + "m2");
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().equals(name)) {
                System.out.println(room.getLength() + "m x " +
                        room.getWidth() + "m = " + room.getArea() + "m2");
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        for (MeetingRoom room : meetingRooms) {
            if (room.getName().toUpperCase().indexOf(part.toUpperCase()) > -1) {
                System.out.println(room.getLength() + "m x " +
                        room.getWidth() + "m = " + room.getArea() + "m2");
            }
        }
    }

    public void printAreasLargerThan(int area){
        for (MeetingRoom room : meetingRooms) {
            if (room.getArea() > area) {
                System.out.println(room.getName() + ": " + room.getLength() + "m x " +
                        room.getWidth() + "m =" + room.getArea() + "m2");
            }
        }
    }


}
