public class Interval
{
    public int low;
    public int high;

    public Interval() { }

    public Interval(int low, int high)
    {
        this.low = low;
        this.high = high;
    }

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
     * @return true if they overlap, false otherwise
     */
    public boolean Overlap(Interval i)
    {
        if (this.low <= i.high && i.low <= this.high) return true;
        return false;
    }
}
