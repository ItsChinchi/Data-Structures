package com.company;

public class SingleLinkedList {
    static Node Head = null;

    /*Create Node is used to allocate a node in the memory and fill its data, then return a
    reference to the node. If it can’t allocate the node, then the returned reference will be null.*/
    static Node CreateNode(int Data) {
        Node node = new Node();
        if (node != null) {
            node.data = Data;
            node.Next = null;
        }
        return node;
    }//end of CreateNode method



    /*The addNode is used to add the created node at the end of the linked list. It start by calling
CreateNode, then check if the node is allocated, so it will add it at the end.
The method return bool (true if the node is allocated and added, false if it couldn’t allocate the node
and it is not added)*/
    public static boolean AddNode(int Data) {
        boolean retval = false;
        Node node;
        Node temp;
        node = CreateNode(Data);
        if (node != null) {
            if (Head == null) { //no list
                Head = node;
            } else { //there's a list
                temp = Head;
                while (temp != null) {
                    temp = temp.Next;
                } //end while
                temp.Next = node;
            }//end else
            retval = true;
        }//end if
        return retval;
    } //end of AddNode method




   /* public static void printList(SingleLinkedList list)
    {
        Node currNode = list.Head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.Next;
        }
    }*/




    /*insert node is used to insert node in a specific location by the user.
    location is ZERO based, if the location is greater than number of existing node,
    it will be inserted at the end  */
    public static boolean InsertNode(int data, int Loc){
        boolean retval = false;
        Node node;
        Node temp;
        node = CreateNode(data);
        if(node!=null){
            if(Head==null){ //no list
                Head = node;
            }
            else { //there's a list
            if(Loc==0){ //first node
                node.Next=Head;
                Head=node;
            } //end of if //enta kda 7atet el node fel bdaya
                else{
                    temp=Head;
                    for(int i=0; (i<Loc-1) && (temp.Next!=null); i++){
                        temp=temp.Next;
                }//end of for
                if(temp.Next==null) {//last node
                temp.Next=node;
                } //end of if
                else{
                    node.Next=temp.Next;
                    temp.Next=node;
                } //end of 3rd else
            } //end of 2nd else
            }//end of 1st else
            retval=true;
        }
        return retval;
    } //end of InsertNode



public static Node SearchNode(int data){
        Node node;
        node=Head;
        while(node.data!=data && node!=null){
            node = node.Next;
        } //end of while
    return node;
    }//end of SearchNode



public void DeleteNode(int loc){
        if(loc==0) { //first node
            Head = Head.Next;  //5let el head y4awr 3la el node elly b3do
        }//end of if
        else{
            Node temp=Head;
            for(int i=0; (i<loc-1)&&(temp!=null); i++){
                temp=temp.Next;
            }//if for
         Node node =temp.Next;
            temp.Next=node.Next;
        }
}//end of DeleteNode

}//end class SingleLinkedList


