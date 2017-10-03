---
title: tomcat's tips 
date: 2017-04-09 00:21:16
tags:
---
mark on april 9th
Learn tomcat,and in a few day,I should upload my tomcat server to linux server.
To achieve the purpose "web server"
such as upload,download,comment,search,game,etc

    How to deploy web application?

    1./conf/server.xml  find"localhost",and add <Context> to deploy it
    Here to alert the Context's configurations.
    <Context path="/WebContent/" docBase="c:/java/j2ee" debug="0" reloadable="true" /> 

    2/DocBase mean the webContent's path,u can do it by search the WARS(But u should pack it)
    And path is the supplement of the docBase.
      --So the entire path will be "docBase"+"path";
    reloadable--mean when u change some of the things,it should be auto-renewal or not.