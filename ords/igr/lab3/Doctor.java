package lab3;

import java.util.GregorianCalendar;

public class Doctor extends Homo {
    private final float experienceCoefficient = (float) 223.17;

    public Doctor(String surname, String name, GregorianCalendar birthday,
            Sex sex, String location, String passport) {
        super(surname, name, birthday, sex, location, passport);
    }

    @Override
    public float getRevenue() {
        return getAge() * experienceCoefficient;
    }
    
    public static Doctor dataEnter() {
        Object[] data = Homo.basicDataEnter("лікаря");
        return new Doctor((String)data[0], (String)data[1],
                (GregorianCalendar)data[2], (Sex)data[3], (String)data[4],
                (String)data[5]);
    }
}