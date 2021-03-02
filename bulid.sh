#!/usr/bin/env bash

# 模块
project='psychology'
modules=('registry' 'gateway' 'centre' 'base')
ports=(8000 8010 8020 8030)
exposes=(8000 8010 8020 8030)
compileSkipTest=true

function echoln() {
    printf "%s\n" "$1"
}

function dockerBuild() {
    echoln "$1 $2 $3 $4"
    docker stop "$1"
    docker container rm "$1"
    docker image rm "$1"
    docker build -t "$2" .
    docker run -itd --name "$1" -p "$3":"$4" "$1"
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
        echo "module not found: $1"
        exit 1
    else
        echoln "模块名称: $applicationName"
        echoln "模块目录: ./$directory"
        echoln "系统端口: $port"
        echoln "暴露端口: $expose"
    fi

    echoln "开始编译"
    mvn clean package -Dmaven.test.skip=$compileSkipTest

    echoln "进入目录: $directory"
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
