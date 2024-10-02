public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    private final static double PERCENT_VALUE = 1d;
    private final static double PERCENT_INCREASE = 1 + PERCENT_VALUE / 100;


    private int counterEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public Employee createNewEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee employee = new Employee(fullName, department, salary);
                return employees[i] = employee;
            }
        }
        return null;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && id == employees[i].getId()) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee != null && id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public double calculateAmountOfSalaryCosts() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        Employee result = null;
        if (employees.length > 0) {
            result = employees[0];
            for (int i = 1; i < employees.length; i++) {
                if (employees[i].getSalary() < result.getSalary()) {
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalary() {
        Employee result = null;
        if (employees.length > 0) {
            result = employees[0];
            for (int i = 1; i < employees.length; i++) {
                if (employees[i].getSalary() > result.getSalary()) {
                    result = employees[i];
                }
            }
        }
        return result;
    }


    public double calculateAverageSalaryAllEmployees() {
        int count = counterEmployees();
        return count != 0 ? calculateAmountOfSalaryCosts() / count : 0.0;
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

    public double calculateIndexedSalaryAllEmployees() {
        return calculateAmountOfSalaryCosts() * PERCENT_INCREASE;
    }

    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee result = null;
        if (employees.length > 0) {
            result = employees[department - 1];
            for (int i = 0; i < employees.length; i++) {
                if (department == employees[i].getDepartment() && employees[i].getSalary() < result.getSalary()) {
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee result = null;
        if (employees.length > 0) {
            result = employees[department - 1];
            for (int i = 0; i < employees.length; i++) {
                if (department == employees[i].getDepartment() && employees[i].getSalary() > result.getSalary()) {
                    result = employees[i];
                }
            }
        }
        return result;
    }

    public int calculateAmountOfSalaryCostsForDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calculateAverageSalaryByDepartment(int department) {
        double all = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && department == employee.getDepartment()) {
                all += employee.getSalary();
                count++;
            }
        }
        return count != 0 ? all / count : 0.0;
    }

    public double calculateIndexedSalaryForDepartment(int department) {
        return calculateAmountOfSalaryCostsForDepartment(department) * PERCENT_INCREASE;
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
