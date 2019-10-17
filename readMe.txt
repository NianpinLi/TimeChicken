项目使用技术
1.项目搭建后端使用SpringBoot框架
2.项目搭建前端使用layuinimi
3.项目使用shiro框架作权限控制
4.项目使用redis作为缓存，并使用redis做session共享
5.项目使用Mybatis做数据持久化，并使用Mybatis-generator做反向生成
6.项目使用Jsoup做Xss攻击过滤
7.项目使用log4j2做日志输出
8.项目使用FastDFS做文件服务器，并做文件储存,下载,图片展示等
9.项目是由Druid连接池,Mybatis做持久化，并配置Druid监控。


项目搭建
1，项目搭建需使用Nginx 做项目的负载均衡
2，项目搭建需使用Redis 做项目缓存
3，项目搭建需使用FastDFS做文件服务器


项目编码风格，编码规范
1.项目编码请严格遵守阿里编码守则
2.项目编码使用 Alibaba Java Coding Guidelines 做代码检查
3.增删改需在Service方法上添加 @Transactional(rollbackFor=Exception.class) 注解做事务控制
