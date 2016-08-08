import java.util.ArrayList;
import java.util.List;

/**
 * Created by SteveQ on 2016-08-05.
 */
public class GenerateAcronymsTest {
    public static void main(String[] args) {
        Generator gen = new Generator();
        ArrayList<Character> charListTest = new ArrayList<Character>();
        charListTest.add('g');
        charListTest.add('a');
        charListTest.add('m');
        charListTest.add('e');
        List<Integer> reps = gen.getRepetitions(charListTest);
        System.out.println("Numbers of repetitions: " + reps);
        int combs = gen.permutationWithRepetition(charListTest.size(), reps);
        System.out.println("Possible combinations: " + combs);
        gen.inputWord = "klomb";
        System.out.println(gen.generateAcronyms("klomb"));
    }
}
