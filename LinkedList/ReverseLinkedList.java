
import java.util.LinkedList;

/*
 * Problem: Reverse a singly linked list.
 */
public class ReverseLinkedList {
    static LinkedList list = new LinkedList();
    //static String i = "1";
   
  
   
    public static void main(String[] args) {
         Node head = new Node("1");
         Node tail = new Node("2");
         Node a = head;
         Node b = a;
         b = b.next;
         try{
   
    list.add(head);
    list.add(tail);
     
}
    catch (Exception e) {
    e.printStackTrace();
    }
         System.out.println(a.item);
  
}
 private static class Node<E> {
         E item;
        Node<E> next;
        Node<E> prev;
   
        Node(E i) {
            this.item = i;
        }
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}