import java.io.FileWriter;
import java.io.IOException;

public class testFilewriter {
    public static void main(String[]args) {
        try {
            String text = "";
            FileWriter fw = new FileWriter("C:\\Users\\abotl\\OneDrive\\Desktop\\SortedIndexFile_Aliceinwonderland.txt");

            text = "hello every body";
            fw.write(text);
            fw.flush();
            fw.close();

    }catch(IOException I)

    {
        System.out.println("unable to write into the file");
    }
}
}
