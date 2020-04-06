/** Interval Class
 * 
 * @author Nick Heisler and Tom Frye
 */

public class Interval
{
    public int low;
    public int high;

    /*-----Constructors---------*/
    public Interval() { }

    public Interval(int low, int high)
    {
        this.low = low;
        this.high = high;
    }

    /*----Class Methods----------*/
    /**
     * @return the high
     */
    public int getHigh()
    {
        return high;
    }

    /**
     * @return the low
     */
    public int getLow()
    {
        return low;
    }

    /**
     * Check if the current interval overlaps with i
     * @param i
     * @return true if the intervals overlap, false otherwise
     */
    public boolean Overlap(Interval i)
    {
        if (this.low <= i.high && i.low <= this.high) return true;
        return false;
    }

    public boolean isEqual(Interval i)
    {
        if (i.low == low && i.high == high) return true;
        else return false;
    }
}
