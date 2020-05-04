import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        IntervalTreap treap = new IntervalTreap();

        // Interval i1 = new Interval(5, 16);
        // Interval i2 = new Interval(21, 24);
        // Interval i3 = new Interval(15, 18);
        // Interval i4 = new Interval(4, 8);
        // Interval i5 = new Interval(9, 17);

        // Node n1 = new Node(i1);
        // Node n2 = new Node(i2);
        // Node n3 = new Node(i3);
        // Node n4 = new Node(i4);
        // Node n5 = new Node(i5);
 
        // treap.intervalInsert(n1);
        // treap.intervalInsert(n2);
        // treap.intervalInsert(n3);
        // treap.intervalInsert(n4);
        // treap.intervalInsert(n5);

        File f = new File("treap_int.txt");
		String line;
		String [] split;
        try
        {
			Scanner sc = new Scanner(f);
            while(sc.hasNextLine())
            {
				line = sc.nextLine();
				split = line.split(" ");
				treap.intervalInsert(new Node(new Interval(Integer.parseInt(split[0]),Integer.parseInt(split[1]))));
            }
            
            sc.close();

            checkPriority(treap.root);

            int height = treap.getHeight();
            int height_calc = testHeightRecursive(treap.root, 0);

            if (height != height_calc)
            {
                System.out.println("Houston we have a problem");
                System.out.println("Height value: " + height);
                System.out.println("Calculated Height: " + height_calc);
            }
        }
        catch (FileNotFoundException e)
        {

        }
        

    }

    public static void checkPriority(Node n)
    {
        if (n.left == null && n.right == null) return;
        else if (n.left != null && n.right == null)
        {
            if (n.priority > n.left.priority)
            {
                System.out.println("Priority mismatch.");
            }
            checkPriority(n.left);
        }
        else if (n.left == null && n.right != null)
        {
            if (n.priority > n.right.priority)
            {
                System.out.println("Priority mismatch.");
            }
            checkPriority(n.right);
        }
        else
        {
            if (n.priority > n.left.priority || n.priority > n.right.priority)
            {
                System.out.println("Priority mismatch.");
            }
            checkPriority(n.left);
            checkPriority(n.right);
        }
    }

    public static int testHeightRecursive(Node n, int currentHeight)
    {
		int h = currentHeight;
		if(n.left!=null) h = testHeightRecursive(n.left, currentHeight+1);
		if(n.right!=null) h = Math.max(h, testHeightRecursive(n.right, currentHeight+1));
		return h;
	}
}