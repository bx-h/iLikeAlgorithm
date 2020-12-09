package utils;

public class Util {
    /*
    * 先序遍历打印树
    * */
    public static void printTree(TreeNode root) {
        if(root == null) {
            System.out.print("--->null");
            return;
        }
        System.out.print("-->" + root.val);
        printTree(root.left);
        printTree(root.right);
    }

}
