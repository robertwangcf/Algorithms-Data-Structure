
import java.util.LinkedList;
import java.util.List;
import javaapplication_test.LinkedList.Node;

/*
 * Problem: Reverse a singly linked list.
 */
public class ReverseLinkedList {
    //this is the list for reversing
    
    public Node reverseLinkedList(Node head) {
        Node prev = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
   
  
   
  
   
    public static void main(String[] args) {
         Node node1 = new Node("1");
         Node node2 = new Node("2");
         Node node3 = new Node("I am a tail before reverse but a head after that");
        node1.next = node2;
        node2.next = node3;
        
        System.out.println("Original list head:" + node1.item);
        System.out.println("Modified list head:" + new ReverseLinkedList().reverseLinkedList(node1).item);
  
}
 
}