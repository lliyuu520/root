#!/bin/bash
###################################
#环境变量及程序执行参数
#需要根据实际环境以及Java程序名称来修改这些参数
###################################
#JDK所在路径


#Java程序所在的目录（classes的上一级目录）

#需要启动的Java主程序（main方法类）
APP_NAME=$2
RUNNING_USER=root

#jps 加 l 参数，表示显示java的完整包路径
#使用awk，分割出pid ($1部分)，及Java程序名称($2部分)
###################################
#初始化psid变量（全局）
psid=0

checkpid() {
   javaps=`$JAVA_HOME/bin/jps -l | grep $APP_NAME`

   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
   else
      psid=0
   fi
}

###################################
#(函数)启动程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示程序已启动
#3. 如果程序没有被启动，则执行启动命令行
#4. 启动命令执行后，再次调用checkpid函数
#5. 如果步骤4的结果能够确认程序的pid,则打印[OK]，否则打印[Failed]
#注意：echo -n 表示打印字符后，不换行
#注意: "nohup 某命令 >/dev/null 2>&1 &" 的用法
###################################
start() {
   checkpid

   if [ $psid -ne 0 ]; then
      echo "================================"
      echo "warn: $APP_NAME already started! (pid=$psid)"
      echo "================================"
   else
      echo -n "Starting $APP_NAME ..."
      nohup java -Xms128m -Xmx256m -jar  $APP_NAME --spring.prifiles.active=prod >/dev/null 2>&1 &
      checkpid
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else
         echo "[Failed]"
      fi
   fi
}

###################################
#(函数)停止程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则开始执行停止，否则，提示程序未运行
#3. 使用kill -9 pid命令进行强制杀死进程
#4. 执行kill命令行紧接其后，马上查看上一句命令的返回值: $?
#5. 如果步骤4的结果$?等于0,则打印[OK]，否则打印[Failed]
#6. 为了防止java程序被启动多次，这里增加反复检查进程，反复杀死的处理（递归调用stop）。
#注意：echo -n 表示打印字符后，不换行
#注意: 在shell编程中，"$?" 表示上一句命令或者一个函数的返回值
###################################
stop() {
   checkpid

   if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_NAME ...(pid=$psid) "
      kill -9 $psid
      if [ $? -eq 0 ]; then
         echo "[STOP ]${APP_NAME} SUCCESS"
      else
         echo "[STOP ]${APP_NAME}  FAILED]"
      fi

      checkpid
      if [ $psid -ne 0 ]; then
         stop
      fi
   else
      echo "================================"
      echo "warn: $APP_NAME is not running"
      echo "================================"
   fi
}

###################################
#(函数)检查程序运行状态
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示正在运行并表示出pid
#3. 否则，提示程序未运行
###################################
status() {
   checkpid

   if [ $psid -ne 0 ];  then
      echo "$APP_NAME is running! (pid=$psid)"
   else
      echo "$APP_NAME is not running"
   fi
}



###################################
#读取脚本的第一个参数($1)，进行判断
#参数取值范围：{start|stop|restart|status|info}
#如参数不在指定范围之内，则打印帮助信息
###################################
case "$1" in
   'start')
      start
      ;;
   'stop')
     stop
     ;;
   'restart')
     stop
     start
     ;;
   'status')
     status
     ;;
  *)
echo "Usage: $0 {start|stop|restart|status}"
exit 1
esac
exit 0
