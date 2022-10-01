package suan_fa;

import suan_fa.structure.TreeNode;

public class Test017 {
    /**
     * *********** 二叉树的中序遍历 ***********
     * 给定一个二叉树的根节点root，返回它的中序遍历
     *  前序遍历：根-->左-->右
     *  中序遍历：左-->根-->右
     *  后序遍历：左-->右-->根
     * 例：       5
     *          /  \
     *         2    7
     *        / \  / \
     *       0  4 6   9
     * 注意：
     *
     *
     *
     */

















    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(2,new TreeNode(0),new TreeNode(4)),
                new TreeNode(7,new TreeNode(6),new TreeNode(9))
        );
    }

}
