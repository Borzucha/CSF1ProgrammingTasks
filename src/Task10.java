import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task10 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in1 (10).txt"));

        int n = scan.nextInt(); // считать количество отрезков
        ArrayList<Line> lines = new ArrayList<>();

        // Считываем все отрезки из файла в список отрезков
        for (int i = 0; i < n; i++) {
            lines.add(new Line(scan.nextInt(), scan.nextInt()));
        }

        // Сортируем список отрезков по возрастанию
        Collections.sort(lines);

        int max = 0;
        ArrayList<Line> maxLines = new ArrayList<>();

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if(!lines.get(j).equals(lines.get(i)))
                    for (int k = 0; k < n; k++) {
                        if(!lines.get(j).equals(lines.get(k)) && !lines.get(i).equals(lines.get(k)))
                            if(!lines.get(i).overlap(lines.get(j)) && !lines.get(j).overlap(lines.get(k)) && !lines.get(i).overlap(lines.get(k))){
                                int current = lines.get(i).length() + lines.get(j).length() + lines.get(k).length();
                                if(current > max){
                                    max = current;
                                    maxLines.clear();
                                    maxLines.add(lines.get(i));
                                    maxLines.add(lines.get(j));
                                    maxLines.add(lines.get(k));
                                }
                            }
                    }
            }
        }
        Collections.sort(maxLines);

        JFrame frame = new JFrame();
        frame.setSize(150, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(maxLines.isEmpty()) {
            frame.add(new JLabel("Нет таких отрезков"));
        }
        else {
            frame.setLayout(new GridLayout(3, 1, 15, 15));
            for (Line line:maxLines){
                JLabel l = new JLabel(line.toString());
                frame.add(l);
                frame.pack();
            }
        }
        frame.setVisible(true);

    }

    // Вспомогательный класс, моделирующий отрезок
    public static class Line implements Comparable<Line>{
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // Длина отрезка
        public int length(){
            return end - start;
        }

        // Проверка на пересечение с другим отрезком
        public boolean overlap(Line other){
            return (start >= other.start && start <= other.end) || (end >= other.start && start <= other.end);
        }

        @Override
        public int compareTo(Line o) {  // Вводим линейный порядок (natural order) на множестве объектов "отрезок"
            if(start == o.start) return Integer.compare(end, o.end);
            else return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "{" + start + " " + end + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return start == line.start &&
                    end == line.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
