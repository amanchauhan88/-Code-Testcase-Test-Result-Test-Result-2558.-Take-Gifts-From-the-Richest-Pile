import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max heap to keep track of the largest piles
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements from gifts array into the max heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                // Take the largest pile
                int largest = maxHeap.poll();

                // Calculate the remaining gifts in the pile
                int remaining = (int) Math.floor(Math.sqrt(largest));

                // Add the remaining gifts back into the max heap
                maxHeap.add(remaining);
            }
        }

        // Sum up the remaining gifts in all piles
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}
