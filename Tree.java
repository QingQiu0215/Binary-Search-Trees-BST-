import java.util.Collection;
import java.util.Iterator;
//interface Tree
public interface Tree <E> 
{	
	public void add(E e);
	public void addAll (Collection<? extends E> c);
	public boolean remove(Object o);
	public Iterator<E> iterator();
	public int height();
	public int size();
    public Node<E> getRoot();

}
