public class UglyNumber {
    /**
    Ugly number is a number that only have factors 2, 3 and 5.
    Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
    # Note that 1 is typically treated as an ugly number.


    tags: Math, DP, Heap, Enumeration,
    todo:: PriorityQueue(java最小堆) 优先队列-队列中权值最小的（Java的优先队列每次取最小元素，C++的优先队列每次取最大元素）。这里牵涉到了大小关系，元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器（Comparator，类似于C++的仿函数）
    PriorityQueue的peek()顶部返回bool，插入offer()返回bool, 无参数的remove()、poll()-bool方法的时间复杂度都是log(N)。

    time: O(n)
    space: O(n)

    #### DP
    - curr index is based on previous calculation: the min of all 3 previous factors
    - O(n)

    #### PriorityQueue, DP
    - 非常brutle的。
    - 每次把dp[i-1]拿出来，不管三七二十一，分别乘以2,3,5. 出来的结果放进priority queue做比较。
    - 最后时间是n*log(n*3)
    - 注意：use long, use HashSet确保没有重复
    - O(nlogn)

     **/

//    todo: define whether is ugly number  Time:log2N+log3N+log5N
    public static boolean uglyNumbers(long n){
        int count = 0;
//        first figure out 0 not ugly
        if (n == 0) return false;
        while (n%5 == 0) n = n/5;
        while (n%3 == 0) n = n/3;
        while (n%2 == 0) n = n/2;

        return n==1;

    }

//    todo: print out ugly number for the sequence
    public static int uglySequence(long n){
//        NO.1690 为2^30不超过整形范围
        int ugly = 0;
//        for ()
        return ugly;
    }

    public static void main (String[] args){
        System.out.print(uglyNumbers(0));
    }
}
