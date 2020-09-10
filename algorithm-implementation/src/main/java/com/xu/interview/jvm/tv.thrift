/*
*如果thrift有嵌套，最外层的struct放在最下面.
*/
namespace java com.xiaomi.data.spec.platform.tv

struct TvAppUsageRussia {
    1: optional string deviceId;
    2: optional i32 platform;
    3: optional string appName;
    //4: optional string package;
    5: optional i32 appTs;
}