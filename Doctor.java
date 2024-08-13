package hospital_management_system;

public class Doctor {
    private static int idcounter = 0;
    private int id;
    private String name;
    private String speciality;
    public Doctor(String name, String speciality){
        this.id = ++idcounter;
        this.name = name;
        this.speciality = speciality;
        System.out.println("your id no is : "+id);
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Doctor id = "+id+", name = "+name+", spciality = "+speciality;
    }
}
