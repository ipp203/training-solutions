package db_covid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vaccination {

    public enum VaccinationStatus {
        VACCINATED, FAILED
    }

    public enum VaccinationType {
        NONE, ASTRAZENECA, SINOPHARM, PFIZER_BIONTECH, MODERNA, SPUTNIK;

        public static List<String> getVaccinationTypeList() {
            List<String> result = new ArrayList<>();
            for (VaccinationType vt : VaccinationType.values()) {
                if (vt != NONE) {
                    result.add(vt.name());
                }
            }
            return result;
        }
    }

    private int citizenId;
    private LocalDate vacDate;
    private VaccinationStatus status;
    private String note;
    private VaccinationType type;

    public Vaccination(int citizenId, LocalDate vacDate, VaccinationStatus status, String note, VaccinationType type) {
        this.citizenId = citizenId;
        this.vacDate = vacDate;
        this.status = status;
        this.note = note;
        this.type = type;
    }

    public static Vaccination ofWithVaccinated(int citizenId, LocalDate vacDate, VaccinationType type) {
        return new Vaccination(citizenId, vacDate, VaccinationStatus.VACCINATED, "", type);
    }

    public static Vaccination ofWithFailed(int citizenId, LocalDate failedDate, String note) {
        return new Vaccination(citizenId, failedDate, VaccinationStatus.VACCINATED, note, VaccinationType.NONE);
    }

    public int getCitizenId() {
        return citizenId;
    }

    public LocalDate getVacDate() {
        return vacDate;
    }

    public VaccinationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccinationType getType() {
        return type;
    }

    @Override
    public String toString() {
        return vacDate + "; "
                + type.toString() + "; "
                + status.toString() + "; "
                + note;
    }
}
