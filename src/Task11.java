import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in.txt"));
        String text = scan.nextLine();
        String currentWord = "";
        String answer = "";

        // Читаем всю строку посимвольно в цикле от начала до конца
        for (int i = 0; i < text.length(); i++) {
            // Если символ - буква, то добавляем его в переменную накопитель "текущего слова"
            if(Character.isLetter(text.charAt(i))){
                currentWord += text.charAt(i);
            }
            // Если дошли до небуквенного символа, то развернуть подстроку-слово в currentWord
            else {
                for (int j = currentWord.length() - 1; j >= 0; j--){
                    answer += currentWord.charAt(j);
                }
                currentWord = "";
                answer += text.charAt(i);
            }
        }
        // Если в currentWord осталось недоразвернутое слово - развернуть и конкатенировать со строкой-результатом
        if(!currentWord.equals("")){
            for (int j = currentWord.length() - 1; j >= 0; j--){
                answer += currentWord.charAt(j);
            }
        }
        System.out.println(answer);
    }
}
