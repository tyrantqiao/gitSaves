---
title: python
date: 2017-09-08 22:31:59
tags:
---
`自动补全`（linux）

  - vim内实现：(此方案来自http://xushaojie.blog.51cto.com/6205370/1783256）
    ```
    wget https://github.com/rkulla/pydiction/archive/master.zip
    unzip -q master
    mv pydiction-master pydiction
    mkdir -p ~/.vim/tools/pydiction
    cp -r pydiction/after ~/.vim
    cp pydiction/complete-dict ~/.vim/tools/pydiction
    ```
    vim ~/.vimrc
    ```
    filetype plugin on
    let g:pydiction_location = '~/.vim/tools/pydiction/complete-dict'
    ```
  - terminal（交互模式下）
    名字随意
    ```
       #!/usr/bin/python
       # python startup file

       import sys
       import readline
       import rlcompleter
       import atexit
       import os
       readline.parse_and_bind('tab: complete')
       histfile = os.path.join(os.environ['HOME'], '.pythonhistory')
       try:
           readline.read_history_file(histfile)
       except IOError:
           pass
       atexit.register(readline.write_history_file, histfile)

       del os, histfile, readline, rlcompleter
    ```
    查询本机python库（import sys; sys.path）
    `cp xx.py lib_path`
    加入到bashrc:`export PYTHONSTARTUP=lib_path/xx.py
    DONE

`python version error`

    To begin with,Python now has two version,2 or 3.
    Although official is recommending coders to use Python3.But the transmit the 2 code to 3
    will cost too much,at the same time.The version 3 is no longer be compatible with 2.

Until 17.04.29,My linux's yum still use the Python2...
if u had installed some Python3 ,and caused some error.
It might be the confusion of version,

    find your app config,such as yum
    vim /usr/bin/yum
    #!/usr/bin/yum2.7

    vim /usr/libexec/urlgrabber-ext-down
    #!/usr/bin/yum2.7

If your app needs Python3,first download and make the configure file.
(By the way,seems the pyenv can achieve auto-change Python)

`python request`
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36

def saveFile(text):
    save_path = 'grab1.out'
    f_obj = open(save_path, 'wb')
    f_obj.write(text)
    f_obj.close()


saveFile(data)

- requests

        import requests
        r = requests.get('https://stackoverflow.com/users')
        # print(r.text)

        def saveText(text):
            save_path = 'stackoverflowUsers.out'
            f_obj = open(save_path, 'wb')
            f_obj.write(text)
            f_obj.close()

        rData=r.text.encode('UTF-8')
        saveText(rData)

-worm

        import re
        from urllib.request import urlretrieve
        from worm.fileio import save_text

        with open('.\\graber\\users.out', 'r', encoding='UTF-8') as users_obj:
            # print(users_obj)
            html_list = users_obj.readlines()
            # print(type(html_str))
            html_str = "".join(html_list)
            # print(type(html_str))
            # print(html_str)

            image_matches = re.findall('<img src="(https://www.gravatar.*)" alt', html_str, re.M | re.I)
            index = 0
            for image_match in image_matches:
                index += 1
                print(image_match)
                urlretrieve(image_match, './graber/image/user' + str(index) + '.jpg')

                # image_urls_text = '''stackoverflow's users' image url:\n '''
                # for image_match in image_matches:
                #     image_urls_text = image_urls_text + image_match +'\n'
                # print(image_urls_text)

                # save_text(image_urls_text, './graber/imageURL.txt')
                # savefile(image_text.encode('UTF-8'),'image_url')

