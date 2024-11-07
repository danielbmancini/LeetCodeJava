import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Int2DArraySet implements Set<int[][]> {
    private final Map<Entry, Object> map = new HashMap<>();
    private static final Object PRESENT = new Object();

    // Inner class to define unique array entries based on content
    private static class Entry {
        private final int[][] array;

        public Entry(int[][] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Entry other = (Entry) obj;
            return arraysEqual(this.array, other.array);
        }

        @Override
        public int hashCode() {
            int hash = 1;
            for (int[] row : array) {
                for (int element : row) {
                    hash = 31 * hash + element;
                }
            }
            return hash;
        }

        private static boolean arraysEqual(int[][] a, int[][] b) {
            if (a.length != b.length)
                return false;
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != b[i].length)
                    return false;
                for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] != b[i][j])
                        return false;
                }
            }
            return true;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof int[][]))
            return false;
        return map.containsKey(new Entry((int[][]) o));
    }

    @Override
    public Iterator<int[][]> iterator() {
        return new Iterator<int[][]>() {
            private final Iterator<Entry> entryIterator = map.keySet().iterator();

            @Override
            public boolean hasNext() {
                return entryIterator.hasNext();
            }

            @Override
            public int[][] next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return entryIterator.next().array;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return map.keySet().stream().map(entry -> entry.array).toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return map.keySet().stream().map(entry -> entry.array).toArray(size -> a);
    }

    @Override
    public boolean add(int[][] array) {
        return map.put(new Entry(array), PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof int[][]))
            return false;
        return map.remove(new Entry((int[][]) o)) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends int[][]> c) {
        boolean modified = false;
        for (int[][] array : c) {
            if (add(array))
                modified = true;
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return map.keySet().retainAll(c.stream().map(obj -> new Entry((int[][]) obj)).toList());
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            if (remove(element))
                modified = true;
        }
        return modified;
    }

    @Override
    public void clear() {
        map.clear();
    }

}
