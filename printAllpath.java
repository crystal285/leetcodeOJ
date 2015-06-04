import java.util.ArrayList;


public class printAllpath {
	public static void printAllpath(TreeNode root, ArrayList<Integer> list)
	{
		if(root == null)
			return;
		list.add(root.val);
		if(root.left == null && root.right == null)
			{
				for(int i = 0; i < list.size(); i++)
					System.out.print(list.get(i) + " ");
				System.out.println();
			}
			printAllpath(root.left, list);
			printAllpath(root.right,list);
			list.remove(list.size()-1);
	}

	public static TreeNode createTree()
	{
		 TreeNode rootNode =new TreeNode(40);
		  TreeNode node20=new TreeNode(20);
		  TreeNode node10=new TreeNode(10);
		  TreeNode node30=new TreeNode(30);
		  TreeNode node60=new TreeNode(60);
		  TreeNode node50=new TreeNode(50);
		  TreeNode node70=new TreeNode(70);
		  TreeNode node5=new TreeNode(5);
		  TreeNode node55=new TreeNode(55);

		  rootNode.left=node20;
		  rootNode.right=node60;

		  node20.left=node10;
		  node20.right=node30;

		  node60.left=node50;
		  node60.right=node70;
		  node10.left=node5;
		  node50.right=node55;

		  return rootNode;
	}

public static void main(String[] args)
{
	TreeNode root = createTree();
	printAllpath(root, new ArrayList<Integer>());
}
}

