package freemarker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xushichao
 * @date 2023/4/8 10:43
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NbDatasourceDisplay {
    private String inputClass;//入口类名称
    private String outputClass;//输出类名称
    private String datasourceName;//数据源名称
    private String singleDisplayExample;//单独调用示例
    private String batchDisplayExample;// 批量调用示例
}
