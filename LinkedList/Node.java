/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_test.LinkedList;

/**
 *
 * @author Sony
 */
public class Node<E> {
         public E item;
        public Node<E> next;
        public Node<E> prev;
   
       public Node(E i) {
            this.item = i;
        }
        public Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

