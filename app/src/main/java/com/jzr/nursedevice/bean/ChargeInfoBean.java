package com.jzr.nursedevice.bean;

public class ChargeInfoBean {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 0
     * timestamp : 2019-05-07T02:34:16.835Z
     * data : {"id":1,"patientCode":"3000166","patientCureNo":"099665","allCharge":266.2,"chargeDays":null,"balence":-133.1,"serviceFee":null,"opFee":null,"nursingFee":null,"pathologicalDiagnosisFee":null,"lisDiagnoseFee":null,"clinicalDiagnoseFee":null,"imagingDiagnoseFee":null,"recoveryFee":null,"chineseTreatmentFee":null,"chineseMadicineFee":null,"westernMadicineFee":null,"baseMadicineFee":null,"bloodFee":null,"materialFee":null,"qtFee":null,"feeType":null,"updateTime":"2019-04-30 02:51:44","updateBy":null}
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * patientCode : 3000166
         * patientCureNo : 099665
         * allCharge : 266.2
         * chargeDays : null
         * balence : -133.1
         * serviceFee : null
         * opFee : null
         * nursingFee : null
         * pathologicalDiagnosisFee : null
         * lisDiagnoseFee : null
         * clinicalDiagnoseFee : null
         * imagingDiagnoseFee : null
         * recoveryFee : null
         * chineseTreatmentFee : null
         * chineseMadicineFee : null
         * westernMadicineFee : null
         * baseMadicineFee : null
         * bloodFee : null
         * materialFee : null
         * qtFee : null
         * feeType : null
         * updateTime : 2019-04-30 02:51:44
         * updateBy : null
         */

        private int id;
        private String patientCode;
        private String patientCureNo;
        private double allCharge;
        private Object chargeDays;
        private double balence;
        private Object serviceFee;
        private Object opFee;
        private Object nursingFee;
        private Object pathologicalDiagnosisFee;
        private Object lisDiagnoseFee;
        private Object clinicalDiagnoseFee;
        private Object imagingDiagnoseFee;
        private Object recoveryFee;
        private Object chineseTreatmentFee;
        private Object chineseMadicineFee;
        private Object westernMadicineFee;
        private Object baseMadicineFee;
        private Object bloodFee;
        private Object materialFee;
        private Object qtFee;
        private String feeType;
        private String updateTime;
        private Object updateBy;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPatientCode() {
            return patientCode;
        }

        public void setPatientCode(String patientCode) {
            this.patientCode = patientCode;
        }

        public String getPatientCureNo() {
            return patientCureNo;
        }

        public void setPatientCureNo(String patientCureNo) {
            this.patientCureNo = patientCureNo;
        }

        public double getAllCharge() {
            return allCharge;
        }

        public void setAllCharge(double allCharge) {
            this.allCharge = allCharge;
        }

        public Object getChargeDays() {
            return chargeDays;
        }

        public void setChargeDays(Object chargeDays) {
            this.chargeDays = chargeDays;
        }

        public double getBalence() {
            return balence;
        }

        public void setBalence(double balence) {
            this.balence = balence;
        }

        public Object getServiceFee() {
            return serviceFee;
        }

        public void setServiceFee(Object serviceFee) {
            this.serviceFee = serviceFee;
        }

        public Object getOpFee() {
            return opFee;
        }

        public void setOpFee(Object opFee) {
            this.opFee = opFee;
        }

        public Object getNursingFee() {
            return nursingFee;
        }

        public void setNursingFee(Object nursingFee) {
            this.nursingFee = nursingFee;
        }

        public Object getPathologicalDiagnosisFee() {
            return pathologicalDiagnosisFee;
        }

        public void setPathologicalDiagnosisFee(Object pathologicalDiagnosisFee) {
            this.pathologicalDiagnosisFee = pathologicalDiagnosisFee;
        }

        public Object getLisDiagnoseFee() {
            return lisDiagnoseFee;
        }

        public void setLisDiagnoseFee(Object lisDiagnoseFee) {
            this.lisDiagnoseFee = lisDiagnoseFee;
        }

        public Object getClinicalDiagnoseFee() {
            return clinicalDiagnoseFee;
        }

        public void setClinicalDiagnoseFee(Object clinicalDiagnoseFee) {
            this.clinicalDiagnoseFee = clinicalDiagnoseFee;
        }

        public Object getImagingDiagnoseFee() {
            return imagingDiagnoseFee;
        }

        public void setImagingDiagnoseFee(Object imagingDiagnoseFee) {
            this.imagingDiagnoseFee = imagingDiagnoseFee;
        }

        public Object getRecoveryFee() {
            return recoveryFee;
        }

        public void setRecoveryFee(Object recoveryFee) {
            this.recoveryFee = recoveryFee;
        }

        public Object getChineseTreatmentFee() {
            return chineseTreatmentFee;
        }

        public void setChineseTreatmentFee(Object chineseTreatmentFee) {
            this.chineseTreatmentFee = chineseTreatmentFee;
        }

        public Object getChineseMadicineFee() {
            return chineseMadicineFee;
        }

        public void setChineseMadicineFee(Object chineseMadicineFee) {
            this.chineseMadicineFee = chineseMadicineFee;
        }

        public Object getWesternMadicineFee() {
            return westernMadicineFee;
        }

        public void setWesternMadicineFee(Object westernMadicineFee) {
            this.westernMadicineFee = westernMadicineFee;
        }

        public Object getBaseMadicineFee() {
            return baseMadicineFee;
        }

        public void setBaseMadicineFee(Object baseMadicineFee) {
            this.baseMadicineFee = baseMadicineFee;
        }

        public Object getBloodFee() {
            return bloodFee;
        }

        public void setBloodFee(Object bloodFee) {
            this.bloodFee = bloodFee;
        }

        public Object getMaterialFee() {
            return materialFee;
        }

        public void setMaterialFee(Object materialFee) {
            this.materialFee = materialFee;
        }

        public Object getQtFee() {
            return qtFee;
        }

        public void setQtFee(Object qtFee) {
            this.qtFee = qtFee;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }
    }
}
