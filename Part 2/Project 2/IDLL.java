public class IDLL<AnyType extends IDedObject>   {

    Node head;

    public IDLL()
    {
        head = new Node(null, null, null);
    }

    /* Empties the linked list by making the sentinel node null
    *  @param none
    *  @return none
     */
    public void makeEmpty()
    {
        head.next = null;
    }

    /* Traverses linked list, ending at Node with element x
    *  @param int ID
    *  @return AnyType
     */
    public void findID(int x)
    {
        findID(x, head);
    }

    public AnyType findID(int e, Node x)
    {

        if(head.next == null)
        {
            return null;
        }

    }


    // Node subclass
    public class Node <Node>  {
        AnyType element;
        Node prev;
        Node next;

        public Node(AnyType data, Node previous, Node n)
        {
            element = data;
            prev = previous;
            next = n;
        }
    }

}
