import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class TreeSort
{
	//generic method to sort array for AVLTree 
	public static <E> void sort( E[] a)
	{
		Tree <E> tree = new A3AVLTree();
		sort(tree, a);//call method sort(Tree <E> tree, E[] a) to sort 
	}
	//generic method to sort array
	public static <E> void sort(Tree <E> tree, E[] a)
	{
		for(E i:a)//for-each loop to add all the elements into tree
			tree.add(i);
		//create an empty array to store all elements from the tree
		ArrayList<E> arrayListNew = new ArrayList<>();
		//call this method to store elements in the tree to arrayList
		ArrayList<E> arrayList=inorderAddArray(tree.getRoot(),arrayListNew);
        //store all elements in ArrayList to array a.
		for (int i = 0; i < a.length ; i++) 
			a[i] = arrayList.get(i);
	}
    //store all elements in the tree to ArrayList by recursion
	private static <E> ArrayList<E> inorderAddArray(Node<E> subTreeRoot, ArrayList<E> arrayList) 
	{
		if(subTreeRoot!=null)
		{
			inorderAddArray(subTreeRoot.leftLink, arrayList);
			arrayList.add(subTreeRoot.data);
			inorderAddArray(subTreeRoot.rightLink,arrayList);
		}
		return arrayList;
	}
}
