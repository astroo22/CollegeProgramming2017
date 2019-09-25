//jonathan Starkey

/*
public class BinaryTree
{
	//ok need the base node
	HuffmanNode baseNode;
	BinaryTree left;
	BinaryTree right;
	boolean empty;
	public BinaryTree()
	{
		//first call should be an empty tree so if empty do things so boolean ^^
		this.empty = true;
	}
	//over load 
	public BinaryTree(HuffmanNode node, BinaryTree left, BinaryTree right) throws NullPointerException
	{
		//ok here we do things not entirely sure what things yet but things.
		this.baseNode = node; //first node
		this.empty = false; //no longer empty
		//ok so left = either new tree or itself? i think?
		if(left == null)
		{
			this.left = new BinaryTree();
		}
		else
		{
			this.left = left;
		}
		if(right == null)
		{
			this.right = new BinaryTree();
			
		}
		else
		{
			this.right = right;
		}
	}
	public boolean isEmpty()
	{
		return this.empty;
	}
	public BinaryTree getRight()
	{
		if(empty)
		{
			return null;
		}
		else
		{
			return right;
		}
	}
	public BinaryTree getLeft()
	{
		if(empty)
		{
			return null;
		}
		else
		{
			return left;
		}
	
	}
	
	
}*/