import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SberIterator <E> implements Iterator<E> {

    Iterator<E> iteratorA;
    Iterator<E> iteratorB;
    Comparator<E> comparator;
    TreeSet<E> set;

    public SberIterator(Iterator<E> iteratorA, Iterator<E> iteratorB, Comparator<E> comparator) {
        this.iteratorA = iteratorA;
        this.iteratorB = iteratorB;
        this.comparator = comparator;
    }

    @Override
    public boolean hasNext() {
        return !set.isEmpty();
    }

    @Override
    public E next() {
        return null;
    }
}
