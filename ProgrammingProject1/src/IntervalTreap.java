import java.util.List;

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


    // EXTRA CREDIT METHODS (NOT REQUIRED)
    
    // TODO
    public Node intervalSearch(Interval i)
    {
        return null;
    }

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
}