制作钥匙：

在装有java环境里
1，切换到DatGen.java目录,比如E目录
2，E:\>javac -d ./ DatGen.java
3，E:\>java DatGen '{"ipList":["127.0.0.1"],"codeList":["802000","802001","802002","802005","802006","802007","802100","802101","802102","802105","802106","802107","802110","802111","802112","802115","802116","802117","802150","802151","802152","802153"]}'

4，拷贝当前目录下的“config.dat”到项目“{项目路径}\src\main\resources”
5，验证：项目跑起来。在浏览器输入“http://IP:端口/项目名/api”，出现版本信息即成功。


部署步骤：
1，切换到本地tomcat部署包所在目录,例如
  cd /Users/myb858/Documents/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp5/wtpwebapps
  
2，打包
   scp -P22 ./std-account.war root@121.43.101.148:/home
   T6dh%$%$ss1

3，部署
  ssh root@121.43.101.148 -p 22
  T6dh%$%$ss1
  
  cd /home/wwwroot/common/tomcat_std_account/webapps
  rm -rf std-account.war
  cp ./std-account/WEB-INF/classes/application.properties .
  cp ./std-account/WEB-INF/classes/config.properties .
  rm -rf std-account*
  mv /home/std-account.war .
  
4,起停tomcat_STD_account
  mv -f application.properties ./std-account/WEB-INF/classes/
  mv -f config.properties ./std-account/WEB-INF/classes/
  ../bin/shutdown.sh
  ../bin/startup.sh
  
   http://121.43.101.148:8906/std-account/api
