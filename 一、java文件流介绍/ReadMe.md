# java文件流介绍
在本次实验中，我们主要使用的文件流有四种（严格来说算上System.out有五种，不过谁care呢？）：

1、FileInputStream 与 FileOutputStream（以下简称fis与fos）
2、BufferedInputStream 与 BufferedOutputStream（以下简称bis与bos）

有同学就疑惑了，ackon同学呀，我知道前两个流，他们的read和write函数足够支持文件读写了，后两个有啥用啊？

我说后两个是高级流，很高级，用起来感觉非常的装13（划掉），用起来可以大幅度提升文件读写效率。我们都知道，电脑从硬盘读写文件的速度是相对较慢的。
当我们只使用fis和fos时，Java会从你的硬盘里一个字节一个字节的读取，再一个字节一个字节的存储。而bis与bos则将转储过程在内存中完成，非常迅速。因此
在实际的使用过程中，我们经常会bis与fis、bos与fos搭配使用，完成本机的文件读写。

接下来让我们来实现一个非常简单的小实验吧~

# 实验内容：

一、创建一个内容为“hello word！”的a.txt文件与一个空的destination文件夹。

二、读取a.txt文件中内容并输出。

三、将a.txt文件内容写出到destination文件夹内，保存为b.txt

四、尝试将一个8MB的mp4文件写入destination文件夹内。
