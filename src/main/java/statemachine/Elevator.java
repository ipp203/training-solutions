package statemachine;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private List<String> history = new ArrayList<>();
    private ElevatorState elevatorState;
    private List<ElevatorState> destinations;

    public Elevator() {
        this(ElevatorState.GROUND_FLOOR_OPEN);
    }

    public Elevator(ElevatorState elevatorState) {
        stateInfoToHistory(elevatorState);
        this.elevatorState = elevatorState;
        destinations = new ArrayList<>();
    }

    public String getHistory() {
        return history.toString();
    }

    public void pushButtonToGoToFirstFloor() {
        destinations.add(ElevatorState.FIRST_FLOOR_OPEN);
    }

    public void pushButtonToGoToGroundFloor() {
        destinations.add(ElevatorState.GROUND_FLOOR_OPEN);
    }

    public void pushCallButtonOnFirstFloor() {
        pushButtonToGoToFirstFloor();
    }

    public void pushCallButtonOnGroundFloor() {
        pushButtonToGoToGroundFloor();
    }

    public void work() {
        for (ElevatorState dest : destinations) {
            elevatorState.setDirection(getDirection(dest));
            while (elevatorState != dest) {
                elevatorState = elevatorState.changeState();
                stateInfoToHistory(elevatorState);
            }
        }
        destinations.clear();
    }

    private void stateInfoToHistory(ElevatorState elevatorState) {
        history.add(elevatorState.getStateInfo());
    }

    private ElevatorState.DirectionType getDirection(ElevatorState destination) {
        switch (destination) {
            case GROUND_FLOOR_OPEN, GROUND_FLOOR_CLOSED: {
                return ElevatorState.DirectionType.DOWN;
            }
            default: {
                return ElevatorState.DirectionType.UP;
            }
        }
    }

}
