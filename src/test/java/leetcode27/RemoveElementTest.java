package leetcode27;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: algorithm
 * @description: leetcode中21题
 * @author: mengxiangxing
 * @create: 2021-07-11 14:41
 **/
@SpringBootTest
public class RemoveElementTest {

  /**
   * 解法1：双指针思想
   */
  @Test
  public void test1() {
    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int val = 2;
    if (nums.length == 0) {
      System.out.println(0);
      return;
    }

    /**双指针的第二个指针k,记录当前坐标下的值是否和val相等，不相等的时候把i对应的值赋予k，
     相等的时候i继续，k不再增加，直到再次不相等的时候继续i赋值给k，当i结束的时候返回k即可 */
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        k++;
      }
    }
    System.out.println(k);
    return;
  }

}
