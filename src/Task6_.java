import java.util.Scanner;

public class Task6_ {

    public static void main(String[] args) {
        // Создаем считыватель с консоли
        Scanner scan = new Scanner(System.in);

        // Из-за русскоязычной локали дробые числа пишем через запятую!!!!!!!!!1

        // Считываем значение функции в точке
        double x = scan.nextDouble();
        // Считываем количество членов ряда
        int n = scan.nextInt();
        // Считываем константу, с которой будем сравнивать члены ряда
        double e = scan.nextDouble();

        System.out.println("1. " + calculateRight(x, n, -1));
        System.out.println("2. " + calculateRight(x, n, e));
        System.out.println("3. " + calculateRight(x, n, e/10));
        System.out.println("4. " + calculateLeft(x));
    }

    private static double calculateLeft(double x){
        return Math.pow(2, x);
    }

    private static double calculateRight(double x, double n, double e){
        double sum = 0;
        for (int i = 0; i < n; i ++){
            double s = Math.pow(Math.log(2), i)/factorial(i) * Math.pow(x, i);
            if(s > e) {
                sum += s;
            }
        }
        return sum;
    }

    private static long factorial(long a){
        if(a <= 1) return 1;
        return a * factorial(a - 1);
    }
}

