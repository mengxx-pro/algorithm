package leetcode1021;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @program: algorithm
 * @description: leetcode中1021题 删除最外层的括号
 * // 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * // 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * // 示例 1：
 * //输入：s = "(()())(())"  输出："()()()"
 * //解释：输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * // 示例 2：
 * //输入：s = "(()())(())(()(()))" 输出："()()()()(())"
 * //解释：输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * // 示例 3：
 * //输入：s = "()()" 输出：""
 * //解释：输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * //删除每个部分中的最外层括号后得到 "" + "" = ""。
 * // 提示：
 * // 1 <= s.length <= 105
 * // s[i] 为 '(' 或 ')'
 * // s 是一个有效括号字符串
 * //
 * // Related Topics 栈 字符串
 *
 * @author: mengxiangxing
 * @create: 2021-07-14 13:38
 **/
@SpringBootTest
public class RemoveOuterParenthesesTest {

  @Test
  public void removeOuterParentheses() {
    String[] parenthesesArray = {"(()())(())", "(()())(())(()(()))", "()()"};
    String parentheses = parenthesesArray[new Random().nextInt(parenthesesArray.length)];
    System.out.println("输入" + parentheses);

    char[] parenthesesChar = parentheses.toCharArray();
    //初始化一个计算所有左右括号相加的值，左括号+1，有括号-1，总的计数为0时，这段字符串即为有效括号字符串原语
    //循环中只把除第一个和最后一个括号加入到新的字符串中即可，判断allCount不是0时就是需要的括号
    int allCount = 0;//初始化左右括号相加的值
    StringBuilder parenthesesBuilder = new StringBuilder();
    char leftChar = "(".charAt(0);
    char rightChar = ")".charAt(0);
    for (char word : parenthesesChar) {
      if (leftChar == word) {
        if (allCount != 0) {
          parenthesesBuilder.append(word);
        }
        allCount++;
      } else if (rightChar == word) {
        allCount--;
        if (allCount != 0) {
          parenthesesBuilder.append(word);
        }
      }
    }
    System.out.println("输出" + parenthesesBuilder.toString());
    return;
  }
}
