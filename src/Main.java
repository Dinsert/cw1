public class Main {

    public static final double PERCENT = 1d / 100;

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
        System.out.println(calculateSpendSalary(employees));
        System.out.println(findEmployeeMinSalary(employees));
        System.out.println(findEmployeeMaxSalary(employees));
        System.out.println(calculateMiddleSalary(employees));
        printAllFullNameEmployees(employees);
        System.out.println(calculateSpendSalaryIndex());
        System.out.println(findEmployeeMinSalaryDepartment(employees[3].getDepartment()));
        System.out.println(findEmployeeMaxSalaryDepartment(employees[1].getDepartment()));
        System.out.println(calculateSpendSalaryDepartment(employees[0].getDepartment()));
        System.out.println(calculateMiddleSalaryDepartment(employees[4].getDepartment()));
        System.out.println(calculateSpendSalaryDepartmentIndex(employees[2].getDepartment()));
        printAllEmployeesDepartment(employees[0].getDepartment());
        printAllEmployeesLessNumber(55000);
        printAllEmployeesMoreNumber(55000);
    }

    public static Employee printAllEmployees(Employee[] employees) {
        Employee employee = null;
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
        return sum;
    }

    public static Employee findEmployeeMinSalary(Employee[] employees) {
        int min = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;

        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
        int max = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }


    public static double calculateMiddleSalary(Employee[] employees) {
        double all = calculateSpendSalary(employees);
        all /= employees.length;
        return all;
    }

    public static String printAllFullNameEmployees(Employee[] employees) {
        String fullName = null;
        for (Employee employee : employees) {
            fullName += employee.getFullName();
            System.out.println(employee.getFullName());
        }
        return fullName;
    }

    public static double calculateSpendSalaryIndex() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        sum += sum * PERCENT;
        return sum;
    }

    public static Employee findEmployeeMinSalaryDepartment(int department) {
        Employee employee1 = null;
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (department == employee.getDepartment() && min > employee.getSalary()) {
                min = employee.getSalary();
                employee1 = employee;
            }
        }
        return employee1;
    }

    public static Employee findEmployeeMaxSalaryDepartment(int department) {
        Employee employee1 = null;
        int max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (department == employee.getDepartment() && max < employee.getSalary()) {
                max = employee.getSalary();
                employee1 = employee;
            }
        }
        return employee1;
    }

    public static int calculateSpendSalaryDepartment(int department) {

        int sum = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment())
                sum += employee.getSalary();
        }
        return sum;
    }

    public static double calculateMiddleSalaryDepartment(int department) {
        double all = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                all += employee.getSalary();
                count++;
            }
        }
        all /= count;
        return all;
    }

    public static double calculateSpendSalaryDepartmentIndex(int department) {
        double sum = calculateSpendSalaryDepartment(department);
        sum += sum * PERCENT;
        return sum;
    }

    public static void printAllEmployeesDepartment(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.println(employee);
            }
        }
    }

    public static void printAllEmployeesLessNumber(int number) {
        for (Employee employee : employees) {
            if (number > employee.getSalary()) {
                System.out.print(employee.getId() + " ");
                System.out.print(employee.getFullName() + " ");
                System.out.print(employee.getSalary());
                System.out.println();
            }
        }
    }

    public static void printAllEmployeesMoreNumber(int number) {
        for (Employee employee : employees) {
            if (number < employee.getSalary()) {
                System.out.print(employee.getId() + " ");
                System.out.print(employee.getFullName() + " ");
                System.out.print(employee.getSalary());
                System.out.println();
            }
        }
    }
}