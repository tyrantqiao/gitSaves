---
title: Autowired无法注入解决办法和一些Junit4异常处理
date: 2017-04-21 22:53:37
tags:
---
`怎么设置autowired`

- first u should set up your file structure like below
--fundamental class(+@Component)
--configure (+@ComponentScan)
--Main、Test(+@ContextConfiguration(classes=xxxConfigure.class))

- if u want to test whether the file is injected...(by Junit4 etc)

here is some emphasis:
First import junit4 api
In the main class,should add the prefix to run the junit4
```
@Runwith(SpringJUnit4ClassRunner.class)
@Context

@Autowired 
public xx xxx; 

@Test
public void testMethod(){}
{% endcodeblock %}
current spring doesn't recommend field injection
change like this
{% codeblock %}
@Autowired
public void setxxx(xx xx){this.xx=xx}
```
or
```
@Autowired
public constructor(xxxx xxx){this.xxx=xxx}
```
but here is a big question,junit4 will load a none-parameter constructor,so u cannot new a 
constructor with parameter and use it by junit

below is exception,show why parameter-constructor will make exception
```
 org.junit.runners.BlockJUnit4ClassRunner.validateZeroArgConstructor(BlockJUnit4ClassRunner.java:171)
 org.junit.runners.BlockJUnit4ClassRunner.validateConstructor(BlockJUnit4ClassRunner.java:148)
```
get inside to first exception
```
protected void validateZeroArgConstructor(List<Throwable> errors) {
    if(!this.getTestClass().isANonStaticInnerClass() && this.hasOneConstructor() && this.getTestClass().getOnlyConstructor().getParameterTypes().length != 0) {
        String gripe = "Test class should have exactly one public zero-argument constructor";
        errors.add(new Exception(gripe));
    }
}
```
it will check your constructor is none-parameters or not Try setter injection or field(->field is not recommended officially)