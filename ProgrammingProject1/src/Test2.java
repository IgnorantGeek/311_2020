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

        File f = new File("small_1.txt");
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
        // treap.inorder();

        // System.out.println("\nRoot Node:");
        // treap.root.printNode();

        System.out.println("Test section");

        for (Interval i : TP)
        {
            Node n = treap.intervalSearch(i);
            
            if (n == null)
            {
                System.out.println("Null node. Could not find interval [" + i.low + " " + i.high + "]");
            }
        }
    }    
}