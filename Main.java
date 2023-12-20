package less3.hw3;


import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        View v = new View();
        String name = v.getName();
        String dateOfBirth = v.dateOfBirth();
        String numTel = v.getNum();
        String sex = v.sex();
        String personData = name + dateOfBirth + " " + numTel + " " + sex;
        String [] fio = name.split(" ");
        String fileName = fio[0];
        String filePath = "D:\\study\\exception\\exception\\src\\less3\\hw3\\data\\" + fileName + ".txt";
        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(personData + "\n");
            System.out.println("Данные  { " + personData + "} записаны в файл" + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
