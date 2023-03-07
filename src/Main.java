import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int satir, sutun;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Satır sayısını giriniz:");
            satir = input.nextInt();
            System.out.print("Sütün sayısını giriniz:");
            sutun = input.nextInt();
        } while (satir < 0 || sutun < 0);
        MineSweeper mayin= new MineSweeper(satir,sutun);
}}
