import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;


public class ParenSymmetry {
   /* Write two methods:
    Write a method isBalanced that takes a string, and produces true if balanced,
            false otherwise. The method signature
    should be: public boolean isBalanced(String stringToTest);
    Write another method checkFile that use the first to check a
    file of paren strings producing a true or false for each line in the file.
    It should look like public void checkFile(String filename);
    And use either TestStrings0.txt and/or TestStrings1.txt to
    test your work. The results of running agains the TestStrings0.txt file
    should be true, false, true, false, true, false, true */

    private Boolean isBalanced(String s) {
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('(')) {
                counter1++;
            } else if (s.charAt(i) == (')')) {
                counter2++;
            }
        }

        if (counter1 == counter2) {
            return true;
        } else {
            return false;
        }
        // implement this method
    }

    private void checkFile(String filename) throws IOException {
        //Path is a java class that gets a file path
        Path filePath = Paths.get(filename);
        //stream is new. //Files is a java class to handle and manipulate files
        Stream<String> lines = Files.lines(filePath);
        //Iterator class helps you go through each line of the file
        Iterator<String> iterator = lines.iterator();
        //while there is still a next line, it will continue looping/reading
        while ((iterator.hasNext()) == true) {
            //stores each line in a line variable
            String line = iterator.next();
            //we know call a method on each line , in this came its system out print
            System.out.println(line + " >>> " + isBalanced(line));
        }
        //just like closing scanner, its good practice to close lines
        lines.close();
    }




        // open file named filename
//        FileInputStream file = new FileInputStream(filename);
//        Scanner scanner = new Scanner(filename);
//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }
//        scanner.close();



        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file


    public static void main(String[] args) throws IOException {


        ParenSymmetry ps = new ParenSymmetry();

        ps.checkFile("TestStrings0.txt"); //I added this. This works.

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
