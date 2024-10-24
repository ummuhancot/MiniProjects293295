package LoginPageApp;

import java.util.*;

//3-adım: userla ilgisi methodlar
public class UserServic {

    public Scanner scanner = new Scanner(System.in);

    //List<User> users = new ArrayList<>(); --> practice oldugu için
    //ders sonrası dene

    //burada data tipleri sırasıyla key ve value ların data tipini belirtir,
    // biz map içinde kullanıcının email ve passwordlerini tutacağız, her ikisinin data
    // tipide String olduğu için ikisini de String olarak seçtik. Bu mapin ismini de userInfo olarak belirledik

    public Map<String,String> userInfo = new HashMap<>(); //k:email, v:password

    //4-adım: üye olma işlemi
    public  void  register(){
        System.out.println("Ad-Soyad giriniz : ");
        String name = scanner.nextLine();

        //email geçerlimi mi ? geçersizese tekrar sorulmalı

        String email;
        boolean isValid;//T:geçerli F:geçerli değil


        do {
            System.out.println("Email giriniz : ");
            email = scanner.nextLine();

            //geçerli mi
            isValid = validateEmail(email);//true , false

            //email unique olmalı benzersiz olmalı yani:bu imail ile daha önce kayıtlı kullanıcı var mı
            //map i kontrol ederiz
            boolean isEstEmail = this.userInfo.containsKey(email);//map i kontrol ederiz T veya F döndürücek
            if (isEstEmail){
                System.out.println("Bu email ile kayıtlı kullanıcı zaten var !");
                isValid=false;//tekrar başa dönmesi için yazdık
            }




        }while (!isValid);//geçerli değilse döngüye devam et

        //geçerli bir şifre oluşturma
        String password;
        boolean isValidPassword;

        do {
            System.out.println("Şifrenizi oluşturunuz : ");
            password = scanner.nextLine();

            validatePassword(password);

            isValidPassword = validatePassword(password);
            //unik olmasına gerek yok benzersiz olmasına gerek yok



        } while (!isValidPassword);

        //user oluşturalım
        User user = new User(name,password,email);
        System.out.println(user.getEmail());

        //userin bilgilerini userInfo ya ekleyelim

        this.userInfo.put(user.getEmail(),user.getPassword());
        System.out.println(this.userInfo.containsKey(email));

        System.out.println("Sayın " + user.getName() + ", tebrikler, kayıt işlemi başarıyla gercekleşti");
        System.out.println("Email ve sifrenizi kullanarak sisteme giriş yapabilirsiniz.");

    }

    //7-adım: giriş işlemi için method tamamlama

    public void login(){
        System.out.println("Email giriniz : ");
        String email = scanner.nextLine();//asd@gmail.com

        //kullanıcı kayıdı var mı
        System.out.println(email);
        System.out.println(this.userInfo.containsKey(email));

        if(this.userInfo.containsKey(email)){//kullanıcı varsa
            //şifre soralım

            //şifre için hak verildi
            boolean isSuccess = false;//başarılı
            int counter = 3;

            while (!isSuccess && counter > 0){
                System.out.println("Şifrenizi giriniz : ");
                String password = scanner.nextLine();

                //email ile şifre eşleşiyor mu kontrol eder
                if (this.userInfo.get(email).equals(password)){
                    //giriş başarılı
                    System.out.println("Harika, sisteme giriş yaptınız. Hoşgeldiniz :)");
                    isSuccess = true; //doğru girişte döngüyü burası kırdı
                } else {
                    //şifre yanlış
                    counter--;//2-1-0
                    if (counter == 0){
                        System.out.println("3 kez hatalı giriş yaptınız! Ana menüye yönlendiriliyorsunuz!");
                    } else {
                        System.out.println("Şifreniz yanlız, tekrar deneyiniz, kalan hakkınız : " + counter);
                    }
                }




            }



        } else {//kullanıcı yoksa
            System.out.println("Sisteme bu email ile kayıtlı kullanıcı bulunamadı.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, değilseniz üye olunuz!");
        }



    }


    //5-adım:email doğrulama metodu:ÖDEVV
    private boolean validateEmail(String email){
       //email geçersizse hata mesajı ver
        boolean isValid = true;

        boolean hasSpace = email.contains(" ");
        boolean hasAtSymbol = email.contains("@");

        if (hasSpace){
            System.out.println("Email boşluk içeremez!");
            isValid = false;
        } else if (!hasAtSymbol){
            System.out.println("Email @ sembolü içermelidir!");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String seconPart = email.split("@")[1];

            boolean isExistsInvalidChar = firstPart.
                    replaceAll("[A-Za-z0-9-._]", "").length()>0;//* ? /

            boolean isValidDomain = seconPart.equals("gmail.com") ||
                                    seconPart.equals("yahoo.com") ||
                                    seconPart.equals("hotmail.com");
            if (isExistsInvalidChar){
                System.out.println("Email kullanıcı adı harf, rakam ve -._ dışında karakter içeremez!");
                isValidDomain = false;
            } else if (!isValidDomain){
                System.out.println("Sisteme sadece gmail, yahoo ve hotmail ile kayıt olabilirsiniz.");
                isValid = false;
            }


        }

        if (!isValid){
            System.out.println("Geçersiz email, tekrar deneyiniz");
        }



        return isValid;//isvalid true ise false ise
    }

    //6-adım:password doğrulama metodu:ÖDEVV
    private boolean validatePassword(String password){
        return true;
    }



}
