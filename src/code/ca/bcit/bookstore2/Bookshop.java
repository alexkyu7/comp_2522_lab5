package ca.bcit.bookstore2;

import java.util.*;

/**
 * Represents the Bookshop.
 *
 * @author Alex Lee
 * @author Evan Tang
 *
 * @version 1
 */
public class Bookshop
{
    final Map<String, Novel> novelMap;
    final Set<String> keyset;
    final Iterator<String> it;
    final List<String> sortedTitles;

    public Bookshop(List<Novel> novelList)
    {
        novelMap = new HashMap<>();

        for (Novel novel : novelList)
        {
            novelMap.put(novel.getTitle(), novel);
        }

        keyset = novelMap.keySet();

        it = keyset.iterator();

        System.out.println("All titles:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        sortedTitles = new ArrayList<>();

        for (String key : keyset) {
            if (!key.toLowerCase().contains("the")) {
                sortedTitles.add(key);
            }
        }

        Collections.sort(sortedTitles);

        System.out.println("\nSorted titles:");
        for (String title : sortedTitles) {
            System.out.println(novelMap.get(title));
        }
    }
}
