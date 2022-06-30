import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class KR {

private StringBuilder data;
private Map<Integer, Integer> unused = new HashMap<Integer, Integer>();
private Map<Integer, String> inserts = new HashMap<Integer, String>();
private ArrayList<Integer> revers = new ArrayList<Integer>();

public static String readFile(String path, Charset encoding) throws IOException {
        return Files.readString(Paths.get(path), encoding);
        }

    KR(String input1, String input2, String output1, String output2, String output3) {
        data = new StringBuilder("");
        String line = "";
        try {
            line = readFile(input1, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.append(line);
        alg(input2, output2, output3);
        try {
            FileWriter myWriter = new FileWriter(output1);
            myWriter.write(data.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void alg(String input2, String output2, String output3) {

        try {
            File file = new File(input2);
            FileReader fr = null;
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer defaultTokenizer = new StringTokenizer(line);
                while (defaultTokenizer.hasMoreTokens()) {

                    String f = defaultTokenizer.nextToken();

                    int end = 1;
                    while(f.charAt(end) < 58 && f.charAt(end) > 48) {
                        ++end;
                    }

                    Integer number = Integer.parseInt(f.substring(1, end));
                    revers.add(number);
                    unused.put(number, number);
                    inserts.put(number, f.substring(end + 1, f.length()));
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < data.length(); i++) {
            if(data.charAt(i) == '[') {
                int end = i + 1;
                while(data.charAt(end) < 58 && data.charAt(end) > 48) {
                    ++end;
                }
                Integer number = Integer.parseInt(data.substring(i + 1, end));
                data.replace(i, end + 1, inserts.get(number));
                if(unused.containsKey(number)) {
                    unused.remove(number);
                }
            }
        }

        try {
            FileWriter myWriter = new FileWriter(output2);
            for (Map.Entry<Integer, Integer> entry : unused.entrySet()) {
                myWriter.write("[" + entry.getKey() + "]" + inserts.get(entry.getKey()) + "\n");
            }
            myWriter.close();
            myWriter = new FileWriter(output3);
            Collections.reverse(revers);
            for(Integer i : revers) {
                myWriter.write(i + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

public class Main {

    public static void main(String[] args) {
        KR obj = new KR("input1.txt", "input2.txt", "output1.txt", "output2.txt", "output3.txt");
    }

}
