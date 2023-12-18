import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) {

        //  * 2.1 Создать список из 10-20 сотрудников
        List<Employee> personal = generateEmployees();
        System.out.println("Personal: " + personal);
        System.out.println("----------");

        //  * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
        Set<Employee> devDep = personal.stream().filter(it -> it.getDepartment().equals("Development")).collect(Collectors.toSet());
        System.out.println("Development department: " + devDep);

        Set<Employee> devDes = personal.stream().filter(it -> it.getDepartment().equals("Design")).collect(Collectors.toSet());
        System.out.println("Design department: " + devDes);

        Set<Employee> devTest = personal.stream().filter(it -> it.getDepartment().equals("Testing")).collect(Collectors.toSet());
        System.out.println("Testing department: " + devTest);
        System.out.println("----------");

        //  * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        personal.stream().filter(it -> it.getSalary() < 10_000).forEach(it -> it.setSalary(it.getSalary() * 1.2));
        System.out.println("Salary up: " + personal);
    }

    private static List<Employee> generateEmployees() {
        return List.of(
                new Employee("Gennady", 35, 20_000, "Development"),
                new Employee("Peter", 40, 16_000, "Development"),
                new Employee("Yuri", 43, 5_000, "Development"),
                new Employee("Ivan", 30, 23_000, "Development"),
                new Employee("Alexey", 25, 9_000, "Development"),

                new Employee("Fedor", 23, 7_000, "Design"),
                new Employee("Dmitriy", 28, 6_000, "Design"),
                new Employee("Anatoliy", 21, 22_000, "Design"),
                new Employee("Pavel", 35, 18_000, "Design"),
                new Employee("Artem", 33, 15_000, "Design"),

                new Employee("Anton", 20, 19_000, "Testing"),
                new Employee("Mikhail", 34, 8_000, "Testing"),
                new Employee("Evgeniy", 46, 15_000, "Testing"),
                new Employee("Semion", 42, 7_000, "Testing"),
                new Employee("leonid", 31, 17_000, "Testing")
        );
    }

    //  * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
    static class Employee {
        private final String name;
        private int age;
        private double salary;
        private String department;

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        public Employee(String name, int age, double salary, String department) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String toString() {
            return String.format("[%s] (age = %s, salary = %s, department = %s)", name, age, salary, department);
        }
    }
}