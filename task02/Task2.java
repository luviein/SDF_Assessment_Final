package task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Task2 {


    public static void function(String texts) {
        Map<String, List<String>> hmap = new HashMap<>();
        texts = texts.replace(",", "");
        texts = texts.replace("'", "");
        texts = texts.replace("!", "");
        texts = texts.replace(".", "");
        texts = texts.replace(";", "");
        texts = texts.replace("?", "");
        texts = texts.replace("-", "");
        texts = texts.replace(":", "");
        texts = texts.toLowerCase();

        String[] words = texts.split(" ");

        for (int i = 0; i < words.length - 1; i++) { // n - 1 because last word has no next word
            if (!hmap.containsKey(words[i])) {
                // create list of key if dont exist in map
                hmap.put(words[i], new ArrayList<String>());
            }
            // append next word to current key's list
            hmap.get(words[i]).add(words[i + 1]);
        }

        // print statistics
        for (Map.Entry<String, List<String>> entry : hmap.entrySet()) {
            List<String> nextWords = entry.getValue();
            Map<String, Integer> wordFrequencyMap = new HashMap<>();
            for (int i = 0; i < nextWords.size(); i++) {
                String nextWord = nextWords.get(i);
                if (!wordFrequencyMap.containsKey(nextWord)) {
                    wordFrequencyMap.put(nextWord, 0);
                }
                wordFrequencyMap.put(nextWord, wordFrequencyMap.get(nextWord) + 1);
            }

            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> freqEntry : wordFrequencyMap.entrySet()) {
                String freqString = String.valueOf(freqEntry.getValue() / (float) nextWords.size());
                System.out.println("\t" + freqEntry.getKey() + " " + freqString);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        // System.out.println(args[0]);
        File directoryPath = new File(args[0]);
        // System.out.println(directoryPath);
        List<File>filesList = new ArrayList<>(Arrays.asList(directoryPath.listFiles()));

        // System.out.println(filesList.length);
        System.out.println("List of files and directories in the specified directory:");
        String texts = "";
        while (filesList.size() > 0) {
            File file = filesList.remove(0);
            if (file.isDirectory()) {
                for (int i = 0; i < file.listFiles().length; i++) {

                    filesList.add(file.listFiles()[i]);
                }
            }else{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";

                while ((line = br.readLine()) != null) {
                    texts += line;
                    texts += " ";
                }
                texts += " ";
                br.close();

            }

            
            
        }
        function(texts);

        //System.out.println(texts);

    }
}
