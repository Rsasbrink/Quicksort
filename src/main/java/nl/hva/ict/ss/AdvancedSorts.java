package nl.hva.ict.ss;

import java.util.LinkedList;

public class AdvancedSorts {

    /**
     * Implement quicksort using LinkedList only! Usage of anything but
     * LinkedList will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        return linkedListSort(unsorted, 0, unsorted.size() - 1);
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will
     * result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {
        return arraySort(unsorted, 0, unsorted.length - 1);
    }
    
    public static <E extends Comparable<E>> LinkedList<E> linkedListSort(LinkedList<E> unsorted, int links, int rechts) {
        int L = links;
        int R = rechts;
        E pivot = unsorted.get((links + rechts) / 2);
        Player pivotPlayer = (Player) pivot;
        do {
            Player comparePlayerLeft = (Player) unsorted.get(L);
            while(comparePlayerLeft.getHighScore() < pivotPlayer.getHighScore()){
                L++;
                comparePlayerLeft = (Player) unsorted.get(L);
            }
            Player comparePlayerRight = (Player) unsorted.get(R);
            while (pivotPlayer.getHighScore() < comparePlayerRight.getHighScore())
            {
                R--;
                comparePlayerRight = (Player) unsorted.get(R);
            }

            if (L <= R) {
                E playerLeft = unsorted.get(L);
                unsorted.set(L, unsorted.get(R));
                unsorted.set(R, playerLeft);
                L++;
                R--;
            }
        } while (L < R);

        if (links < R) {
            linkedListSort(unsorted, links, R);
        }
        if (L < rechts) {
            linkedListSort(unsorted, L, rechts);
        }
        
        return unsorted;
    }
    
    public static <E extends Comparable<E>> E[] arraySort(E[] unsorted, int links, int rechts) {
        int L = links;
        int R = rechts;
        E pivot = unsorted[(links + rechts) / 2];
        Player pivotPlayer = (Player) pivot;
        
        do {
            Player comparePlayerLeft = (Player) unsorted[L];
            while(comparePlayerLeft.getHighScore() < pivotPlayer.getHighScore()){
                L++;
                comparePlayerLeft = (Player) unsorted[L];
            }
            Player comparePlayerRight = (Player) unsorted[R];
            while (pivotPlayer.getHighScore() < comparePlayerRight.getHighScore())
            {
                R--;
                comparePlayerRight = (Player) unsorted[R];
            }

            if (L <= R) {
                E playerLeft = unsorted[L];
                unsorted[L] = unsorted[R];
                unsorted[R] = playerLeft;
                L++;
                R--;
            }
        } while (L < R);

        if (links < R) {
            arraySort(unsorted, links, R);
        }
        if (L < rechts) {
            arraySort(unsorted, L, rechts);
        }
        
        return unsorted;
    }
}
