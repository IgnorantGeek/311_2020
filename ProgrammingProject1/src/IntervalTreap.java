import java.util.ArrayList;
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
        root = null;
        size = 0;
        height = 0;
    }

    // TODO - Update imax in insert and delete

    // We can figure out which is the left/right child by looking at the key

    // The height can be updated in each rotation. Each node has a height


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


    // TODO - NEEDS TESTING
    /**
     * Insert a new node into the treap
     * @param z The node to insert
     */
    public void intervalInsert(Node z)
    {
        // INSERT SECTION
        Node y = null;
        Node x = root;
        // This doesn't seem like the best solution
        ArrayList<Node> update = new ArrayList<Node>();
        while (x != null)
        {
            y = x;
            // push the node to the update list
            update.add(x);
            if (z.interv.low < x.interv.low) x = x.left;
            else x = x.right;
        }
        update.add(z);
        // new
        boolean newNode = false;
        if (y != null && y.left == null && y.right == null)
        {
            newNode = true;
        }
        z.parent = y;
        if (y == null) root = z;
        else if (z.interv.low < y.interv.low) y.left = z;
        else y.right = z;

        // ROTATE SECTION
        while (y!= null && z.priority < y.priority)
        {
            // rotate up
            if (y.left == z) RightRotate(y);
            else LeftRotate(y);
            y = z.parent;
        }

        if (newNode)
        {
            for (Node node : update)
            {
                // update the height of each node
                if (node.left == null && node.right == null) /*do nothing*/;
                else if (node.left != null && node.right == null)
                {
                    node.height = 1 + node.left.height;
                }
                else if (node.left == null && node.right != null)
                {
                    node.height = 1 + node.right.height;
                }
                else node.height = (node.left.height > node.right.height) ? 1 + node.left.height : 1 + node.right.height;
            }
        }

        // Update size and height. This implies that the root has correct height
        // Need to update height of each node in insert function.
        size++;
        height = root.height;
    }

    /**
     * Delete the specified node from the treap
     * @param z
     */
    public void intervalDelete(Node z)
    {
        // Case 1
        if (z.left == null && z.right == null)
        {
            if (z.parent == null) root = null;
            else if (z.parent.left == z) z.parent.left = null;
            else z.parent.right = null;
            size--;
            // height
        }

        // Case 2
        if (z.left != null && z.right == null)
        {
            if (z.parent == null) root = z.left;
            else if (z.parent.left == z) z.parent.left = z.left;
            else z.parent.right = z.left;
            size--;
            //height
        }
        if (z.right != null && z.left == null)
        {
            if (z.parent == null) root = z.right;
            else if (z.parent.left == z) z.parent.left = z.right;
            else z.parent.right = z.right;
            size--;
            //height
        }

        // Case 3
        if (z.left != null && z.right != null)
        {
            // TODO
        }
    }
    
    // TODO - NEEDS TESTING
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
    private void LeftRotate(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
        int xheight = x.height;
        x.height = y.height;
        y.height = xheight;
    }

    private void RightRotate(Node x)
    {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;
        y.right = x;
        x.parent = y;
        int xheight = x.height;
        x.height = y.height;
        y.height = xheight;
    }

    public void inorder()
    {
         inorderRec(root);
    }

    private void inorderRec(Node n)
    {
        if (n != null)
        {
            inorderRec(n.left);
            n.printNode();
            inorderRec(n.right);
        }
    }

    private Node Minimum(Node x)
    {
        while (x.left != null)
        {
            x=x.left;
        }
        return x;
    }

    private Node Successor(Node x)
    {
        if (x.right != null)
        {
            return Minimum(x.right);
        }
        Node y = x.parent;
        while (y != null && x == y.right)
        {
            x=y;
            y=y.parent;
        }
        return y;
    }
}