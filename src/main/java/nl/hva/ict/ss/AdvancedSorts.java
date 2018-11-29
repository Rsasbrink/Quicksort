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
        if(unsorted.size() == 0){
            return unsorted;
        }else{
            return linkedListSort(unsorted, 0, unsorted.size() - 1);
        }
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
        if(unsorted.length == 0){
            return unsorted;
        }else{
            return arraySort(unsorted, 0, unsorted.length - 1);
        }
    }
    
    public static <E extends Comparable<E>> LinkedList<E> linkedListSort(LinkedList<E> unsorted, int minimum, int maximum) {
        int left = minimum;
        int right = maximum;
        E pivot = unsorted.get((minimum + maximum) / 2);
        Player pivotPlayer = (Player) pivot;
        do {
            Player comparePlayerLeft = (Player) unsorted.get(left);
            while(comparePlayerLeft.compareTo(pivotPlayer) == 1){
                left++;
                comparePlayerLeft = (Player) unsorted.get(left);
            }
            Player comparePlayerRight = (Player) unsorted.get(right);
            while (pivotPlayer.compareTo(comparePlayerRight)== 1)
            {
                right--;
                comparePlayerRight = (Player) unsorted.get(right);
            }

            if (left <= right) {
                E playerLeft = unsorted.get(left);
                unsorted.set(left, unsorted.get(right));
                unsorted.set(right, playerLeft);
                left++;
                right--;
            }
        } while (left < right);

        if (minimum < right) {
            linkedListSort(unsorted, minimum, right);
        }
        if (left < maximum) {
            linkedListSort(unsorted, left, maximum);
        }
        
        return unsorted;
    }
    
    public static <E extends Comparable<E>> E[] arraySort(E[] unsorted, int minimum, int maximum) {
        int left = minimum;
        int right = maximum;
        E pivot = unsorted[(minimum + maximum) / 2];
        Player pivotPlayer = (Player) pivot;
        
        do {
            Player comparePlayerLeft = (Player) unsorted[left];
            while(comparePlayerLeft.compareTo(pivotPlayer) == 1){
                left++;
                comparePlayerLeft = (Player) unsorted[left];
            }
            Player comparePlayerRight = (Player) unsorted[right];
             while (pivotPlayer.compareTo(comparePlayerRight)== 1)
            {
                right--;
                comparePlayerRight = (Player) unsorted[right];
            }

            if (left <= right) {
                E playerLeft = unsorted[left];
                unsorted[left] = unsorted[right];
                unsorted[right] = playerLeft;
                left++;
                right--;
            }
        } while (left < right);

        if (minimum < right) {
            arraySort(unsorted, minimum, right);
        }
        if (left < maximum) {
            arraySort(unsorted, left, maximum);
        }
        
        return unsorted;
    }
}
