public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.createNewEmployee("Ivanov1 Ivan1 Ivanovich1", 1, 10_000);
        employeeBook.createNewEmployee("Ivanov2 Ivan2 Ivanovich2", 2, 20_000);
        employeeBook.createNewEmployee("Ivanov3 Ivan3 Ivanovich3", 3, 30_000);
        employeeBook.createNewEmployee("Ivanov4 Ivan4 Ivanovich4", 4, 40_000);
        employeeBook.createNewEmployee("Ivanov5 Ivan5 Ivanovich5", 5, 50_000);
        employeeBook.createNewEmployee("Ivanov6 Ivan6 Ivanovich6", 1, 60_000);
        employeeBook.createNewEmployee("Ivanov7 Ivan7 Ivanovich7", 2, 70_000);
        employeeBook.createNewEmployee("Ivanov8 Ivan8 Ivanovich8", 3, 80_000);
        employeeBook.createNewEmployee("Ivanov9 Ivan9 Ivanovich9", 4, 90_000);
        employeeBook.createNewEmployee("Ivanov10 Ivan10 Ivanovich10", 5, 100_000);

        if (employeeBook.createNewEmployee("", 1, 1) == null) {
            System.out.println("хранилище заполнено");
        }

    }
}