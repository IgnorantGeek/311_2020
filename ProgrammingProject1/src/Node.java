import java.util.Random;

/** Treap Node Class
 * 
 * @author Nick Heisler and Tom Frye
 */

public class Node
{
    public Interval interv;
    public int priority;
    public Node parent;
    public Node left;
    public Node right;
    public int imax;
    public int height;

    /*-----Constructors---------*/
    public Node() { }

    public Node(Interval i)
    {
        interv = i;
        parent = null;
        left = null;
        right = null;
        height = 0;
        Random rand = new Random();
        priority = rand.nextInt(1000);
    }

    // Manually set priority for testing
    public Node(Interval i, int priority)
    {
        interv = i;
        parent = null;
        left = null;
        right = null;
        height = 0;
        this.priority = priority;
    }


    /*----Class Methods----------*/
    /**
     * @return the imax
     */
    public int getImax()
    {
        return imax;
    }

    /**
     * @return the interv
     */
    public Interval getInterv()
    {
        return interv;
    }

    /**
     * @return the left
     */
    public Node getLeft()
    {
        return left;
    }

    /**
     * @return the parent
     */
    public Node getParent()
    {
        return parent;
    }

    /**
     * @return the priority
     */
    public int getPriority()
    {
        return priority;
    }

    /**
     * @return the right
     */
    public Node getRight()
    {
        return right;
    }

    /**
     * @return the height
     */
    public int getHeight()
    {
        return height;
    }
}