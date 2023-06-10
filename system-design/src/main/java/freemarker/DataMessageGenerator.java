package freemarker;

import com.google.common.collect.Maps;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author xushichao
 * @date 2023/4/8 10:36
 * @desc
 */
@Service
public class DataMessageGenerator implements ApplicationContextAware {

    private Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
    private ApplicationContext applicationContext;

    public DataMessageGenerator() {
        configuration.setClassForTemplateLoading(this.getClass(), "/template");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public Template getTemplate(String templateName) throws IOException {
        return configuration.getTemplate(templateName,"utf-8");
    }


//    public String generateMessage(String templateName, String fillableBeanName, Map<String,Object> contextMap, Object[]
//            params)
//            throws
//            IOException,
//            TemplateException {
//        DataMapFillable bean = applicationContext.getBean(fillableBeanName, DataMapFillable.class);
//        return generateMessage(templateName, bean, contextMap, params);
//    }
//
//
//    public String generateMessage(String templateName, DataMapFillable fillable, Map<String,Object> contextMap, Object[]
//            params)
//            throws
//            IOException,
//            TemplateException {
//        Map<String, Object> dataMap = initDataMap(contextMap);
//        fillable.fillDataMap(dataMap, params);
//        return composeMessage(templateName, dataMap);
//    }
//
//    private Map<String,Object> initDataMap(Map<String,Object> contextMap){
//        Map<String,Object> dataMap =  Maps.newHashMap();
//        // 填写运行时map信息
//        return dataMap;
//    }
//    private String composeMessage(String templateName, Map<String,Object> dataMap) throws IOException,
//            TemplateException {
//        StringWriter writer = new StringWriter();
//        Template template = configuration.getTemplate(templateName,"utf-8");
//        template.process(dataMap, writer);
//        return writer.toString();
//    }

    public String genMsgFromString(String templateContent, Map<String,Object> dataMap) throws IOException,
            TemplateException {
        StringWriter result = new StringWriter();
        Template t = new Template("tempTemplate", new StringReader(templateContent), configuration);
        t.process(dataMap, result);
        return result.toString();
    }




}
