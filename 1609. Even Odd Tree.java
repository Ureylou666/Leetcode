class Solution {
    List<Integer> numberToCheck = new ArrayList<>();
    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> tempList = new ArrayList<>();
        treeNodeList.add(root);
        boolean needIncrease = true;
        boolean even = false;
        numberToCheck.add(root.val);
        while (!treeNodeList.isEmpty()) {
            if ( numberToCheck.size() > 1 ) {
                if ( !increase(numberToCheck, needIncrease) ) return false;
            }
            for (int i:numberToCheck) if ((i % 2 == 0) ^ even ) return false;
            tempList.clear();
            numberToCheck.clear();
            for (TreeNode node : treeNodeList) {
                if (node.left != null) {
                    tempList.add(node.left);
                    numberToCheck.add(node.left.val);
                }
                if (node.right != null) {
                    tempList.add(node.right);
                    numberToCheck.add(node.right.val);
                }
            }
            treeNodeList.clear();
            treeNodeList.addAll(tempList);
            needIncrease = !needIncrease;
            even = !even;
        }
        return true;
    }

    public boolean increase(List<Integer> list, boolean needIncrease) {
        int i=0;
        while  (i<list.size()-1) {
            if (needIncrease) {
                if (list.get(i) >= list.get(i+1)) return false;
            } else {
                if (list.get(i) <= list.get(i+1)) return false;
            }
            i++;
        }
        return true;
    }
}
