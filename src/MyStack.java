import java.util.Iterator;

/**
 * 栈-数组实现
 *
 * @param <T>
 */
public class MyStack<T> implements Iterable<T> {

    //内部维护的数组
    private T[] array = (T[]) new Object[10];
    private int currentEle = 0;


    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    public void push(T t) {
        ensureSize();
        array[currentEle++] = t;
    }

    private void ensureSize() {
        if (currentEle + 1 == array.length) {
            //准备满了
            //当前的元素个数 == array.length
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = (T[]) newArray;
        }
    }

    public T pop() {
        --currentEle;
        T last = array[currentEle];
        array[currentEle] = null;
        //自动减少
        reduceSize();
        return last;
    }

    private void reduceSize() {
        if (currentEle < array.length * 0.25) {
            T[] newArray = (T[]) new Object[array.length / 2];
            for (int i = 0; i < currentEle; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }


    private class MyStackIterator implements Iterator<T> {

        private int currentAid = currentEle;

        @Override
        public boolean hasNext() {
            return currentAid > 0;
        }

        //支持先进后出的stack结构迭代
        @Override
        public T next() {
            return array[--currentAid];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String args[]) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(11);
        myStack.push(12);


        Iterator<Integer> it = myStack.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
