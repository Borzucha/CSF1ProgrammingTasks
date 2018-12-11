import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in1.txt"));

        ArrayList<Integer> list = new ArrayList<>();
        while (scan.hasNext()){
            list.add(scan.nextInt());
        }
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i:list){
            if(map.containsKey(i)) map.replace(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        lst.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        ArrayList<Integer> ans = new ArrayList<>();
        int max = lst.get(0).getValue();
        ans.add(lst.get(0).getKey());
        for (int i = 1; i < lst.size(); i++){
            if(max == lst.get(i).getValue()) {
                ans.add(lst.get(i).getKey());
            } else break;
        }
        ans.sort(Comparator.naturalOrder());
        System.out.println(ans);
    }
}
