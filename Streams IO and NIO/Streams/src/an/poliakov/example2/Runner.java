package an.poliakov.example2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src/an/poliakov/filesForTests/basicFile.txt");
             FileOutputStream fos = new FileOutputStream("src/an/poliakov/filesForTests/fileOutput.txt")){

            byte [] b = new byte[fis.available()];
            int i;
            while((i = fis.read(b)) != -1){
                fos.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
