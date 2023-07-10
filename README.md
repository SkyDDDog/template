# SpringBoot 开发基本框架
> 本项目是基于SpringBoot开发的基本框架，封装了Crud的基本操作，仅供学习参考

## 说在前头
本项目仅供参考学习，主要是个人习惯，实际使用以个人为主；如果有更好的建议，欢迎提出issue/pr

## 项目依赖
开发环境为jdk1.8，项目依赖如下：

仅列出本项目中的主要依赖，具体依赖请查看pom.xml文件

本项目仅作为模板尽可能的少引入依赖，具体使用时请根据实际情况引入依赖

* SpringBoot 2.3.4.RELEASE
* Mybatis 3.0.2
* Mybatis-Plus 3.5.3.1
* Lombok
* Swagger 2.7.0
* FastJson 1.2.73
* ...

## 项目结构
```
.
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─west2
│  │  │          ├─common           // 通用结果返回类
│  │  │          ├─config           // 配置类
│  │  │          ├─controller       // controller层(控制器层) 用于暴露接口
│  │  │          ├─entity           // 实体类
│  │  │          │  ├─base          // 封装的基本实体类(用于数据库增删改查)
│  │  │          │  ├─dto           // 数据传输对象(接收前端参数)
│  │  │          │  └─vo            // 视图对象(返回给前端的数据)
│  │  │          ├─mapper           // mapper层(持久层) 用于与数据库交互
│  │  │          └─service          // service层(业务层) 上传下达，用于编写业务代码
│  │  └─resources                   // 资源文件
│  └─test                           // 测试目录(建议按src目录结构建立并编写单元测试)
│      └─java
│          └─com
└─              └─west2
```

## 最后
后续可能考虑会制成starter发布(可能也只是供自己学习使用罢)

有什么不错的想法或者建议，欢迎提出issue/pr