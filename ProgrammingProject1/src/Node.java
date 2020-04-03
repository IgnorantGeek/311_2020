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

    /*-----Constructors---------*/
    public Node() { }

    public Node(Interval i)
    {
        interv = i;
        parent = null;
        left = null;
        right = null;
        Random rand = new Random();
        priority = rand.nextInt(1000);
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
}