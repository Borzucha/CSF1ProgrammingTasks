import java.util.Scanner;

public class task5 {

    public static void main(String[] args) {
        int h;
        Scanner scr = new Scanner(System.in);
        h=scr.nextInt();
        for (int i=0; i<h;i++) {
            if (i<h/2) {
                for (int j = 0; j < i; j++)
                    System.out.print(" ");
                for (int j = 0; j < i + 1; j++)
                    System.out.print(j);
                for (int j = 0; j < 2 * (h - 1) + 1 - 2 * (2 * i + 1); j++)
                    System.out.print(i);
                for (int j = i; j >= 0; j--)
                    System.out.print(j);
                System.out.println();
            }else if(i==h/2){
                for (int j = 0; j < i; j++)
                    System.out.print(" ");
                for(int j=0;j<h/2;j++)
                    System.out.print(j);
                for(int j=h/2;j>=0;j--)
                    System.out.print(j);
                System.out.println();
            }else{
                for (int j = 0; j < i; j++)
                    System.out.print(" ");
                for (int j=0;j<h-i;j++)
                    System.out.print(j);
                for (int j=h-i-2;j>=0;j--)
                    System.out.print(j);
                System.out.println();
            }
        }
    }
}