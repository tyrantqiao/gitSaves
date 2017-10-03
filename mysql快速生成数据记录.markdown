---
title: mysql快速生成数据记录
date: 2017-09-14 20:43:18
tags:
---
`FUNCTION`和`PROCEDURE`，除了function只能返回一个函数外，其他基本一样

`while`和创建过程

```flow
st=>start: create function name (params) returns type charset name;
op1=>operation: begin
op2=>operation: declare name type;
op3=>operation: statement
op4=>operation: end while
op5=>operation: statement
cond1=>condition: while condition do
e1=>end: end:>http://tyrantqiao.github.io/Blog[blank]

st->op1->op2->cond1
cond1(yes)->op4->e1
cond1(no)->op5->cond1
```

`repeat`
```
repeat
    statement
until condition
end repeat
```

`if-else`
```
if condition then
    statement
else
    statement
end if
```


