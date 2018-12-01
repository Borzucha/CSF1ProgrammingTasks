import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("x: ");
        double x = scan.nextDouble();
        System.out.print("n: ");
        int n = scan.nextInt();
        System.out.print("e: ");
        double e = scan.nextDouble();

        System.out.println("Сумма первых " + n + " членов: " + sumN(x, n)); // пункт 1
        System.out.println(String.format("Сумма тех членов из %s, которые больше %s по абсолютной величине: ", n, e) + sumBiggerThanE(x, n, e));

    }

    // Вычисление факториала
    public static int fact(int n) {
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul *= i;
        }
        return mul;
    }

    // N-ный член ряда
    public static double aN(double x, int n) {
        return Math.pow(Math.log(2), n-1) / fact(n-1) * Math.pow(x, n-1);
    }

    // Сумма N первых членов
    public static double sumN(double x, int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += aN(x, n);
        }
        sum += 1;

        return sum;
    }

    // Вычисление суммы слагаемых, больших по модулю, чем Е (определяется вводом)
    public static double sumBiggerThanE(double x, int n, double e) {
        double sum = 0;
        for (int i = 2; i <= n; i++) {
            if (Math.abs(aN(x, n)) > e)
                sum += aN(x, n);
        }
        sum += 1;

        return sum;
    }

    //sumBiggerThanE(5, 17, 4.56*0.1)
}
