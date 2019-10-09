public class fib {
    public int fib(int N) {
        // if (N==0) return 0;
        // if (N==1) return 1;
        // return fib(N-1) + fib(N-2);

        //todo: Bottom-Up Approach using Memoization

        //need to concern about first two
        if(N<=1) return N;
        int[] mem = new int[N+1];
        mem[0] =0;
        mem[1] = 1;

        for(int i = 2; i<=N;i++){
            mem[i] = mem[i-1] +mem[i-2];
        }
        return mem[N];
    }
}