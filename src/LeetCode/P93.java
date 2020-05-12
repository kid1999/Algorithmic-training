package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @desc:
 * @auther: kid1999
 * @date: 2020/5/12 9:01
 **/
public class P93 {
    public static void main(String[] args) {
        System.out.println("1000".compareTo("255"));
        System.out.println("123456".substring(3));
    }

    // dfs
//    List<String> res;
//    Set<String> set;
//    public List<String> restoreIpAddresses(String s) {
//        res = new ArrayList<>();
//        set = new HashSet<>();
//        dfs("",s,0);
//        return res;
//    }
//    public void dfs(String s,String  remain,int count){
//        if(count > 4) return;
//        if(count == 4 && remain.equals("") && !set.contains(s)){
//            set.add(s);
//            res.add(s.substring(1));
//            return;
//        }
//        String num = "";
//        for (char c:remain.toCharArray()) {
//            num += c;
//            if(num.length() > 2 && num.charAt(0) == '0') continue;
//            int number = Integer.parseInt(num);
//            if(number>255) break;
//            else {
//                dfs(s + "." + num,remain.substring(num.length()),count+1);
//            }
//        }
//    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        // 回溯
        back(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    // 中间两个参数解释：pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
    private void back(String s, int pos, List<String> cur,  List<String> ans) {
        if (cur.size() == 4) {
            // 如果此时 pos 也刚好遍历完整个 s
            if (pos == s.length()) {
                // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
                ans.add(String.join(".", cur));
            }
            return;
        }

        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }
            // 将 s 的子串开始分段
            String segment = s.substring(pos, pos + i);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            // 符合要求就加入到 cur 数组中
            cur.add(segment);
            // 继续递归遍历下一个位置
            back(s, pos + i, cur, ans);
            // 回退到上一个元素，即回溯
            cur.remove(cur.size() - 1);
        }
    }
}
