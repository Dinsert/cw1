import static java.util.Objects.nonNull;

public class EmployeeBook {
    private final Employee[] employees = new Employee[10];
    private final static double PERCENT_VALUE = 1.0;
    private final static double PERCENT_INCREASE = 1 + PERCENT_VALUE / 100;


    private int getNumberOfEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                count++;
            }
        }
        return count;
    }

    public Employee createNewEmployee(String fullName, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return employees[i] = new Employee(fullName, department, salary);
            }
        }
        return null;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (nonNull(employees[i]) && id == employees[i].getId()) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (nonNull(employee) && id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public int getTotalEmployeeSalaries() {
        int sum = 0;
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        Employee result = null;
        for (int i = 1; i < employees.length; i++) {
            Employee employee = employees[i];
            if (result == null && nonNull(employee)) {
                result = employee;
                continue;
            }
            if (nonNull(employee) && employee.getSalary() < result.getSalary()) {
                result = employees[i];
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalary() {
        Employee result = null;
        for (int i = 1; i < employees.length; i++) {
            Employee employee = employees[i];
            if (result == null && nonNull(employee)) {
                result = employee;
                continue;
            }
            if (nonNull(employee) && employee.getSalary() > result.getSalary()) {
                result = employees[i];
            }
        }
        return result;
    }


    public double calculateAverageSalaryAllEmployees() {
        double count = getNumberOfEmployees();
        return count != 0 ? getTotalEmployeeSalaries() / count : 0.0;
    }

    public String getAllFullNameEmployees() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                stringBuilder.append(employee.getFullName()).append("\n");
            }
        }
        return stringBuilder.toString();

    }

    public double calculateIndexedSalaryAllEmployees() {
        return getTotalEmployeeSalaries() * PERCENT_INCREASE;
    }

    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee result = null;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (result == null && nonNull(employee) && department == employee.getDepartment()) {
                result = employee;
                continue;
            }
            if (nonNull(employee) && department == employee.getDepartment() && employee.getSalary() < result.getSalary()) {
                result = employees[i];
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee result = null;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (result == null && nonNull(employee) && department == employee.getDepartment()) {
                result = employee;
                continue;
            }
            if (nonNull(employee) && department == employee.getDepartment() && employee.getSalary() > result.getSalary()) {
                result = employees[i];
            }
        }
        return result;
    }

    public int getTotalEmployeeSalariesByDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double calculateAverageSalaryByDepartment(int department) {
        double all = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                all += employee.getSalary();
                count++;
            }
        }
        return count != 0 ? all / count : 0.0;
    }

    public double getTotalIndexedSalaryForDepartment(int department) {
        return getTotalEmployeeSalariesByDepartment(department) * PERCENT_INCREASE;
    }

    public void printAllEmployeesByDepartment(int department) {
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(int value) {
        for (Employee employee : employees) {
            if (nonNull(employee) && employee.getSalary() < value) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(int value) {
        for (Employee employee : employees) {
            if (nonNull(employee) && employee.getSalary() > value) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}
