import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task8 {

    public static void main(String[] args) throws FileNotFoundException {
        // Считываем исходный список из файла
        Scanner scan = new Scanner(new File("in1.txt"));

        // Прочитать список из файла в List
        ArrayList<Integer> list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.nextInt());
        }

        // Проходим по списку и добавляем в мапу пары "число->количество повторений числа в списке"
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i:list){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }

        // Создаем список из всех пар значений в мапе
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        // Сортируем его по количеству повторений чисел в списке по убыванию
        lst.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        // Создаём список чисел, попадающих в ответ
        ArrayList<Integer> ans = new ArrayList<>();
        // Запоминаем количество повторений для первого числа с максимальным количеством повторений
        int max = lst.get(0).getValue();
        // Добавляем это число в список ответов
        ans.add(lst.get(0).getKey());
        // Проходим по списку пар и забираем в ответ только те числа, количество повторений которых совпадает с максимальным
        for (int i = 1; i < lst.size(); i++){
            if(max == lst.get(i).getValue()) {
                ans.add(lst.get(i).getKey());
            } else break;
        }
        // Сортируем список ответов по возрастанию
        ans.sort(Comparator.naturalOrder());
        System.out.println(ans);
    }
}


