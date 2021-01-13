package Daily.hard._1203;

import java.util.*;

public class Solution1 {
    private HashMap<Integer, myItem> items = new HashMap<>();
    private List<List<Integer>> beforeItems;
    private List<Integer> waitingList;
    private HashMap<Integer, List<Integer>> itemGroup = new HashMap<>();


    private class myItem {
        int day;
        public myItem() {
            this.day = 0;
        }

        public myItem(int layer) {
            this.day = layer;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }


    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        this.beforeItems = beforeItems;
        for (int i = 0; i < group.length; ++i) {
            if (itemGroup.containsKey(group[i])) {
                int key = group[i];
                List<Integer> integers = itemGroup.get(key);
                integers.add(i);
                itemGroup.replace(group[i],integers);
            } else {
                itemGroup.put(group[i], Arrays.asList(i));
            }
        }

        TreeMap<Integer, Integer> sortedgroup = new TreeMap<>();
        itemGroup.entrySet().forEach((entry)->{
            int sum = entry.getValue().stream().reduce(0, Integer::sum);
            sortedgroup.put(sum, entry.getKey());
        });

        sortedgroup.computeIfAbsent()
        sortedgroup.forEach((key, value)->{
            List<Integer> groupWithMinSum = itemGroup.get(value);
            for (Integer item:groupWithMinSum) {


            }


        });





    }


    public myItem getItem(int itemno) {
        if (items.containsKey(itemno)) {
            return items.get(itemno);
        }

        List<Integer> parents = beforeItems.get(itemno);
        if (parents.size() == 0) {
            myItem res = new myItem();
            items.put(itemno, res);
            return res;
        }
        else {
            waitingList.add(itemno);
            int maxday = 0;
            for (Integer parent: parents) {
                if (waitingList.contains(parent)) {
                    return null;
                }
                myItem parentItem = getItem(parent);
                if (parentItem == null) {
                    return null;
                }
                if (parentItem.day > maxday) {
                    maxday = parentItem.day;
                }
            }
            myItem res = new myItem(maxday);
            return res;
        }
    }

}
