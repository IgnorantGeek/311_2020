public class Test
{
    public static void main(String[] args)
    {
        IntervalTreap treap = new IntervalTreap();

        Interval i1 = new Interval(3, 6);
        Interval i2 = new Interval(2, 4);
        Interval i3 = new Interval(1, 2);

        Node n1 = new Node(i1);
        Node n2 = new Node(i2);
        Node n3 = new Node(i3);

        treap.intervalInsert(n1);
        treap.intervalInsert(n2);
        treap.intervalInsert(n3);

        System.out.println("Root: [" + treap.root.interv.low + "," + treap.root.interv.high + "] " + treap.root.priority);

        treap.inorder();
    }
}