---
title: vps with shadowsocks
date: 2017-04-19 22:59:53
tags:
---
	this article is in order to record how to set up ssserver,and is writtened by win_turn.

need a vps,u would better to get a vps in western countries.
There are some vps recommended,vultr,banwagong,HostUS,DO```````
(first ping the server,as the great wall and different operator cause different speed.)
(!ps,if u use the putty or pietty,better choose those whose ping is less than 160ms,or u will feel crashed)
```
yum install gcc
yum install openssl-devel

wget http://python.org/ftp/python/2.7.3/Python-2.7.3.tar.bz2
tar -jxvf Python-2.7.3.tar.bz2 
cd Python-2.7.3  
./configure
make all
make install 
mv /usr/bin/python /usr/bin/python2.6.6
ln -s /usr/local/bin/python2.7 /usr/bin/python 
```
```
vi /usr/bin/yum
#!/usr/bin/yum2.6.6

cd
yum install python-setuptools
wget https://bootstrap.pypa.io/ez_setup.py -O - | python
wget http://pypi.python.org/packages/source/d/distribute/distribute-0.6.10.tar.gz
tar zxvf distribute-0.6.10.tar.gz
cd distribute-0.6.10
python setup.py install
cd
easy_install pip
pip install shadowsocks
```
```
vi /etc/shadowsocks.json

{
"server":"xxx.xx.x.xx",
"server_port":7777,
"password":"xxxxxxx",
"timeout":300,
"method":"aes-256-cfb",
"fast_open":false,
"workers": 1
}

setup openserver auto open shacksocks
vi /etc/rc.local
ssserver -c /etc/shadowsocks.json -d start
```