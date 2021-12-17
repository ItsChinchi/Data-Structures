package com.company;

public class double_linkedlist {

    static Node head=null; //ref to first node
    static Node tail=null; //ref to last node

    public static boolean AddNode(int data) {
        boolean retval = false;
        Node node = new Node(data); //node created
        if (node != null) { //node created
            if (head == null) { //empty list
                head = tail = node;

            } else {
                tail.next = node; //1
                node.prev = tail; //2
                tail = node; //3
            }
            retval = true;
        } //end of first if
        return retval;
    } //end of AddNode


    public static Node SearchNode(int data){
        Node node;
        node=head;
        while(node != null && node.Data!=data){
            node=node.next;
        }
        return node;
    }//end of search node

    public static boolean InsertNode(int data, int loc){
        boolean retval = false;
        Node node = new Node(data);
        if(node!= null){ //node existed
            if(head==null){
                head=tail=node;
                retval=true;
            }
            else{ //there's a list
                if(loc==0) {//first node
                    node.prev=head;//1
                    head.prev=node;//2
                    head=node;//3
                    retval=true;
                }
                else{ //mid or last
                    Node temp;
                    temp =head;
                    for(int i=0; i<loc-1 && temp!=null; i++){
                        temp=temp.next;
                    }//end for
                    if (temp==null || temp==tail) { //insert last node
                        tail.next=node; //1
                        node.prev=tail;//2
                        tail=node;//3

                    } //end if
                    else { //insert mid
                        temp.next.prev = node;//1
                        node.next = temp.next;//2
                        node.prev = temp;//3
                        temp.next = node;//4
                    }
                }//end of 2nd else
            }//end of first else
            retval=true;
        }//end of first if
        return retval;
    }//end of Insert node

    public static boolean DeleteNode(int loc){
        boolean retval = false;
        if(head!=null){//there's a list
            if(loc==0){//first node
                if(head==tail){//only one node
                    head=tail=null;
                }
                else{//there's more than one node
                    head.next.prev=null;
                    head=head.next;
                }
                retval=true;
            }
            else { //mid or last
                Node temp;
                temp=head;
                for(int i=0; i<loc && temp!=null; i++){
                    temp=temp.next;
                }
                if(temp!=null){//there's a node
                    retval =true;
                    if(temp==tail){//last node
                        tail=tail.prev;
                        tail.next=null;
                    }
                    else{
                        temp.prev.next=temp.next;
                        temp.next.prev=temp.prev;
                    }
                }
            }
        }
        return retval;
    }
} //end of double linkedlist
