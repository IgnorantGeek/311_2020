import java.util.Scanner;

public class TreapIterator
{
    Scanner scan;
    IntervalTreap treap;
    Node current;
    
    public TreapIterator(IntervalTreap treap)
    {
        scan = new Scanner(System.in);
        this.treap = treap;
    }

    public void start()
    {
        // Start the iterator at the root?
        current = treap.root;

        // Scan for input from the user
        boolean run = true;
        while (run)
        {
            String command = scan.nextLine();
            switch (command)
            {
                case "print":
                    current.printNode();
                    break;
                case "print-left":
                    if (current.left != null) current.left.printNode();
                    else System.out.println("No left child.");
                    break;
                case "print-right":
                    if (current.right != null) current.right.printNode();
                    else System.out.println("No right child.");
                    break;
                case "go-left":
                    if (current.left != null) current = current.left;
                    else System.out.println("No left child.");
                    break;
                case "go-right":
                    if (current.right != null) current = current.right;
                    else System.out.println("No right child.");
                    break;
                case "go-up":
                    if (current.parent != null) current = current.parent;
                    break;
                case "priority":
                    System.out.println(current.priority);
                    break;
                case "height":
                    System.out.println(current.height);
                    break;
                case "interval":
                    System.out.println("[" + current.interv.low + " " + current.interv.high + "]");
                    break;
                case "quit":
                    run = false;
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }

            System.out.println();
        }
    }
}