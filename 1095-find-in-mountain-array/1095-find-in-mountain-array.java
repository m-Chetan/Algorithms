/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low=0, high=mountainArr.length()-1;
        
        int peak = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int ele = mountainArr.get(mid);
            int left = mid-1>=0 ? mountainArr.get(mid-1) : Integer.MIN_VALUE;
            int right = mid+1<=high ? mountainArr.get(mid+1) : Integer.MIN_VALUE;
            
            if(ele>left && ele>right){
                peak = mid;
                break;
            }
            if(ele>left) low = mid+1;
            else high = mid-1;
        }
        
        
        int res = binarySearchLeft(0,peak,target,mountainArr);
 
        return res!=-1 ? res : binarySearchRight(peak,mountainArr.length()-1,target,mountainArr);
    }
    
    private int binarySearchLeft(int low, int high, int target, MountainArray mountainArr){
        while(low<=high){
            int mid = (low+high)/2;
            int ele = mountainArr.get(mid);
            
            if(ele==target) return mid;
            
            if(ele<target) low = mid+1;
            else high = mid-1;
        }
        
        return -1;
    
    }
    
    private int binarySearchRight(int low, int high, int target, MountainArray mountainArr){
        while(low<=high){
            int mid = (low+high)/2;
            int ele = mountainArr.get(mid);
            
            if(ele==target) return mid;
            
            if(ele>target) low = mid+1;
            else high = mid-1;
        }
        
        return -1;
    
    }
}