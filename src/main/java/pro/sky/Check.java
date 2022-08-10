package pro.sky;

import pro.sky.exception.WrongLoginException;
import pro.sky.exception.WrongPasswordException;

public class Check {
    public static boolean checkCred(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        try {
            return checkPass(password, confirmPassword) && checkLogin(login);
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException(e.getMessage());
        } catch (WrongLoginException e) {
            throw new WrongLoginException(e.getMessage());
        }
    }

    private static boolean checkPass(String password, String confirmPassword) throws WrongPasswordException {
        if (!(checkSecurity(password) && checkSecurity(confirmPassword))) {
            throw new WrongPasswordException("Пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания, а также не должен превышать 20 символов");
        } else return password.equals(confirmPassword);
    }

    private static boolean checkLogin(String login) throws WrongLoginException {
        if (!checkSecurity(login)) {
            throw new WrongLoginException("Логин может содержать в себе только латинские буквы, цифры и знак подчеркивания, а также не должен превышать 20 символов");
        } else return true;
    }


    private static boolean checkSecurity(String logopass) {
        String regex = "^\\w{0,20}$";
        return logopass.matches(regex);
    }
}
