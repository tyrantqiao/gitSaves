---
title: Error:server send disconnect message(protocol type2)too Many Authentication```
date: 2017-04-28 22:09:09
tags:
---
If you change your config file before '/etc/ssh/sshd_config'

    -->change the things such as MaxAuth or allow Root to false or set the public key '#'
        if might be the crux of the problem
        -->set the maxAuth bigger or let the root admin or set the public key and rsa 'yes'

This might be helpful,if it doesn't work,reset the key.

`Extension:`
If u ping your server too high(such as 260ms)
It will influence your experience
(when u type a letter,it will cost some time to display on your monitor)
-->cause the interaction cost too much,for example,when u type a letter,it will send to your 
server,after the process is finished,then send back the information to you and display on your
monitor[putty etc]

Resolve
-->connect to the proxy server
    (if u use shadowsocks,it has a port default '1080' for the proxy)
    -->putty configuration 
        --connection
            --proxy (fill the thing)
    -->use the proxifer to agent your app'putty'
       {% blockquote https://www.proxifier.com/  proxifer for windows %} {% endblockquote %} 
       
       -->set the shadowsocks configuration to sock5 
           fill the thing,add the app putty
           remeber not to use proxifer to agent your network,it will be slow.