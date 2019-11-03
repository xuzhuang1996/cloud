# cloud
## 编写过程中遇到的问题
1. SpringApplicationBuilder，SpringApplication and ApplicationContext实例的构建器。使用 SpringApplicationBuilder 进行启动，主要是为了创建一个分层次的ApplicationContext （多个context，有父子关系）。它可以链式调用方法，并且设置父子关系。
2. SpringApplicationBuilder的使用导致的错误：

        Error starting Tomcat context. Exception: org.springframework.beans.factory.UnsatisfiedDependencyException. Message: Error creating bean with name 'traceFilterRegistration' defined in class path resource [org/springframework/cloud/netflix/eureka/server/EurekaServerAutoConfiguration.class]: Unsatisfied dependency expressed through method 'traceFilterRegistration' parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'javax.servlet.Filter' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Qualifier(value=httpTraceFilter)}
    1. 解决方式：删掉.m2下的所有，应该是依赖冲突。 
