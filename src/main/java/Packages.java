import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Packages {

    private static final String SPLIT_REG_EXP = " ";

    Map<String, Double> data;
    String fileName;
    BufferedWriter writer;

    Packages(String fileName) throws IOException {
        this.fileName = fileName;
        this.data = new ConcurrentHashMap<>();
        this.writer = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8,
                StandardOpenOption.APPEND);
        loadPackages();
    }

    void logPackage(String inputLine) throws IOException {

        writer.write(inputLine + "\n");
    }

    private void loadPackages() {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(this::addPackageWeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addPackage(String line) throws IOException {
        addPackageWeight(line);
        logPackage(line);
    }

    public void addPackageWeight(String line) {
        if (line.isEmpty()) return;
        String[] entry = line.split(SPLIT_REG_EXP);
        double weight = Double.parseDouble(entry[0]);
        String postalCode = entry[1];
        if (data.containsKey(postalCode)) weight += data.get(postalCode);
        data.put(postalCode, weight);
    }

    Stream<String> generateOutput() {

        return data.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(entry -> String.format(entry.getKey() + " %.3f", entry.getValue()));
    }

    void print() {
        generateOutput().forEach(System.out::println);
    }

}