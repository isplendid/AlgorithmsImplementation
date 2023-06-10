package task.scheduler;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author xushichao
 * @date 2023/5/22 22:08
 * @desc
 * 一个包含Delayed节点的阻塞队列
 */
public class DelayQueue <E extends Delayed>  extends AbstractQueue<E> implements BlockingQueue<E> {

    private final transient ReentrantLock lock = new ReentrantLock();
    private final PriorityQueue<E> q = new PriorityQueue<>();//优先队列，队列里面的元素必须实现Delayed接口
    private Thread leader = null; // 采用Leader-Follower模式可以最小化不必要的时间等待。
    private final Condition available = lock.newCondition();



    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(E e) throws InterruptedException {

    }

    @Override
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();//必须是线程安全的

        try {
            for(;;) {// 自旋直到取出堆顶节点
                E first = q.peek();
                if(first == null) { //队列为空
                    available.await(); //阻塞
                } else {
                    long delay = first.getDelay(NANOSECONDS);//获取节点的延迟时间
                    if (delay <= 0) //小于等于0，任务超时可以执行了
                        return q.poll();//返回超时的任务
                    first = null; // 如果大于0说明还没到时，需要继续等待，断开与堆顶元素的引用，以便gc的时候能及时回收掉

                    if (leader != null)
                        available.await();//没有抢到leader的线程进入等待，避免大量唤醒操作
                    else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            available.awaitNanos(delay);//leader线程，在等待一定时间后再次尝试获取
                        } finally {
                            if (leader == thisThread)
                                leader = null;//重置leader线程
                        }
                    }
                }


                }
        } finally {
            if(leader== null  && q.peek() != null) {
                available.signal();

            lock.unlock();

        }

    }

    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public int remainingCapacity() {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c) {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements) {
        return 0;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
