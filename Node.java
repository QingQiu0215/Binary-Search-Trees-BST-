//create Node class for A3BSTree and A2AVLTree
public class Node<E>
{
	protected E data;
    protected Node<E> leftLink;
    protected Node<E> rightLink;
    int height;//track the heiht of the tree
    protected Node(E newData, Node<E> newLeftLink,Node<E> newRightLink)
    {
         data = newData;
         leftLink = newLeftLink;
         rightLink = newRightLink;
         height = 0;
    }  
    protected Node(E newData)
    {
    	data = newData;
    }
 
    protected void setChild(int direction, Node<E> child) 
    {
        if (direction < 0) //control the direction to link child
        {
          leftLink = child;
        } 
        else 
        {
          rightLink = child;
        }
    }
    protected void setItem(E item) 
    {
        data = item;
    }
    protected E getData()
    {
    	return data;
    }
}
