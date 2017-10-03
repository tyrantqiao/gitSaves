---
title: how to fix shadowsocks 's slow
date: 2017-04-25 23:49:48
tags:
---
if your shadowsocks is very slow,and this is not your net's wrong.
You can try the below tests to fast your ss.

    1.change your ss server's config which is located in /etc/shadowsocks.json
       --The port change to 443 will be helpful,as the default web service port is 443(i mean the website etc) 
vim /etc/shadowsocks.json

-->port:443,
-->timeout:800
ssserver -c /etc/shadowsocks restart (if don't have the bash restart,stop->start)

    2.change your local(client) application and some useful tips
    proxy mode -->PAC (inside the wall will not use proxy)
                      (outside the wall will use proxy)
               -->ALL (wherever the site is,will surf by the server)
               (if u cannot surf the domestic site,use the pac)
    use the show statics to look what make your network so slow,and correct it,
    server  -->if u are getting stuck,change the server setting alternatively.It might be helpful.

   