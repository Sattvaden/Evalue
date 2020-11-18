import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PackagesTest {

    @Test
    void testLoadPackagesFromList() throws IOException {
        Packages packages = new Packages("src/test/resources/empty.txt");

        List<String> list = new ArrayList<>();
        list.add("3.4 08801");
        list.add("2 90005");
        list.add("12.56 08801");
        list.add("5.5 08079");
        list.add("3.2 09300");

        list.forEach(packages::addPackageWeight);

        String[] expected = new String[]{"08801 15.960", "08079 5.500", "09300 3.200", "90005 2.000"};

        Assertions.assertArrayEquals(packages.generateOutput().toArray(), expected);

    }

    @Test
    void  testLoadPackagesFromFile() throws IOException {
        Packages packages = new Packages("src/test/resources/data.txt");
        String[] expected = new String[]{"08802 10.800", "55555 8.000", "11111 5.900", "90005 5.000", "23432 3.000", "22233 2.000"};

        Assertions.assertArrayEquals(packages.generateOutput().toArray(), expected);
    }

}