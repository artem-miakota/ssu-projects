public class Lab2 {
    private static final double P0 = 1.29;
    private static final double z = 0.000125;

     public static void main(String []args) {
        double P;
        for (int h = 0; h < 10000; h++) {
            P = P0 * Math.pow(Math.E, -1 * h * z);
            if (P < 1) {
                System.out.print("h = " + h + "  P = " + P + "\n");
                return;
            }
        }
     }
}
