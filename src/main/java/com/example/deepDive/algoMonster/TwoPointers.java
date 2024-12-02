package com.example.deepDive.algoMonster;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    }
}
