import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by SteveQ on 2016-08-13.
 */
public class SearchForWordsTest {
    public static void main(String[] args) {
        SearchForWords sfw = new SearchForWords();
        String[] str = new String[2];
        str[0] = "kot";
        str[1] = "bułka";
        System.out.println(str);
        ArrayList<String> list = sfw.getRealWordsList(str);
        System.out.println(list);
        System.out.println(list.get(0));
    }
}
