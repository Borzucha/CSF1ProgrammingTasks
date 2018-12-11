import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task9 {

    public static int[][] first;
    public static int[][] second;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in39 (1).txt"));

        first = scanArray(scan);
        second = scanArray(scan);

        int x = -1, y = -1;
        boolean found = false;
        // Выделяем в первом массиве подмассив с ячейками-кандидатами на успешное наложение второго массива. Заведомо невозможные ячейки отбрасываются.
        for (int i = 0; i < first.length - second.length + 1; i++) {
            if(found) break;
            for (int j = 0; j < first[0].length - second[0].length + 1; j++) {
                // Перебираем все ячейки выделенного подмассива, тестируя на равенство с левым верхним углом второго массива (ищем ячейки-кандидаты)
                if(first[i][j] == second[0][0]) {
                    // Проверяем, можно ли в данной точке-кандидате успешно наложить второй массив
                    if(check(i, j)) {
                        y = i;
                        x = j;
                        found = true;
                        break;
                    }
                }
            }
        }

        // Рисуем простенький GUI на Swing для отображения ответа
        JFrame frame = new JFrame();
        frame.setSize(250, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        if(x == -1) frame.add(new JLabel("Нельзя поместить"));
        else {
            frame.setLayout(new GridLayout(3, 1, 10, 10));
            frame.add(new JLabel("Можно поместить:"));
            frame.add(new JLabel("x = " + (x + 1)));
            frame.add(new JLabel("y = " + (y + 1)));
        }

        frame.setVisible(true);
    }

    // Функция считывания из файла
    private static int[][] scanArray(Scanner scan){
        // Счиитываем количество строк
        int y = scan.nextInt();
        // Считываем количество столбцов
        int x = scan.nextInt();
        // Создаём массив указанных размеров
        int[][] array = new int[y][x];
        // Заполняем этот массив числами из файла
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        return array;
    }


    // Фунция проверки успешного наложения второго массива в заданной точке
    private static boolean check(int y, int x){
        for (int i = 0; i < second.length; i++){
            for (int j = 0; j < second[0].length; j++) {
                if(first[i + y][j + x] != second[i][j]) return false;
            }
        }
        return true;
    }
}
