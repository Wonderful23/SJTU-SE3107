# homework3
## 基本功能实现
- 由于采用了eureka的服务发现，所以我写了三个程序分别是eureka的服务端在homework的文件夹中，eureka的客户端在homework2与homework3.
- homework2实现的是login，homework3实现的是wordladder。
## 具体实现
- 分别运行这三个文件之后，可以打开localhost:8761端口查看这两个服务是否注册
- 发现两个服务wordladder和login已经存在于注册中心之后，可以进行一下的操作。
- 在postman 的url 发送http://localhost:8082/login2/{username}/{password}/{begin}/{end}首先，wordladder微服务会先将username与password发送login微服务，login微服务通过判读会返回一个String，wordladder接收这个String然后进行判断是否要执行wordladder的计算。
## docker
-  分别在三个文件夹下 执行mvn clean package docker：build 
- 之后分别执行 docker run -p 8761:8761 -d springboot/server
-  docker run -p 8082:8082 -d springboot/wordladder
- docker run -p 8081:8081 -d springboot/login