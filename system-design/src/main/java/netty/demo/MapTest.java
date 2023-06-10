package netty.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushichao
 * @date 2023/1/17 15:45
 * @desc
 */
public class MapTest {

    static class FeatureBind {
        private  String  value;
        public FeatureBind(String val){
            this.value = val;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    static class  FeatureBindCollection {
        private FeatureBind bind;
        private FeatureBind unbind;

        public FeatureBindCollection(FeatureBind bind, FeatureBind unbind) {
            this.bind = bind;
            this.unbind = unbind;
        }

        public FeatureBind getBind() {
            return bind;
        }

        public void setBind(FeatureBind bind) {
            this.bind = bind;
        }

        public FeatureBind getUnbind() {
            return unbind;
        }

        public void setUnbind(FeatureBind unbind) {
            this.unbind = unbind;
        }

        public void merge(FeatureBindCollection other) {
            this.bind.setValue(other.getBind().getValue());
            this.unbind.setValue(other.getUnbind().getValue());

        }
    }

    public static void main(String[] args) {
        Map<String, FeatureBind> map = new HashMap<>();
        map.put("t1", new FeatureBind("xsc"));
        map.put("t2", new FeatureBind("hel"));

        FeatureBind t1 = map.get("t1");
        FeatureBind t2 = map.get("t2");



        FeatureBind bind1 = new FeatureBind("new1");
        FeatureBind unbind1 = new FeatureBind("unNew1");
        FeatureBindCollection other = new FeatureBindCollection(bind1, unbind1);


        FeatureBindCollection collection = new FeatureBindCollection(t1, t2);
        collection.merge(other);

        System.out.println(map);


    }
}
