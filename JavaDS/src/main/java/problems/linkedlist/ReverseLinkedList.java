package problems.linkedlist;

//Time Complexity: O(n)
//Space Complexity:O(1)
public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        //to create the initial nodes
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode current=head;
        ListNode prev=null;

        while(current!=null){
            ListNode nextNode=current.next;
            current.next=prev;
            prev=current;
            current=nextNode;
        }

        return prev;

    }

    // Helper method to print the list visually
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // 2. The Main Method where execution happens
    public static void main(String[] args) {
        // Here we USE the constructor to create 4 distinct nodes in memory
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original List: ");
        printList(head);

        // Reverse the list in-place (rewiring the existing nodes)
        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List: ");
        printList(reversedHead);
    }
}
