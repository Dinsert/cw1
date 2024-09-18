public class Main {

    public static double percent = 1d / 100;
    public static int number = 55000;

    public static Employee[] employees = {
            new Employee("Ivanov1 Ivan1 Ivanovich1", 1, 10_000),
            new Employee("Ivanov2 Ivan2 Ivanovich2", 2, 20_000),
            new Employee("Ivanov3 Ivan3 Ivanovich3", 3, 30_000),
            new Employee("Ivanov4 Ivan4 Ivanovich4", 4, 40_000),
            new Employee("Ivanov5 Ivan5 Ivanovich5", 5, 50_000),
            new Employee("Ivanov6 Ivan6 Ivanovich6", 1, 60_000),
            new Employee("Ivanov7 Ivan7 Ivanovich7", 2, 70_000),
            new Employee("Ivanov8 Ivan8 Ivanovich8", 3, 80_000),
            new Employee("Ivanov9 Ivan9 Ivanovich9", 4, 90_000),
            new Employee("Ivanov10 Ivan10 Ivanovich10", 5, 100_000)
    };

    public static void main(String[] args) {
        printAllEmployees(employees);
        calculateSpendSalary(employees);
        findEmployeeMinSalary(employees);
        findEmployeeMaxSalary(employees);
        calculateMiddleSalary(employees);
        printAllFullNameEmployees(employees);
        calculateSpendSalaryIndex();
        findEmployeeMinSalaryDepartment(employees[3].getDepartment());
        findEmployeeMaxSalaryDepartment(employees[1].getDepartment());
        calculateSpendSalaryDepartment(employees[0].getDepartment());
        calculateMiddleSalaryDepartment(employees[4].getDepartment());
        calculateSpendSalaryDepartmentIndex(employees[2].getDepartment());
        printAllEmployeesDepartment(employees[0].getDepartment());
        printAllEmployeesLessNumber(number);
        printAllEmployeesMoreNumber(number);
    }

    public static Employee printAllEmployees(Employee[] employees) {
        Employee employee = employees[0];
        for (Employee i : employees) {
            employee = i;
            System.out.println(employee);
        }
        return employee;
    }

    public static int calculateSpendSalary(Employee[] employees) {
        int sum = 0;
        for (Employee i : employees) {
            sum += i.getSalary();
        }
        System.out.println(sum);
        return sum;
    }

    public static Employee findEmployeeMinSalary(Employee[] employees) {
        int min = 2_147_438_647;
        Employee employeeWithMinSalary = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        System.out.println(employeeWithMinSalary);
        return employeeWithMinSalary;
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
        int max = -2_147_438_647;
        Employee employeeWithMaxSalary = employees[1];
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        System.out.println(employeeWithMaxSalary);
        return employeeWithMaxSalary;
    }


    public static double calculateMiddleSalary(Employee[] employees) {
        double all = 0;
        for (Employee i : employees) {
            all += i.getSalary();
        }
        all /= employees.length;
        System.out.println(all);
        return all;
    }

    public static String printAllFullNameEmployees(Employee[] employees) {
        String fullName = "";
        for (Employee i : employees) {
            fullName += i.getFullName();
            System.out.println(i.getFullName());
        }
        return fullName;
    }

    public static double calculateSpendSalaryIndex() {
        double sum = 0;
        for (Employee i : employees) {
            sum += i.getSalary();
        }
        sum += sum * percent;
        System.out.println(sum);
        return sum;
    }

    public static Employee findEmployeeMinSalaryDepartment(int department) {
        Employee employee = employees[0];
        int min = Integer.MAX_VALUE;
        for (Employee i : employees) {
            if (department == i.getDepartment() && min > i.getSalary()) {
                min = i.getSalary();
                employee = i;
            }
        }
        System.out.println(employee);
        return employee;
    }

    public static Employee findEmployeeMaxSalaryDepartment(int department) {
        Employee employee = employees[0];
        int max = Integer.MIN_VALUE;
        for (Employee i : employees) {
            if (department == i.getDepartment() && max < i.getSalary()) {
                max = i.getSalary();
                employee = i;
            }
        }
        System.out.println(employee);
        return employee;
    }

    public static int calculateSpendSalaryDepartment(int department) {

        int sum = 0;
        for (Employee i : employees) {
            if (department == i.getDepartment())
                sum += i.getSalary();
        }
        System.out.println(sum);
        return sum;
    }

    public static double calculateMiddleSalaryDepartment(int department) {
        double all = 0;
        int count = 0;
        for (Employee i : employees) {
            if (department == i.getDepartment()) {
                all += i.getSalary();
                count++;
            }
        }
        all /= count;
        System.out.println(all);
        return all;
    }

    public static double calculateSpendSalaryDepartmentIndex(int department) {

        double sum = 0;
        for (Employee i : employees) {
            if (department == i.getDepartment()) {
                sum += i.getSalary();
            }
        }
        sum += sum * percent;
        System.out.println(sum);
        return sum;
    }

    public static void printAllEmployeesDepartment(int department) {
        for (Employee i : employees) {
            if (department == i.getDepartment()) {
                System.out.print(i.getFullName() + " ");
                System.out.print(i.getSalary() + " ");
                System.out.print(i.getId());
                System.out.println();
            }
        }
    }

    public static void printAllEmployeesLessNumber(int number) {
        for (Employee i : employees) {
            if (number > i.getSalary()) {
                System.out.print(i.getId() + " ");
                System.out.print(i.getFullName() + " ");
                System.out.print(i.getSalary());
                System.out.println();
            }
        }
    }

    public static void printAllEmployeesMoreNumber(int number) {
        for (Employee i : employees) {
            if (number < i.getSalary()) {
                System.out.print(i.getId() + " ");
                System.out.print(i.getFullName() + " ");
                System.out.print(i.getSalary());
                System.out.println();
            }
        }
    }
}