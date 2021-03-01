#!/usr/bin/env bash

# docker 暴露端口
expose_port=8010

# 系统对应端口
application_port=8010

# 应用名称
application_name=psychology-gateway

# jar 包路径
jar_path=./target/${application_name}.jar

function build() {
  # 停止旧的服务
  echo -e '停止旧的服务\n'
  docker stop ${application_name}

  # 删除旧容器
  echo -e '删除旧容器\n'
  docker container rm ${application_name}

  # 删除旧镜像
  echo -e '删除旧镜像\n'
  docker image rm ${application_name}

  # 构建新镜像
  echo -e '构建新镜像\n'
  docker build -t ${application_name} .

  # 运行新服务
  echo -e '运行新服务\n'
  docker run -itd --name ${application_name} -p ${application_port}:${expose_port} ${application_name}
}


# 编译打包
echo -e "application_name: ${application_name}\nexpose_port: ${expose_port}\napplication_port: ${application_port}\njar_path: ${jar_path}\n"
echo -e '编译打包\n'
mvn clean package -Dmaven.test.skip=true

if [ -e ${jar_path} ]; then
  # 拷贝到根目录
  cp ${jar_path} ./${application_name}.jar
  # 构建
  build && echo '完成'
else
  echo 'mvn 编译打包失败'
fi

unset jar_path
unset expose_port
unset application_port