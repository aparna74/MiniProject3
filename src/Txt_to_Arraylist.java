import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Txt_to_Arraylist {
    public static void main(String[]args) {
        try {
            ArrayList<node> wordlist = new ArrayList<node>(10);
            File file = new File("C:\\Users\\abotl\\IdeaProjects\\MiniProject3\\src\\alice_in_wonderland.txt");
            Scanner sc = new Scanner(file);
            int count=0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                count++;
                line= line.replaceAll("^[A-Za-z1-9]", " ");
                String[] words = line.split("[\\s,]+");


                for (String word:words) {
                    node e = new node(word,"Alice in wonderland",count);
                    wordlist.add(e);

                }

            }

            sortwordlist(wordlist);
            write_to_file( wordlist );
            display(wordlist);



        } catch (java.io.FileNotFoundException fe) {
            System.out.println("input file not found");
        }
    }
    public static void display(ArrayList wordlist){
        for (Object e:wordlist){
              node k= (node)e;
            System.out.println(k.word+","+k.book_name+","+k.line_num);
        }

    }
    public static void sortwordlist(ArrayList<node> wordlist) {
        String min;
        node temp;
        int min_ind = 0;
        String current;
        for (int i = 0; i < wordlist.size() - 1; i++) {
            min = wordlist.get(i).word;
            for (int j = i + 1; j < wordlist.size() - 1; j++) {
                current = wordlist.get(j).word;
                if (min.compareTo(current) <= 0) continue;
                min = current;
                min_ind = j;

            }
            temp = wordlist.get(i);
            wordlist.set(i, wordlist.get(min_ind));
            wordlist.set(min_ind, temp);
        }
    }
    public static void write_to_file(ArrayList<node> wordlist ) {
        try {
            String text="";
            FileWriter fw = new FileWriter("C:\\Users\\abotl\\OneDrive\\Desktop\\SortedIndexFile_Aliceinwonderland.txt");
            for(int i=0;i<wordlist.size()-1;i++) {
                text =wordlist.get(i).word+ ","+wordlist.get(i).book_name+","+wordlist.get(i).line_num+"\n";
                fw.write(text);
            }
        }catch(IOException I){
            System.out.println("unable to write into the file");
        }
    }

}
