package LoginPageApp;

//2-adım:user nesnesini oluşturalım


//POJO:Plain Old Java Object bir objenin datalarını taşıyan kılaslara dicez
//field:private
//constructor
//getter-setter
//toString

public class User {

    //ad-soyad, username(email), password

    private String name;//null varsayılan değer
    private String email;//null
    private String password;//null


    // user oluşturuldugunda fieldlarının set edilmesi için: parametreli constacter oluşturucak

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    //gettir-setter


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*//3-adım:uye olma methodu
    public void register(){

    }*/

}
