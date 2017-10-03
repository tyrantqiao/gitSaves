---
title: ssh
date: 2017-05-16 23:47:05
tags:
---
As the telnet doesn't encrypt information,ssh be the popular connecting way.

SSH:  
    1.server create public key
    2.receiver get the key and create its' public and private key.
    3.resent the 'receiver'public key to server
    
   server will send the data which is encrypted(use the receiver's public key
    encrypt).Receiver get the data and decrypt it with receiver's private key.