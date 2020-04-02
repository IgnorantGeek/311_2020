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
    
    // Default constructor
    public IntervalTreap()
    {
        // Initialize the root?
        root = new Node();
        size = 1;
        height = 1;
    }

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

    }

    // TODO
    public void intervalDelete(Node z)
    {

    }
    
    // TODO
    public Node intervalSearch(Interval i)
    {
        return null;
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

    private void LeftRotate(Node z)
    {
        // perform a left rotate on the specified node
    }

    private void RightRotate(Node z)
    {
        // perform a right rotate on the specified node
    }
}