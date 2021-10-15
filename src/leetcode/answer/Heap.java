package leetcode.answer;

import java.util.Arrays;

/**
 * 手写堆
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

    //数据存储堆结构
    private Object[] heap;
    //是否是大根堆
    private boolean isBigRoot;
    //默认堆初始空间大小
    private static final int DEFAULTLENT = 16;
    //设置堆空间大小
    private int lent;

    @Override
    public String toString() {
        return "Heap{" +
                "heap=" + Arrays.toString(heap) +
                '}';
    }

    //元素个数
    private int size = 0;

    public Heap(boolean isBigRoot) {
        this.isBigRoot = isBigRoot;
        init();
    }

    public Heap(boolean isBigRoot, int lent) {
        this.isBigRoot = isBigRoot;
        this.lent = lent;
        init();
    }

    //堆初始化
    private void init() {
        if (lent <= 0) {
            heap = new Object[DEFAULTLENT];
        } else {
            heap = new Object[lent];
        }
    }

    public void inset(T arg) {
        if (size >= heap.length) {//进行扩容
            Object[] temp = new Object[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                temp[i] = heap[i];
            }
            heap = temp;
        }
        heap[size++] = arg;
        if (size > 1) {
            siftUp();
        }

//        System.out.println(Arrays.toString(heap));
    }

    /**
     * 末尾添加元素 向上调整
     * (i-1)/2   (i-2)/2
     */
    private void siftUp() {
        int index = size - 1;
        int subTreeRoot;
        while (index > 0) {
            T temp1 = (T) heap[(index - 1) / 2];
            T tempI = (T) heap[index];
            if (isBigRoot) {
                if (tempI.compareTo(temp1) > 0) {
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                } else {
                    return;
                }
            } else {
                if (tempI.compareTo(temp1) > 0) {
                    return;
                } else {
                    swap(index, (index - 1) / 2);
                    index = (index - 1) / 2;
                }
            }
        }
    }

    public T peek() {
        return (T) heap[0];
    }


    /**
     * 得到堆顶元素,并删除堆顶元素
     *
     * @return 返回堆顶元素
     */
    public T pop() {
        T result = (T) heap[0];
        swap(0, size - 1);
        heap[size - 1] = null;
        size--;
        siftDown();
        return result;
    }

    /**
     * 头部放出元素向下调整
     * 2i + 1 左子树
     * 2i + 2 右子树
     **/
    private void siftDown() {
        int index = 0;
        while (index * 2 + 1 < size) {
            T tIndex = (T) heap[index];
            T left = (T) heap[2 * index + 1];
            T right = (T) heap[2 * index + 2];
            if (isBigRoot) {
                int maxIndex;
                T max;
                if (right == null) {
                    maxIndex = 2 * index + 1;
                    max = left;
                } else {
                    maxIndex = left.compareTo(right) > 0 ? 2 * index + 1 : 2 * index + 2;
                    max = (T) heap[maxIndex];
                }
                if (max.compareTo(tIndex) > 0) {
                    swap(index, maxIndex);
                    index = maxIndex;
                } else {
                    return;
                }
            }
            if (!isBigRoot) {
                int minIndex;
                T min;
                if (right == null) {
                    minIndex = 2 * index + 1;
                    min = left;
                } else {
                    minIndex = left.compareTo(right) < 0 ? 2 * index + 1 : 2 * index + 2;
                    min = (T) heap[minIndex];
                }
                if (min.compareTo(tIndex) < 0) {
                    swap(index, minIndex);
                    index = minIndex;
                } else {
                    return;
                }
            }
        }
//        System.out.println(Arrays.toString(heap));
    }

    /**
     * 位置交换
     */
    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
