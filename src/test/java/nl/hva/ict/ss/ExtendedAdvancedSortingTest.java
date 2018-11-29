package nl.hva.ict.ss;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import static nl.hva.ict.ss.AdvancedSortingTest.UPPER_LIMIT;
import org.junit.Test;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored! Failing to add tests
 * here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {

    @Test
    public void measureEfficiencyArray() {
        System.out.printf("Array implementation V2%n");
        int numberOfPlayers = 20;
        Player[] players = getSubList(unsortedPlayers, numberOfPlayers).toArray(new Player[numberOfPlayers]);

        Player[] playersSorted = AdvancedSorts.quickSort(players);
        for (int i = 0; i < playersSorted.length; i++) {
            System.out.println(playersSorted[i].getHighScore());
        }

    }

    @Test
    public void measureEfficiencyLinkedList() {
        System.out.printf("LinkedList implementation%n");
        int numberOfPlayers = 100;
        LinkedList<Player> players = getSubList(unsortedPlayers, numberOfPlayers);
        AdvancedSorts.quickSort(players);
        LinkedList<Player> playersSorted = AdvancedSorts.quickSort(players);
        for (int i = 0; i < playersSorted.size(); i++) {
            System.out.println(playersSorted.get(i).getHighScore());
        }
        // Try to keep measurements steady
        players.clear();

    }
}
