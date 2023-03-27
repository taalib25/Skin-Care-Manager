import java.awt.event.ActionEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Collections;

public  class WestminsterSkinConsultationManager implements SkinConsultationManager {

    protected static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
    protected static ArrayList<String> dateTimeList = new ArrayList<String>();
    private Scanner input = new Scanner(System.in);
    private String option;

    @Override
    public void addDoctor() {
        if (doctorList.size() <= 9) {
            System.out.println("Enter the doctor's name: ");
            String doctorName = input.next();
            System.out.println("Enter the doctor's surname: ");
            String doctorSurname = input.next();
            System.out.println("Enter the doctor's D.O.B: ");
            String doctorDob = input.next();
            System.out.println("Enter the doctor's mobile number: ");
            String mobileNumber = input.next();
            System.out.println("Enter the doctor's license number: ");
            String licenseNumber = input.next();
            System.out.println("Enter the doctor's specialisation: ");
            String doctorSpecialisation = input.next();

            Doctor doctor = new Doctor(doctorName, doctorSurname, doctorDob, mobileNumber, licenseNumber, doctorSpecialisation);
            doctorList.add(doctor);
            System.out.println("The doctor has been successfully added in the system:))");
        } else {
            System.out.println("There are already 10 doctors in the system");
            System.out.println("If you want to add more doctors, delete a doctor from the system");
            System.out.println(" ");
        }



    }

    @Override
    public void deleteDoctor() {
        System.out.println("Enter the license number of the doctor to delete from the system");
        String selectedLicense = input.next();
        //print list
        for (Doctor doctor : doctorList) {
            if (doctor.getLicenseNumber().toLowerCase().equals(selectedLicense.toLowerCase())) {
                System.out.println("Do you want to delete: " + doctor.getName());
                System.out.println("Enter yes/no");
                option = input.next();

                if (option.toLowerCase().equals("yes")) {
                    doctorList.remove(doctor);

                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println(doctor.getName() + " was successfully deleted");
                    //sortDrivers();
                    System.out.println("The number of doctors right now in the system are :" + doctorList.size());
                    return;
                } else {
                    return;
                }
            }
        }
        System.out.println(selectedLicense + " is not in the system ");
    }



    @Override
    public void printDoctor() {
        sortDoctor();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor.getName() + "\t" +
                    doctor.getSurname() + "\t" +
                    doctor.getDOB() + "\t" +
                    doctor.getNumber() + "\t" +
                    doctor.getLicenseNumber() + "\t" +
                    doctor.getSpecialisation());
        }


    }


    private static  void sortDoctor(){
        Collections.sort(doctorList, new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareTo(d2.getSurname());
            }
        });
    }


    @Override
    public void loadFile() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("DoctorDetails.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);
        for(;;){
            try{
                Doctor doctor =    (Doctor) oi.readObject();
                doctorList.add(doctor);
            }catch(EOFException e){
                break;

            }
        }
        fi.close();
        oi.close();

        System.out.println("---------------------------------------------------------");
        System.out.println(" Doctors Loaded Successfully");
        sortDoctor();
    }

    @Override
    public ActionEvent loadGUI() throws IOException {
        //saveFile();
        new DoctorDetailsGUI();
        return null;
    }

    @Override
    public void saveFile() throws IOException {
        FileOutputStream f = new FileOutputStream(new File("DoctorDetails.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        for(Doctor doctor : doctorList){
            o.writeObject(doctor);
        }

        o.flush();
        f.close();
        o.close();
        System.out.println("The file has been successfully saved!!..");
    }



}

