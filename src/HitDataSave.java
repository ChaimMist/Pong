import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HitDataSave {
    public static int maxHitsEver;
    String line;
    public static ArrayList<String> hitTemp = new ArrayList<>();
    public static File hitFile = new File("HitHistory.txt");
    public static String[] hitHistory = new String[5];

    public HitDataSave() {
        try {
            FileWriter fw = new FileWriter(hitFile, true);
            Writer output = new BufferedWriter(fw);
            for (String s : hitTemp) {
                if (s != null)
                    output.write(s + "\n");
            }
            hitTemp.clear();
            output.close();
        } catch (IOException e) {
            System.out.println("Couldn't create that file.");
        }
        hitDataRetrieve();
    }

    public void hitDataRetrieve() {
        System.out.println("before");
        try {
            BufferedReader input = new BufferedReader(new FileReader(hitFile));
            System.out.println("After");
            if (!input.ready()) {
                throw new IOException();
            }
            while ((line = input.readLine()) != null) {
                hitTemp.add(line);
            }
            getHighest(hitTemp);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hitList(hitTemp);
    }

    private void getHighest(ArrayList<String> hitTemp) {
        int highest = 0;
        for (String t: hitTemp){
            int x = Integer.parseInt(t);
            if (highest<x){
                highest = x;
                maxHitsEver = x;
                System.out.println("Calculating Highest hits... - "+x);}
        }
    }

    public void hitList(ArrayList<String> temp) {
        for (int i = 0; i < 5; i++) {
            try {
                hitHistory[i] = (temp.get(temp.size() -1 - i));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Something happened when adding to hitList");
            }
        }
        temp.clear();
        System.out.println(Arrays.toString(hitHistory));
    }
}
