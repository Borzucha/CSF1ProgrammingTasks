import java.util.*;

public class task4 {

    public static void main(String[] args) {

        // Считываем из stdin размер массива и его содержимое
        Scanner in = new Scanner(System.in);
        System.out.print("Длина массива: ");
        int N = in.nextInt();

        int[] arr = new int[N];
        int k = 0;
        System.out.print("Содержимое массива: ");

        while (k < N && in.hasNextInt())
            if (in.hasNextInt()) {
                arr[k] = in.nextInt();
                k++;
            }

        // Список для хранения чередующихся подотрезков
        List<IntervalCoord> intervals = new ArrayList<>();

        // Перебор всех подотрезков в массиве
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++) {
                if ((j - i + 1) % 2 == 0) {
                    if (checkForAlternation(arr, i, j)) {
                        intervals.add(new IntervalCoord(i, j));
                    }
                }
            }

        // Сортировать по размеру полученных подотрезков по возрастанию
        intervals.sort(Comparator.comparingInt(e -> e.getJ() - e.getI()));

        // Выбираем из списка подотрезков самые наибольшие
        // (они будут самыми правыми в списке из-за сортировки выше)
        List<IntervalCoord> maxIntervals = new ArrayList<>();
        for (int c = intervals.size() - 1; c >= 0; c--) {
            if (c > 0 && intervals.get(c).equals(intervals.get(c - 1))) {
                maxIntervals.add(intervals.get(c));
            } else {
                maxIntervals.add(intervals.get(c));
                break;
            }
        }

        // Сортируем по возрастанию по индексу начала подотрезка
        maxIntervals.sort(Comparator.comparing(IntervalCoord::getI));

        if (maxIntervals.size() > 1) {
            // Вывести индексы начала и конца второго по счету подотрезка
            System.out.println("Координаты начала и конца подотрезка: " + "[" + maxIntervals.get(1).getI() + ";" + maxIntervals.get(1).getJ() + "]");
            System.out.println("Подотрезок: " + stringifyInterval(arr, intervals.get(1).getI(), intervals.get(1).getJ()));
        } else if (maxIntervals.size() == 1) {
            System.out.println("Координаты начала и конца подотрезка: " + "[" + maxIntervals.get(0).getI() + ";" + maxIntervals.get(0).getJ() + "]");
            System.out.println("Подотрезок: " + stringifyInterval(arr, maxIntervals.get(0).getI(), maxIntervals.get(0).getJ()));
        } else {
            System.out.println("В массиве нет чередующихся последовательностей!");
        }

        in.close();
    }

    // Разбиение подотрезка на 2 половины и проверка равенства этих половин
    private static boolean checkForAlternation(int[] arr, int i, int j) {
        boolean good = false;
        int middle = (j - i + 1) / 2; // расстояние от начала до середины подотрезка
        for (int k = 0; k < middle; k++) {
            if (arr[i + k] == arr[i + middle + k])
                good = true;
            else {
                return false;
            }
        }
        return good;
    }

    // Выделение подотрезка из массива в виде строки
    private static String stringifyInterval(int[] arr, int i, int j) {
        StringBuilder interval = new StringBuilder();
        for (int k = i; k <= j; k++) {
            interval.append(arr[k]).append(" ");
        }
        return interval.toString();
    }

    // Вспомогательный класс для хранения начала и конца подотрезков
    private static class IntervalCoord {

        private int i;
        private int j;

        IntervalCoord(int i, int j) {
            this.i = i; // начало подотрезка
            this.j = j; // конец подотрезка
        }

        int getI() {
            return i;
        }

        int getJ() {
            return j;
        }

        // Провести сравнение по содержанию между двумя объектами
        @Override // говорит о том, что переопределяем метод, который уже есть в родителе
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntervalCoord that = (IntervalCoord) o;
            return this.j - this.i == that.j - that.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
