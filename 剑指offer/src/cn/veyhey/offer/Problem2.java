/*
 * 题目描述 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 
 * @author Administrator
 *
 */
public class Problem2 {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	int index = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		return dfs(pRoot, k);
	}

	public TreeNode dfs(TreeNode pRoot, int k) {
		if (pRoot != null) {
			if (pRoot.left != null) {
				TreeNode tn = dfs(pRoot.left, k);
				if (tn != null) {
					return tn;
				}
			}
			index++;
			if (index == k) {
				return pRoot;
			}
			if (pRoot.right != null) {
				TreeNode tn = dfs(pRoot.right, k);
				if (tn != null) {
					return tn;
				}
			}
		}
		return null;
	}
}