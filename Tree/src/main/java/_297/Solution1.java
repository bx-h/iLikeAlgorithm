package _297;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示:这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

说明:不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。


//* */
//public class Solution1 {
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
////        ArrayList<Integer> ares = decompose(root);
//        StringBuilder result = new StringBuilder();
////        for (int i = 0; i < ares.size() - 1; ++i) {
////            result.append(String.valueOf(ares.get(i)));
////            result.append(",");
////        }
////        result.append(ares.get(ares.size()-1));
////
////
////        return "[" + result + "]";
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int currentLevelSize = queue.size();
//            for (int i = 1; i <= currentLevelSize; ++i) {
//                TreeNode node = queue.poll();
//                if (node == null) {
//                    result.append("null");
//                    result.append(",");
//                    continue;
//                }
//                result.append(String.valueOf(node.val));
//                result.append(",");
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }
//        }
//        return "[" + result + "]";
//
//    }
//
//    public ArrayList<Integer> decompose(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        if (root == null) {
//            res.add(null);
//            return res;
//        }
//        res.add(root.val);
//
//        res.addAll(decompose(root.left));
//        res.addAll(decompose(root.right));
//
//        return res;
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        return null;
//    }
//
//    @Test
//    public void test1() {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//
//        String serialize = serialize(root);
//        System.out.println(serialize);
//    }
//}


/*
* Fail
* 做不出来。
* 层序遍历最后一层会输出一堆 NULL
*
* */