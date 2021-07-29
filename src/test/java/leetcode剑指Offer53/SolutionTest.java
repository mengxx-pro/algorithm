package leetcode剑指Offer53;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: algorithm
 * @description:
 *
 * @author: mengxiangxing
 * @create: 2021-07-18 15:01
 **/
@SpringBootTest
public class SolutionTest {

  @Test
  public void main() {
    int[] nums =new int[] {1,2,3,3,3,5,6};
    int num = search(nums,5);
    System.out.println(num);
  }

  public int search(int[] nums, int target) {
    if(nums.length<=0){
      return 0;
    }

    int leftIndex = leftIndex(nums,target);
    if(leftIndex==-1){
      return 0;
    }
    int rightIndex = rightIndex(nums,target);
    return rightIndex-leftIndex+1;
  }

  public int leftIndex(int[] nums, int target){
    int left=0;
    int right=nums.length-1;
    int mid=0;
    while(left<right){
      mid=left+(right-left)/2;
      if(nums[mid]<target){
        left = mid+1;
      }else if(nums[mid]==target){
        right=mid;
      }else{
        right=mid-1;
      }
    }
    if(left==right){
      if(nums[left]==target){
        return left;
      }
    }
    return -1;
  }

  public int rightIndex(int[] nums, int target){
    int left=0;
    int right=nums.length-1;
    int mid=0;
    while(left<right){
      mid=left+(right-left+1)/2;
      if(nums[mid]<target){
        left = mid+1;
      }else if(nums[mid]==target){
        left=mid;
      }else{
        right=mid-1;
      }
    }
    if(left==right){
      if(nums[right]==target){
        return right;
      }
    }
    return -1;
  }
}
