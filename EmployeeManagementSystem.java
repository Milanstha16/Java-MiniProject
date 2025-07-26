abstract class Employee {
    protected final String name;
    protected final int id;
    protected final double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public abstract double calculateTax();

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: NPR" + salary);
    }
}

interface TaxPayer {
    double calculateTax();
}

class Manager extends Employee implements TaxPayer {
    private final int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println(name + " is managing a team of " + teamSize + " employees.");
    }

    @Override
    public double calculateTax() {
        return salary * 0.25;
    }
}

class Developer extends Employee implements TaxPayer {
    private final String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage + ".");
    }

    @Override
    public double calculateTax() {
        return salary * 0.20;
    }
}

class Intern extends Employee implements TaxPayer {
    private final int duration;

    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public void work() {
        System.out.println(name + " is interning for " + duration + " months.");
    }

    @Override
    public double calculateTax() {
        return 0; 
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        System.out.println();
        Employee emp1 = new Manager("Rochak", 1001, 70000, 5);
        Employee emp2 = new Developer("Milan", 1002, 50000, "Java");
        Employee emp3 = new Intern("Pritam", 1003, 20000, 6);

        Employee[] employees = {emp1, emp2, emp3};

        for (Employee e : employees) {
            e.displayInfo();
            e.work();
            System.out.println("Tax: NPR" + e.calculateTax());

            if (e instanceof Manager) {
                System.out.println("-> This is a Manager");
            } else if (e instanceof Developer) {
                System.out.println("-> This is a Developer");
            } else if (e instanceof Intern) {
                System.out.println("-> This is an Intern");
            }

            System.out.println();
        }
    }
}
