package ex2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть х-координату першої точки: ");
        double xl = scanner.nextDouble();
        System.out.print("Введіть у-координату першої точки: ");
        double yb = scanner.nextDouble();
        System.out.print("Введіть х-координату другої точки: ");
        double xr = scanner.nextDouble();
        System.out.print("Введіть у-координату другої точки: ");
        double yt = scanner.nextDouble();
        
        Rectangle r = new Rectangle(xl, xr, yt, yb);
        System.out.println("\nПериметр прямокутника: " + r.getPerimeter() +
                "\nПлоща прямокутника: " + r.getSqare()+
                "\nДовжина діагоналі прямокутника: " + r.getDiagonal() + "\n\n");
    }
}