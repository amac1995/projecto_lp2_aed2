package projeto;

import java.io.FileReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;

public class CopiarFicheiro {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new FileReader("src/com/company/poema.txt");
            outputStream= new FileWriter("data/dump.txt");
            int c;
            while((c=inputStream.read())!= -1){
                outputStream.write(c);
                out.write(c);

            }
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }

    }
}
