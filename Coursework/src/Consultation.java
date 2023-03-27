import java.util.Date;
import java.text.SimpleDateFormat;


public class Consultation extends Person {

    public static Date date;
    private  Doctor doctor;
    private Patient patient;


    public Consultation(String name, String surname, String dob, String mobileNumber) {
        super(name, surname, dob, mobileNumber);
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public Patient getPatient(){
        return patient;
    }
}
