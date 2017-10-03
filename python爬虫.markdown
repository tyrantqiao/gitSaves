---
title: python爬虫
date: 2017-09-25 23:12:03
tags:
---
【配置: Python3 + re + requests + Chrome】

在imooc上学习的，写时最好分下模块，便于自己思路整理和编写

```flow
st=>start: engine(启动类)
op1=>operation: downloader(下载类)
op2=>operation: textManager(文字处理，负责提取信息部分)
op3=>operation: logManager(负责日志和文件输出部分)
op4=>operation: ThreadManager(负责线程开展)
cond=>condition: 确定无下一步链接
e=>end: 我的项目地址（点我）:> https://github.com/tyrantqiao/PythonGraber

st->op1->op2->cond
cond(yes)->op3->op4->e
cond(no)->op1
```

具体代码github上
[python_grab](https://github.com/tyrantqiao/PythonGraber)

以下是介绍一些注意事项：

- 打日志时，可以用`datetime.datetime.now().strftime("%Y====")`

- 为/item/dwdede这种只有一半的链接补充头时，可用enumerate来解决
```
for i,item in enumerate(your_list):
    item='dwdwdwdw'+item
    your_list[i]=item
```

- 关于URI={URL,URN} URN--只命名不标记

- 若是简单的字符还是可以使用re来进行使用regex，但是若是很复杂的html标签之类的不太建议使用regex，
一是调试时间长，而且复用性差。可用beautifulsoul来代替。

当然若是执意要用re，这里可给出一些例子，提供你参考。
  - regex
    - [x] re.match() return tuple 如果要使用list，用 `[i for i in tuple_name]`
    - [x] re.search() 比match()好一点，因为match()限定了string的开头开始匹配，大部分错误都是这开始的
    - [x] re.findall() 这个比较推荐，首先是返回list，好操作，然后不局限于开头这一段
    - [x] re.DOTALL 使点也能匹配newline， re.VERBOSE 忽略空格和行符 ,re.MULTIILINE 使多行匹配
    - [x] \* ? + 都是greedy, 关掉greedy模式，使得最短匹配，使用??、+?、*?
    - [x] (?=xxx)xx 环视，检索xxx开头的，再以xx开始匹配.
    - [x] (?<=xxx)xx 检索xxx开头，再跳过xx开始匹配
    - [x] or | 或

