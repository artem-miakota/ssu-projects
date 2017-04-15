package lab3;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;

public class Student extends Homo {
    private final float scholarship = 1000;
    
    private String univercity, specialityCode, course;
    private HashMap<String, Integer> marks;

    public Student(String surname, String name, GregorianCalendar birthday,
            Sex sex, String location, String passport, String univercity,
            String specialityCode, String course) {
        super(surname, name, birthday, sex, location, passport);
        this.univercity = univercity;
        this.specialityCode = specialityCode;
        this.course = course;
        marks = new HashMap<>();
    }

    public void addMark(String discipline, Integer mark) {
        marks.put(discipline, mark);
    }
    
    public void removeMark(String discipline) {
        marks.remove(discipline);
    }
    
    public float getAverageMark() {
        int sum = 0, amount = 0;
        for(HashMap.Entry<String, Integer> entry : marks.entrySet()) {
            sum += entry.getValue();
            amount++;
        }
        return (float) sum / amount;
    }

    @Override
    public float getRevenue() {
        return (getAverageMark() - 3) / 2 * scholarship;
    }
    
    public String getUnivercity() {
        return univercity;
    }
    
    public String getSpecialityCode() {
        return specialityCode;
    }
        
    public String getCourse() {
        return course;
    }    
    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }
    
    public void setSpecialityCode(String specialityCode) {
        this.specialityCode = specialityCode;
    }
        
    public void setCourse(String course) {
        this.course = course;
    }
    
    public static Student dataEnter() {
        Object[] data = Homo.basicDataEnter("студента");
        Scanner scanner = new Scanner(System.in);
        String _univercity, _code, _course, _disc, buffer;
        Integer _mark = 0;
        boolean check = false;
        
        System.out.print("Введіть університет: ");
        _univercity = scanner.nextLine();
        System.out.print("Введіть курс: ");
        _course = scanner.nextLine();
        System.out.print("Введіть код спеціальності: ");
        _code = scanner.nextLine();
        Student s = new Student((String)data[0], (String)data[1],
                (GregorianCalendar)data[2], (Sex)data[3], (String)data[4],
                (String)data[5], _univercity, _code, _course);
        for (int i = 0; i < 5; i++) {
            System.out.print("Введіть премет №" + (i + 1) + ": ");
            _disc = scanner.nextLine();
            while (check == false) {
                System.out.print("Введіть оцінку з цього премету: ");
                buffer = scanner.nextLine();
                if (buffer.equals("3") || buffer.equals("4") || buffer.equals("5")) {
                    _mark = Integer.parseInt(buffer);
                    check = true;
                }
            }
            check = false;
            s.addMark(_disc, _mark);
        }
        return s;
    }
}
