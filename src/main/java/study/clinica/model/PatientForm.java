package study.clinica.model;

public class PatientForm {

    private Long patId;
    private String patSurname;
    private String patName;
    private String patPatronymic;
    private String patMedicalCardNumber;
    private String patDateOfBirth;
    private String patGender;

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getPatSurname() {
        return patSurname;
    }

    public void setPatSurname(String patSurname) {
        this.patSurname = patSurname;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatPatronymic() {
        return patPatronymic;
    }

    public void setPatPatronymic(String patPatronymic) {
        this.patPatronymic = patPatronymic;
    }

    public String getPatMedicalCardNumber() {
        return patMedicalCardNumber;
    }

    public void setPatMedicalCardNumber(String patMedicalCardNumber) {
        this.patMedicalCardNumber = patMedicalCardNumber;
    }

    public String getPatDateOfBirth() {
        return patDateOfBirth;
    }

    public void setPatDateOfBirth(String patDateOfBirth) {
        this.patDateOfBirth = patDateOfBirth;
    }

    public String getPatGender() {
        return patGender;
    }

    public void setPatGender(String patGender) {
        this.patGender = patGender;
    }
}
