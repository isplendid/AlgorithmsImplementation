package com.xu.basic.reflection;

import com.xu.basic.reflection.annotation.AlgorModelEndPoint;
import com.xu.basic.reflection.annotation.AlgorithmVersion;

/**
 * @author xushichao
 * @date 2022/2/9 2:13 PM
 * @desc
 */
@AlgorithmVersion(key = "test.fast.V0_0")

public class AlgorDemo {

    @AlgorModelEndPoint(
            modelKey = "${algorithm.model.preprocess.testv1}",  //通过算法参数 algorithm.model.testmodel1 来控制执行那个模型
            batchSize = 20, // 如果批量执行，每一批最多20个
            ordinal = 1, // 执行顺序，越小的执行顺序越靠前，如果ordinal相等，则比较modelKey（已经转换后的modelKey，不是${algorithm.model.xxx}变量）大小，modelKey越小越先执行；
            lazyExecution = false,  // 是否懒加载执行
            inputClass = CommonModelInput.class,
            outputClass = CommonModelOutput.class
    )
    ModelOnceCaller<CommonModelInput, CommonModelOutput> modelOnceCaller;

}
