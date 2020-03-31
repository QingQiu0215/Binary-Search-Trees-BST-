import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class A3AVLTree <E extends Comparable<E>> implements Tree<E>
{
	protected  Node <E> root;
	public Node<E> getRoot() 
	{
		return root;
	}
	protected  int size = 0;
	protected A3AVLTree()
	{
		root = null;
	}
	//
	protected int max(int a, int b) 
	{
		return (a > b) ? a : b;
	}
	public void add(E e) 
	{
		root = add(root, e);	
	}
	//add one element in the tree
	protected Node<E> add(Node<E> t, E e)
	{
		if (t == null)
			t = new Node<E>(e);
		else if (e.compareTo(t.data)<0)
		{
			t.leftLink = add(t.leftLink, e);
			//if the tree is not balanced 
			if(height(t.leftLink) - height(t.rightLink) == 2)
				//single rotate
				if( e.compareTo(t.leftLink.data)<0 )
					t = rotateWithleftLinkChild(t);
			    //double rotate
				else
					t = doubleWithleftLinkChild(t);
		}
		else
		{
			t.rightLink = add(t.rightLink, e);
			//if the tree is not balanced 
			if( height(t.rightLink) - height(t.leftLink) == 2 )
				if(e.compareTo(t.rightLink.data)>0)
					//single rotate
					t = rotateWithrightLinkChild(t);
				else
					//double rotate
					t = doubleWithrightLinkChild(t);
		}	
		    //calculate the height
			t.height = max(height(t.leftLink), height(t.rightLink)) + 1;
			size++;
			return t;
	}	 
	//single rotate to balance the tree
	protected Node<E> rotateWithleftLinkChild(Node<E> c)
	{
		Node<E> b = c.leftLink;
		c.leftLink = b.rightLink;
		b.rightLink = c;
		c.height = max(height(c.leftLink), height(c.rightLink)) + 1;
		b.height = max(height(b.leftLink), c.height) + 1;
		return b;
	}
	//single rotate to balance the tree
	protected Node<E> rotateWithrightLinkChild(Node<E> a)
	{
		Node<E> b = a.rightLink;
		a.rightLink = b.leftLink;
		b.leftLink = a;
		a.height = max( height(a.leftLink), height(a.rightLink)) + 1;
		b.height = max( height(b.rightLink), a.height) + 1;
		return b;
	}
	//double rotate to balance the tree
	protected Node<E> doubleWithleftLinkChild(Node<E> c)
	{
		c.leftLink = rotateWithrightLinkChild(c.leftLink);		
		return rotateWithleftLinkChild(c);				
	}	
	//double rotate to balance the tree
	protected Node<E> doubleWithrightLinkChild(Node<E> a){
		a.rightLink = rotateWithleftLinkChild(a.rightLink);	
		return rotateWithrightLinkChild(a);			
	}   
	//call the method add(E e) to all all elements in the tree
	public void addAll(Collection<? extends E> c) 
	{
		for(E e:c)
			add(e);
	}
	//remove one element from the tree
	public boolean remove(Object o) 
	{
		E target=(E) o;
		//if the element does not exist,return false
		if (target==null)
			return false;
	    if(!contains(target))
	        return false;
		root = deleteNode(root,target);
		return true;
	}
	//check the target element if exist in the tree
	private boolean contains(E target)
	{
		Node<E> node = root;
	    while (node != null) 
	    {
	      int comparison = target.compareTo(node.data);
	      if (comparison < 0) 
	      {    
	        node = node.leftLink;
	      } 
	      else if (comparison == 0) 
	      { 
	        return true;
	      } 
	      else 
	      {                  
	        node = node.rightLink;
	      }
	    }
	    return false;
	}
	//remove one element from the tree
	private Node<E> deleteNode(Node<E> root, E target)
    {
		//remove one element by recursion
        if (root == null)
            return root;
        if (target.compareTo(root.data) <0)
            root.leftLink = deleteNode(root.leftLink, target);
        else if (target.compareTo(root.data) >0)
            root.rightLink = deleteNode(root.rightLink, target);
        else
        {
            if ((root.leftLink == null) || (root.rightLink == null))
            {
                Node<E> temp = null;
                if (temp == root.leftLink)
                    temp = root.rightLink;
                else
                    temp = root.leftLink;
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   
                    root = temp; 
            }
            else
            {
                Node<E> temp = minValueNode(root.rightLink);
                root.data = temp.data;
                root.rightLink = deleteNode(root.rightLink, temp.data);
            }
        }
        if (root == null)
            return root;
        root.height = max(height(root.leftLink), height(root.rightLink)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.leftLink) >= 0)
            return rightRotate(root);
        if (balance > 1 && getBalance(root.leftLink) < 0)
        {
            root.leftLink = leftRotate(root.leftLink);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.rightLink) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.rightLink) > 0)
        {
            root.rightLink = rightRotate(root.rightLink);
            return leftRotate(root);
        }
 
        return root;
    }
	//check if the tree is balanced
	private int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.leftLink) - height(N.rightLink);
    }
	//rotate the tree to get balanced
	private Node rightRotate(Node y)
    {
        Node x = y.leftLink;
        Node T2 = x.rightLink;
        x.rightLink = y;
        y.leftLink = T2;
        y.height = max(height(y.leftLink), height(y.rightLink)) + 1;
        x.height = max(height(x.leftLink), height(x.rightLink)) + 1;
        return x;
    }
	//rotate the tree to get balanced
	private Node leftRotate(Node x)
    {
        Node y = x.rightLink;
        Node T2 = y.leftLink;
        y.leftLink = x;
        x.rightLink = T2;
        x.height = max(height(x.leftLink), height(x.rightLink)) + 1;
        y.height = max(height(y.leftLink), height(y.rightLink)) + 1;
        return y;
    }
	//get the leftmost value of all nodes
	private Node<E> minValueNode(Node<E> node)
    {
        Node<E> current = node;
        while (current.leftLink != null)
           current = current.leftLink;
        return current;
    }
	//get the rightmost value of all nodes
	private Node<E> findMax(Node<E> t)
	{
		if( t == null )
			return t;
		while(t.rightLink != null)
			t = t.rightLink;
		return t;
	}
	public Iterator<E> iterator() {
		return new inorderIterator();
	}
	//create class DinorderIterator 
	private class inorderIterator implements Iterator<E>
	{
		//create an array to store elements in the tree
		protected ArrayList<E> list = new ArrayList<E>();
		protected int current = 0;
		public inorderIterator()
		{
			inorder();
		}
		protected void inorder()
		{
			inorder(root);
		}
		protected void inorder(Node<E> root)
		{
			if (root == null) return;
			inorder(root.leftLink);
			list.add(root.data);
			inorder(root.rightLink);
		}
		public boolean hasNext() 
		{
			if(current < list.size())
				return true;
			return false;
		}
		public E next() 
		{
			return list.get(current++);
		}		
	} 
	//sort the tree by inorder with one parameter
	private void inorder(Node<E> root)
	{
		if (root == null)
			return;
		inorder(root.leftLink);
		System.out.print(root.data + " ");
		inorder(root.rightLink);
	}
	//sort the tree in order without parameter
	private void inorder(){
		inorder(root);
	}
	//sort the tree by postorder with one parameter
	private void postorder(Node<E> root)
	{
		if (root == null)
			return;
		postorder(root.leftLink);
		postorder(root.rightLink);
		System.out.print(root.data + " ");
	}
	//sort the tree by postorder without parameter
	private void postorder()
	{
		postorder(root);
	}
	//sort the tree by preorder with one parameter
	private void preorder(Node<E> root)
	{
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.leftLink);
		preorder(root.rightLink);
	}
	//sort the tree by preorder without parameter
	private void preorder()
	{
		preorder(root);
	}
	public int height() 
	{
		return height(root);
	}
	private int height(Node<E> t) 
	{
		if (t == null)
			return -1;
		return t.height;
	}
	public int size() 
	{
		return size(root);
	}
	private int size(Node<E> node)
	{
		if (node == null) 
		{
			return 0;
		} 
		else 
		{
			return 1 + size(node.leftLink) + size(node.rightLink);
		}
	}
	protected void showElements()
	{
	     showElementsInsubtree(root);
	}
	//output all the elements in the tree by recursion
	private void showElementsInsubtree(Node<E> subTreeRoot)
	{
		if(subTreeRoot!=null)
		{
			showElementsInsubtree(subTreeRoot.leftLink);
			System.out.print(subTreeRoot.data+" ");
			showElementsInsubtree(subTreeRoot.rightLink);
		}		
	}
}
