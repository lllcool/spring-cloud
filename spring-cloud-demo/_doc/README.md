# PostCloud


PostCloud基于Spring Cloud快速搭建微服务开发环境，
本工程提供了 Spring Cloud 的主要组件使用方式的示例。


## 示例
针对Eureka为例，Zookeeper方式同理
### 1. 运行 Spring Cloud的Eureka Server 集群

运行 post-eureka-cluster 下EurekaCluster1，EurekaCluster2，EurekaCluster3

注意：对三个Spring Boot的启动程序，分别在VM arguments那里，加入

```
-Dspring.profiles.active=cluster-1
-Dspring.profiles.active=cluster-2
-Dspring.profiles.active=cluster-3
```



### 2. 运行Spring Cloud的Service集群

运行 post-eureka-service 下 EurekaService1，EurekaService2

注意：对两个Spring Boot的启动程序，分别在VM arguments那里，加入

```
-Dspring.profiles.active=service-1
-Dspring.profiles.active=service-2
```



### 3. 运行Spring Cloud的Reference

运行 post-eureka-reference 下 EurekaReference1，EurekaReference2

第一种：基于Ribbon的运行方式
第二种：基于Feign的运行方式（对 post-service 服务的绑定和关联，达到以本地接口方式调用远程接口的目的）

第三种：断路器模式。即 post-eureka-reference-hystrix，

注意：前两种方式不能同时运行。

查看Eureka Server集群运行状况：

- http://localhost:1111，

查看远程调用结果（当基于Ribbon的运行方式的时候）： 

- http://localhost:3333/add1
- http://localhost:3333/getUser1

查看远程调用结果（当基于Feign的运行方式的时候）：

- http://localhost:3333/add2
- http://localhost:3333/getUser2







