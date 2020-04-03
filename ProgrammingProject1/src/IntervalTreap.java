import java.util.List;

/** Interval Treap Class
 * 
 * @author Nick Heisler and Tom Frye
 */
public class IntervalTreap
{
    public Node root;

    // may not need to store these, leaving them for now
    public int size;
    public int height;
    
    /*-----Constructors---------*/
    public IntervalTreap()
    {
        // Initialize the root?
        root = new Node();
        size = 1;
        height = 0;
    }

    public IntervalTreap(Interval i)
    {
        root = new Node(i);
        size = 1;
        height = 0;
    }


    /*----Class Methods----------*/
    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @return the root
     */
    public Node getRoot()
    {
        return root;
    }

    /**
     * @return the size
     */
    public int getSize()
    {
        return size;
    }


    // TODO
    public void intervalInsert(Node z)
    {
        // Generate a random priority, insert the node the same way as a BST
        // Then, if the priority is not valid, perform rotations until the 
        // treap is correctly ordered
    }

    // TODO
    public void intervalDelete(Node z)
    {

    }
    
    // TODO - Needs testing
    /**
     * Searches for the specified interval in the treap
     * @param i the interval
     * @return the node containing the interval, or null if not found
     */
    public Node intervalSearch(Interval i)
    {
        Node x = root;
        while (x != null && !i.Overlap(x.interv))
        {
            if (x.left != null && x.left.imax >= i.low)
            {
                x = x.left;
            }
            else x = x.right;
        }
        return x;
    }


    // EXTRA CREDIT METHODS (NOT REQUIRED)

    // TODO
    public Node intervalSearchExactly(Interval i)
    {
        return null;
    }

    // TODO
    public List<Interval> overlappingIntervals(Interval i)
    {
        return null;
    }

    /*-------Helper Methods-------*/
    private void LeftRotate(Node z)
    {
        // perform a left rotate on the specified node
    }

    private void RightRotate(Node z)
    {
        // perform a right rotate on the specified node
    }
}