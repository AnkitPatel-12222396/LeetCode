class Solution {
    public int countPrimes(int n) {
        int [] prime = new int [n];
        Arrays.fill(prime,1);
        if(n>0)prime[0] = 0;
        if(n>1)prime[1] = 0;
        int count = 0;
        for(int i=2;i<n;i++){
            if(prime[i]==0)continue;
            for(long j=(long)i*i;j<n;j+=i){
                prime[(int)j] = 0;
            }
        }
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) count++;
        }
        return count;
    }
}