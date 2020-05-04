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
    
    /*-----Constructors---------*/
    public IntervalTreap()
    {
        root = null;
        size = 0;
    }

    /*----Class Methods----------*/
    /**
     * @return the height
     */
    public int getHeight()
    {
        if (root == null) return -1;
        else return root.height;
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


    /**
     * Insert a new node into the treap
     * @param z The node to insert
     */
    public void intervalInsert(Node z)
    {
        // INSERT SECTION
        Node y = null;
        Node x = root;
        while (x != null)
        {
            y = x;
            if (z.interv.low < x.interv.low) x = x.left;
            else x = x.right;
        }
        boolean update = false;
        if (y != null)
        {
            update = true;
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

        // UPDATE HEIGHT/IMAX SECTION
        if (update)
        {
            Node node = z;
            while (node != null)
            {
                // If the node has no children, height is zero
                if (node.left == null && node.right == null) node.height = 0;

                // If the node has one child, height is 1 + the height of that child
                else if (node.left != null && node.right == null)
                {
                    node.height = 1 + node.left.height;
                    node.imax = (node.imax > node.left.imax) ? node.imax : node.left.imax;
                }
                else if (node.left == null && node.right != null)
                {
                    node.height = 1 + node.right.height;
                    node.imax = (node.imax > node.right.imax) ? node.imax : node.right.imax;
                }

                // If the node has two children, height is 1 + the max of the children's height
                else
                {
                    node.height = (node.left.height > node.right.height) ? 1 + node.left.height : 1 + node.right.height;
                    int submax = (node.left.imax > node.right.imax) ? node.left.imax : node.right.imax;
                    node.imax = (submax > node.interv.high) ? submax : node.interv.high;
                }
                node = node.parent;
            }
        }
        size++;
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
        }

        // Case 2
        if (z.left != null && z.right == null)
        {
            if (z.parent == null) root = z.left;
            else if (z.parent.left == z) z.parent.left = z.left;
            else z.parent.right = z.left;
            size--;
        }
        if (z.right != null && z.left == null)
        {
            if (z.parent == null) root = z.right;
            else if (z.parent.left == z) z.parent.left = z.right;
            else z.parent.right = z.right;
            size--;
        }

        // Case 3
        if (z.left != null && z.right != null)
        {
            // Replace z with its successor
        
            // Get the successor and copy it
            Node succ = Successor(z);
            Node hold = new Node();
            hold.left = succ.left;
            hold.right = succ.right;
            hold.parent = succ.parent;
            succ.height = z.height;
            succ.parent = z.parent;

            // Swap z with successor
            if (z == root) root = succ;
            else if (z.parent.left == z) z.parent.left = succ;
            else z.parent.right = succ;
            z.parent = hold.parent;
            z.left = hold.left;
            z.right = hold.right;

            // Remove reference from succ parent
            if (z.parent.left == succ) z.parent.left = null;
            else z.parent.right = null;

            // While z is not a leaf node, and its priority is bigger than its childrens' priorities
            while (z.left != null && z.right != null && (z.priority > z.left.priority || z.priority > z.right.priority))
            {
                if (z.left.priority < z.priority) RightRotate(z);
                else if (z.right.priority < z.priority) LeftRotate(z);
            }
        }

        // update the height and imax
        Node node = z;
        while (node != null)
        {
            // If the node has no children, height is zero
            if (node.left == null && node.right == null) 
            {
                node.height = 0;
                System.out.println("leaf node");
            }

            // If the node has one child, height is 1 + the height of that child
            else if (node.left != null && node.right == null)
            {
                node.height = 1 + node.left.height;
                node.imax = (node.imax > node.left.imax) ? node.imax : node.left.imax;
                System.out.println("left child");
            }
            else if (node.left == null && node.right != null)
            {
                node.height = 1 + node.right.height;
                node.imax = (node.imax > node.right.imax) ? node.imax : node.right.imax;
                System.out.println("right child");
            }

            // If the node has two children, height is 1 + the max of the children's height
            else
            {
                node.height = (node.left.height > node.right.height) ? 1 + node.left.height : 1 + node.right.height;
                int submax = (node.left.imax > node.right.imax) ? node.left.imax : node.right.imax;
                node.imax = (submax > node.interv.high) ? submax : node.interv.high;
                System.out.println("two children");
            }
            node = node.parent;
        }

        // Set the deleted node to null, let garbage collector remove it
        z = null;
    }

    /**
     * Searches for the interval that overlaps this interval in the treap
     * @param i the interval
     * @return the node containing the overlapping interval, or null if not found
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
    /**
     * Search for the node containing the interval
     * @param i the interval to check
     * @return  the node containing the interval, or null if not found
     */
    public Node intervalSearchExactly(Interval i)
    {
        Node x = root;
        while (x != null && !i.isEqual(x.interv))
        {
            if (x.left != null && x.left.imax >= i.low)
            {
                x = x.left;
            }
            else x = x.right;
        }
        return x;
    }

    /**
     * NOT DONE
     * @param i
     * @return
     */
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

        // Update the imax of x and y
        x.updateImax();
        y.updateImax();
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

        // Update the imax of x and y
        x.updateImax();
        y.updateImax();
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