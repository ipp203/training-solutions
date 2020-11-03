package stringtype.registration;

public class UserValidator {
    public boolean isValidUserName(String username){
        return username.length() > 0;
    }
    public boolean isValidPassword(String password1,String password2){
        return (password1.equals(password2) && (password1.length() >= 8));
    }
    public boolean isValidEmail(String email){
        int atPos = email.indexOf("@");
        int pointPos = email.indexOf(".",atPos);
        return ( atPos > 0) && (pointPos > 0) && (atPos + pointPos < email.length());
    }
}
