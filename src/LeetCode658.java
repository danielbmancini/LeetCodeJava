import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
    Find K Closest Elements
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

    04/2020
 */
public class LeetCode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList();

        int binarySearchReturn = Arrays.binarySearch(arr,x);
        int binarySearchInsertionPoint = -(binarySearchReturn + 1);

        int insertionPointRight;
        try{
            insertionPointRight = arr[binarySearchReturn] == x ?
                    binarySearchReturn :
                    binarySearchInsertionPoint;
        }catch(ArrayIndexOutOfBoundsException e){
            insertionPointRight = binarySearchInsertionPoint;
        }
        int insertionPointLeft = insertionPointRight;


        if(insertionPointRight == binarySearchInsertionPoint)
            insertionPointLeft--;
        else
            insertionPointRight++;
        while(list.size() < k){
            int right;
            int left;


            try{right = arr[insertionPointRight]; }catch(ArrayIndexOutOfBoundsException e){
                list.add(arr[insertionPointLeft]);
                insertionPointLeft--;
                continue;
            }
            try{left = arr[insertionPointLeft];}catch(ArrayIndexOutOfBoundsException e){
                list.add(right);
                insertionPointRight++;
                continue;
            }

            if(Math.abs(x - right) < Math.abs(x - left)){
                insertionPointRight++;
                list.add(right);}
            else{
                insertionPointLeft--;
                list.add(left);
            }
        }

        list.sort(Comparator.naturalOrder());

        return list;
    }
}
