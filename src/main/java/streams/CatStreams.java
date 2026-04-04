package streams;

import java.util.ArrayList;
import java.util.List;

record Cat(int weight){};

public class CatStreams {
    public static void main(String... args) {
        List<Cat> clouder = new ArrayList<>();
        clouder.add(new Cat(100));  clouder.add(new Cat(1));  clouder.add(new Cat(10));

        sumOverWeight(8, clouder);
    }

    private static int sumOverWeight(int threshold, List<Cat> cats) {
        int result = 0;
        for (Cat c : cats) {
            int weight = c.weight();
            if (weight > threshold) {
                result += weight;
            }
        }
        return result;
    }
}
