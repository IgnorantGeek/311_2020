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
        imax = interv.high;
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
        imax = interv.high;
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

    /**
     * Print the formatted node
     */
    public void printNode()
    {
        System.out.println("[" + interv.low + "," + interv.high + "]");
        System.out.println("priority: " + priority);
        System.out.println("imax : " + imax + " | height : " + height);
    }

    public void updateImax()
    {
        // If the node has no children, height is zero
        if (this.left == null && this.right == null) this.imax = this.interv.high;

        // If the node has one child, height is 1 + the height of that child
        else if (this.left != null && this.right == null)
        {
            this.imax = (this.imax > this.left.imax) ? this.imax : this.left.imax;
        }
        else if (this.left == null && this.right != null)
        {
            this.imax = (this.imax > this.right.imax) ? this.imax : this.right.imax;
        }

        // If the node has two children, height is 1 + the max of the children's height
        else
        {
            int submax = (this.left.imax > this.right.imax) ? this.left.imax : this.right.imax;
            this.imax = (submax > this.interv.high) ? submax : this.interv.high;
        }
    }
}