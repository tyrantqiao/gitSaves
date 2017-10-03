---
title: JAVA8
date: 2017-09-07 17:45:44
tags: Java
---
java8的一些新特性：

 1. 流处理（`stream API`）
 2. 行为参数化  ::
 3. Lambda
 4. 方法引用（predicate--谓词）
 5. 默认方法（default）
 6. `Optional<T>`容器对象 可包含空值

**Stream API+lambda+行为参数化**

```
things=filterThings(things,(Thing a)->a.getColor().equals("red"));
List<Thing> blueThings=things.stream().filter((Thing t)->t.getColor().equals("blue")).collect(Collectors.toList());
List<Thing> parallelThings=things.parallelStream().filter((Thing t)->t.getSize()<5).collect(Collectors.toList());
```

**行为参数化**
 1. predicate 流程

```flow
st=>start: 建立接口（接口有一个默认的方法test）
op=>operation: 实现这个接口，并重写方法
e=>end: 行为参数化

st->op->e
```

```
public static boolean testSizeBig(Thing thing){
        return thing.getSize()>5;
}
filter(xxx,class::testSizeBig)
```

**default**

 - 扩写接口且实体类不用显式实现
 (这样就可以在函数接口内扩写方法，而不破坏函数接口的唯一性--`只能有一个抽象方法`

**Lambda**

- 本质是对应接口的签名

```flow
st=>start: ()->()
op1=>operation: 确定接口的类型（比如是String）
op2=>operation: 确定抽象方法（开始调用【扩写】）
e=>end

st->op1->op2->e
```

- 常用函数接口
> Predicate -- boolean test

> Consumer  -- void accept(T t)

> Function<T,R> -- R apply(T,t)

由于接口泛型缘故，使得必须传入引用类型（Reference Type）使得基本类型要经过boxing，开销大。
解决：调用IntFunction或者Double之类的避免装箱拆箱过程。

此外Lambda不直接支持异常：
- try-catch解决
- 接口处throw

- 关于签名认证，若接口为void，Lambda为语句即可满足，即便返回的是其它类型

- 作用域：实例、static变量（但局部变量必须为final）as: 使局部唯一，避免并行错误

- 操作符： .and .or .andThen(g) .compose(xx)先执行xx

**方法引用**
()->new XXX() == XXX::new 调用构造器。（无法访问内部类的构造器ｍａｙｂｅ）

多参数接口
```
XFunction<T,U,V,R>{
        R apply(T t,U u, R r);
}
```

**流**
comparing(xx::xx)
.thenComparing()

- Stream
.fliter
.skip
.collet(toList())
.max
.min
.map(method()) 让每个元素执行函数
.distinct() 使独一无二
.anyMatch 至少1
.noneMatch
.flatMap(Arrays::Stream) Stream<String> 使流数组汇成一个流
.ifPresent  若有值则true或者执行语句
.reduce(Initial, BinaryOperator<T>) 初始值若不加则对象应为Optional，操作符即可用Lambda
.sorted(comparing())
.mapToInt() 返回IntStream
.boxed() 装箱
.mapToObj 对象流
.iterate() 遍历
.groupingBy() 分组

- 数据类型
同样避免装箱拆箱操作，有IntStream等选择



