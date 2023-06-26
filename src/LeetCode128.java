import java.util.ArrayList;

/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.*/
public class LeetCode128 { //incomplete
    public static int longestConsecutive(int[] nums) {
        ArrayList<Integer> arrayList = constructNums(nums);
        ArrayList<Integer> records = new ArrayList<>();

        while (!arrayList.isEmpty()) {
            int min = min(arrayList);
            ArrayList<Integer> sequence = new ArrayList<>();

            while (sequence.isEmpty() || min - sequence.get(sequence.size() - 1) <= 1 && min - sequence.get(sequence.size() - 1) >= 0) {
                if (!sequence.isEmpty() && min - sequence.get(sequence.size() - 1) == 0) {
                    ArrayList<Integer> temp = new ArrayList<>(arrayList);
                    temp.remove((Integer) min);
                    if (!temp.isEmpty())
                        min = min(temp);
                    else
                        break;

                    continue;

                } else if (min - sequence.get(sequence.size() - 1) >= 0) {


                    sequence.add(min);
                    arrayList.remove((Integer) min);
                    if (!arrayList.isEmpty())
                        min = min(arrayList);
                }

            }
            System.out.println(sequence);
            records.add(sequence.size());
        }
        return max(records);
    }


    private static int min(ArrayList<Integer> arrayList) {
        int min = arrayList.get(0);

        for (int num : arrayList)
            if (num < min)
                min = num;
        return min;
    }

    private static int max(ArrayList<Integer> arrayList) {
        int max;
        if (!arrayList.isEmpty())
            max = arrayList.get(0);
        else
            return 0;
        for (int num : arrayList)
            if (num > max)
                max = num;

        return max;
    }

    private static ArrayList<Integer> constructNums(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums)
            arrayList.add(num);

        return arrayList;

    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
