class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++) arr[i] = new Pair(nums1[i],nums2[i]);
        
        Arrays.sort(arr,(a,b)->b.num2-a.num2);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.num1 - b.num1);
        
        long res = 0;
        long sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i].num1;
            pq.add(arr[i]);
        }
        res = Math.max(res,sum*arr[k-1].num2);
        
        for(int i=k;i<n;i++){
            Pair pair = pq.remove();
            sum -= pair.num1;
            sum += arr[i].num1;
            pq.add(arr[i]);
            res = Math.max(res,sum*arr[i].num2);
        }
        
        return res;
    }
}

class Pair{
    int num1,num2;
    public Pair(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}