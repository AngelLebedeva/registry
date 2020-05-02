package study.clinica.model;

public class RegistrationForm {

    private Long regId;
    private String position;
    private String docSurname;
    private String patSurname;
    private String visDate;
    private String visTime;

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDocSurname() {
        return docSurname;
    }

    public void setDocSurname(String docSurname) {
        this.docSurname = docSurname;
    }

    public String getPatSurname() {
        return patSurname;
    }

    public void setPatSurname(String patSurname) {
        this.patSurname = patSurname;
    }

    public String getVisDate() {
        return visDate;
    }

    public void setVisDate(String visDate) {
        this.visDate = visDate;
    }

    public String getVisTime() {
        return visTime;
    }

    public void setVisTime(String visTime) {
        this.visTime = visTime;
    }
}
