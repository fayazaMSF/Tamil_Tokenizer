import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CSE on 1/20/2017.
 */
public class LMcleaner {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//set1T.txt set1S.txt
        String suffix = ".si-ta.ta";
        int nGram = Integer.parseInt(args[0]);
        String inputFile = args[1];
        int exactmatch = Integer.parseInt(args[2]); // 0 -will get same length as the n-gram size

        BufferedReader sourceFile = new BufferedReader(new FileReader(new File(inputFile+suffix)));
        BufferedWriter outFile   = new BufferedWriter(new FileWriter(new File((inputFile+ "-"+nGram+"LM" + suffix))));

        String line1 = sourceFile.readLine();

        while(line1 != null){
            String[] tokens = line1.split(" ");
            if(exactmatch ==0) {
                if (tokens.length >= nGram) {
                    outFile.write(line1 + "\n");
                }
            }else {
                if (tokens.length > nGram) {
                    outFile.write(line1 + "\n");
                }
            }
            line1 = sourceFile.readLine();
        }

        sourceFile.close();
        outFile.close();

    }
}
