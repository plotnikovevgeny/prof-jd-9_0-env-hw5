package pro.sky;

import pro.sky.exception.WrongLoginException;
import pro.sky.exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        boolean check = Check.checkCred("java_skyprogo", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        System.out.println(check);
    }
}