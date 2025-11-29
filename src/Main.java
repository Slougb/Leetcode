
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int flag;
    static final AtomicBoolean aB = new AtomicBoolean(false);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(aB);
        System.out.println(aB.compareAndSet(false, true));
        System.out.println(aB);
    }

    public static void puzirikSort(int[] nums) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] > nums[i + 1]) {
                    int a = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = a;
                    flag = true;
                }
            }
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            for (int k = 0; k < nums.length ; k++) {
                if (nums[k] == b && i != k) {
                    return new int[] {i, k};
                }
            }
        }
        return new int[] {0, 0};
    }

    public static int combinationSum4(int[] nums, int target) {
        int result = 0;
        int length = nums.length;
        int ac = target;
        for (int i = 0; i < length; i++) {
            while(ac > 0) {
                ac-=nums[i];
                if (ac == 0) {
                    result++;
                    ac = target;
                } else if (ac < 0){
                    ac+=nums[i];
                }
            }
        }
        return result;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (char i : letters) {
            if(i > target) {
                return i;
            }
        }
        return target;
    }


    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return n - count;
    }



    public static int firstIdentityCountFromArray(int[] array) {
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int a : array) {
            if (set.add(a)) {
                list.add(a);
            } else {
                list.remove(Integer.valueOf(a));
            }
        }
        return list.getFirst();

    }

    public static int firstIdentityIndexFromArray(int[] array) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
           if(set.add(array[i])) {
               map.put(array[i], i);
           } else {
               map.remove(Integer.valueOf(array[i]));
           }
        }
        return map.pollFirstEntry().getValue();
    }

    public static int factorial(int num) {
       if(num==0) {
           return 1;
       } else {
           return num * factorial(num - 1);
       }
    }

    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static int[] findElementWithcount(int[] array, int count) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int number : array) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        int[] result = map.entrySet().stream()
                .filter((e) -> e.getValue() == count)
                .mapToInt((e)-> e.getKey())
                .toArray();
        return result;
    }

    public static int[] sortedSquares(int[] array) {
        int left = 0;
        int right = array.length-1;
        int[] result = new int[array.length];
        int pos  = right;
        while(left < right) {
            int leftSqrt  = array[left] * array[left];
            int rightSqrt = array[right] * array[right];
            if (leftSqrt < rightSqrt) {
                result[pos] = rightSqrt;
                right--;
            } else {
                result[pos] = leftSqrt;
                left++;
            }
            pos--;
        }
        return result;
    }

    public static int fibIterative(int num) {
        if (num==1) {       return 1;
        }
        if (num==0) {
            return 0;
        }
        int result = 2;
        int left = 1;

        for(int i = num - 2; i > 0; i--) {
            int temp = result;
            result+= left;
            left = temp;
        }
        return result;

    }

    public int firstUniqueFind(int[] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int a: array) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> mapEntry: map.entrySet()) {
            if (mapEntry.getValue() == 1) {
                return mapEntry.getKey();
            }
        }
        return -1;
    }

    public boolean isPolyndrom(String s) {
         int left = 0;
         int right = s.length();
         StringBuilder stringBuilder = new StringBuilder(s);
         for(char c : s.toLowerCase().toCharArray()) {
             if(Character.isLetterOrDigit(c)) {
                 stringBuilder.append(c);
             }
         }
         while (left < right) {
            if (stringBuilder.charAt(left) != stringBuilder.charAt(right)) {
                return false;
            }
            left++;
            right--;
         }
         return true;
    }

    static long febonachi(long count) {
        if (count == 0) {
            return 0;
        }
        if (count == 1) {
            return 1;
        }

        long result = 1;
        long leftCount = 1;

        for(long i = count; i >= 2; i--) {
            long temp = result;
            result += leftCount;
            leftCount = temp;
        }
        return result;

    }

    public static int biggestValue(int i, int j) {
        return i>j?i:j;
    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arrayList.add(entry.getValue());
        }
        if (arrayList.size() <= 1) {
            return 0;
        }
        int[] res = new int[arrayList.size() - 1];
        for (int i = 0; i < arrayList.size() - 1; i++) {
            res[i] = arrayList.get(i) + arrayList.get(i + 1);
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
            for(int i = 0; i < boxTypes.length; i++) {
                int numberOfBoxes = boxTypes[i][0];
                int numberOfUnitsPerBox = boxTypes[i][1];
                if (truckSize - numberOfBoxes >= 0) {
                    truckSize -= numberOfBoxes;
                    result += numberOfBoxes * numberOfUnitsPerBox;
                } else {
                    result += truckSize * numberOfUnitsPerBox;
                    break;
                }
            }
            return  result;
    }

    public static int countPairs(int[] deliciousness) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
            map.put(i , map.getOrDefault(i, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        for (Map.Entry<Integer, Integer> mapEntry : set) {

            for (Map.Entry<Integer, Integer> mapEntry2 : map.entrySet()) {
                int value = mapEntry.getKey() + mapEntry2.getKey();
                if (mapEntry.getKey() == mapEntry2.getKey() && ((value & (value -1)) == 0)) {
                    result += mapEntry.getValue() * (mapEntry.getValue()-1);
                } else if ((value & (value -1)) == 0) {
                    result += mapEntry.getValue() * mapEntry2.getValue();
                }
            }
        }
        return result/2;
    }
    static String reverseWordsKeepSpaces(String word){
        String [] strings = word.split("_");
        LinkedList<String> list =Arrays.stream(strings).filter((e) -> !e.isEmpty())
                .map(
                        (e)-> {
                            char[] chars = e.toCharArray();
                            StringBuilder sb = new StringBuilder();
                            for (char c : chars) {
                                if (c != '_') {
                                    sb.append(c);
                                }
                            }
                            return sb.toString();
                        }
                )
                .collect(Collectors.toCollection(LinkedList::new));


        StringBuilder sb = new StringBuilder();
        char[] chars = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;
        boolean nowProbel = chars[0] != '_';
        while(left < word.length() && right >=0) {
            while (left < word.length() && chars[left] == '_') {
                nowProbel = true;
                sb.append('_');
                left++;
            }
            while (right >= 0 && chars[right] != '_'){
                nowProbel=false;
                sb.append(list.pollLast());
                right--;
            }

            if (nowProbel) {
                right--;
            } else {
                left++;
            }
        }
        return sb.toString();
    }

    public static int largestInteger(int[] nums, int k) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {

            if (!set.add(i)) {
                continue;
            }
            int repet = 0;
            int start = 0;
            for(int end = k; end < nums.length; end++) {
                for(int j = start; j <= end; j++) {
                    if (nums[j] == i) {
                        repet++;
                    }
                    if (repet > 1) {
                        break;
                    }
                }
                if (repet > 1) {
                    break;
                }
                start++;
            }
            result = repet == 1 && i > result ? i : result;
        }
        return result;
    }


}