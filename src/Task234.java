package com.company;

import java.util.Scanner;

public class Task234 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w=in.nextInt();
        for (int i=0;i<w;i++)
            System.out.print("*");
        System.out.println();
        for(int i=w/2;i>0;i--){
            for (int j=0;j<i;j++)
                System.out.print("*");
            for (int j=0;j<w-2*i;j++)
                System.out.print(" ");
            for (int j=0;j<i;j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
