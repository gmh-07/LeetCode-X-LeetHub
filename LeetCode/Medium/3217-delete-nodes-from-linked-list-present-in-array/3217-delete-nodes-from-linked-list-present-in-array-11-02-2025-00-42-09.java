class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; // skip node
            } else {
                prev = curr; // move forward
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
