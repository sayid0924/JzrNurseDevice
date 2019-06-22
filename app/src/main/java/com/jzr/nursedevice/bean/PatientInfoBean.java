package com.jzr.nursedevice.bean;

import java.util.List;

public class PatientInfoBean {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 20
     * timestamp : 2019-04-13T08:32:24.499Z
     * data : [{"id":1,"code":"3000854","cureNo":"098170","name":"刘四媛","districtCode":"1","deptCode":"1303","sickroomCode":"1","bedCode":"L01","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"1988-10-25 00:00:00","age":"20","pcaCode":755,"address":"深圳市","mobile":"18126121170","education":"大学","duties":"工程师","idType":1,"idNumber":"123456678890","height":160.1,"weight":22.1,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-09-27 07:14:08","inDays":199,"outTime":null,"sort":0,"description":null,"diagnose":"诊断测试1","allergy":"过敏测试1","doctorCode":"1","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":null,"createBy":null,"updateTime":null,"updateBy":null,"bedName":"L01床","bedName2":null},{"id":2,"code":"3001913","cureNo":"098149","name":"骆宇轩","districtCode":"1","deptCode":"1303","sickroomCode":"1","bedCode":"L02","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-09 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中1","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-09-28 07:14:08","inDays":198,"outTime":null,"sort":0,"description":null,"diagnose":"诊断测试2","allergy":"过敏测试2","doctorCode":"2","doctorId":null,"doctorName":null,"nurseCode":"2","nurseId":null,"nurseName":null,"createTime":null,"createBy":null,"updateTime":null,"updateBy":null,"bedName":"L02床","bedName2":null},{"id":3,"code":"3002609","cureNo":"098282","name":"彭晓慧","districtCode":"1","deptCode":"1303","sickroomCode":"1","bedCode":"L03","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-10 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-09-29 07:14:08","inDays":197,"outTime":null,"sort":0,"description":"","diagnose":null,"allergy":null,"doctorCode":"3","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-02 11:41:00","createBy":null,"updateTime":"2018-11-02 11:41:08","updateBy":null,"bedName":"L03床","bedName2":null},{"id":4,"code":"3003266","cureNo":"098289","name":"叶觉英","districtCode":"1","deptCode":"1303","sickroomCode":"2","bedCode":"L04","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-10 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":null,"education":null,"duties":null,"idType":null,"idNumber":null,"height":null,"weight":null,"areaCode":null,"customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-09-30 07:14:08","inDays":196,"outTime":null,"sort":0,"description":null,"diagnose":null,"allergy":null,"doctorCode":"4","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":null,"createBy":null,"updateTime":null,"updateBy":null,"bedName":"L04床","bedName2":null},{"id":5,"code":"3003711","cureNo":"098243","name":"钟雯清","districtCode":"1","deptCode":"1303","sickroomCode":"2","bedCode":"L05","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-10 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-01 07:14:08","inDays":195,"outTime":null,"sort":0,"description":null,"diagnose":null,"allergy":null,"doctorCode":"5","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":null,"createBy":null,"updateTime":null,"updateBy":null,"bedName":"L05床","bedName2":null},{"id":6,"code":"3004031","cureNo":"098221","name":"高婵","districtCode":"1","deptCode":"1303","sickroomCode":"2","bedCode":"M1501","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-09 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-02 07:14:08","inDays":194,"outTime":null,"sort":0,"description":null,"diagnose":null,"allergy":null,"doctorCode":"6","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":null,"createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1501床","bedName2":null},{"id":7,"code":"3007063","cureNo":"098293","name":"周慧欢","districtCode":"1","deptCode":"1303","sickroomCode":"3","bedCode":"M1502","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-10 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-03 07:14:08","inDays":193,"outTime":null,"sort":0,"description":"","diagnose":null,"allergy":null,"doctorCode":"7","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-02 11:41:00","createBy":null,"updateTime":"2018-11-02 11:41:08","updateBy":null,"bedName":"M1502床","bedName2":null},{"id":8,"code":"3007933","cureNo":"098190","name":"文杏环","districtCode":"1","deptCode":"1303","sickroomCode":"3","bedCode":"M1503","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2017-10-10 00:00:00","age":"1岁 6月","pcaCode":755,"address":"深圳市","mobile":"123456252141","education":"高中","duties":"工人","idType":2,"idNumber":"388239840240923409242304","height":140,"weight":143,"areaCode":"0755","customInfusionRule":0,"runStatus":0,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-04 07:14:08","inDays":192,"outTime":null,"sort":0,"description":"","diagnose":null,"allergy":null,"doctorCode":"8","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-02 11:41:00","createBy":null,"updateTime":"2018-11-02 11:41:08","updateBy":null,"bedName":"M1503床","bedName2":null},{"id":9,"code":"3008097","cureNo":"098247","name":"何玉玲","districtCode":"1","deptCode":"1303","sickroomCode":"3","bedCode":"M1504","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589810","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745810","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-05 07:14:08","inDays":191,"outTime":null,"sort":10,"description":null,"diagnose":null,"allergy":null,"doctorCode":"9","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:21","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1504床","bedName2":null},{"id":10,"code":"3008244","cureNo":"098192","name":"李水珍","districtCode":"1","deptCode":"1303","sickroomCode":"4","bedCode":"M1505","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":0,"marriageText":"未婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589811","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745811","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-06 07:14:08","inDays":190,"outTime":null,"sort":11,"description":null,"diagnose":null,"allergy":null,"doctorCode":"10","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:22","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1505床","bedName2":null},{"id":11,"code":"3008610","cureNo":"098244","name":"黄秀芳","districtCode":"1","deptCode":"1303","sickroomCode":"4","bedCode":"M1506","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589812","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745812","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-07 07:14:08","inDays":189,"outTime":null,"sort":12,"description":null,"diagnose":null,"allergy":null,"doctorCode":"11","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:22","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1506床","bedName2":null},{"id":12,"code":"3009292","cureNo":"098134","name":"陈素巧","districtCode":"1","deptCode":"1303","sickroomCode":"4","bedCode":"M1507","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":0,"marriageText":"未婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589813","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745813","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-08 07:14:08","inDays":188,"outTime":null,"sort":13,"description":null,"diagnose":null,"allergy":null,"doctorCode":"12","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1507床","bedName2":null},{"id":13,"code":"3010161","cureNo":"097695","name":"朱君","districtCode":"1","deptCode":"1303","sickroomCode":"5","bedCode":"M1508","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":0,"marriageText":"未婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589814","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745814","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-09 07:14:08","inDays":187,"outTime":null,"sort":14,"description":null,"diagnose":null,"allergy":null,"doctorCode":"13","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1508床","bedName2":null},{"id":14,"code":"3011326","cureNo":"098246","name":"黄惠琼","districtCode":"1","deptCode":"1303","sickroomCode":"5","bedCode":"M1509","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589815","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745815","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-10 07:14:08","inDays":186,"outTime":null,"sort":15,"description":null,"diagnose":null,"allergy":null,"doctorCode":"14","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1509床","bedName2":null},{"id":15,"code":"3012450","cureNo":"098196","name":"张莉","districtCode":"1","deptCode":"1303","sickroomCode":"5","bedCode":"M1510","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589816","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745816","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-11 07:14:08","inDays":185,"outTime":null,"sort":16,"description":null,"diagnose":null,"allergy":null,"doctorCode":"15","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1510床","bedName2":null},{"id":16,"code":"3014265","cureNo":"098263","name":"刘洁丽","districtCode":"1","deptCode":"1303","sickroomCode":"6","bedCode":"M1511","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589817","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745817","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-12 07:14:08","inDays":184,"outTime":null,"sort":17,"description":null,"diagnose":null,"allergy":null,"doctorCode":"16","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1511床","bedName2":null},{"id":17,"code":"3020432","cureNo":"098295","name":"陈朝维","districtCode":"1","deptCode":"1303","sickroomCode":"6","bedCode":"M1512","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":0,"marriageText":"未婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589818","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745818","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-13 07:14:08","inDays":183,"outTime":null,"sort":18,"description":null,"diagnose":null,"allergy":null,"doctorCode":"17","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1512床","bedName2":null},{"id":18,"code":"3021811","cureNo":"098157","name":"陈金兰","districtCode":"1","deptCode":"1303","sickroomCode":"6","bedCode":"M1513","nurseLevelCode":"3","nurseLevelId":3,"nurseLevelName":"Ⅲ级护理","nurseLevelBgColor":"#009688","nurseLevelFontColor":"#FFF","outlayType":null,"sex":0,"sexText":"男","marriage":0,"marriageText":"未婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589819","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745819","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-14 07:14:08","inDays":182,"outTime":null,"sort":19,"description":null,"diagnose":null,"allergy":null,"doctorCode":"18","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1513床","bedName2":null},{"id":19,"code":"3021983","cureNo":"098276","name":"林明婷","districtCode":"1","deptCode":"1303","sickroomCode":"7","bedCode":"M1514","nurseLevelCode":"1","nurseLevelId":1,"nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589820","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745820","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-15 07:14:08","inDays":181,"outTime":null,"sort":20,"description":null,"diagnose":null,"allergy":null,"doctorCode":"19","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:23","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1514床","bedName2":null},{"id":20,"code":"3022231","cureNo":"097846","name":"孙俊芳","districtCode":"1","deptCode":"1303","sickroomCode":"7","bedCode":"M1515","nurseLevelCode":"2","nurseLevelId":2,"nurseLevelName":"Ⅱ级护理","nurseLevelBgColor":"#2eb827","nurseLevelFontColor":"#FFF","outlayType":null,"sex":1,"sexText":"女","marriage":1,"marriageText":"已婚","birthday":"2018-11-09 00:00:00","age":"6月","pcaCode":755,"address":"深圳市","mobile":"18214589821","education":"初中","duties":null,"idType":1,"idNumber":"425874589658745821","height":162,"weight":49.5,"areaCode":"0755","customInfusionRule":0,"runStatus":1,"beginTime":"2019-04-10 07:28:33","endTime":"2019-04-10 07:28:33","inTime":"2018-10-16 07:14:08","inDays":180,"outTime":null,"sort":21,"description":null,"diagnose":null,"allergy":null,"doctorCode":"20","doctorId":null,"doctorName":null,"nurseCode":null,"nurseId":null,"nurseName":null,"createTime":"2018-11-09 10:37:24","createBy":null,"updateTime":null,"updateBy":null,"bedName":"M1515床","bedName2":null}]
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
         * code : 3000854
         * cureNo : 098170
         * name : 刘四媛
         * districtCode : 1
         * deptCode : 1303
         * sickroomCode : 1
         * bedCode : L01
         * nurseLevelCode : 1
         * nurseLevelId : 1
         * nurseLevelName : Ⅰ级护理
         * nurseLevelBgColor : #ae0502
         * nurseLevelFontColor : #FFF
         * outlayType : null
         * sex : 1
         * sexText : 女
         * marriage : 1
         * marriageText : 已婚
         * birthday : 1988-10-25 00:00:00
         * age : 20
         * pcaCode : 755
         * address : 深圳市
         * mobile : 18126121170
         * education : 大学
         * duties : 工程师
         * idType : 1
         * idNumber : 123456678890
         * height : 160.1
         * weight : 22.1
         * areaCode : 0755
         * customInfusionRule : 0
         * runStatus : 1
         * beginTime : 2019-04-10 07:28:33
         * endTime : 2019-04-10 07:28:33
         * inTime : 2018-09-27 07:14:08
         * inDays : 199
         * outTime : null
         * sort : 0
         * description : null
         * diagnose : 诊断测试1
         * allergy : 过敏测试1
         * doctorCode : 1
         * doctorId : null
         * doctorName : null
         * nurseCode : null
         * nurseId : null
         * nurseName : null
         * createTime : null
         * createBy : null
         * updateTime : null
         * updateBy : null
         * bedName : L01床
         * bedName2 : null
         */

        private int id;
        private String code;
        private String cureNo;
        private String name;
        private String districtCode;
        private String deptCode;
        private String sickroomCode;
        private String bedCode;
        private String nurseLevelCode;
        private int nurseLevelId;
        private String nurseLevelName;
        private String nurseLevelBgColor;
        private String nurseLevelFontColor;
        private Object outlayType;
        private int sex;
        private String sexText;
        private int marriage;
        private String marriageText;
        private String birthday;
        private String age;
        private int pcaCode;
        private String address;
        private String mobile;
        private String education;
        private String duties;
        private int idType;
        private String idNumber;
        private double height;
        private double weight;
        private String areaCode;
        private int customInfusionRule;
        private int runStatus;
        private String beginTime;
        private String endTime;
        private String inTime;
        private int inDays;
        private Object outTime;
        private int sort;
        private Object description;
        private String diagnose;
        private String allergy;
        private String doctorCode;
        private Object doctorId;
        private String doctorName;
        private Object nurseCode;
        private Object nurseId;
        private Object nurseName;
        private Object createTime;
        private Object createBy;
        private Object updateTime;
        private Object updateBy;
        private String bedName;
        private Object bedName2;
        private String deviceIp;


        public String getDeviceIp() {
            return deviceIp;
        }

        public void setDeviceIp(String deviceIp) {
            this.deviceIp = deviceIp;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCureNo() {
            return cureNo;
        }

        public void setCureNo(String cureNo) {
            this.cureNo = cureNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDistrictCode() {
            return districtCode;
        }

        public void setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
        }

        public String getDeptCode() {
            return deptCode;
        }

        public void setDeptCode(String deptCode) {
            this.deptCode = deptCode;
        }

        public String getSickroomCode() {
            return sickroomCode;
        }

        public void setSickroomCode(String sickroomCode) {
            this.sickroomCode = sickroomCode;
        }

        public String getBedCode() {
            return bedCode;
        }

        public void setBedCode(String bedCode) {
            this.bedCode = bedCode;
        }

        public String getNurseLevelCode() {
            return nurseLevelCode;
        }

        public void setNurseLevelCode(String nurseLevelCode) {
            this.nurseLevelCode = nurseLevelCode;
        }

        public int getNurseLevelId() {
            return nurseLevelId;
        }

        public void setNurseLevelId(int nurseLevelId) {
            this.nurseLevelId = nurseLevelId;
        }

        public String getNurseLevelName() {
            return nurseLevelName;
        }

        public void setNurseLevelName(String nurseLevelName) {
            this.nurseLevelName = nurseLevelName;
        }

        public String getNurseLevelBgColor() {
            return nurseLevelBgColor;
        }

        public void setNurseLevelBgColor(String nurseLevelBgColor) {
            this.nurseLevelBgColor = nurseLevelBgColor;
        }

        public String getNurseLevelFontColor() {
            return nurseLevelFontColor;
        }

        public void setNurseLevelFontColor(String nurseLevelFontColor) {
            this.nurseLevelFontColor = nurseLevelFontColor;
        }

        public Object getOutlayType() {
            return outlayType;
        }

        public void setOutlayType(Object outlayType) {
            this.outlayType = outlayType;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSexText() {
            return sexText;
        }

        public void setSexText(String sexText) {
            this.sexText = sexText;
        }

        public int getMarriage() {
            return marriage;
        }

        public void setMarriage(int marriage) {
            this.marriage = marriage;
        }

        public String getMarriageText() {
            return marriageText;
        }

        public void setMarriageText(String marriageText) {
            this.marriageText = marriageText;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public int getPcaCode() {
            return pcaCode;
        }

        public void setPcaCode(int pcaCode) {
            this.pcaCode = pcaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEducation() {
            return education;
        }

        public void setEducation(String education) {
            this.education = education;
        }

        public String getDuties() {
            return duties;
        }

        public void setDuties(String duties) {
            this.duties = duties;
        }

        public int getIdType() {
            return idType;
        }

        public void setIdType(int idType) {
            this.idType = idType;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public int getCustomInfusionRule() {
            return customInfusionRule;
        }

        public void setCustomInfusionRule(int customInfusionRule) {
            this.customInfusionRule = customInfusionRule;
        }

        public int getRunStatus() {
            return runStatus;
        }

        public void setRunStatus(int runStatus) {
            this.runStatus = runStatus;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public int getInDays() {
            return inDays;
        }

        public void setInDays(int inDays) {
            this.inDays = inDays;
        }

        public Object getOutTime() {
            return outTime;
        }

        public void setOutTime(Object outTime) {
            this.outTime = outTime;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public String getDiagnose() {
            return diagnose;
        }

        public void setDiagnose(String diagnose) {
            this.diagnose = diagnose;
        }

        public String getAllergy() {
            return allergy;
        }

        public void setAllergy(String allergy) {
            this.allergy = allergy;
        }

        public String getDoctorCode() {
            return doctorCode;
        }

        public void setDoctorCode(String doctorCode) {
            this.doctorCode = doctorCode;
        }

        public Object getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(Object doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public Object getNurseCode() {
            return nurseCode;
        }

        public void setNurseCode(Object nurseCode) {
            this.nurseCode = nurseCode;
        }

        public Object getNurseId() {
            return nurseId;
        }

        public void setNurseId(Object nurseId) {
            this.nurseId = nurseId;
        }

        public Object getNurseName() {
            return nurseName;
        }

        public void setNurseName(Object nurseName) {
            this.nurseName = nurseName;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public String getBedName() {
            return bedName;
        }

        public void setBedName(String bedName) {
            this.bedName = bedName;
        }

        public Object getBedName2() {
            return bedName2;
        }

        public void setBedName2(Object bedName2) {
            this.bedName2 = bedName2;
        }
    }
}
