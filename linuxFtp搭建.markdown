---
title: linuxFtpConstruct
date: 2017-04-16 16:46:09
tags:
---
linux ftp (win to linux server)

- vsftpd --download by yum ,
    `yum install vsftpd`

don't use such as /etc/init.d and service(<--cannot use anymore)
- use the systemctl to check service
	`systemctl list-unit-files|grep vsftpd.service`

- check the service with vsftpd  disabled
	`systemctl enable vsftpd.service`

- And the vsftpd file is locating at /etc/vsftpd
	 `ls`

-show all files in this directory
	`vim- modify the file`
	`cat- catch the file`

- check the port is occupying by who
	` netstat -natp|grep name`
	if not the vsftpd ,use systemctl stop xxx to kill the thing.

- check SELINUX's config
	 `getsebool -a|grep ftp`
	 change the config
	 `setsebool -P xxxx=1 `

- add user(ftp)
	  `useradd ____ -s /sbin/nologin
	  passwd ____ `
	set the new password(!!!when u input the password, it will not show u how many characters u had typed)
	
- vsftpd's config locates on /etc/vsftpd/vsftpd.conf

- if u cannot use the ftp,see the port or iptables
	 iptables -L
- if u want to use ssl to encrypt your message
	first check the ssl module
		ldd $(which vsftpd) |grep ssl
	then create ssl certification(in CentOS /etc/pki/tls/certs is where to create certifications)
	 cd /etc/pki/tls/certs
	 make vsftpd.pem 
	supply balbalbalba your message
		cp -a vsftpd.pem /etc/vsftpd/
		ll /etc/vsftpd/vsftpd.pem 
		vim /etc/vsftpd/vsftpd.conf 
	insert ssl_enable=YES
		   allow_anon_ssl=NO
		   force_local_data_ssl=YES
		   force_local_logins_ssl=YES
		   ssl_tlsv1=YES
		   ssl_tlsv2=NO
		   ssl_tlsv3=NO
		   rsa_cert_file=/etc/vsftpd/vsftpd.pem (<-your rsa certification)
	restart your vsftpd
	

`linuxApache`

apache 2 structure
/etc/apache2/
         |
         |- charset.conv
         |- conf.d/
         |   |
         |   |- *.conf
         |
         |- default-server.conf
         |- errors.conf
         |- httpd.conf
         |- listen.conf
         |- magic
         |- mime.types
         |- mod_*.conf
         |- server-tuning.conf
         |- ssl.*
         |- ssl-global.conf
         |- sysconfig.d
         |   |
         |   |- global.conf
         |   |- include.conf
         |   |- loadmodule.conf . .
         |
         |- uid.conf
         |- vhosts.d
         |   |- *.conf

first install thing
    yum install httpd
    chkconfig httpd on  (powerboot)
    systemctl start httpd (same as the before init.d)

  - default file path when you login on http server `/root`
  - www file default path`/var/www/`
