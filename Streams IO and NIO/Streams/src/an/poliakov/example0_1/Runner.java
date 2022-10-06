package an.poliakov.example0_1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Работа с байтовым потоком ByteArrayOutputStream\ByteArrayInputStream
 * Помогает при тестировании, что бы не создавать потоков/соединений
 * **/
public class Runner {
    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String str = "Файл File 123";

        try {
            // запись данных в массив (типо "фийл")
            output.write(str.getBytes());

            // первый способ считать данные (получение массива байт)
            byte[] bytes = output.toByteArray();
            for(int i = 0; i < bytes.length; i++){
                System.out.print((char) bytes[i]);
            }
            //второй способ считать данные (получения String)
            System.out.println(output.toString());

            //не закрывал поток
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
