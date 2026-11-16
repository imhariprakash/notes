public class SinglyLinkedList 
{
    public static void main(String[] args) 
    {
        
    }
}

class Node
{
    private int value;
    private Node next = null;

    Node(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node nextNode)
    {
        this.next = nextNode;
    }

    public void appendToTail(int value)
    {
        Node newNode = new Node(value);
        Node ptr = this;
        while(ptr.getNext() != null)
        {
            ptr = ptr.getNext();
        }
        ptr.setNext(newNode);
    }
}
