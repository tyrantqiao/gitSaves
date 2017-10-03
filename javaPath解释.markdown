---
title: javaPath详解
date: 2017-04-16 16:03:47
tags:
---
java path is aiming to conveniently open :
 - `java.exe` which is designed for compiling .java to .class.
 - `javac.exe` explain the .class file to executable binary file
 - `jvm.exe` jvm to load the binary code
In stead of using cmd to run the binary exe above with all path(such as : `c:/java/jdk/bin/java.exe etc.`

When build the path,`JAVA_HOME` jdk should save to a place different from the jre file.In order to prevent the lib path mixing up.
