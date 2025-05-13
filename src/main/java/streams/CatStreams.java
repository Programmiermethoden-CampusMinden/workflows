package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

record Cat(int weight) {}

/** CatStreams. */
public class CatStreams {
    public static void main(String... args) {
        List<Cat> clouder = new ArrayList<>();
        clouder.add(new Cat(100));
        clouder.add(new Cat(1));
        clouder.add(new Cat(10));

        sumOverWeight(8, clouder);
    }

    /**
     * sumOverWeight.
     *
     * @param threshold
     * @param cats
     * @return
     */
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

    /**
     * sumOverWeightStream.
     *
     * @param threshold
     * @param cats
     * @return
     */
    private static int sumOverWeightStream(int threshold, List<Cat> cats) {

        return cats.stream().filter(c -> c.weight() > threshold).mapToInt(c -> c.weight()).sum();
    }

    /**
     * sumOverWeightStreamMethodenrefferenz.
     *
     * @param threshold
     * @param cats
     * @return
     */
    private static int sumOverWeightStreamMethodenrefferenz(int threshold, List<Cat> cats) {

        return  cats.stream().filter(cat -> isFett(threshold, cat)).mapToInt(c -> c.weight()).sum();
    }

    /**
     * isFett.
     *
     * @param threshold
     * @param car
     * @return
     */
    private static boolean isFett(int threshold, Cat car) {
        return car.weight() > threshold ? true : false;
    }

    /**
     * fettFilter.
     *
     * @param threshold
     * @return
     */
    private static Predicate<Cat> fettFilter(int threshold) {
        return cat -> cat.weight() > threshold;
    }

    /**
     * superDuper.
     *
     * @param threshold
     * @param cats
     * @return
     */
    private static int superDuper(int threshold, List<Cat> cats) {

        return cats.stream()
            .filter(fettFilter(threshold))
            .mapToInt(Cat::weight)
            .sum();
    }

    private static int getCatWeight(Cat car)
    {
        return car.weight();
    }

    /**
     * superDuperUltra was auch immer, aber hauptsache richtige Methodenrefferenz.
     *
     * @param threshold
     * @param cats
     * @return die Ultimative Methode um DAS Übergewicht aller Katzen in (cats) über dem Threshold zu summieren
     */
    private static int superDuperRichtigeMethodenRefferenzMethodeSumOverWeith(int threshold, List<Cat> cats)
    {
        return cats.stream()
            .filter(fettFilter(threshold))
            .mapToInt(CatStreams::getCatWeight)
            .sum();
    }

}
