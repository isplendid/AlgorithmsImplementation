
/***
* 获取特征过滤标签信息
**/
struct FetchFilter {
   1:  required string name;
   2:  required list<string> values;
}

/***
* 时序过滤标签，时间间隔
**/
struct FetchGap{
   1: optional i16 fromIndex; //当前时序向前的偏移,负数代表当前时间点向前，正数代表当前时间点向后，小于toIndex
   2: optional i16 toIndex;  //当前时序向后的偏移,负数代表当前时间点向前，正数代表当前时间点向后，大于fromIndex
}

struct FetchOption {

   1: optional FetchGap fetchGap; //时序过滤标签, 与fetchFilter只能存在一个;FetchGap和fetchFilter不能共存
   2: optional FetchFilter fetchFilter; //key value类型的过滤标签, 与fetchGap只能存在一个
}

/***
* 同一维度的特征参数
**/
struct DimensionInputV2 {
   1: required String algoName;
   2: optional list<string> algoVersions;
   3: required string dimensionType;
   4: required string dimensionValues;
   5: required list<string> featureNames;
   6: optional binary fetchMatrixBinary; //deprecated = "未使用",
   7: optional list<list<bool>> fetchMatrix; //特征是否需要获取标示, true 表示获取当前特征，false 表示不获取
   8: optional list<FetchOption> fetchOptions;
   9: optional list<list<i16>> fetchOptionMatrix; //过滤标签序号, fetchOption对应的序号
}

/***
* 特征结果
**/
struct FeatureValueV2 {
   1: optional string value; //特征值
   2: optional byte valueType; //特征值类型 (特征平台支持的特征值类型)
   3: optional byte flag; //单个值/多个值标示, 0. 单个值；1. 一维数组 version == 1 有效
   4: optional binary encodedValue; //序列化后的特征值, version == 1 有效

}

/***
* 同维度请求信息对应的返回结果
**/
struct DimensionOutputV2 {
  1: required list<list<FeatureValueV2>> values;//特征值结果
}

/**
* 获取离线特征参数
**/
struct FetchOfflineFeatureParamsV2 {
   1: required list<DimensionInputV2> dimensionInputs;  //按维度区分，获取离线特征参数
   2: optional i32 version;  //特征获取的版本信息, 1表示最初版本，2表示支持过滤标签版本
}
/***
* 离线特征返回结果
**/
struct FetchOfflineFeatureResultV2 {
   1: required bool success; //是否成功获取，true成功，false失败
   2: optional string message; //结果描述信息
   3: required list<DimensionOutputV2> values; //返回的特征组结果
}

/***
* 按业务线获取特征，按维度区分的输入信息
**/
struct PDLDimensionInput {
    1: required string dimensionType; //维度类型，算法平台支持的维度类型
    2: required list<string> dimensionValues; //维度值
    3: required list<string> featureNames; //特征名称
    8: optional list<FetchOption> fetchOptions;
    9: optional list<list<i16>> fetchOptionMatrix; //过滤标签的序号,fetchOptions list中对应的序号
}

/***
* 按业务线获取特征的输入参数
**/
struct PDLFeatureParam {
  1: required string pdl;
  2: required list<PDLDimensionInput> dimensionInputs; //各维度特征的输入信息
}

/***
* 需要查询特征所在特征组的特征参数
**/
struct QueryFeatureGroupParam {
  1: required list<string> featureNames; //需要查询特征所在特征组的特征列表
}

/**
* 特征与特征所在的特征组的对应关系
**/
struct QueryFeatureGroupResult {
  1: required map<string, list<string>> featureInGroups; //特征与特征所在的特征组的对应关系，特征可能在多个特征组中
}