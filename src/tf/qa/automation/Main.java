package tf.qa.automation;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Введите номер телефона:");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        sc.close();
        phoneCheck(phone);
    }

    public static void phoneCheck(String phone){
        String spacebr = "В номере есть пробелы и/или скобки";
        String wrongN="Введен некорректный номер";
        String replace = "Замена +7 на 8";
        String overfloat="Количество символов больше 11";
        String small="Количество символов менее 11";
        String check="Список изменений и сработавших проверок на некорректность: ";
        int x=phone.length();

        phone = phone.replace("+7", "8");

        if(phone.length()!=x) { // если замена сработала
            int y=phone.length();
            phone = phone.replace("(", "");
            phone = phone.replace(")", "");
            phone = phone.replace(" ", "");
            if(phone.length()!=y) { // если скобки были
                if(phone.length()==11) {
                    System.out.println(phone);
                    System.out.println(check +replace +";"+ spacebr); //"Замена +7 на 8";"В номере есть пробелы и/или скобки";
                }
                else {
                    System.out.println(wrongN); //"Введен некорректный номер";
                    if(phone.length()>11) {
                        System.out.println(overfloat); //>11;
                    }
                    else {
                        System.out.println(small); // <11
                    }
                }
            }
            else { // если скобок не было
                if(phone.length()==11) {
                    System.out.println(phone);
                    System.out.println(check + replace); //"Замена +7 на 8";
                }
                else {
                    System.out.println(wrongN); //"Введен некорректный номер";
                    if(phone.length()>11) {
                        System.out.println(overfloat); //>11;
                    }
                    else {
                        System.out.println(small); // <11
                    }
                }
            }
        }
        else { // если замена +7 на 8 не сработала
            phone = phone.replace("(", "");
            phone = phone.replace(")", "");
            phone = phone.replace(" ", "");

            if(phone.length()!=x) { // если сработала замена скобок

                if(phone.length()==11) {// если были скобки и не было +7 и номер введен верно
                    System.out.println(phone);
                    System.out.println(check + spacebr);// "В номере есть пробелы и/или скобки"
                }
                else {
                    System.out.println(wrongN); //"Введен некорректный номер";
                    if(phone.length()>11) {
                        System.out.println(overfloat); //>11;
                    }
                    else {
                        System.out.println(small); // <11
                    }
                }
            }
            else{ // если ни одна замена не сработала
                if(phone.length()==11) {
                    System.out.println(phone); // изначально корректный номер
                    System.out.println(check + "Не было изменений");
                }
                else{
                    if(phone.length()<11) {
                        System.out.println(wrongN); //"Введен некорректный номер";
                        System.out.println(small); //<11
                    }
                    else{
                        System.out.println(wrongN); //"Введен некорректный номер";
                        System.out.println(overfloat); //>11;
                    }
                }
            }
        }


    }
}

