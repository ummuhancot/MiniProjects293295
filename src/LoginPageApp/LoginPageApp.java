package LoginPageApp;
/*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
                             email ve şifre birer listede tutulur.
                             aynı email kabul edilmez.

         giriş(login): email ve şifre girilir.
                       email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
*/


import java.util.Scanner;

public class LoginPageApp {
    public static void main(String[] args) {

        start();


    }

    //1-adım:

    private static void start(){

        Scanner scanner = new Scanner(System.in);

        UserServic userServic = new UserServic();
        int select; //çıkış için 0 seçiniz



        //menü tekrar tekrar sunucaz

        do {
            System.out.println("=== TECHPRO EDUCATİON ===");
            System.out.println("1 - Üye ol");
            System.out.println("2 - Giriş yap");
            System.out.println("0 - ÇIKIŞ");
            System.out.println("Seçiminiz : ");
            select = scanner.nextInt();//0,1,2

            switch (select){
                case 1:
                    //üye olma
                    userServic.register();

                    break;
                case 2:
                    //giriş yap
                    userServic.login();
                    break;
                case 0:
                    System.out.println("İyi günler dileriz :) ");
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız, tekrar deneyiniz!");
                    break;
            }


        } while (select != 0);


    }




}
