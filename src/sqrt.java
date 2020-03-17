public class sqrt {
    public int mySqrt(int x) {
        System.out.print(Math.floor(1.0006));
        //floor - returns the double value that is less than or equal to the argument and is equal to the nearest mathematical integer.
        return (int)Math.floor(Math.sqrt(x));
    }

    /**
     * pocket calculator use math.E
     * @param x
     * @return
     * todo: aware of double-int truncated rather than rounded
     * O(1) O(1)
     */
    public int pocketSqrt(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }



}
