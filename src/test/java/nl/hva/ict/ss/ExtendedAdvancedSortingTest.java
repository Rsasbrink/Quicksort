package nl.hva.ict.ss;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored! Failing to add tests
 * here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {
int numberOfPlayers = 100;
    @Test
    public void measureEfficiencyArray() {
        System.out.printf("Array implementation V2%n");
       
        Player[] players = getSubList(unsortedPlayers, numberOfPlayers).toArray(new Player[numberOfPlayers]);

        Player[] playersSorted = AdvancedSorts.quickSort(players);
        for (int i = 0; i < playersSorted.length; i++) {
            System.out.println(playersSorted[i].getHighScore());
        }

    }

    @Test
    public void measureEfficiencyLinkedList() {
        System.out.printf("LinkedList implementation%n");
       
        LinkedList<Player> players = getSubList(unsortedPlayers, numberOfPlayers);
        AdvancedSorts.quickSort(players);
        LinkedList<Player> playersSorted = AdvancedSorts.quickSort(players);
        for (int i = 0; i < playersSorted.size(); i++) {
            System.out.println(playersSorted.get(i).getHighScore());
        }
        // Try to keep measurements steady
        players.clear();

    }
    // Check if list is really sorted
    @Test
    public void checkIfSortingWorks(){
        
        LinkedList<Player> players = getSubList(unsortedPlayers, numberOfPlayers);
        
        LinkedList<Player> playersSorted = AdvancedSorts.quickSort(players);
        boolean sorted = true;
        for(int i = 0; i < playersSorted.size() - 1; i++){
            if(playersSorted.get(i).compareTo(players.get(i + 1)) != 1){
               sorted = false;
               break;
            }
        }
        Assert.assertEquals(true, sorted);
  
        
    }
    // Checks if size doesn't change on sort.
    @Test
    public void checkIfEven(){
        LinkedList<Player> players = getSubList(unsortedPlayers, numberOfPlayers);
        int initialSize = players.size();
        
        LinkedList<Player> playersSorted = AdvancedSorts.quickSort(players);
        int sortedSize = playersSorted.size();
        Assert.assertEquals(true, initialSize == sortedSize);
    }
}
