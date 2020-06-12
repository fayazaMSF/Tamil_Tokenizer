import java.io.*;
import java.util.LinkedList;

import com.sun.xml.internal.ws.util.StringUtils;

public class TamilTokenizerMain {

	// private static final String inputF = "op-10-19.si-ta.ta";
	// private static final String outputF = inputF + ".tok";

	public static void main(String[] args) throws IOException {
		// String[] fileSet ={"let0-", "let1-", "let2-", "let3-", "let4-",
		// "let5-","extract-"};
		// String suffix = ".si-ta.ta";
		// String tokSuffix = ".tok";
		// String date = "1-17";
		// String fileIndex =args[0];
		// int fileIndex = Integer.parseInt(args[0]);

		String date="16102018";
		String source="bbc";//Thinakkural,Virakesari,Thinakaran,Adaderana,bbc,ITN,News_First,Sooriyan_FM_News,Virakesari,Tamilmirror,
		String directoryName="C:\\Users\\ffayaza\\Documents\\Data\\TokenModelData";
//				"C:\\Users\\ffayaza\\Documents\\MscProject\\Data\\TokenizedData\\October\\"+date;
		
		File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\ffayaza\\Documents\\Data\\PROJECT_DATA\\TEST_DATA\\extracted_data\\data\\dec\\data_03122018.xml")));
//				"C:\\Users\\ffayaza\\Documents\\MscProject\\Data\\PreProcessData\\October\\"+date+"\\"+source+"_"+date+".xml")));
		BufferedWriter bufferedWriter = new BufferedWriter(
				new FileWriter(new File("C:\\Users\\ffayaza\\Documents\\Data\\PROJECT_DATA\\TEST_DATA\\tokenized_data\\dec\\data_03122018.xml")));
//						"C:\\Users\\ffayaza\\Documents\\MscProject\\Data\\TokenizedData\\October\\"+date+"\\"+source+"_"+date+".xml")));
		// BufferedReader bufferedReader = new BufferedReader(new FileReader(new
		// File(fileSet[fileIndex]+date+suffix)));
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new
		// File(fileSet[fileIndex]+date+tokSuffix + suffix)));

		TamilTokenizer tamilTokenizer = new TamilTokenizer();

		String line = bufferedReader.readLine().trim();

		while (line != null) {
			if (line.contains("TITLE")) {
				String[] line1 = line.split("TITLE>");
				String[] line2 = line1[1].split("<");
				line = line2[0];
				LinkedList<String> tokenized = tamilTokenizer.splitWords(line);

				String str = "";
				for (String term : tokenized) {
					str = str + term + " ";
				}

				if (str != null)
					str = str.trim();

				String[] parts = str.split("\\s+");

				String lineToWrite = "";

				for (int i = 0; i < parts.length; i++) {
					if (i == parts.length - 1) {
						lineToWrite += parts[i].trim();
						break;
					}

					if (parts[i].equalsIgnoreCase("/") || parts[i].equalsIgnoreCase(".")) {
						if (i > 0 && isNumeric(parts[i - 1])) {
							// lineToWrite = lineToWrite.trim();

							if (i < parts.length - 1 && isNumeric(parts[i + 1]))
								lineToWrite += parts[i] + " ";
							else
								lineToWrite += parts[i] + " ";
						} else {
							lineToWrite += parts[i] + " ";
						}
					} else {
						lineToWrite += parts[i] + " ";
					}

				}
				lineToWrite="<TITLE> "+ lineToWrite+ " </TITLE> ";
				bufferedWriter.write(lineToWrite + "\n");
			} else if (line.contains("<BODY>")) {
				System.out.println(line);
				String[] line1 = line.split(">");
				String[] line2 = line1[1].split("<");
				line = line2[0];
				LinkedList<String> tokenized = tamilTokenizer.splitWords(line);

				String str = "";
				for (String term : tokenized) {
					str = str + term + " ";
				}

				if (str != null)
					str = str.trim();

				String[] parts = str.split("\\s+");

				String lineToWrite = "";

				for (int i = 0; i < parts.length; i++) {
					if (i == parts.length - 1) {
						lineToWrite += parts[i].trim();
						break;
					}

					if (parts[i].equalsIgnoreCase("/") || parts[i].equalsIgnoreCase(".")) {
						if (i > 0 && isNumeric(parts[i - 1])) {
							// lineToWrite = lineToWrite.trim();

							if (i < parts.length - 1 && isNumeric(parts[i + 1]))
								lineToWrite += parts[i] + " ";
							else
								lineToWrite += parts[i] + " ";
						} else {
							lineToWrite += parts[i] + " ";
						}
					} else {
						lineToWrite += parts[i] + " ";
					}

				}
				lineToWrite="<BODY> "+ lineToWrite+ " </BODY> ";
				bufferedWriter.write(lineToWrite + "\n");
			} else {
				bufferedWriter.write(line + "\n");
			}

			line = bufferedReader.readLine();

			if (line != null)
				line = line.trim();
		}

		bufferedReader.close();
		bufferedWriter.close();
	}

