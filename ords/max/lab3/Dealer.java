package lab3;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Dealer extends Homo {
    private final float experienceCoefficient = (float) 123.21;

    private int cars;

    public Dealer(String surname, String name, GregorianCalendar birthday,
            Sex sex, String location, String passport, int cars) {
        super(surname, name, birthday, sex, location, passport);
        this.cars = cars;
    }

    @Override
    public float getRevenue() {
        return cars * experienceCoefficient;
    }
    
    public void addCar() {
        cars++;
    }
    
    public static Dealer dataEnter() {
        Scanner scanner = new Scanner(System.in);
        Object[] data = Homo.basicDataEnter("дилера");
        System.out.print("Введіть кількість проданих машин: ");
        int _cars = scanner.nextInt();
        return new Dealer((String)data[0], (String)data[1],
                (GregorianCalendar)data[2], (Sex)data[3], (String)data[4],
                (String)data[5], _cars);
    }
}
