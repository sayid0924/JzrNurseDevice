package com.jzr.nursedevice.bean;

import java.util.List;

public class CheckDeptBean {


    /**
     * code : 0
     * message : 查询数据成功
     * timestamp : 2019-03-26T09:34:55.230Z
     * data : [{"id":1,"name":"妇科","simpleName":"外科分诊台","description":null},{"id":2,"name":"妇科分诊台","simpleName":"妇科分诊台","description":null},{"id":3,"name":"口腔科","simpleName":"口腔科","description":null},{"id":4,"name":"风湿科门诊","simpleName":"风湿科门诊","description":null},{"id":5,"name":"科教科","simpleName":"科教科","description":null},{"id":6,"name":"肺功能室","simpleName":"肺功能室","description":null},{"id":7,"name":"骨科门诊","simpleName":"骨科门诊","description":null},{"id":8,"name":"手术室","simpleName":"手术室","description":null},{"id":9,"name":"康复科门诊","simpleName":"康复科门诊","description":null},{"id":10,"name":"康复科","simpleName":"康复科","description":null},{"id":11,"name":"综合医疗中心","simpleName":"综合医疗中心","description":null},{"id":12,"name":"介入神经放射科（","simpleName":"介入神经放射科（","description":null},{"id":13,"name":"检验科","simpleName":"检验科","description":null},{"id":14,"name":"脊髓神经外科门诊","simpleName":"脊髓神经外科门诊","description":null},{"id":15,"name":"脊髓神经外科","simpleName":"脊髓神经外科","description":null},{"id":16,"name":"静脉配置中心","simpleName":"静脉配置中心","description":null},{"id":17,"name":"感染科门诊","simpleName":"感染科门诊","description":null},{"id":18,"name":"感染科","simpleName":"感染科","description":null},{"id":19,"name":"杂交手术室","simpleName":"杂交手术室","description":null},{"id":20,"name":"肌电图","simpleName":"肌电图","description":null},{"id":21,"name":"会计与财务","simpleName":"会计与财务","description":null},{"id":22,"name":"护理中心","simpleName":"护理中心","description":null},{"id":23,"name":"肝胆外科","simpleName":"肝胆外科","description":null},{"id":24,"name":"肝胆外科门诊","simpleName":"肝胆外科门诊","description":null},{"id":25,"name":"创伤外科","simpleName":"创伤外科","description":null},{"id":26,"name":"感染控制科","simpleName":"感染控制科","description":null},{"id":27,"name":"护理部","simpleName":"护理部","description":null},{"id":28,"name":"妇产科","simpleName":"妇产科","description":null},{"id":29,"name":"妇科门诊","simpleName":"妇科门诊","description":null},{"id":30,"name":"产科","simpleName":"产科","description":null},{"id":31,"name":"产科门诊","simpleName":"产科门诊","description":null},{"id":32,"name":"儿科(大)","simpleName":"儿科(大)","description":null},{"id":33,"name":"儿科门诊","simpleName":"儿科门诊","description":null},{"id":34,"name":"呼吸内科门诊","simpleName":"呼吸内科门诊","description":null},{"id":35,"name":"作业疗法","simpleName":"作业疗法","description":null},{"id":36,"name":"呼吸内科","simpleName":"呼吸内科","description":null},{"id":37,"name":"急诊收费处","simpleName":"急诊收费处","description":null},{"id":38,"name":"急诊科门诊","simpleName":"急诊科门诊","description":null},{"id":39,"name":"骨科","simpleName":"骨科","description":null},{"id":40,"name":"功能神经外科门诊","simpleName":"功能神经外科门诊","description":null},{"id":41,"name":"功能神经外科","simpleName":"功能神经外科","description":null},{"id":42,"name":"采购与库存科","simpleName":"采购与库存科","description":null},{"id":43,"name":"风湿科","simpleName":"风湿科","description":null},{"id":44,"name":"放射科","simpleName":"放射科","description":null},{"id":45,"name":"创伤外科门诊","simpleName":"创伤外科门诊","description":null},{"id":46,"name":"超声科","simpleName":"超声科","description":null},{"id":47,"name":"神经外科住院","simpleName":"神经外科住院","description":null},{"id":48,"name":"综合部","simpleName":"综合部","description":null},{"id":49,"name":"财务部","simpleName":"财务部","description":null},{"id":50,"name":"病理科","simpleName":"病理科","description":null},{"id":51,"name":"MRI","simpleName":"MRI","description":null},{"id":52,"name":"CT","simpleName":"CT","description":null},{"id":53,"name":"神经外科门诊","simpleName":"神经外科门诊","description":null},{"id":54,"name":"心血管内科门诊","simpleName":"心血管内科门诊","description":null},{"id":55,"name":"药房","simpleName":"药房","description":null},{"id":56,"name":"药库","simpleName":"药库","description":null},{"id":57,"name":"中药库","simpleName":"中药库","description":null},{"id":58,"name":"药剂科","simpleName":"药剂科","description":null},{"id":59,"name":"中成药库","simpleName":"中成药库","description":null},{"id":60,"name":"急诊药房","simpleName":"急诊药房","description":null},{"id":61,"name":"住院收费处","simpleName":"住院收费处","description":null},{"id":62,"name":"中医科门诊","simpleName":"中医科门诊","description":null},{"id":63,"name":"中医科","simpleName":"中医科","description":null},{"id":64,"name":"麻精库","simpleName":"麻精库","description":null},{"id":65,"name":"住院药房","simpleName":"住院药房","description":null},{"id":66,"name":"门诊药房","simpleName":"门诊药房","description":null},{"id":67,"name":"质量控制与投诉管","simpleName":"质量控制与投诉管","description":null},{"id":68,"name":"中药房","simpleName":"中药房","description":null},{"id":69,"name":"运营办公室","simpleName":"运营办公室","description":null},{"id":70,"name":"运动疗法","simpleName":"运动疗法","description":null},{"id":71,"name":"院办","simpleName":"院办","description":null},{"id":72,"name":"医院管理团队","simpleName":"医院管理团队","description":null},{"id":73,"name":"医务科","simpleName":"医务科","description":null},{"id":74,"name":"医疗部办公室","simpleName":"医疗部办公室","description":null},{"id":75,"name":"神经眼科病区","simpleName":"神经眼科病区","description":null},{"id":76,"name":"医疗部","simpleName":"医疗部","description":null},{"id":77,"name":"医保物价","simpleName":"医保物价","description":null},{"id":78,"name":"急诊科分诊台","simpleName":"急诊科分诊台","description":null},{"id":79,"name":"眼科门诊","simpleName":"眼科门诊","description":null},{"id":80,"name":"言语疗法","simpleName":"言语疗法","description":null},{"id":81,"name":"血液科门诊","simpleName":"血液科门诊","description":null},{"id":82,"name":"血液科","simpleName":"血液科","description":null},{"id":83,"name":"胸外科门诊","simpleName":"胸外科门诊","description":null},{"id":84,"name":"胸外科","simpleName":"胸外科","description":null},{"id":85,"name":"行政支持科","simpleName":"行政支持科","description":null},{"id":86,"name":"信息资讯科","simpleName":"信息资讯科","description":null},{"id":87,"name":"挂号与收费","simpleName":"挂号与收费","description":null},{"id":88,"name":"新生儿重症科门诊","simpleName":"新生儿重症科门诊","description":null},{"id":89,"name":"神经外科病区","simpleName":"神经外科病区","description":null},{"id":90,"name":"呼吸科分诊台","simpleName":"呼吸科分诊台","description":null},{"id":91,"name":"神经康复科分诊台","simpleName":"神经康复科分诊台","description":null},{"id":92,"name":"神经外科分诊台","simpleName":"神经外科分诊台","description":null},{"id":93,"name":"综合性康复科门诊","simpleName":"综合性康复科门诊","description":null},{"id":94,"name":"运动疗法科门诊","simpleName":"运动疗法科门诊","description":null},{"id":95,"name":"职业疗法科门诊","simpleName":"职业疗法科门诊","description":null},{"id":96,"name":"理疗科门诊","simpleName":"理疗科门诊","description":null},{"id":97,"name":"麻醉科药房","simpleName":"麻醉科药房","description":null},{"id":98,"name":"儿科药房","simpleName":"儿科药房","description":null},{"id":99,"name":"神经放射科门诊","simpleName":"神经放射科门诊","description":null},{"id":100,"name":"神经病理科门诊","simpleName":"神经病理科门诊","description":null},{"id":101,"name":"信息资讯部","simpleName":"信息资讯部","description":null},{"id":102,"name":"眼科分诊台","simpleName":"眼科分诊台","description":null},{"id":103,"name":"心血管科分诊台","simpleName":"心血管科分诊台","description":null},{"id":104,"name":"神经内科分诊台","simpleName":"神经内科分诊台","description":null},{"id":105,"name":"内科分诊台","simpleName":"内科分诊台","description":null},{"id":106,"name":"血液内科分诊台","simpleName":"血液内科分诊台","description":null},{"id":107,"name":"肿瘤科分诊台","simpleName":"肿瘤科分诊台","description":null},{"id":108,"name":"消化内科分诊台","simpleName":"消化内科分诊台","description":null},{"id":109,"name":"骨科分诊台","simpleName":"骨科分诊台","description":null},{"id":110,"name":"妇产科分诊台","simpleName":"妇产科分诊台","description":null},{"id":111,"name":"儿科分诊台","simpleName":"儿科分诊台","description":null},{"id":112,"name":"耳鼻喉科分诊台","simpleName":"耳鼻喉科分诊台","description":null},{"id":113,"name":"感染科分诊台","simpleName":"感染科分诊台","description":null},{"id":114,"name":"口腔科分诊台","simpleName":"口腔科分诊台","description":null},{"id":115,"name":"妇科病区","simpleName":"妇科病区","description":null},{"id":116,"name":"外科病区","simpleName":"外科病区","description":null},{"id":117,"name":"普通外科门诊","simpleName":"普通外科门诊","description":null},{"id":118,"name":"新生儿重症科","simpleName":"新生儿重症科","description":null},{"id":119,"name":"内科病区","simpleName":"内科病区","description":null},{"id":120,"name":"新生儿科门诊","simpleName":"新生儿科门诊","description":null},{"id":121,"name":"新生儿科","simpleName":"新生儿科","description":null},{"id":122,"name":"儿科病区","simpleName":"儿科病区","description":null},{"id":123,"name":"心血管内科","simpleName":"心血管内科","description":null},{"id":124,"name":"心电图","simpleName":"心电图","description":null},{"id":125,"name":"小儿神经外科门诊","simpleName":"小儿神经外科门诊","description":null},{"id":126,"name":"小儿神经外科","simpleName":"小儿神经外科","description":null},{"id":127,"name":"消化内科门诊","simpleName":"消化内科门诊","description":null},{"id":128,"name":"胃肠科","simpleName":"胃肠科","description":null},{"id":129,"name":"眼科病区","simpleName":"眼科病区","description":null},{"id":130,"name":"物理疗法","simpleName":"物理疗法","description":null},{"id":131,"name":"外周神经外科门诊","simpleName":"外周神经外科门诊","description":null},{"id":132,"name":"外周神经外科","simpleName":"外周神经外科","description":null},{"id":133,"name":"外科门诊","simpleName":"外科门诊","description":null},{"id":134,"name":"耳鼻咽喉科病区","simpleName":"耳鼻咽喉科病区","description":null},{"id":135,"name":"体检科","simpleName":"体检科","description":null},{"id":136,"name":"疼痛科门诊","simpleName":"疼痛科门诊","description":null},{"id":137,"name":"疼痛科","simpleName":"疼痛科","description":null},{"id":138,"name":"输血科","simpleName":"输血科","description":null},{"id":139,"name":"手术室麻醉科","simpleName":"手术室麻醉科","description":null},{"id":140,"name":"肾内科门诊","simpleName":"肾内科门诊","description":null},{"id":141,"name":"肾内科","simpleName":"肾内科","description":null},{"id":142,"name":"神经专科中心","simpleName":"神经专科中心","description":null},{"id":143,"name":"神经重症科门诊","simpleName":"神经重症科门诊","description":null},{"id":144,"name":"神经重症科","simpleName":"神经重症科","description":null},{"id":145,"name":"神经肿瘤科门诊","simpleName":"神经肿瘤科门诊","description":null},{"id":146,"name":"神经肿瘤科","simpleName":"神经肿瘤科","description":null},{"id":147,"name":"神经影像科","simpleName":"神经影像科","description":null},{"id":148,"name":"神经眼科住院","simpleName":"神经眼科住院","description":null},{"id":149,"name":"神经眼科门诊","simpleName":"神经眼科门诊","description":null},{"id":150,"name":"神经眼科","simpleName":"神经眼科","description":null},{"id":151,"name":"神经血管外科门诊","simpleName":"神经血管外科门诊","description":null},{"id":152,"name":"神经血管外科","simpleName":"神经血管外科","description":null},{"id":153,"name":"神经外科（大）","simpleName":"神经外科（大）","description":null},{"id":154,"name":"神经外科","simpleName":"神经外科","description":null},{"id":155,"name":"神经生理科门诊","simpleName":"神经生理科门诊","description":null},{"id":156,"name":"神经生理科","simpleName":"神经生理科","description":null},{"id":157,"name":"神经内科门诊","simpleName":"神经内科门诊","description":null},{"id":158,"name":"神经内科（大）","simpleName":"神经内科（大）","description":null},{"id":159,"name":"神经内科","simpleName":"神经内科","description":null},{"id":160,"name":"神经内分泌科门诊","simpleName":"神经内分泌科门诊","description":null},{"id":161,"name":"神经内分泌科","simpleName":"神经内分泌科","description":null},{"id":162,"name":"神经康复科门诊","simpleName":"神经康复科门诊","description":null},{"id":163,"name":"神经康复科","simpleName":"神经康复科","description":null},{"id":164,"name":"神经病理科","simpleName":"神经病理科","description":null},{"id":165,"name":"设施管理科","simpleName":"设施管理科","description":null},{"id":166,"name":"人力资源科","simpleName":"人力资源科","description":null},{"id":167,"name":"普通外科","simpleName":"普通外科","description":null},{"id":168,"name":"皮肤病与性病科门诊","simpleName":"皮肤病与性病科门诊","description":null},{"id":169,"name":"皮肤病与性病科","simpleName":"皮肤病与性病科","description":null},{"id":170,"name":"脑电图","simpleName":"脑电图","description":null},{"id":171,"name":"内科门诊","simpleName":"内科门诊","description":null},{"id":172,"name":"内镜中心","simpleName":"内镜中心","description":null},{"id":173,"name":"内分泌科门诊","simpleName":"内分泌科门诊","description":null},{"id":174,"name":"内分泌科","simpleName":"内分泌科","description":null},{"id":175,"name":"泌尿外科门诊","simpleName":"泌尿外科门诊","description":null},{"id":176,"name":"泌尿外科","simpleName":"泌尿外科","description":null},{"id":177,"name":"门诊收费处","simpleName":"门诊收费处","description":null},{"id":178,"name":"门诊部","simpleName":"门诊部","description":null},{"id":179,"name":"劳务派遣","simpleName":"劳务派遣","description":null},{"id":180,"name":"口腔正畸门诊","simpleName":"口腔正畸门诊","description":null},{"id":181,"name":"口腔正畸","simpleName":"口腔正畸","description":null},{"id":182,"name":"口腔内科门诊","simpleName":"口腔内科门诊","description":null},{"id":183,"name":"口腔内科","simpleName":"口腔内科","description":null},{"id":184,"name":"基本体检套餐男","simpleName":"基本体检套餐男","description":null},{"id":185,"name":"A套餐男(30-35岁)","simpleName":"A套餐男(30-35岁)","description":null},{"id":186,"name":"A套餐女(30-35岁)","simpleName":"A套餐女(30-35岁)","description":null},{"id":187,"name":"B套餐男(35-45岁)","simpleName":"B套餐男(35-45岁)","description":null},{"id":188,"name":"B套餐女(35-45岁)","simpleName":"B套餐女(35-45岁)","description":null},{"id":189,"name":"C套餐男(45-55岁)","simpleName":"C套餐男(45-55岁)","description":null},{"id":190,"name":"C套餐女(45-55岁)","simpleName":"C套餐女(45-55岁)","description":null},{"id":191,"name":"D套餐男(55-65岁)","simpleName":"D套餐男(55-65岁)","description":null},{"id":192,"name":"D套餐女(55-65岁)","simpleName":"D套餐女(55-65岁)","description":null},{"id":193,"name":"E套餐男(65岁以上)","simpleName":"E套餐男(65岁以上)","description":null},{"id":194,"name":"E套餐女(65岁以上)","simpleName":"E套餐女(65岁以上)","description":null},{"id":195,"name":"基本体检套餐女","simpleName":"基本体检套餐女","description":null},{"id":196,"name":"中医科分诊台","simpleName":"中医科分诊台","description":null},{"id":197,"name":"普工健康证体检套餐","simpleName":"普工健康证体检套餐","description":null},{"id":198,"name":"消毒供应室","simpleName":"消毒供应室","description":null},{"id":199,"name":"病案科","simpleName":"病案科","description":null},{"id":200,"name":"儿科住院","simpleName":"儿科住院","description":null},{"id":201,"name":"运营部","simpleName":"运营部","description":null},{"id":202,"name":"耳鼻咽喉科","simpleName":"耳鼻咽喉科","description":null},{"id":203,"name":"预防保健科","simpleName":"预防保健科","description":null},{"id":204,"name":"内科","simpleName":"内科","description":null},{"id":205,"name":"内科住院","simpleName":"内科住院","description":null},{"id":206,"name":"妇科1","simpleName":"妇科","description":null},{"id":207,"name":"眼科住院","simpleName":"眼科住院","description":null},{"id":208,"name":"外科","simpleName":"外科","description":null},{"id":209,"name":"外科住院","simpleName":"外科住院","description":null},{"id":210,"name":"儿科","simpleName":"儿科","description":null},{"id":211,"name":"耳鼻咽喉科住院","simpleName":"耳鼻咽喉科住院","description":null},{"id":212,"name":"眼科","simpleName":"眼科","description":null},{"id":213,"name":"急诊科","simpleName":"急诊科","description":null},{"id":214,"name":"妇科住院","simpleName":"妇科住院","description":null},{"id":215,"name":"综合处置区","simpleName":"综合处置区","description":null},{"id":216,"name":"耳鼻喉科门诊","simpleName":"耳鼻喉科门诊","description":null}]
     */

    private int code;
    private String message;
    private String timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 妇科
         * simpleName : 外科分诊台
         * description : null
         */

        private int id;
        private String name;
        private String simpleName;
        private Object description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSimpleName() {
            return simpleName;
        }

        public void setSimpleName(String simpleName) {
            this.simpleName = simpleName;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }
    }
}
