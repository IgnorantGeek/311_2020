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
}
