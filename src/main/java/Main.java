import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String QUIT = "quit";
    private static final String WRONG_FORMAT_MESSAGE = "Input format is not correct. Try again";
    private static final String NO_ARGUMENT_MESSAGE = "Specify file name as argument in command";
    private static final String VALIDATION_REG_EXP = "\\d{1,9}(\\.\\d{1,3})? \\d{5}";

    public static void main(String[] args) {

        System.out.prtln("try to test github actions");
        if (args.length == 0) {
            System.err.println(NO_ARGUMENT_MESSAGE);
            System.exit(1);
        }

        try {
            Packages packages = new Packages(args[0]);
            OutputThread outputThread = new OutputThread(packages);
            outputThread.start();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String inputLine = inputReader.readLine();
                if (inputLine.equals(QUIT)) break;
                if (!inputLine.matches(VALIDATION_REG_EXP)) {
                    System.err.println(WRONG_FORMAT_MESSAGE);
                    continue;
                }
                packages.addPackage(inputLine);
            }

            outputThread.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

}

