package suan_fa.structure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    // 叶子节点
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    public static int[] strToIntArray(String str){
        str = str.substring(1, str.length()-1);
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];

        for (int i = 0; i < arr.length; i++) {
            if (strs[i] == "null") {
                arr[i] = Integer.MAX_VALUE;
            }else {
                arr[i] = Integer.parseInt(strs[i]);
            }
        }
        return arr;

    }

    public static TreeNode treeObj(String str){
        int[] arr = strToIntArray(str);
        TreeNode[] nodes = new TreeNode[arr.length+1];

        for (int i = 1; i < nodes.length; i++) {
            if (arr[i-1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i-1]);
            }else {
                nodes[i] = null;
            }
        }

        TreeNode node = null;
        for (int i = 1; i < nodes.length / 2; i++) {
            node = nodes[i];
            if (node == null) {
                continue;
            }
            node.left = nodes[2*i];
            node.right = nodes[2*i+1];
        }
        return nodes[1];
    }

}
