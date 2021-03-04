#!/usr/bin/env bash

# 模块
project='psychology'
modules=('registry' 'gateway' 'centre' 'base')
ports=(8000 8010 8020 8030)
exposes=(8000 8010 8020 8030)
compileSkipTest=true

function echoln() {
    echo -e "$1\n"
}

function echolnsp() {
    echo -e "\n$1"
}

function dockerBuild() {
    echolnsp "stop $1"
    docker stop "$1"
    echolnsp "remove container $1"
    docker container rm "$1"
    echolnsp "remove image $1"
    docker image rm "$1"
    echolnsp "build image $2"
    docker build -t "$2" .
    echolnsp "run $2, expose port $4, port $3"
    docker run -itd --name "$2" -p "$3":"$4" "$2"
}

function build() {
    applicationName="${project}-$1"
    directory="$1"
    port=0
    expose=0

    for ((i = 0; i < ${#modules[*]}; i++)); do
        if [ "$1" = "${modules[$i]}" ]; then
            port=${ports[$i]}
            expose=${exposes[$i]}
        fi
    done

    if [ $((expose)) -eq 0 ]; then
        echoln "module not found: $1"
        exit 1
    else
        echo "模块名称: $applicationName"
        echo "模块目录: ./$directory"
        echo "系统端口: $port"
        echo "暴露端口: $expose"
    fi

    echolnsp "拉取最新"
    git pull

    echosp "开始编译, 跳过测试: $compileSkipTest"
    mvn clean package -Dmaven.test.skip=$compileSkipTest

    echosp "进入目录: $directory"
    cd "$directory" || exit 1

    jar_path="./target/${applicationName}.jar"

    if [ -e "$jar_path" ]; then
        cp "$jar_path" "./${applicationName}.jar"
        dockerBuild "$applicationName" "$applicationName" "$port" "$expose"
    else
        echo "file not found: $jar_path"
    fi
}

function help() {
    echo "-l list modules."
    echoln "-b <module> build module."
}

# main
if [ -n "$1" ]; then
    case "$1" in
    -l)
        echoln "${modules[*]}"
        ;;
    -b)
        if [ -n "$2" ]; then
            build "$2"
        else
            echoln "-b <module name>"
        fi
        ;;
    esac
else
    help
fi
