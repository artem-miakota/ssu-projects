package lab3;

public class Lab3 {
    public static void main(String[] args) {
        Student s = Student.dataEnter();
        System.out.println("Вік студента: " + s.getAge()
                + "\nСередній бал студента: " + s.getAverageMark()
                + "\nРозмір стипендії студента: " + s.getRevenue());

        Dealer d = Dealer.dataEnter();
        d.addCar();
        System.out.println("Вік дилера: " + d.getAge()
                + "\nЗ/п дилера: " + d.getRevenue());

        Doctor l = Doctor.dataEnter();
        System.out.println("Вік лікаря: " + l.getAge()
                + "\nЗ/п лікаря: " + l.getRevenue());
    }
}
