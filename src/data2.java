import java.util.Scanner;

public class data2 {

    public static String typeDay(int date, int month){
        String Calendar = "";
        switch(month){
            case 1: if ((date == 1) || (date == 8) || (date == 13) || (date == 14) || (date == 20)
                    || (date == 21) || (date == 27) || (date == 28))Calendar= "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 2: if ((date == 3) || (date == 4) || (date == 10) || (date == 11) || (date == 17) ||
                    (date == 18) || (date == 23) || (date == 24) || (date == 25)) Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 3: if ((date == 3) || (date == 4) || (date == 8) || (date == 9) || (date == 10) || (date == 11) ||
                    (date == 17) || (date == 18) || (date == 24) || (date == 25) || (date == 31)) Calendar ="Выходной день";
            else Calendar = "Рабочий день"; break;

            case 4: if ((date == 1) || (date == 7) || (date == 8) ||  (date == 14) || (date == 15) || (date == 21) ||
                    (date == 22) ||  (date == 29) || (date == 30))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 5: if ((date == 1) || (date == 2) || (date == 5) || (date == 6) || (date == 12) || (date == 13) ||
                    (date == 19) || (date == 20) || (date == 26) || (date == 27))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 6: if ((date == 2) || (date == 3) || (date == 10) || (date == 11) || (date == 12) || (date == 16) ||
                    (date == 17) || (date == 23) || (date == 24) || (date == 30))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 7: if ((date == 1) || (date == 7) || (date == 8) || (date == 14) || (date == 15) || (date == 21) ||
                    (date == 22) || (date == 28) || (date == 29))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 8: if ((date == 4) || (date == 5) || (date == 11) || (date == 12) || (date == 18) || (date == 19) ||
                    (date == 25) || (date == 26))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 9: if ((date == 1) || (date == 2) || (date == 8) || (date == 9) || (date == 15) || (date == 16) ||
                    (date == 22) || (date == 23) || (date == 29) || (date == 30))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 10: if ((date == 6) || (date == 7) || (date == 13) || (date == 14) || (date == 20) || (date == 21) ||
                    (date == 27) ||  (date == 28)) Calendar= "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 11: if ((date == 3) ||  (date == 4) || (date == 10) || (date == 11) || (date == 17) || (date == 18) ||
                    (date == 24) || (date == 25))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;

            case 12: if ((date == 1) ||  (date == 2) || (date == 8) || (date == 9) || (date == 15) || (date == 16) ||
                    (date == 22) || (date == 23) || (date == 30) || (date ==31))Calendar = "Выходной день";
            else Calendar = "Рабочий день"; break;


        }
        return Calendar;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Введите дату: ");
        int data = scn.nextInt();
        System.out.print("Введите месяц: ");
        int month = scn.nextInt();

        String Day = typeDay(data, month);

        System.out.println(data + "." + month + " это " + Day);
    }
}