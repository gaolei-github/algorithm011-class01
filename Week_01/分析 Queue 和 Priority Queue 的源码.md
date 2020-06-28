##### 分析 Queue 和 Priority Queue 的源码

1. Queue是个接口先看实现类

<img src="/Users/gaolei/Library/Application Support/typora-user-images/image-20200627092846525.png" alt="image-20200627092846525" style="zoom:50%;" />

2.分析的主要是ArrayDeque和PriorityQueue

ArrayDeque

```java
public boolean add(E e) {
    addLast(e);
    return true;
}
```

直接是向尾部插入数据，并且返回是否插入成功，因为是双指针数据组，插入数据的时候直接指向尾部的指针，因此时间复杂度是o(1)

```java
public void addLast(E e) {
    if (e == null)
        throw new NullPointerException();
    elements[tail] = e;
    if ( (tail = (tail + 1) & (elements.length - 1)) == head)
        doubleCapacity();
}
```

取出数据，直接取出的是头节点数据，因此时间复杂度是o(1)

```java
public E poll() {
    return pollFirst();
}
```

PriorityQueue

```java
public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}
```

主要看siftUp方法，插入数据的时候，会比较两个数据的大小，把数据小的值放到前面，因此时间复杂度是o(n)

```java
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);
    return result;
}
```

取出数据，也要进行数据的比较，取出小的数据，因此时间复杂度是o(n)