import java.util.ArrayList;
import java.util.List;


abstract class Employee {
    private int ID;
    private String NAME;

    public  Employee( int ID, String NAME){
        this.ID=ID;
        this.NAME=NAME;
    }
    public String getName(){
        return NAME;

    }
    public int getID(){
        return ID;
    }
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + NAME + " , ID="  + ID +", salary=" + calculateSalary() +"]";
    }
    

    


}
class FullTimeEmployee extends Employee{
    private double monthlysalary;

    public  FullTimeEmployee(int ID , String NAME , double monthlysalary){
        super(ID ,NAME);
        this.monthlysalary=monthlysalary;
    }
    @Override
    public double calculateSalary() {
        return monthlysalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private int hourlyRate;

    public PartTimeEmployee(int ID,String Name, int hourlyRate ,int hoursWorked){
        super(ID, Name);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }
}




class PayrollSystem {
    private List<Employee> employeelList;

    public PayrollSystem(){
        employeelList =new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeelList.add(employee);

    }
    public void removeEmployee(int id){
        Employee employeeToremove = null;
        for(Employee employee : employeelList){
            if(employee.getID() == id){
                employeeToremove = employee;
                break;
            }
            if(employeeToremove != null){
                employeelList.remove(employeeToremove);
            }
        }
    }
    public void displayEmployees(){
        for(Employee employee : employeelList){
            System.out.println(employee);
        }
    }
}
public class Main1 {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee(1, "Gaurav", 700000);
        PartTimeEmployee emp2 = new PartTimeEmployee(2, "Suraj", 2000, 5);

        
        
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();
    }

    
}
