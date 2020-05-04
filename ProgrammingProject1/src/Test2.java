import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test2
{
    public static void main(String[] args)
    {
        IntervalTreap treap = new IntervalTreap();
        ArrayList<Interval> TP = new ArrayList<Interval>();
        ArrayList<Interval> TN = new ArrayList<Interval>();

        File f = new File("large_1.txt");
		String line;
		String [] split;
        try
        {
			Scanner sc = new Scanner(f);
			sc.nextLine(); //skip first line "TP"
            while (sc.hasNextLine())
            {
				line = sc.nextLine();
				if (line.equals("TN")) break;
                split = line.split(" ");
                TP.add(new Interval(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
			}
            while (sc.hasNextLine())
            {
				line = sc.nextLine();
				if (line.equals("Intervals")) break;
                split = line.split(" ");
                TN.add(new Interval(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
			}
            while(sc.hasNextLine())
            {
				line = sc.nextLine();
				split = line.split(" ");
				treap.intervalInsert(new Node(new Interval(Integer.parseInt(split[0]),Integer.parseInt(split[1]))));
            }
            
            sc.close();
        }
        catch (FileNotFoundException e)
        {

		}

        System.out.println("Test the search function. If we see no other output, the test has passed.");

        for (Interval i : TP)
        {
            Node n = treap.intervalSearch(i);
            
            if (n == null)
            {
                System.out.println("Null node. Could not find interval [" + i.low + " " + i.high + "]");
            }
        }

        for (Interval i : TN)
        {
            Node n = treap.intervalSearch(i);

            if (n != null)
            {
                System.out.println("Match found. Interval [" + i.low + " " + i.high + "]");
            }
        }

        int height = treap.getHeight();
        int height_calc = Test.testHeightRecursive(treap.root, 0);

        if (height != height_calc)
        {
            System.out.println("Houston we have a problem");
            System.out.println("Height value: " + height);
            System.out.println("Calculated Height: " + height_calc);
            System.out.println("Left Child height: " + treap.root.left.height);
            System.out.println("Right Child height: " + treap.root.right.height);
        }
    }    
}