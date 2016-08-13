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
        char[] lets = {'a', 'd', 'a', 'm'};
        int[] reps = gen.getRepetitions(lets);
        for(int el : reps) {
            System.out.println("Numbers of repetitions: " + el);
        }
        int combs = gen.permutationWithRepetition(charListTest.size(), reps);
        System.out.println("Possible combinations: " + combs);
        gen.inputWord = "kot";
        System.out.println(gen.generateAcronyms("kot"));
    }
}
