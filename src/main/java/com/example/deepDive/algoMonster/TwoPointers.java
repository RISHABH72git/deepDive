package com.example.deepDive.algoMonster;

import java.util.*;

public class TwoPointers {
    public static int removeDuplicates(List<Integer> arr) {
        int pointer = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (!arr.get(i).equals(arr.get(pointer))) {
                pointer++;
                arr.set(pointer, arr.get(i));
            }
        }
        return pointer + 1;
    }

    public static int middleOfLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static List<Integer> moveZeros(List<Integer> nums) {
        int slow = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) != 0) {
                int slowNum = nums.get(slow);
                nums.set(slow, nums.get(i));
                nums.set(i, slowNum);
                slow++;
            }
        }
        return nums;
    }

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        List<Integer> list = new ArrayList<>();
        while (left < right) {
            int twoSum = arr.get(right) + arr.get(left);
            if (twoSum == target) {
                list.add(left);
                list.add(right);
                break;
            } else if (twoSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return list;
    }

    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(arr[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(arr[r])) {
                r--;
            }
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static int containerWithMostWater(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(arr.get(left), arr.get(right)) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (arr.get(left) < arr.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int subarraySumFixed(List<Integer> nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums.get(i);
        }
        int largest = windowSum;
        for (int right = k; right < nums.size(); right++) {
            int left = right - k;
            windowSum -= nums.get(left);
            windowSum += nums.get(right);
            largest = Math.max(largest, windowSum);
        }
        return windowSum;
    }

    public static List<Integer> findAllAnagrams(String original, String check) {
        int originalLen = original.length();
        int checkLen = check.length();
        ArrayList<Integer> res = new ArrayList<>();
        if (originalLen < checkLen) return res;

        // stores the frequency of each character in the check string
        int[] checkCounter = new int[26];
        // stores the frequency of each character in the current window
        int[] window = new int[26];
        for (int i = 0; i < checkLen; i++) {
            checkCounter[check.charAt(i) - 'a']++;
            window[original.charAt(i) - 'a']++;
        }
        if (Arrays.equals(window, checkCounter)) res.add(0);
        for (int i = checkLen; i < originalLen; i++) {
            System.out.println(Arrays.toString(window));
            System.out.println(original.charAt(i - checkLen));
            window[original.charAt(i - checkLen) - 'a']--;
            System.out.println(Arrays.toString(window));
            window[original.charAt(i) - 'a']++;
            System.out.println(Arrays.toString(window));
            if (Arrays.equals(window, checkCounter)) {
                System.out.println("+++++++++++++++++++");
                System.out.println(Arrays.toString(window));
                System.out.println(Arrays.toString(checkCounter));
                System.out.println("==========================");
                res.add(i - checkLen + 1);
            }
        }
        return res;
    }

    private static int subarraySumLongest(List<Integer> nums, Integer target) {
        int windowSum = 0;
        int length = 0;
        int left = 0;
        for (int right = 0; right < nums.size(); right++) {
            windowSum += nums.get(right);
            while (windowSum > target) {
                windowSum -= nums.get(left);
                ++left;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    private static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    private static int minConsecutiveCards(int[] chars) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int minlength = Integer.MAX_VALUE;
        for (int right = 0; right < chars.length; right++) {
            int key = chars[right];
            if (hashMap.containsKey(key)) {
                int left = hashMap.get(key);
                minlength = Math.min(minlength, right - left + 1);
            }
            hashMap.put(key, right);
        }
        System.out.println(hashMap);
        return minlength == Integer.MAX_VALUE ? -1 : minlength;
    }

    public static boolean linkedListCycle(LinkedListCycle<Integer> listNode) {
        LinkedListCycle<Integer> tortoise = nextNode(listNode);
        LinkedListCycle<Integer> hare = nextNode(nextNode(listNode));
        while (tortoise != hare && hare.next != null) {
            tortoise = nextNode(tortoise);
            hare = nextNode(nextNode(hare));
        }
        return hare.next != null;
    }

    private static LinkedListCycle<Integer> nextNode(LinkedListCycle<Integer> listNode) {
        System.out.println(listNode.val);
        if (listNode.next == null) {
            return listNode;
        }
        return listNode.next;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        System.out.println(sArr);
        System.out.println(tArr);
        int left = 0;
        int right = 0;
        while (left < sArr.length) {
            if (tArr[left] != sArr[right]) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }

    private static boolean isAnagramWithoutSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    private static List<Integer> findAllAnagramInString(String original, String check) {
        ArrayList<Integer> res = new ArrayList<>();
        if (original.length() < check.length()) return res;
        int[] checkCounter = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < check.length(); i++) {
            checkCounter[check.charAt(i) - 'a']++;
            window[original.charAt(i) - 'a']++;
        }
        if (Arrays.equals(checkCounter, window)) res.add(0);

        for (int i = check.length(); i < original.length(); i++) {
            window[original.charAt(i - check.length()) - 'a']--;
            window[original.charAt(i) - 'a']++;
            if (Arrays.equals(window, checkCounter)) res.add(i - check.length() + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(removeDuplicates(list));
        LinkedListNode<Integer> linkedListNode = new LinkedListNode<Integer>(1);
        System.out.println(middleOfLinkedList(linkedListNode));
        System.out.println(list);
        System.out.println(moveZeros(list));
        System.out.println(twoSumSorted(List.of(2, 3, 4, 5, 8, 11, 18), 8));
        System.out.println(isPalindrome("civic"));
        System.out.println(containerWithMostWater(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7)));
        System.out.println(subarraySumFixed(List.of(1, 8, 6, 2, 5, 4, 8, 3, 7), 3));
        System.out.println("-------------------");
        System.out.println(findAllAnagrams("cbaebabacd", "abc"));
        System.out.println(subarraySumLongest(list, 7));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(minConsecutiveCards(new int[]{3, 4, 2, 3, 4, 7}));
        NumArray numArray = new NumArray(new int[]{3, 6, 9, 8, 4});
        //sum in constant time
        System.out.println(numArray.sumRange(1, 4));
        System.out.println("+++++++++++++++++++++++++++");
        List<Integer> integerArraysList = List.of(0, 1, 2, 3, 4);
        ArrayList<LinkedListCycle<Integer>> nodesList = new ArrayList<>();
        for (int i = 0; i < integerArraysList.size(); i++) {
            nodesList.add(new LinkedListCycle<Integer>(i));
        }
        for (int i = 0; i < integerArraysList.size(); i++) {
            if (integerArraysList.get(i) != -1) {
                nodesList.get(i).next = nodesList.get(integerArraysList.get(i));
            }
        }
        LinkedListCycle<Integer> nodes = nodesList.get(0);
        System.out.println(linkedListCycle(nodes));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagramWithoutSort("rat", "car"));
        System.out.println(findAllAnagramInString("cbaebabacd", "abc"));
    }


}

class NumArray {
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
    }

    public int sumRange(int left, int right) {
        System.out.println(prefixSum[right + 1]);
        System.out.println(prefixSum[left]);
        return prefixSum[right + 1] - prefixSum[left];
    }
}

class LinkedListCycle<T> {
    T val;
    LinkedListCycle<T> next;

    public LinkedListCycle(T val) {
        this(val, null);
    }

    public LinkedListCycle(T val, LinkedListCycle<T> next) {
        this.val = val;
        this.next = next;
    }
}
