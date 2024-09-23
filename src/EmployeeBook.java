import Test.Employee;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private final double PERCENT = 1d / 100;

    public void createNewEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()) {
                employees[i] = null;
                return;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        Employee employee1 = null;
        for (Employee employee : employees) {
            if (employee != null && id == employee.getId()) {
                employee1 = employee;
            }
        }
        return employee1;
    }

    public Employee printAllEmployees() {
        Employee employee = null;
        for (Employee i : employees) {
            employee = i;
            System.out.println(employee);
        }
        return employee;
    }

    public int calculateTheAmountOfSalaryCosts() {
        int sum = 0;
        for (Employee i : employees) {
            sum += i.getSalary();
        }
        return sum;
    }

    public Employee findEmployeeMinSalary() {
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

    public Employee findEmployeeMaxSalary() {
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


    public double calculateMiddleSalary() {
        double all = calculateTheAmountOfSalaryCosts();
        all /= employees.length;
        return all;
    }

    public String printAllFullNameEmployees() {
        String fullName = null;
        for (Employee employee : employees) {
            fullName += employee.getFullName();
            System.out.println(employee.getFullName());
        }
        return fullName;
    }

    public double calculateIndexedSalary() {
        double sum = calculateTheAmountOfSalaryCosts();
        sum += sum * PERCENT;
        return sum;
    }

    public Employee findEmployeeMinSalaryDepartment(int department) {
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

    public Employee findEmployeeMaxSalaryDepartment(int department) {
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

    public int calculateTheAverageSalaryForTheDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calculateMiddleSalaryDepartment(int department) {
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

    public double calculateTheAverageIndexedSalaryForTheDepartment(int department) {
        double sum = calculateTheAverageSalaryForTheDepartment(department);
        sum += sum * PERCENT;
        return sum;
    }

    public void printAllEmployeesDepartment(int department) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printAllEmployeesLessNumber(int number) {
        for (Employee employee : employees) {
            if (number > employee.getSalary()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printAllEmployeesMoreNumber(int number) {
        for (Employee employee : employees) {
            if (number < employee.getSalary()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}
