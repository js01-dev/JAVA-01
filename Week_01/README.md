学习笔记


https://blog.csdn.net/tree_ifconfig/article/details/81222196
堆区参数配置
 （1）-Xms：Java虚拟机堆区内存初始内存分配的大小，按照实际情况进行分配（一般为操作系统可用内存的1/64大小）。
（2）-Xmx：Java虚拟机堆区内存可被分配的最大上限（一般为操作系统可用内存的1/4大小）。
注意：①一般-Xms、-Xmx两个参数会配置相同的值（优点：能够在Java垃圾回收机制清理完堆区后不需要重新分隔计算堆区的大小而浪费资源）。
（3）-XX:newSize:新生代初始化内存的大小(注意：该值需要小于-Xms的值)。
（4）-XX:MaxnewSize:新生代可被分配的内存的最大上限(注意：该值需要小于-Xmx的值)。
（5）-Xmn:对-XX:newSize、-XX:MaxnewSize两个参数同时进行配置（注意：JDK1.4之后才有该参数）


https://docs.gigaspaces.com/latest/production/production-jvm-tuning.html
Thread Stack Tuning (Xss)
In many cases, the thread stack size needs to be tuned because the default size is too high. In Java SE 6 OS, the default thread stack size on Sparc is 512k for 32-bit VMs, and 1024k for 64-bit VMs. On x86 Solaris/Linux OS, the thread stack size is 320k for 32-bit VMs and 1024k for 64-bit VMs.

On Microsoft Windows OS, the default thread stack size is read from the binary (java.exe). As of Java SE 6, this value is 320k for 32-bit VMs and 1024k for 64-bit VMs. You can reduce your thread stack size by running with the -Xss option.

MaxDirectMemorySize
This JVM option specifies the maximum total size of java.nio (New I/O package) direct buffer allocations. It is used with network data transfer and serialization activity.
The default value for direct memory buffers depends on your version of your JVM. Oracle HotSpot has a default equal to the maximum heap size (-Xmx value), although some early versions may default to a particular value. To control this specific memory area, use the -XX:MaxDirectMemorySize property. 
