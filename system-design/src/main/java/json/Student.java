package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xushichao
 * @date 2022/9/7 10:22
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String className;

    public JSONObject getObject(){
        return (JSONObject) JSON.toJSON(this);
    }
}
