package hospital_management_system ;

public class Patient {
    private static int idcounter = 0;
    private int id;
    private String name;
    private String gender;
    private int age;
    public Patient(String name, String gender, int age){
        this.id = ++idcounter;
        this.name = name;
        this.gender = gender;
        this.age = age;
        System.out.println("your id no is : "+id);
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Patient id = "+this.id+", name = "+this.name+", gender = "+this.gender+", age = "+this.age;
    }
}