public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    private final double PERCENT_INCREASE = 1 + 1d / 100;

    public void createNewEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (id == employees[i].getId()) {
                employees[i] = null;
                break;
            }
        }
    }

    public Employee getEmployeeById(int id) {
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && id == employee.getId()) {
                result = employee;
            }
        }
        return result;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public int calculateAmountOfSalaryCosts() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeMinSalary() {
        int min = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < min) {
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
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }


    public double calculateMiddleSalary() {
        double all = calculateAmountOfSalaryCosts();
        return all /= employees.length;
    }

    public String getAllFullNameEmployees() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            if (employee != null) {
                stringBuilder.append(employee.getFullName()).append("\n");
            }
        }
        return stringBuilder.toString();

    }

    public double calculateIndexedSalary() {
        double sum = calculateAmountOfSalaryCosts();
        return sum * PERCENT_INCREASE;
    }

    public Employee findEmployeeMinSalaryByDepartment(int department) {
        Employee result = null;
        int min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment() && min > employee.getSalary()) {
                min = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public Employee findEmployeeMaxSalaryByDepartment(int department) {
        Employee result = null;
        int max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment() && max < employee.getSalary()) {
                max = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public int calculateAverageSalaryForDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calculateMiddleSalaryByDepartment(int department) {
        double all = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                all += employee.getSalary();
                count++;
            }
        }
        return all /= count;
    }

    public double calculateAverageIndexedSalaryForDepartment(int department) {
        double sum = calculateAverageSalaryForDepartment(department);
        return sum * PERCENT_INCREASE;
    }

    public void printAllEmployeesByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(int value) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < value) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(int value) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > value) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}
