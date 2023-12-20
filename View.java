package less3.hw3;

import java.util.Scanner;

public class View {
    public String getName(){
        System.out.println("Введите данные пользователя:");
        System.out.println("Фамилия, имя, отчество - строки");
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine().toLowerCase();
        String [] nameArr = data.split(" ");
        scan.close();
        if (nameArr.length != 3){
            throw new RuntimeException("Неверно ввели ФИО");
        }
        String firstName = nameArr[0];
        String lastName = nameArr[1];
        String patronymic = nameArr[2];
        if (!firstName.matches("[a-zA-Zа-яА-Я ]+") || !lastName.matches("[a-zA-Zа-яА-Я ]+") || !patronymic.matches("[a-zA-Zа-яА-Я ]+")) {
            throw new RuntimeException("Ввели не только строчные символы");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append(" ");
        sb.append(patronymic);
        sb.append(" ");
        return sb.toString();
    }

    public String dateOfBirth() {
        System.out.println("Введите данные пользователя:");
        System.out.println("Дата рождения - строка формата dd.mm.yyyy");
        Scanner scan = new Scanner(System.in);
        String data1 = scan.nextLine();
        scan.close();
        String [] data = data1.split(".");
        int day = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
        if (1900 > year || year > 2023) {
            throw new RuntimeException("Введите корректный год");
        }
        if (month > 12 || month < 1) {
            throw new RuntimeException("Введите корректный месяц");
        }
        if (day > 31 || day < 1) {
            throw new RuntimeException("Введите корректный день");
        }
        if (day > 31 && month == 1 || day > 31 && month == 3 || day > 31 && month == 5 || day > 31 && month == 7 || day > 31 && month == 8 || day > 31 && month == 10 || day > 31 && month == 12) {
            throw new RuntimeException("в " + month + " месяце не более 31 дня");
        }
        if (day > 30 && month == 4 || day > 30 && month == 6 || day > 30 && month == 9 || day > 30 && month == 11) {
            throw new RuntimeException("в " + month + " месяце не более 30 дней");
        }
        if (month == 2 && year % 4 == 0 && year / 4 % 100 != 0 && day > 29) {
            throw new RuntimeException("в феврале " + year + " года 29 день");
        }
        if (month == 2 && (year % 4 != 0 || (year % 4 != 0 && year / 4 % 100 != 0)) && day > 28) {
            throw new RuntimeException("в феврале " + year + " года  28 дней");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(day);
        sb.append(".");
        sb.append(month);
        sb.append(".");
        sb.append(year);
        sb.append(". ");

        return sb.toString();
    }
    public String getNum() {
        System.out.println("Введите данные пользователя:");
        System.out.printf("Номер телефона - целое беззнаковое число без форматирования");
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        scan.close();
        try {
            int num = Integer.parseInt(data);
        } catch (RuntimeException e) {
            System.out.println("Введите номер телефона без других символов и пробелов.");
        }
        return data;
    }
    public String sex() {
        System.out.println("Введите данные пользователя:");
        System.out.println("Пол - символ латиницей f (женский) или m (мужской)");
        Scanner scan = new Scanner(System.in);

        String data = scan.nextLine();
        scan.close();
        if (!data.equals("m") && !data.equals("f")) {
            throw new RuntimeException("Укажите пол 1 символом m или f");
        }
        return data;
    }
}
