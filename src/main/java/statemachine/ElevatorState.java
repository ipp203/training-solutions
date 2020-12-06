package statemachine;

public enum ElevatorState {

    GROUND_FLOOR_OPEN("Ground Floor Open") {
        @Override
        public ElevatorState changeState() {
            return GROUND_FLOOR_CLOSED;
        }
    },
    GROUND_FLOOR_CLOSED("Ground Floor Closed") {
        @Override
        public ElevatorState changeState() {
            if (direction == DirectionType.DOWN) {
                return GROUND_FLOOR_OPEN;
            } else {
                return FIRST_FLOOR_CLOSED;
            }
        }
    },
    FIRST_FLOOR_OPEN("First Floor Open") {
        @Override
        public ElevatorState changeState() {
            return FIRST_FLOOR_CLOSED;
        }
    },
    FIRST_FLOOR_CLOSED("First Floor Closed") {
        @Override
        public ElevatorState changeState() {
            if (direction == DirectionType.DOWN) {
                return GROUND_FLOOR_CLOSED;
            } else {
                return FIRST_FLOOR_OPEN;
            }
        }
    };

    public enum DirectionType {UP, DOWN}

    private String stateInfo;
    private static DirectionType direction;

    ElevatorState(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    abstract ElevatorState changeState();
}
