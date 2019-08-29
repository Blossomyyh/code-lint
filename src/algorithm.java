public class algorithm {

    /*
    古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
1.程序分析：兔子的规律为数列1,1,2,3,5,8,13,21....
     */
    public static int fibonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else return fibonacci(i - 1) + fibonacci(i - 2);
    }

    /*
    判断101-200之间有多少个素数，并输出所有素数。
1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
     */
    public static boolean prime(int num) {
        for (int i = 2; i < num; i++) {
            if (i % num == 0) return true;
        }

        return false;
    }

    /*
      题目：打印出所有的 水仙花数 ，所谓 水仙花数 是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个 水仙花数 ，因为153=1的三次方＋5的三次方＋3的三次方。
1.程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。
     */
//    public static


    //todo: 排序算法
    /*
    1. bubble sort
    最佳情况：T(n) = O(n)
    最差情况：T(n) = O(n^2)
    平均情况：T(n) = O(n^2)
     */
    //
    public static void bubbleSort(int[] array) {
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000.0 + "ms\n");
        for (int m = 0; m < array.length; m++) {
            System.out.println(array[m]);
        }
    }

    //改进冒泡排序： 设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
    public static void bubbleSort2(int[] array) {
        long start = System.nanoTime();
        int len = array.length;
        int i = len - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    pos = j;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            i = pos;
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000.0 + "ms");
    }


    /*
    2.selection sort
    最佳情况：T(n) = O(n^2)
    最差情况：T(n) = O(n^2)
    平均情况：T(n) = O(n^2)
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = array[i];
        }
        for (int m = 0; m < array.length; m++) {
            System.out.println(array[m]);
        }

    }

    /*
    3.InsertSort 插入排序
    最佳情况：输入数组按升序排列。T(n) = O(n)
    最坏情况：输入数组按降序排列。T(n) = O(n^2)
    平均情况：T(n) = O(n^2)
     */

    public static void insertSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }

        }
    }

    //二分法插入排序
    //改进插入排序： 查找插入位置时使用二分查找的方式。相比与上面简单插入排序，他针对每一批已排好序的序列，采用了二分查找的方式提高定位效率。
    public static void insertSort2(int[] array) {
        long start = System.nanoTime();
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int current = array[i];
            int st = 0;
            int en = i - 1;
            while (st <= en) {
                int mid = (st + en) >> 1;
                // >>表示右移，如：int i=15; i>>2的结果是3，
                //j>>>i 与 j/(int)(Math.pow(2,i))的结果相同，其中i和j是整形。
                if (array[mid] < array[i]) {
                    st = mid + 1;
                } else {
                    en = mid - 1;
                }
            }
            for (int j = i - 1; j >= st; j--) {
                array[j + 1] = array[j];
            }
            array[st] = current;
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000.0 + "ms");
    }


    /*
    4.希尔排序
    最佳情况：T(n) = O(nlog2 n)
    最坏情况：T(n) = O(nlog2 n)
    平均情况：T(n) =O(nlog n)
     */
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i; j - gap > 0 && array[j - gap] > array[j]; j -= gap) {
                    int temp = array[j - gap];
                    array[j - gap] = array[j];
                    array[j] = temp;
                }
            }
            gap /= 3; // division should not be 2/1 ends as infinite loop
        }
    }

    /*
    5.归并排序
    最佳情况：T(n) = O(n)
    最差情况：T(n) = O(nlogn)
    平均情况：T(n) = O(nlogn)
     */
    public static void mergeSort(int[] array, int start, int end) {
        int len = end - start + 1;
        if (len < 2) return;
        int middle = end + (start - end) / 2; //防止溢出
        //不断地拆分合并
        mergeSort(array, start, middle);
        mergeSort(array, middle +1, end);
        merge(array, start, middle, end);

    }

    private static void merge(int[] array, int start, int mid,int end) {
        int[] temp = new int[end - start +1];
        int i = start;// 左指针
        int j = end;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i<=mid && j<end){
            if (array[i]<array[j]){
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }
        //把左边剩余的数移入数组
        while (i<=mid){
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j<=end){
            temp[k++] = array[j++];
        }
        //把新数组中的数覆盖nums数组
        for (int m = 0; m< temp.length; m++){
            array[start +m] = temp[m];
        }


    }

    /*
    6.快速排序
    最佳情况：T(n) = O(nlogn)
    最差情况：T(n) = O(n2)
    平均情况：T(n) = O(nlogn)
     */
    public static void quickSort(int[] array, int sta, int end){
        if (sta >= end) return;;
        int index = partition(array, sta, end);
        quickSort(array, sta, index-1);
        quickSort(array, index +1, end);
    }

    private static int partition(int[] array, int sta, int end){
        int reserve = array[sta];
        if (sta>=end) return sta;
        while (sta<end){
            //从后半部分向前扫描
            while (sta<end && reserve <= array[end] ){
                end--;
            }

            if (sta< end){
                array[sta++] = array[end];
            }

            //从前半部分向后扫描
            while (sta < end && array[sta] <= reserve){
                sta++;
            }
            if (sta<end){
                array[end--] = array[sta];
            }
        }
        array[sta] = reserve;
        return sta;
    }

    //快速排序算法优化——三向切分快速排序
    //在上面的快速排序中，当有很多重复元素存在的时候，会大大的增加无谓的切分耗时：比如当前切分块中若全部是相同的元素，则在当前块中的递归切分就是无意义也没有必要的。所以在三向切分中，用了lt和gt两个“指针”来分隔小于当前“基准元素”和大于当前“基准元素”的值。
    public static void quickSort3ways(int[] array, int low, int high) {
        if (low >= high)
            return;
        int lt = low;
        int i = low + 1;
        int gt = high + 1;
        while (i < gt) {
            if (array[i] < array[lt]) {
//                swap(array, i++, lt++);
                int temp = array[i];
                array[i++] = array[lt];
                array[lt++] = temp;
            } else if (array[i] > array[lt]) {
//                swap(array, i, --gt);
                int temp = array[i];
                array[i] = array[--gt];
                array[gt] = temp;
            } else {
                i++;
            }
        }
        quickSort3ways(array, low, lt);
        quickSort3ways(array, gt, high);
    }

    /*
    todo:堆排序
    具体算法描述如下：

<1>.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
<2>.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
<3>.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
     */

    /*
    todo:计数排序
    算法分析
具体算法描述如下：

<1>. 得到待排序数的范围（在这里增加了上界和下界）；
<2>. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
<3>. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加），计算得到每个元素在排序后数组中的结束位置；
<4>. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

当输入的元素是n 个0到k之间的整数时，它的运行时间是 O(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），这使得计数排序对于数据范围很大的数组，需要大量时间和内存（如果数据比较分散，则在countArray中其实是有大量0的，占用很多空间）。

最佳情况：T(n) = O(n+k)
最差情况：T(n) = O(n+k)
平均情况：T(n) = O(n+k)
     */


    /*
    todo:桶排序（Bucket Sort）

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。

(1)算法简介

桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排

(2)算法描述和实现

具体算法描述如下：

<1>.设置一个定量的数组当作空桶；
<2>.遍历输入数据，并且把数据一个一个放到对应的桶里去；
<3>.对每个不是空的桶进行排序；
<4>.从不是空的桶里把排好序的数据拼接起来。

(3)算法分析

　桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。

最佳情况：T(n) = O(n+k)
最差情况：T(n) = O(n+k)
平均情况：T(n) = O(n2)
     */


    /*
    基数排序（Radix Sort）

基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；

(1)算法简介

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。

(2)算法描述和实现

具体算法描述如下：

<1>.取得数组中的最大数，并取得位数；
<2>.arr为原始数组，从最低位开始取每个位组成radix数组；
<3>.对radix进行计数排序（利用计数排序适用于小范围数的特点）；


最佳情况：T(n) = O(n * k)
最差情况：T(n) = O(n * k)
平均情况：T(n) = O(n * k)
基数排序有两种方法：

MSD 从高位开始进行排序
LSD 从低位开始进行排序
todo:基数排序 vs 计数排序 vs 桶排序

这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：

基数排序：根据键值的每位数字来分配桶
计数排序：每个桶只存储单一键值
桶排序：每个桶存储一定范围的数值
     */

}

