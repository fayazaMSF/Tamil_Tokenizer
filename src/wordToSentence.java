import java.io.*;

/**
 * to get the NER tagged corpus into sentence form
 * Created by CSE on 1/26/2017.
 */
public class wordToSentence {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//set1T.txt set1S.txt
        String inputFile = args[0];

        BufferedReader sourceFile = new BufferedReader(new FileReader(new File(inputFile)));
        BufferedWriter outFile   = new BufferedWriter(new FileWriter(new File((inputFile+"sentence.txt"))));

        String line1 = sourceFile.readLine();

        while(line1 != null){
            String tokens = line1.trim();
            if (!tokens.isEmpty() ) {
                if (tokens.equals(".")){
                outFile.write(line1 + "\n");
                }else{
                    outFile.write(line1 + " ");
                }
            }

            line1 = sourceFile.readLine();
        }

        sourceFile.close();
        outFile.close();

    }
}
