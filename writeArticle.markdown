---
title: writeArticle
date: 2017-04-16 15:58:33
tags:
---
How to use hexo to new article and push it on the website?

`Firstly,create the .md file to write things`

{% codeblock %}
    cd the path to hexo document
    hexo new post ______(post_name)
    hexo g -> hexo s -> hexo d
{% endcodeblock %}

- Two ways to write article, one with hexo, the other with the default settings
- with the Hexo's tags' plug in
{% blockquote %}
	write your code in here
{% endblockquote %}
s
{% blockquote url name %}
{% endblockquote %}

 - **(stackoverflow or idea, etc)default settings, I think this is some custom that we all fllow**

**>** add to the begin of the line, it will cause a blockquote, in stackoverflow, the shortcut, will be ctrl+Q

'** **' use to make your font bold or as a function field, can go with '>'
 
 '-'  as a bulleted list.
 
 `xxxx` \`xxxx\`  use `` to highlight the thing you want.
 
 [Qiao's Blog]
 use [] to input the url's description,such as [bala];
 Then add the url to the below as '[bala]:http://xxxxx.xxxx.xxx'
 
 [Qiao's blog]:http://tyrantqiao.github.io/Blog/

If there is any Host key error, that means you need to make ssh key to server(git)
*Resolution*
- make key `ssh-keygen -t rsa -b 4096 -C "email"`


