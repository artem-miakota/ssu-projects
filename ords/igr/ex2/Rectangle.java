package ex2;

public class Rectangle implements Shape {
    private double xr, xl, yt, yb;
    
    public Rectangle(double xl, double xr, double yt, double yb) {
        if (xl == xr || yt == yb) {
            System.out.println("Прямокутника з такими координатами не існує\n");
            System.exit(0);
        }
        
        if (xl < xr) {
            this.xl = xl;
            this.xr = xr;
        } else {
            this.xl = xr;
            this.xr = xl;
        }
        if (yb < yt) {
            this.yb = yb;
            this.yt = yt;
        } else {
            this.yb = yt;
            this.yt = yb;
        }
    }
    
    public double getXR() {
        return xr;
    }

    public double getXL() {
        return xl;
    }

    public double getYT() {
        return yt;
    }

    public double getYB() {
        return yb;
    }

    @Override
    public double getSqare() {
        return (yt - yb) * (xr - xl);
    }

    @Override
    public double getPerimeter() {
        return 2 * (yt - yb + xr - xl);
    }

    @Override
    public double getDiagonal() {
        return Math.sqrt(Math.pow(yt - yb, 2) + Math.pow(xr - xl, 2));
    }
    
}