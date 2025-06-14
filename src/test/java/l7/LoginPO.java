package l7;

import static com.codeborne.selenide.Selenide.$;

public class LoginPO {

    public void loginWithPassportAndCard(){

    }

    public void loginWithUsernameAndPassword(String username, String password){
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("#submit").click();
    }
}
