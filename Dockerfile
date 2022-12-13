# 该镜像需要依赖的基础镜像
FROM eclipse/ubuntu_jdk8:latest
# 调整时区
ENV TZ=Asia/Shanghai
# 将当前目录下的jar包复制到docker容器的/目录下
ADD target/zdm_push-0.0.1-SNAPSHOT.jar /zdm_push-0.0.1-SNAPSHOT.jar
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/zdm_push-0.0.1-SNAPSHOT.jarr"]
