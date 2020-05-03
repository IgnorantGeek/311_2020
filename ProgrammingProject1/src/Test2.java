import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2
{
    public static void main(String[] args)
    {
        IntervalTreap treap = new IntervalTreap();
        
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
			}
            while (sc.hasNextLine())
            {
				line = sc.nextLine();
				if (line.equals("Intervals")) break;
				split = line.split(" ");
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
        treap.inorder();

        System.out.println("\nRoot Node:");
        treap.root.printNode();    
    }    
}