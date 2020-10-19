import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class PrimesIterator implements Iterator<Integer> {

    public List<Integer> primesCache = new ArrayList<>();
    private int i = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
       do {
            i++;
       } while (!isPrime(i));     
       return i;
    }


    public static void main(String[] args) {
        for (int prime : new PrimesIterable()) {
            System.out.println(prime);
            if (prime > 100) break;
        }
    }

    private boolean isPrime(int i) {
        int sqroot = (int) Math.sqrt(i);
        for (int j : primesCache) {
            if (j > sqroot) break;
            if (i % j == 0){
                return false;
            }
        }
        primesCache.add(i);
        return true;
    }
}
