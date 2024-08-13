package hospital_management_system;

import java.util.ArrayList;
import java.util.Scanner;
import hospital_management_system.Patient;
import hospital_management_system.Doctor;
import hospital_management_system.Appointment;

public class Hospital_Management {
    private static ArrayList<Patient> Patients = new ArrayList<>();
    private static ArrayList<Doctor> Doctors = new ArrayList<>();
    private static ArrayList<Appointment> Appointments = new ArrayList<>();
    private static void add_Patient(Scanner scan){
        System.out.print("enter the patient name : ");
        String name = scan.next();
        System.out.print("enter the patient gender : ");
        String gender = scan.next();
        System.out.print("enter the patient age : ");
        int age = scan.nextInt();
        Patients.add(new Patient(name, gender, age));
    }
    private static void add_Doctor(Scanner scan){
        System.out.print("enter the doctor name : ");
        String name = scan.next();
        System.out.print("enter the doctor's speciality : ");
        String speciality = scan.next();
        Doctors.add(new Doctor(name, speciality));
    }
    private static void add_Appointment(int P_id, int D_id, String Appoint_date){
        Patient patient = null; Doctor doctor = null;
        for(Patient i : Patients){
            if(i.getId()==P_id){
                patient = i;
                break;
            }
        }
        for(Doctor i : Doctors){
            if(i.getId()==D_id){
                doctor = i;
                break;
            }
        }
        if(patient==null || doctor==null) return;
        Appointments.add(new Appointment(patient, doctor, Appoint_date));
    }
    private static void change_Appointment_schedule(int P_id, int D_id, String Appoint_date){
        Appointment appointment = null;
        for(Appointment k : Appointments){
            if((k.getPatient().getId()==P_id) && (k.getDoctor().getId()==D_id)){
                appointment = k;
                appointment.changeDate(Appoint_date);
                return;
            }
        }
    }
    private static void schedule_Appointment(Scanner scan, int mode){
        System.out.print("enter the patient id : ");
        int P_id = scan.nextInt();
        System.out.print("enter the doctor's id : ");
        int D_id = scan.nextInt();
        System.out.print("enter the date for Appointment : ");
        String Appoint_date = scan.next();
        if(mode==3){
            add_Appointment(P_id, D_id, Appoint_date);
        }
        else {
            change_Appointment_schedule(P_id, D_id, Appoint_date);
        }
    }
    private static void view_Patient(Scanner scan){
        System.out.println("enter the patient id : ");
        int P_id = scan.nextInt();
        Patient patient = null; 
        for(Patient i : Patients){
            if(i.getId()==P_id){
                patient = i;
                break;
            }
        }
        if(patient==null) return;
        System.out.println(patient);
    }
    private static void view_Doctor(Scanner scan){
        System.out.print("enter the doctor's id : ");
        int D_id = scan.nextInt();
        Doctor doctor = null;
        for(Doctor i : Doctors){
            if(i.getId()==D_id){
                doctor = i;
                break;
            }
        }
        if(doctor==null) return;
        System.out.println(doctor);
    }
    private static void view_schedule(Scanner scan){
        System.out.print("enter the patient id : ");
        int P_id = scan.nextInt();
        System.out.print("enter the doctor's id : ");
        int D_id = scan.nextInt();
        Appointment appointment = null;
        for(Appointment k : Appointments){
            if((k.getPatient().getId()==P_id) && (k.getDoctor().getId()==D_id)){
                appointment = k;
                break;
            }
        }
        if(appointment==null) return;
        System.out.println(appointment);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
         System.out.println("Hospital Management System");
         System.out.println("1. Add Patient");
         System.out.println("2. Add Doctor");
         System.out.println("3. Schedule Appointment");
         System.out.println("4. Change Appointment Schedule");
         System.out.println("5. View Patient");
         System.out.println("6. View Doctor");
         System.out.println("7. View Schedule");
         System.out.println("0. Exit");
         System.out.print("enter your choice : ");
         int choice = scan.nextInt();
 
         switch (choice) {
             case 1:
                 add_Patient(scan);
                 break;
             case 2 :
                 add_Doctor(scan);
                 break;
             case 3 :
             schedule_Appointment(scan, 3);
                 break;
             case 4 :
             schedule_Appointment(scan, 4);
                 break;
             case 5 :
                 view_Patient(scan);
                 break;
             case 6 :
                 view_Doctor(scan);
                 break;
             case 7 :
                 view_schedule(scan);
                 break;
             case 0 :
                 System.out.println(".....Exiting.....");
                 break;
             default:
                 System.out.println("invalid ! enter your choice correctly : ");
                 continue;
         }
         if(choice==0) break;
        }
     }
}
