package leetcode剑指Offer53p2;

class Solution53Test {

  public int missingNumber(int[] nums) {
    if(nums.length<=0){
      return 0;
    }
    int left =0;
    int right =nums.length-1;
    int mid =0;
    //二分查找哪个数大于当前的坐标，锁定到最小区间2个元素，其中一个肯定有不在该数组中的
    while(left <right-1){
      mid= left+ (right-left+1)/2;
      if(mid==nums[mid]){
        left =mid+1;
      }else if(mid<nums[mid]){
        right=mid;
      }
    }
    if(left<nums[left]){
      return left;
    }else if(right<nums[right]){
      return right;
    }else{
      return right+1;
    }
  }
}


