package com.company;

public class Node {
    public com.company.Node next;
    public com.company.Node prev;
    public int Data;

    //constructor to create node
    Node(int data){
        Data= data;
        prev=null;
        next=null;
    }
}
