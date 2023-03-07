import java.util.Scanner;

public class MineSweeper {
    int satir;
    int sutun;
    int bomba;
    int[][] sayilar;
    String[][] bombaTarlasi;
    String[][] girisTarlasi;
    int satirgirdisi;
    int sutungirdisi;
    boolean don = true;

    public MineSweeper(int satir, int sutun) {
        this.satir = satir;
        this.sutun=sutun;
        this.bomba=(satir*sutun)/4;
        this.sayilar=new int[satir][sutun];
        this.bombaTarlasi=new String[satir][sutun];
        this.girisTarlasi=new String[satir][sutun];
        fill(this.bombaTarlasi);
        fill(this.sayilar);
        fill(this.girisTarlasi);
        randomAta(this.bombaTarlasi);
        sayiYerlestir();
        oyna();


    }
    public String[][] fill(String[][] dizi){
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
                dizi[i][j] = "-";
            }
        }
        return dizi;
    }
    public int[][] fill(int[][] dizi){
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
               dizi[i][j] = 0;
            }
        }
        return dizi;
    }

    public String[][] randomAta(String[][] dizi){
        for (int i = 0; i < this.bomba; i++) {

            int random1 = (int) (Math.random() * this.satir);
            int random2 = (int) (Math.random() * this.sutun);
            if (dizi[random1][random2].equals("*")) {
                i--;
            } else {
                dizi[random1][random2] = "*";
            }
        }
        for (int i = 0; i < this.satir; i++) {
            for (int j = 0; j < this.sutun; j++) {
                System.out.print(dizi[i][j]);
            }
            System.out.println();
        }
        return dizi;
    }

    Scanner input=new Scanner(System.in);
    public void oyna(){
        do {
            System.out.print("Satır giriniz:");
            this.satirgirdisi = input.nextInt();
            System.out.print("Sütun giriniz:");
            this.sutungirdisi = input.nextInt();
            if (this.satirgirdisi >= this.satir || this.sutungirdisi >= this.sutun || this.satirgirdisi < 0 || this.sutungirdisi < 0) {
                System.out.println("Lütfen oyunun içinde bir değer giriniz!");

            } else if (this.bombaTarlasi[this.satirgirdisi][this.sutungirdisi].equals("*")) {
                System.out.println("Game Over!");
                break;


            } else {
                int count = 0;
                this.girisTarlasi[this.satirgirdisi][this.sutungirdisi] = String.valueOf(this.sayilar[this.satirgirdisi][this.sutungirdisi]);
                System.out.println("==============");
                for (int i = 0; i < this.satir; i++) {
                    for (int j = 0; j < this.sutun; j++) {
                        System.out.print(this.girisTarlasi[i][j] + " ");
                        if(this.girisTarlasi[i][j].equals("-")) count++;
                    }
                    System.out.println();
                }

                if (count == this.bomba) {
                    System.out.println("Oyunu kazandınız!!!");
                    for (int intt= 0; intt < this.satir; intt++) {
                        int jint;
                        for (jint = 0; jint < this.sutun; jint++) {
                            System.out.print(this.girisTarlasi[intt][jint] + " ");

                        }
                        System.out.println();
                    }
                    break;
                }

            }



        } while (this.don);
    }

public void sayiYerlestir(){
    for (int i = 0; i < this.satir; i++) {
        for (int j = 0; j < this.sutun; j++) {
            if (this.bombaTarlasi[i][j].equals("*") && i == 0 && j == 0) {

                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    //continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;
                }
                if (!this.bombaTarlasi[i + 1][j + 1].equals("*")) {
                    this.sayilar[i + 1][j + 1] = this.sayilar[i + 1][j + 1] + 1;
                }
                if (!this.bombaTarlasi[i + 1][j].equals("*")) {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;
                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i == 0 && j > 0 && j < this.sutun - 1 && this.sutun != 2) {
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j - 1] = this.sayilar[i + 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;

                }
                if (this.bombaTarlasi[i + 1][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j + 1] = this.sayilar[i + 1][j + 1] + 1;

                }
                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;

                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i == 0 && j == this.sutun - 1) {
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j - 1] = this.sayilar[i + 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;

                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i > 0 && i < (this.satir - 1) && j == 0 && this.satir != 2) {
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
                if (this.bombaTarlasi[i - 1][j + 1].equals("*")) {
                    //  continue;
                } else {
                    this.sayilar[i - 1][j + 1] = this.sayilar[i - 1][j + 1] + 1;

                }
                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    //  continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;

                }
                if (this.bombaTarlasi[i + 1][j + 1].equals("*")) {
                    // continue;
                } else {
                    this. sayilar[i + 1][j + 1] = this.sayilar[i + 1][j + 1] + 1;

                }

            }
            if (this.bombaTarlasi[i][j].equals("*") && i == this.satir - 1 && j == 0) {
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    //  continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
                if (this.bombaTarlasi[i - 1][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j + 1] = this.sayilar[i - 1][j + 1] + 1;

                }
                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;

                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i == this.satir - 1 && j > 0 && j < this.sutun - 1 && this.sutun != 2) {
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i - 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j - 1] = this.sayilar[i - 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
                if (this.bombaTarlasi[i - 1][j + 1].equals("*")) {
                    //continue;
                } else {
                    this.sayilar[i - 1][j + 1] = this.sayilar[i - 1][j + 1] + 1;

                }
                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;

                }

            }
            if (this.bombaTarlasi[i][j].equals("*") && i == this.satir - 1 && j == this.sutun - 1) {
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i - 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j - 1] = this.sayilar[i - 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i < this.satir - 1 && i > 0 && j == this.sutun - 1 && this.satir != 2) {
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
                if (this.bombaTarlasi[i - 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j - 1] = this.sayilar[i - 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j - 1] = this.sayilar[i + 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j].equals("*")) {
                    //continue;
                } else {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;

                }
            }
            if (this.bombaTarlasi[i][j].equals("*") && i > 0 && j > 0 && i < this.satir - 1 && j < this.sutun - 1 && this.satir != 2 && this.sutun != 2) {
                if (this.bombaTarlasi[i - 1][j - 1].equals("*")) {
                    //  continue;
                } else {
                    this.sayilar[i - 1][j - 1] = this.sayilar[i - 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i - 1][j].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i - 1][j] = this.sayilar[i - 1][j] + 1;

                }
                if (this.bombaTarlasi[i - 1][j + 1].equals("*")) {
                    //  continue;
                } else {
                    this.sayilar[i - 1][j + 1] = this.sayilar[i - 1][j + 1] + 1;

                }
                if (this.bombaTarlasi[i][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j - 1] = this.sayilar[i][j - 1] + 1;

                }
                if (this.bombaTarlasi[i][j + 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i][j + 1] = this.sayilar[i][j + 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j - 1].equals("*")) {
                    // continue;
                } else {
                    this.sayilar[i + 1][j - 1] = this.sayilar[i + 1][j - 1] + 1;

                }
                if (this.bombaTarlasi[i + 1][j].equals("*")) {
                    //continue;
                } else {
                    this.sayilar[i + 1][j] = this.sayilar[i + 1][j] + 1;

                }
                if (this.bombaTarlasi[i + 1][j + 1].equals("*")) {
                    //continue;
                } else {
                    this.sayilar[i + 1][j + 1] = this.sayilar[i + 1][j + 1] + 1;

                }

            }


        }

    }
    for (int i = 0; i < this.satir; i++) {
        for (int j = 0; j < this.sutun; j++) {
            System.out.print(this.sayilar[i][j]);
        }
        System.out.println();
    }
}









}
