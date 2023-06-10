package freemarker;

import com.google.common.collect.Maps;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;

/**
 * @author xushichao
 * @date 2023/4/8 10:41
 * @desc
 */
@Service
@Slf4j
public class TestGenerator {

    @Autowired
    private DataMessageGenerator dataMessageGenerator;


    public String generateNextboxDisplayCode(NextboxDatasourceDisplay display, String templateName) {
        try {
            Template template = dataMessageGenerator.getTemplate(templateName);
            StringWriter writer = new StringWriter();
            HashMap<String, Object> root = Maps.newHashMap();
            root.put("view", display);
            template.process(root, writer);
            return writer.toString();
        } catch (Exception e) {
            log.error("NextboxDatasourceService generateNextboxDisplayCode", e);
            return "";
        }
    }


    public static void main(String[] args) {

    }


}
