import java.util.ArrayList;
import java.util.Iterator;
public class Driver 
{
	public static void main(String[] args) 
	{
		//create an A3BSTree object to be sorted
		A3BSTree<Integer> tree=new A3BSTree<Integer>();
		//create an array
		ArrayList<Integer> arr=new ArrayList<Integer>();
		//add some elements in the array
		arr.add(2);
		arr.add(8);
		arr.add(4);
		arr.add(5);
		arr.add(1);
		arr.add(5);
		arr.add(9);
		arr.add(3);
		tree.addAll(arr);
		tree.showElements();//show all elements in the tree in order 
		System.out.println();
		System.out.println("The size is "+tree.size());
        System.out.println("The height is "+tree.height());
		System.out.println("The target element removed successful? "+tree.remove(5));
        System.out.println("The size is "+tree.size());
        System.out.println("The height is "+tree.height());
        //call iterator to output all elements in order
        Iterator<Integer> itr=tree.iterator();
        while(itr.hasNext())
        	System.out.print(itr.next()+" ");
        System.out.println();
        System.out.println("===========================");
       	//the comments for the following codes are similar with above comments.
        A3AVLTree<String> tree2=new A3AVLTree<String>();
        ArrayList<String> arr1=new ArrayList<String>();
        tree2.add("c");
        tree2.add("e");
        tree2.add("a");
        tree2.add("d");
        tree2.add("c");
        tree2.add("e");
        tree2.add("a");
        tree2.add("d");

        tree2.addAll(arr1);
		tree2.showElements();
		System.out.println();
	    System.out.println("The size is "+tree2.size());
	    System.out.println("The height is "+tree2.height());
	    System.out.println("The target element removed successful? "+tree2.remove("c"));
	    System.out.println("The size is "+tree2.size());
	    System.out.println("The height is "+tree2.height());
	    Iterator<String> itr2=tree2.iterator();
	    while(itr2.hasNext())
	        System.out.print(itr2.next()+" ");
	    System.out.println();
	    System.out.println("The size is "+tree2.size());
	    System.out.println("The height is "+tree2.height());
	    System.out.println("The target element removed successful? "+tree2.remove("d"));
	    tree2.showElements();
	    System.out.println();
	    System.out.println("The size is "+tree2.size());
	    System.out.println("The height is "+tree2.height());
	    System.out.println("The target element removed successful? "+tree2.remove("1"));
	    tree2.showElements();  
	    System.out.println();
	    System.out.println("The size is "+tree2.size());
	    System.out.println("The height is "+tree2.height());
	}
}
