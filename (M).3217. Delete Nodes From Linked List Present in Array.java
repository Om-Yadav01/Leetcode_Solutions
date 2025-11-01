class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Use a HashSet for O(1) lookup
        Set<Integer> toRemove = new HashSet<>();
        for (int num : nums) {
            toRemove.add(num);
        }
        
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        // Traverse the list
        while (current.next != null) {
            if (toRemove.contains(current.next.val)) {
                // Skip the node
                current.next = current.next.next;
            } else {
                // Move to next node
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}
