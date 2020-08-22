package dataStructure;


import java.util.PriorityQueue;

/**
 * Huffman Tree
 * given n piles fruits,mass of each pile is known
 * u can merge 2 piles once,try to design a sequence to save your energe
 * example: 3 piles ,mass: 1 2 9, merge 1+2=3,merge 3+9=12,total cost=3+12=15
 */
public class fruitsMerge {
    int fruitmerge(int n, int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Integer x, y, ans = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(nums[i]);
        }
        while (minHeap.size() > 1) {
            x = minHeap.element();
            minHeap.poll();
            y = minHeap.element();
            minHeap.poll();
            minHeap.add(x + y);
            ans += x + y;
            System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,2,3,6};
        int n=nums.length;
        System.out.println(new fruitsMerge().fruitmerge(n, nums));
    }
}
