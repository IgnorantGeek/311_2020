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

        File f = new File("small_1.txt");
		String line;
		String [] split;
		try {
			Scanner sc = new Scanner(f);
			sc.nextLine(); //skip first line "TP"
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.equals("TN")) break;
				split = line.split(" ");
			}
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.equals("Intervals")) break;
				split = line.split(" ");
			}
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				split = line.split(" ");
				treap.intervalInsert(new Node(new Interval(Integer.parseInt(split[0]),Integer.parseInt(split[1]))));
            }
            
            sc.close();
		} catch (FileNotFoundException e) {
		}
        treap.inorder();

        System.out.println("\nRoot: [" + treap.root.interv.low + "," + treap.root.interv.high + "] " + "Height: " + treap.root.height + " iMax: " + treap.root.imax);

        treap.intervalDelete(treap.root);


        System.out.println("\nRoot: [" + treap.root.interv.low + "," + treap.root.interv.high + "] " + "Height: " + treap.root.height + " iMax: " + treap.root.imax);
    }
}