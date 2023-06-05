#!/usr/bin/env bash

PROTOC=protoc

INSTALLED_PROTOC_PATH=`which protoc`
echo 'director: '$INSTALLED_PROTOC_PATH

if [[ -z $INSTALLED_PROTOC_PATH ]] || [[ ! -f "$PROTOBUF_INCLUDE/google/protobuf/descriptor.proto" ]]
then

    #PROTOBUF_DOWNLOAD_ZIP="protoc-3.9.1-osx-x86_64.zip"
    PROTOBUF_DOWNLOAD_ZIP="protobuf-2.6.1-osx-x86_64.zip"
    echo "本机未安装protobuf的编译工具，将自动下载X默认的${PROTOBUF_DOWNLOAD_ZIP}编译工具……"

    PROTOBUF_HOME="/tmp/tr/protobuf"
    PROTOBUF_C_FILE="$PROTOBUF_HOME/bin/protoc"
    PROTOBUF_IMPORT_FILE="$PROTOBUF_HOME/include/google/protobuf/descriptor.proto"

    if [[ -f $PROTOBUF_C_FILE ]] && [[ -f $PROTOBUF_IMPORT_FILE ]]
    then
        echo "本机已经下载了X默认的protobuf-2.6.1编译工具，将直接使用已下载的${PROTOBUF_C_FILE}进行编译……"
    else

        echo "将创建编译工具目录：$PROTOBUF_HOME"
        mkdir -p $PROTOBUF_HOME

        rm -f $PROTOBUF_C_FILE $PROTOBUF_IMPORT_FILE

        ## https://tr/command/protobuf-2.6.1-osx-x86_64.zip
        ## https:///tr/command/$PROTOBUF_DOWNLOAD_ZIP

        curl "https://tr/command/$PROTOBUF_DOWNLOAD_ZIP" -o "$PROTOBUF_HOME/$PROTOBUF_DOWNLOAD_ZIP"

        ls -l $PROTOBUF_HOME

        unzip "$PROTOBUF_HOME/$PROTOBUF_DOWNLOAD_ZIP" -d $PROTOBUF_HOME

        ls -l $PROTOBUF_HOME

        [ ! -f $PROTOBUF_C_FILE ]     && echo "ERROR：初始化PB编译工具失败，${PROTOBUF_C_FILE}文件不存在！！！"      && exit 1
        [ ! -f $PROTOBUF_IMPORT_FILE ] && echo "ERROR：初始化PB编译工具失败，${PROTOBUF_IMPORT_FILE}文件不存在！！！" && exit 1



    fi
    export PROTOBUF_INCLUDE=$PROTOBUF_HOME/include
    export PROTOC=$PROTOBUF_C_FILE
else
    echo "将使用本机安装好的PB编译工具${INSTALLED_PROTOC_PATH}，引用目录为：${PROTOBUF_INCLUDE} \n"
fi

CURDIR=`pwd`

OUTPUT_DIR="$CURDIR/src/main/java/"

echo "生成的源代码将放到：$OUTPUT_DIR \n"

[ ! -f "$PROTOBUF_INCLUDE/google/protobuf/descriptor.proto" ] && echo "ERROR：环境变量PROTOBUF_INCLUDE配置不正确，目录${PROTOBUF_INCLUDE}不是正确的PB-Include目录！！！" && exit 1

TR_COMMON_PATH="$CURDIR/../../banma_TR_client/protobuf"
IMPORT_PATH="$PROTOBUF_INCLUDE:$TR_COMMON_PATH"


########################################不要动以上的代码######################################################################################

cd $CURDIR

echo `pwd`


protoc -I=./protobuf -I=$PROTOBUF_INCLUDE --java_out=$OUTPUT_DIR protobuf/teacher.proto




