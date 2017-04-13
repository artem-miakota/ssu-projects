package lab3m;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Homo {
    protected String surname;
    protected String name;
    protected GregorianCalendar birthday;
    protected Sex sex;
    protected String location;
    protected String passport;

    public Homo(String surname, String name, GregorianCalendar birthday,
            Sex sex, String location, String passport) {
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.location = location;
        this.passport = passport;
        this.birthday = birthday;
    }
    
    public int getAge() {
        GregorianCalendar today = (GregorianCalendar) GregorianCalendar.getInstance();
        today.set(GregorianCalendar.HOUR_OF_DAY, 0);
        today.set(GregorianCalendar.MINUTE, 0);
        today.set(GregorianCalendar.SECOND, 0);
        today.set(GregorianCalendar.MILLISECOND, 0);    
        today.add(GregorianCalendar.YEAR, -1 * birthday.get(GregorianCalendar.YEAR));
        today.add(GregorianCalendar.MONTH, -1 * birthday.get(GregorianCalendar.MONTH));
        today.add(GregorianCalendar.DAY_OF_MONTH, -1 * birthday.get(GregorianCalendar.DAY_OF_MONTH));
        return today.get(GregorianCalendar.YEAR);
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }
        
    public Sex getSex() {
        return sex;
    }
    
    public GregorianCalendar getBirthday() {
        return birthday;
    }
    
    public String getPassport() {
        return passport;
    }
    
    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }
    
    public abstract float getRevenue();
    
    protected static Object[] basicDataEnter(String type){
        Scanner scanner = new Scanner(System.in);
        String _name, _surname, _passport, _location, buffer;
        GregorianCalendar _calendar = new GregorianCalendar();
        Sex _sex = Sex.male;
        boolean check = false;
        
        System.out.print("Введіть ім'я " + type + ": ");
        _name = scanner.nextLine();
        System.out.print("Введіть прізвище " + type + ": ");
        _surname = scanner.nextLine();
        System.out.print("Введіть паспортні дані " + type + ": ");
        _passport = scanner.nextLine();
        System.out.print("Введіть місцезнаходження " + type + ": ");
        _location = scanner.nextLine();
        while (check == false) {
            System.out.print("Введіть стать " + type + " (0 - жін., 1 - чол.): ");
            buffer = scanner.nextLine();
            if (buffer.equals("1") || buffer.equals("0")) {
                _sex = (buffer.equals("0")) ? Sex.female : Sex.male;
                check = true;
            }
        }
        check = false;
        while (check == false) {
            System.out.print("Введіть дату народження " + type + " у форматі \"дд.мм.рррр\": ");
            buffer = scanner.nextLine();
            Pattern p = Pattern.compile("^([0-9]{1,2})\\.([0-9]{1,2})\\.([0-9]{4})$");
            Matcher m = p.matcher(buffer);
            if (m.matches()
                    && (Integer.parseInt(m.group(1)) <= 31)
                    && (Integer.parseInt(m.group(2)) <= 12)) {
                _calendar = new GregorianCalendar(Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(2)) - 1, Integer.parseInt(m.group(1)));
                check = true;
            }
        }
        return new Object[] {_surname, _name, _calendar, _sex, _location, _passport};
    }
}
