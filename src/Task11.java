import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task11 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("in.txt"));
        String text = scan.nextLine();
        String currentWord = "";
        String answer = "";
        for (int i = 0; i < text.length(); i++) {
            if(Character.isLetter(text.charAt(i))){
                currentWord += text.charAt(i);
            }else {
                for (int j = currentWord.length() - 1; j >= 0; j--){
                    answer += currentWord.charAt(j);
                }
                currentWord = "";
                answer += text.charAt(i);
            }
        }
        if(!currentWord.equals("")){
            for (int j = currentWord.length() - 1; j >= 0; j--){
                answer += currentWord.charAt(j);
            }
        }
        System.out.println(answer);
    }
}
