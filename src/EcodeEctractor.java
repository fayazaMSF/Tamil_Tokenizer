import java.io.*;

/**
 * Created by CSE on 1/23/2017.
 */
public class EcodeEctractor {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//set1T.txt set1S.txt
        String suffix = ".si-ta.ta";
        int nGram = Integer.parseInt(args[0]);
        String inputFile = args[1];

        BufferedReader rawFileSi = new BufferedReader(new FileReader(new File(inputFile+suffix)));
        BufferedReader rawFileTa = new BufferedReader(new FileReader(new File(inputFile+suffix)));

        BufferedWriter termFileSi   = new BufferedWriter(new FileWriter(new File((inputFile+ "-"+"term" + suffix))));
        BufferedWriter termFileTa   = new BufferedWriter(new FileWriter(new File((inputFile+ "-"+"term" + suffix))));

        String lineSi = rawFileSi.readLine();
        String lineTa = rawFileTa.readLine();

        while(lineSi != null){
            String[] tokensSi = lineSi.split("“”\" ");
            if(tokensSi.length >1) {
                    termFileSi.write(lineSi + "\n");
                    termFileTa.write(lineTa + "\n");
            }
            lineSi = rawFileSi.readLine();
            lineTa = rawFileTa.readLine();
        }

        rawFileSi.close();
        rawFileTa.close();
        termFileSi.close();
        termFileTa.close();

    }
}
