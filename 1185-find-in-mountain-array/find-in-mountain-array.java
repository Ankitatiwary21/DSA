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
        int peakindex = peak(mountainArr);//it will give peak index position
        int res = bs(mountainArr,0,peakindex,target,true);
        if(res==-1){//in the first half target is not availble
            res = bs(mountainArr,peakindex+1,mountainArr.length()-1,target,false);
        }
        return res;
    }
    int bs(MountainArray mountainArr,int l,int h,int target,boolean asc){
        while(l<=h){//1392
            int mid = l+(h-l)/2;
            int val = mountainArr.get(mid);
            if(val==target) return mid;//if mid val is target then return mid index 
            if(asc){//checks if the numbers are in ascending order or not 
                if(val<target) l = mid+1;//if val is less than target then
                //target is in second half else target is in first half 
                else h = mid-1;
            }
            else{
                if(val>target) l = mid+1;
                else h = mid-1;
            }
        }
        return -1;//if no were target is found return -1 
    }
    int peak(MountainArray mountainArr){
        int l=1,h=mountainArr.length()-2;
        while(l<=h){
            int mid = l+(h-l)/2;//will give the middle index 
        int val = mountainArr.get(mid);
        //we will compare mid val with left and right if it satisfies then mid is peak 
        if(val>mountainArr.get(mid-1)&&val>mountainArr.get(mid+1)) return mid;
        //otherwise we will check in second half if mid val is less than right value
        if(val<mountainArr.get(mid+1)) l = mid+1;
        //otherwise we will check in first half if mid val is greater than right value 
        else h = mid-1;
        }
        return -1;//when peak is not found it will return -1 
}
}