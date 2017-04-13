public class Circle implements Shape {
    private double r;
    private Point center;
    
    public Circle() {
        center = new Point(0, 0);
        r = 0;
    }
    
    public Circle(Point p, double r) {
        this.center = p;
        this.r = r;
    }
    
    public Point getCenter() {
        return center;
    }
    
    public double getRadius() {
        return r;
    }
    
    // get distance between center and specific point
    public double getDistance (Point p) {
        return Math.pow(Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() - center.getY(), 2), 0.5);
    }
    
    public double getSquare() {
        return Shape.PI * Math.pow(r, 2);
    }
    
    public double getPerimeter() {
        return 2 * Shape.PI * r;
    } 
}