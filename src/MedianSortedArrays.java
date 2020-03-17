public class MedianSortedArrays {
    //todo: (x+y+1) -- because it plays well whenever x+y is even or odd

    //todo: when iterating , remember i<end && i>start [while (start<=end)]

    //todo: initial end to m ---> when get (start+end)/2 --> works well with even & odd.

    //todo: calculate double: (xxxx)/2.0

    public static double medianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int m = nums1.length;
        int n = nums2.length;
        if(nums1.length>nums2.length){
            int tmp = n;
            n = m;
            m = tmp;

            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int start = 0;
        int end = m;


        while(start<=end){
            int p1 = (start+end)/2;
            int p2 = (m+n+1)/2-p1;
            if(p1<end && nums2[p2-1]>nums1[p1]){
                //p1 too small
                start = p1+1;
            }else if(p1>start && nums1[p1-1]>nums2[p2]){
                //p1 too big
                end = p1-1;
            }else{
                int maxleft = 0;
                if(p1 == 0){
                    maxleft= nums2[p2-1];
                }else if(p2==0){
                    maxleft = nums1[p1-1];
                }else{maxleft = Math.max(nums1[p1-1], nums2[p2-1]);}
                if((m + n) % 2 == 1) return maxleft;


                int maxright = 0;
                if(p1 == m){
                    maxright= nums2[p2];
                }else if(p2==n){
                    maxright = nums1[p1];
                }else{maxright = Math.min(nums1[p1], nums2[p2]);}
                return (maxleft+maxright)/2.0;
            }
        }

        return res;
    }
    // time O(log(min(m,n))).we only need log(m) loops.

    public static void main(String arg[]){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double res  = 0;
        res = medianSortedArrays(nums1,nums2);
    }
}
