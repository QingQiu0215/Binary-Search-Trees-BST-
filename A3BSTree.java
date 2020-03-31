import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Stack;
import java.util.NoSuchElementException;
//E extends Comparable so that it can use method compareTo
public class A3BSTree <E extends Comparable<E>> implements Tree<E>
{
	protected static int size=0;//track the quantity of elements in the tree.
	protected Node <E> root;
	public A3BSTree()
	{
		root=null;
	}
	
	public Node<E> getRoot() 
	{
		return root;
	}

	public void setRoot(Node<E> root) 
	{
		this.root = root;
	}
    //create class DataIterator 
	private class DataIterator<E> implements Iterator<E>
	{
		Stack<Node<E>> tempStack;//create a stack to store elements in the tree
		//push elements in the leftmost in the tree to the stack
		public DataIterator(Node<E> root)
		{
		    tempStack=new Stack<Node<E>>();
		    while (root!=null)
		    {
		    	tempStack.push(root);
		    	root=root.leftLink;
		    }
		}
		public boolean hasNext()
		{
			return !tempStack.isEmpty();
		}
		//pop a element from the stack one by one
		public E next()
		{
			Node<E> node=tempStack.pop();
			E value=node.data;
			if(node.rightLink!=null)
			{
				node=node.rightLink;
				while(node!=null)
				{
					tempStack.push(node);
					node=node.leftLink;
				}
			}
			return value;
		}
	}
    //add an element to the tree,size increases by one
	public void add(E e) 
	{
		root=insertNode(e,root);
		size++;
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
        if(!contains(target))
        	return false;
        Node<E> parent=root;
        Node<E> node = root;
	    int direction = 0;
	    while (node != null) 
	    {
	      int comparison = target.compareTo(node.data);
	      if (comparison < 0) 
	      {     // Go left
	          parent = node;
	          node = node.leftLink;
	      } 
	      else if (comparison == 0) 
	      { // Found it
	    	  spliceOut(node, parent, direction);
	    	  size--;
	          return true;
	      } 
	      else 
	      { //Go right                  
	          parent = node;
	          node = node.rightLink;
	      }
	      direction = comparison;
	    }
	    return true;
	}
	//remove the leftmost element in the tree
	private E removeLeftmost(Node<E> node, Node<E> parent) 
	{
	    int direction = 1;
	    while (node.leftLink != null) 
	    {
	      parent = node;
	      direction = -1;
	      node = node.leftLink;
	    }
	    E result = node.data;
	    spliceOut(node, parent, direction);
	    return result;
	}
	private void spliceOut(Node<E> node,Node<E> parent,int direction) 
	{
	    if (node.leftLink == null) 
		{//set element in the right
	      parent.setChild(direction, node.rightLink);
	    } 
		else if (node.rightLink == null) 
		{//set element in the left
	      parent.setChild(direction, node.leftLink);
	    } 
		else 
		{//remove the leftmost element
	      node.setItem(removeLeftmost(node.rightLink, node));
	    }
	}
	public Iterator<E> iterator() 
	{
		return new DataIterator(root);
	}

	public int height() 
	{
		return findHeigh(root);
	}

	public int size() 
	{
		return size;
	}
    public void showElements()
    {
    	showElementsInsubtree(root);
    }
    //add one element to the tree
    private Node<E> insertNode(E item, Node<E> subTreeRoot)
    {
		int comparison = 0;		
        if (subTreeRoot == null)
           return new Node(item, null, null);
        comparison=item.compareTo(subTreeRoot.data);
        if (comparison<0)//go left
        {
           subTreeRoot.leftLink = insertNode(item, subTreeRoot.leftLink);
           return subTreeRoot;
        }
        else if(comparison>0)//go right
        {
           subTreeRoot.rightLink = insertNode(item, subTreeRoot.rightLink);
           return subTreeRoot;
        }
        else//if duplicate,the size shall reduce by one to offset size++ in the method add
        {
        	size--;
        	return subTreeRoot;
        }
    }
    //output all the elements in the tree by recursion
    private static <E> void showElementsInsubtree(Node<E> subTreeRoot)
	{
		if(subTreeRoot!=null)
		{
		   showElementsInsubtree(subTreeRoot.leftLink);
		   System.out.print(subTreeRoot.data+" ");
		   showElementsInsubtree(subTreeRoot.rightLink);
		}		
	}
    //find the height of the tree by using recursion
    private int findHeigh(Node<E> subTreeRoot)
    {
		
        if (subTreeRoot == null)
           return -1;
        int left=findHeigh(subTreeRoot.leftLink)+1;           
        int right=findHeigh(subTreeRoot.rightLink)+1;
        return Math.max(left, right);
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
}

