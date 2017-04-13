package lab2;

public class Lab2 {
    public static void main(String[] args) {
        double S = 0;  // загальний шлях
        double N = 10; // дення норма
        int D = 10;    //кількість днів
        
        for (int i = 0; i < D; i++) {
            S += N;
            N *= 1.1;  // збільшуємо на щоденний шлях на 10%
        }
        System.out.print("Спортсмен пробіжить " + S + " км за " + D + " днів\n");
    }
}