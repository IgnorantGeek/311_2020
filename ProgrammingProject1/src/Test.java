public class Test
{
    public static void main(String[] args)
    {
        IntervalTreap treap = new IntervalTreap();

        Interval i1 = new Interval(5, 16);
        Interval i2 = new Interval(21, 24);
        Interval i3 = new Interval(15, 18);
        Interval i4 = new Interval(4, 8);
        Interval i5 = new Interval(9, 17);

        Node n1 = new Node(i1);
        Node n2 = new Node(i2);
        Node n3 = new Node(i3);
        Node n4 = new Node(i4);
        Node n5 = new Node(i5);
 
        treap.intervalInsert(n1);
        treap.intervalInsert(n2);
        treap.intervalInsert(n3);
        treap.intervalInsert(n4);
        treap.intervalInsert(n5);

        System.out.println("Root: [" + treap.root.interv.low + "," + treap.root.interv.high + "] " + treap.root.priority + "\n");

        treap.inorder();
    }
}