import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;


    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary= " + calculateSalary() + "]";
    }
}
class FullTimeEmployee extends Employee{
        private double monthlySalary;

        public FullTimeEmployee(String name, int id, double monthlySalary){
            super(name,id);
            this.monthlySalary= monthlySalary;
        }

        @Override
        public double calculateSalary(){
            return monthlySalary;
        }
}
class PartTimeEmployee extends Employee{

        private int hoursWorked;

        private double hourlyRate;

        public PartTimeEmployee(String name, int id, int hoursWorked, int hourlyRate){
            super(name, id);
            this.hoursWorked=hoursWorked;
            this.hourlyRate=hourlyRate;
        }

        @Override
        public double calculateSalary(){
            return hoursWorked * hourlyRate;
        }


}
//making payroll system

class PayrollSystem{
        private ArrayList<Employee> employeeList;

        public PayrollSystem(){
            employeeList = new ArrayList<>();
        }
        public void addEmployee(Employee employee){
            employeeList.add(employee);
        }
//to remove employee
    public void removeEmployee(int id){
            Employee employeeToRemove = null;
            for(Employee employee : employeeList){
                if(employee.getId()==id){
                    employeeToRemove = employee;
                    break;
                }

            }
            if(employeeToRemove != null){
                employeeList.remove(employeeToRemove);
            }
    }

    public void displayEmployee(){
            for (Employee employee: employeeList){
                System.out.println(employee);
         }
    }
}



public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee Emp1 = new FullTimeEmployee("shiv",001,500000.0);
        PartTimeEmployee Emp2 = new PartTimeEmployee("rachit",002,4,300);


        payrollSystem.addEmployee(Emp1);
        payrollSystem.addEmployee(Emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployee();
        System.out.println("removing employee: ");
        payrollSystem.removeEmployee(002);
        System.out.println("Remaining Employee ");
        payrollSystem.displayEmployee();
    }
}
