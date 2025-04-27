// Time Complexity : O(N log k) where N = total nodes in all k lists
// Space Complexity : O(k) -> to store in min-heap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a min-heap (priority queue) to always fetch the node with the smallest value.
//   - Insert the head of each list into the heap initially.
//   - Keep polling the smallest element, attach it to the result, and push its next node (if exists) back to the heap.
//   - Continue until the heap is empty and return the merged list.

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    //approach - merge 2 lists at a time and go on like that
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode merged = new ListNode(Integer.MIN_VALUE);
    //     for(ListNode list: lists) {
    //         merged =  merge(merged, list);
    //     }
    //     return merged.next;
    // }

    // private ListNode merge(ListNode head1, ListNode head2) {
    //     ListNode dummy = new ListNode(-1);
    //     ListNode curr = dummy;

    //     while(head1 != null && head2 != null) {
    //         if(head1.val < head2.val) {
    //             curr.next = head1;
    //             head1 = head1.next;
    //         } else {
    //             curr.next = head2;
    //             head2 = head2.next;
    //         }
    //     }

    //     if(head1 != null) {
    //         curr = head1;
    //     }
    //     if(head2 != null) {
    //         curr = head2;
    //     }
    //     return dummy.next;
    // }

    //Approach - use a min-heap
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(ListNode list: lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            if(minNode.next != null) {
                //push it to pq
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});

        System.out.println("Merged Sorted List:");
        ListNode mergedHead = solution.mergeKLists(lists);
        printList(mergedHead);
    }
}
