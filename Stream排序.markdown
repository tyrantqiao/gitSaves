---
title: Stream排序
date: 2017-09-18 23:48:07
tags:
---
`生成List`

```
List<Integer> list=Stream.iterate(1,i->i+1)
                        .limit(10)
                        .collect(Collectors.toList());
```

`reduce`
对函数进行操作，返回Optional<T>的结果

```
stream.reduce(Integer::sum);
```

这里应注意，当你想在static void main()中使用lambda时，使用的函数必须是static注释的，所以类似一些String::method是
不能使用的.

`sort`
生成List后，直接.sort();
 -  sort
    - [x] Function
    - [x] Function,Comparator
若是选择前者，则以默认的排序方法进行

Function<T,R> -- R apply(T);
    核心是接受类型为T的data，进行操作后返回类型为R的result；

Comparator<T> -- int compare(T o1,T 02);
    接受类型为T的data，进行compare操作，返回正数，负数，0对应><=
    可用a.compareTo(b)
    ((Comparable)a).compareTo(b)
    Comparator.naturalOrder()
    String::compareTo

```
List<Integer> result= Arrays.asList(1,2,5,3,6,2,0,35,34,4,6);
		result.sort(Comparator.comparing(t -> t, (a, b) -> ((Comparable)a).compareTo(b)));
		System.out.println(result);
```
