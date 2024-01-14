package sky.pro.Stream.API.and.Optional;

public class Employee {
    private static int idCounter = 1;

    private int id;
    private String fullName;
    private double salary;
    private int departmentId;

    public Employee(String fullName, double salary, int departmentId) {
        this.id = idCounter++;
        this.fullName = fullName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee #" + id + ": " + fullName + ", Department: " + departmentId + ", Salary: " + salary;
    }
}