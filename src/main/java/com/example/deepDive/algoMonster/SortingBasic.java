package com.example.deepDive.algoMonster;

import java.util.*;

public class SortingBasic {

    public static void main(String[] args) {
        List<Integer> unsortedList = Arrays.asList(33, 4, 7, 1, 3, 9, 2, 0, 13);
        List<Integer> insertionSorted = insertionSort(unsortedList);
        System.out.println("insertion sorting :" + insertionSorted);
        List<Integer> selectionSorted = selectionSort(unsortedList);
        System.out.println("selection sorting :" + selectionSorted);
        List<Integer> bubbleSorted = bubbleSort(unsortedList);
        System.out.println("bubble sorting :" + bubbleSorted);
        List<Integer> mergedSorted = mergeSort(unsortedList, 0, unsortedList.size());
        System.out.println("merge sorting :" + mergedSorted);
        List<Integer> quickSorted = quickSort(unsortedList, 0, unsortedList.size());
        System.out.println("quick sorting :" + quickSorted);
        inBuildSort(unsortedList);
    }

    private static void inBuildSort(List<Integer> list) {
        Collections.sort(list);
        System.out.println(list);
        list.sort(Collections.reverseOrder());
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);
    }

    private static List<Integer> insertionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int current = i;
            while (current > 0 && list.get(current) < list.get(current - 1)) {
                int temp = list.get(current);
                list.set(current, list.get(current - 1));
                list.set(current - 1, temp);
                current--;
            }
        }
        return list;
    }

    private static List<Integer> selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        return list;
    }

    private static List<Integer> bubbleSort(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            boolean swap = false;
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swap = true;
                }
            }
            if (!swap) {
                return list;
            }
        }
        return list;
    }

    private static List<Integer> mergeSort(List<Integer> list, int start, int end) {
        if (end - start <= 1) {
            return list.subList(start, end);
        }
        int mid = (start + end) / 2;
        List<Integer> leftList = mergeSort(list, start, mid);
        List<Integer> rightList = mergeSort(list, mid, end);

        ArrayList<Integer> resultList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            if (leftPointer == leftList.size()) {
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == rightList.size()) {
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else {
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }
        return resultList;
    }

    private static List<Integer> quickSort(List<Integer> unsort, int start, int end) {
        if (end - start <= 1) {
            return unsort.subList(start, end);
        }

        int pivot = unsort.get(end - 1);

        int startPtr = start, endPtr = end - 1;

        while (startPtr < endPtr) {
            while (unsort.get(startPtr) < pivot && startPtr < endPtr) {
                startPtr++;
            }

            while (unsort.get(endPtr) >= pivot && startPtr < endPtr) {
                endPtr--;
            }

            if (startPtr != endPtr) {
                int temp = unsort.get(startPtr);
                unsort.set(startPtr, unsort.get(endPtr));
                unsort.set(endPtr, temp);
            }
        }
        int temp = unsort.get(startPtr);
        unsort.set(startPtr, unsort.get(end - 1));
        unsort.set(end - 1, temp);

        quickSort(unsort, start, startPtr);
        quickSort(unsort, startPtr + 1, end);
        return unsort;
    }

}
