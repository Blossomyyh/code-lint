import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class linkedin {

    /**
     * Encircular
     对于单个指令，机器人遇到 `G` 就向前走一格，`R` 原地向右，`L` 原地向左拐。给一系列指令，机器人重复无限次，判断是否存在一个圈使得机器人的路线永远在圈内。比如：
     `G` 是 no，因为一直往前走。`L` 是 yes，因为在原地转圈。`RG` 是 yes 因为走一步转一下。# linkedin Interviews
     (可以想一下多少次算一个循环，然后根据有没有回到原点来判断)
     * @param instructions
     * @return
     */
    public static boolean isRobotBounded(String instructions) {
        int ctL = 0;
        int ctR = 0;
        //North = 1, East = 2, South = 3, West = 4
        int dir = 1;
        int y = 0;
        int x = 0;
        for(int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if(c == 'L') {
                if(dir == 1) dir = 4;
                else dir--;
            }

            else if(c == 'R') {
                if(dir == 4) dir = 1;
                else dir++;
            }
            else {
                if(dir == 1) y++;
                else if(dir == 2) x++;
                else if(dir == 4) x--;
                else if(dir == 3) y--;
            }
        }
        //dir =1 but not in (0,0) --false else true;
        if(dir == 1) {
            if(y == 0 && x == 0) return true;
            return false;
        }
        return true;
    }

    PriorityQueue<Integer> q;
    int k;
    public void KthLargest(int k, int[] nums) {
        this.k=k;
        q= new PriorityQueue<Integer>(k);
        for(int num:nums)
        {
            if(q.size()<k)
                q.offer(num);
            else
            {
                if(q.peek()<num)
                {
                    q.poll();
                    q.offer(num);
                }
            }

        }
    }

    public int add(int val) {
        if(q.size()>=k){
            if(q.peek()<val)
            {
                q.poll();
                q.offer(val);
            }
        }
        else
            q.add(val);
        return q.peek();
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    public static long subarraySum(List<Integer> arr) {
        // Write your code here
        long res = 0;
        for(int i = 0; i<arr.size(); i++){
            for(int j = 0; j<arr.size()-i;j++){
                for (int m =0; m<i; m++){
                    res += arr.get(j+m);
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        subarraySum(arr);
//        isRobotBounded("GGLLGG");
    }


}
