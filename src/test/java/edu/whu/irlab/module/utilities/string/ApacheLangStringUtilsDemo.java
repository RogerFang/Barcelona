package edu.whu.irlab.module.utilities.string;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 演示Apache Commons Lang3的StringUtils。
 *
 * Created by Roger on 2016/5/26.
 */
public class ApacheLangStringUtilsDemo {

    @Test
    public void nullSafe() {
        // 判断非空，最常用函数
        assertThat(StringUtils.isNotBlank(null)).isFalse();
        assertThat(StringUtils.isNotBlank("")).isFalse();
        assertThat(StringUtils.isNotBlank("  ")).isFalse();

        assertThat(StringUtils.isNotEmpty("  ")).isTrue();

        // 对null或blank字符串的default值
        assertThat(StringUtils.defaultString(null)).isEqualTo("");
        assertThat(StringUtils.defaultString(null, "defaultStr")).isEqualTo("defaultStr");

        assertThat(StringUtils.defaultIfBlank(null, "defaultStr")).isEqualTo("defaultStr");
        assertThat(StringUtils.defaultIfBlank(" ", "defaultStr")).isEqualTo("defaultStr");
    }

    @Test
    public void substring() {
        String input = "hahakaka";
        String result = StringUtils.substringAfter(input, "ha");
        assertThat(result).isEqualTo("hakaka");

        result = StringUtils.substringAfterLast(input, "ha");
        assertThat(result).isEqualTo("kaka");

        assertThat(StringUtils.substringBetween("'haha'", "'")).isEqualTo("haha");
        assertThat(StringUtils.substringBetween("{haha}", "{", "}")).isEqualTo("haha");
    }

    @Test
    public void joinSplit() {
        // join
        List<String> inputList = Lists.newArrayList("a", "b", "c");
        String result = StringUtils.join(inputList, ",");
        assertThat(result).isEqualTo("a,b,c");

        // split
        String input = "a,b,c";
        String[] resultArray = StringUtils.split(input, ",");
        assertThat(resultArray).containsSequence("a", "b", "c");
    }

    @Test
    public void otherUtils() {
        // ignoreCase的比较函数:contains/startWith/EndWith/indexOf/lastIndexOf
        assertThat(StringUtils.containsIgnoreCase("Aaabbb", "aaa")).isTrue();
        assertThat(StringUtils.indexOfIgnoreCase("Aaabbb", "aaa")).isEqualTo(0);

        // 左边补0
        assertThat(StringUtils.leftPad("1", 3, '0')).isEqualTo("001");
        assertThat(StringUtils.leftPad("12", 3, '0')).isEqualTo("012");

        // 超长部分变省略号
        System.out.println(StringUtils.abbreviate("知识挖掘与信息检索研究室", 10));
        System.out.println(StringUtils.abbreviate("知识挖掘与信息检索研究室", 8));

        // 首字母大写/小写
        assertThat(StringUtils.capitalize("abc")).isEqualTo("Abc");
        assertThat(StringUtils.uncapitalize("Abc")).isEqualTo("abc");
    }
}
