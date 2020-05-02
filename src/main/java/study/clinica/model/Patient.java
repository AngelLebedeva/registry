package study.clinica.model;

public class Patient {

    private Long patId;
    private String patSurname;
    private String patName;
    private String patPatronymic;
    private String patMedicalCardNumber;
    private String patDateOfBirth;
    private String patGender;

    public Patient() {

    }
    public Patient(PatientForm patForm){
        this.patId = patForm.getPatId();
        this.patSurname = patForm.getPatSurname();
        this.patName = patForm.getPatName();
        this.patPatronymic = patForm.getPatPatronymic();
        this.patMedicalCardNumber = patForm.getPatMedicalCardNumber();
        this.patDateOfBirth = patForm.getPatDateOfBirth();
        this.patGender = patForm.getPatGender();
    }

    public Patient(Long patId, String patSurname, String patName, String patPatronymic, String patMedicalCardNumber, String patDateOfBirth, String patGender) {

        this.patId = patId;
        this.patSurname = patSurname;
        this.patName = patName;
        this.patPatronymic = patPatronymic;
        this.patMedicalCardNumber = patMedicalCardNumber;
        this.patDateOfBirth = patDateOfBirth;
        this.patGender = patGender;
    }

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
