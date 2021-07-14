import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: algorithm
 * @description: leetcode中模拟面试题，难易程度：简单
 * 给定一个单词，你需要判断单词的大写使用是否正确。  我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写，
 * 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * @author: mengxiangxing
 * @create: 2021-07-11 14:41
 **/
@SpringBootTest
public class UpCharTest {

  @Test
  public void upCharTest() {
    String word = "CHINA";
    //String word = "leetcode";
    //String word = "Google";
    //String word = "leetCode";
    if (word.equals("") || word.equals(null)) {
      System.out.println(false);
      return;
    }
    //字符串转成字符数组
    char[] wordChar = word.toCharArray();
    int length = word.length();
    //upCount 用于统计大写字母的个数
    int upCount = 0;
    boolean fristUp = Character.isUpperCase(wordChar[0]);
    for (char s : wordChar) {
      if (Character.isUpperCase(s)) {
        upCount++;
      }
    }
    if (upCount == length) {
      System.out.println(true);
      return;
    } else if (upCount == 0) {
      System.out.println(true);
      return;
    } else if (upCount == 1 && fristUp) {
      System.out.println(true);
      return;
    } else {
      System.out.println(false);
      return;
    }

  }
}
