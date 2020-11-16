package ru.sapteh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DatabaseMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите дату экзамена: ");
        System.out.println("Введите корректную дату начала экзамена. Пример: 12.12.2012");
        String a = reader.readLine();
        DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = dateFormat1.parse(a);
        int quantityDay = (int)(( date1.getTime()- date.getTime())/1000/24/60/60) ;
        String result = switch (date1.compareTo(date)) {
            case 0 -> "Экзамен сегодня";
            case 1 -> "Остался " + Math.abs(quantityDay) + " день до экзамена";
            case -1 -> "Экзамен был " + Math.abs(quantityDay) + strEx(quantityDay) + " назад";
            default -> "Not input";
        };
        System.out.println(result);
    }
    public static String strEx(int quantityDay ){
       quantityDay = quantityDay % 10;
       return switch (Math.abs(quantityDay)){
           case 1 -> " День";
           case 2,3,4 -> "дня";
           default -> " дней";

       };

    }
}






