import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WinDataSave {

    String line;
    public static ArrayList<String> temp = new ArrayList<>();
    public static File file = new File("winHistory.txt");
    public static String[] winHistory = new String[5];

    public WinDataSave() {
        try {
            FileWriter fw = new FileWriter(file, true);
            Writer output = new BufferedWriter(fw);
            for (int i = 0; i < temp.size(); i++) {
                String s = temp.get(i);
                if (s != null)
                    output.write(s + "\n");
            }
            temp.clear();
            output.close();
        } catch (IOException e) {
            System.out.println("Couldn't create that file.");
        }
        winDataRetrieve();
    }

    public void winDataRetrieve() {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            if (!input.ready()) {
                throw new IOException();
            }
            while ((line = input.readLine()) != null) {
                temp.add(line);
            }
            input.close();
        } catch (IOException ignored) {
        }
        winList(temp);
    }

    public void winList(ArrayList<String> temp) {
        for (int i = 0; i < 5; i++) {
            try {
                winHistory[i] = (temp.get(temp.size() -1 - i));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Something happened when adding to winList");
            }
        }
        temp.clear();
        System.out.println(Arrays.toString(winHistory));
    }
}
