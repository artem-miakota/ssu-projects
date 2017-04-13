import java.util.Scanner;

public class Ex2{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Set circle center x: ");
        double x = scanner.nextDouble();
        System.out.print("Set circle center y: ");
        double y = scanner.nextDouble();
        System.out.print("Set circle radius: ");
        double r = scanner.nextDouble();
        System.out.print("Set point x: ");
        double px = scanner.nextDouble();
        System.out.print("Set point y: ");
        double py = scanner.nextDouble();
        
        Circle c = new Circle(new Point(x, y), r);
        Point point = new Point(px, py);

        System.out.println("\nCircle square: " + c.getSquare() +
        "\nCircle perimeter: " + c.getPerimeter() +
        "\nDistance from (" + point.getX() + ", " + point.getY() + ") to circle center: " + c.getDistance(new Point(0, 0)));
    }
}