	private static boolean isNumeric(String str) {
		try {
			Integer integer = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException exception) {
			return false;
		}
	}
}
//import java.io.*;
//import java.util.LinkedList;
//
//public class TamilTokenizerMain {
//
//   // private static final String inputF = "op-10-19.si-ta.ta";
//   // private static final String outputF = inputF + ".tok";
//
//
//    public static void main(String[] args) throws IOException {
//      //  String[]  fileSet ={"let0-", "let1-", "let2-", "let3-", "let4-", "let5-","extract-"};
//       // String suffix = ".si-ta.ta";
//       // String tokSuffix =  ".tok";
//       // String date = "1-17";
//        //String fileIndex =args[0];
////        int fileIndex = Integer.parseInt(args[0]);
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\ffayaza\\Documents\\Data\\PROJECT_DATA\\TEST_DATA\\formated_data\\October\\16102018\\data_16102018.txt")));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\ffayaza\\Documents\\Data\\PROJECT_DATA\\TEST_DATA\\tokenized_data\\data_16102018.txt")));
////        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileSet[fileIndex]+date+suffix)));
////        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileSet[fileIndex]+date+tokSuffix + suffix)));
//
//        TamilTokenizer tamilTokenizer = new TamilTokenizer();
//
//        String line = bufferedReader.readLine().trim();
//
//        while (line != null) {
//
//            LinkedList<String> tokenized = tamilTokenizer.splitWords(line);
//
//
//            String str = "";
//            for (String term : tokenized) {
//                str = str + term + " ";
//            }
//
//            if (str != null)
//                str = str.trim();
//
//            String[] parts = str.split("\\s+");
//
//            String lineToWrite = "";
//
//            for (int i = 0; i < parts.length; i++) {
//                if (i == parts.length - 1) {
//                    lineToWrite += parts[i].trim();
//                    break;
//                }
//
//                if (parts[i].equalsIgnoreCase("/") || parts[i].equalsIgnoreCase(".")) {
//                    if (i > 0 && isNumeric(parts[i - 1])) {
//                        //lineToWrite = lineToWrite.trim();
//
//                        if (i < parts.length - 1 && isNumeric(parts[i + 1]))
//                            lineToWrite += parts[i] +" ";
//                        else
//                            lineToWrite += parts[i] + " ";
//                    } else {
//                        lineToWrite += parts[i] + " ";
//                    }
//                } else {
//                    lineToWrite += parts[i] + " ";
//                }
//
//            }
//
//            bufferedWriter.write(lineToWrite + "\n");
//
//
//            line = bufferedReader.readLine();
//
//            if (line != null)
//                line = line.trim();
//        }
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//
//    private static boolean isNumeric(String str) {
//        try {
//            Integer integer = Integer.parseInt(str);
//            return true;
//        } catch (NumberFormatException exception) {
//            return false;
//        }
//    }
//}
//
//
