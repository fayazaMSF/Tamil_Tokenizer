import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Extractor {
    public static void main(String[] args) throws FileNotFoundException, IOException{
//set1T.txt set1S.txt
        int fileSet = Integer.parseInt(args[0]);
        System.out.println("parameter :  "+ fileSet );
        String[] slist = {"set0S.txt","set1S.txt", "set2S.txt", "set3S.txt", "set4S.txt", "set5S.txt", "prod1S.txt"};
        String[] tlist = {"set0T.txt","set1T.txt", "set2T.txt", "set3T.txt", "set4T.txt", "set5T.txt", "prod1S.txt"};

        String[] out ={"let0-", "let1-", "let2-", "let3-", "let4-", "let5-","prod1"};
        String date = "1-17";

        BufferedReader tamilReader = new BufferedReader(new FileReader(new File(tlist[fileSet])));
        BufferedReader sinhalaReader = new BufferedReader(new FileReader(new File(slist[fileSet])));

        List<String> fileTamil = new ArrayList<String>();
        List<String> fileSinhala = new ArrayList<String>();


        String line1 = tamilReader.readLine();
        String line2 = sinhalaReader.readLine();

        while(line1 != null){

            fileTamil.add(line1);
            fileSinhala.add(line2);

            line1 = tamilReader.readLine();
            line2 = sinhalaReader.readLine();
        }

        tamilReader.close();
        sinhalaReader.close();

        BufferedWriter sinhala = new BufferedWriter(new FileWriter(new File(out[fileSet]+date+ ".si-ta.si")));
        BufferedWriter tamil   = new BufferedWriter(new FileWriter(new File(out[fileSet]+ date + ".si-ta.ta")));


        for(int i  =0 ; i < fileSinhala.size() ; i++){

            tamilReader = new BufferedReader(new FileReader(new File(fileTamil.get(i))));
            sinhalaReader = new BufferedReader(new FileReader(new File(fileSinhala.get(i))));
            line1 = tamilReader.readLine();
            line2 = sinhalaReader.readLine();

            while(line1 != null){
                sinhala.write(line2+ "\n");
                tamil.write(line1 + "\n");
                line1 = tamilReader.readLine();
                line2 = sinhalaReader.readLine();

            }

            tamilReader.close();
            sinhalaReader.close();
        }

      sinhala.close();
        tamil.close();


    }
}
