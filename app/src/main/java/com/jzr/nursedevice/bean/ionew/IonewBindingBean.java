package com.jzr.nursedevice.bean.ionew;

public class IonewBindingBean {


    /**
     * Result : 1
     * Message : 操作成功
     * Data : {"MessageType":501,"Sid":0,"DeviceMac":"","SeatBedDeviceID":75,"Mac":"BFE49FFEFF570B00","MacAddr":"BFE49FFEFF570B00","SeatBedID":"1","SerialNo":"S001","SuffererNo":"023869","SuffererName":"张玲玲","DevVoice":"1","DevCode":"7","AreaID":"6","AreaCode":"130"}
     */

    private int Result;
    private String Message;
    private DataBean Data;

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public DataBean getData() {
        return Data;
    }

    public void setData(DataBean Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * MessageType : 501
         * Sid : 0
         * DeviceMac :
         * SeatBedDeviceID : 75
         * Mac : BFE49FFEFF570B00
         * MacAddr : BFE49FFEFF570B00
         * SeatBedID : 1
         * SerialNo : S001
         * SuffererNo : 023869
         * SuffererName : 张玲玲
         * DevVoice : 1
         * DevCode : 7
         * AreaID : 6
         * AreaCode : 130
         */

        private int MessageType;
        private int Sid;
        private String DeviceMac;
        private int SeatBedDeviceID;
        private String Mac;
        private String MacAddr;
        private String SeatBedID;
        private String SerialNo;
        private String SuffererNo;
        private String SuffererName;
        private String DevVoice;
        private String DevCode;
        private String AreaID;
        private String AreaCode;

        public int getMessageType() {
            return MessageType;
        }

        public void setMessageType(int MessageType) {
            this.MessageType = MessageType;
        }

        public int getSid() {
            return Sid;
        }

        public void setSid(int Sid) {
            this.Sid = Sid;
        }

        public String getDeviceMac() {
            return DeviceMac;
        }

        public void setDeviceMac(String DeviceMac) {
            this.DeviceMac = DeviceMac;
        }

        public int getSeatBedDeviceID() {
            return SeatBedDeviceID;
        }

        public void setSeatBedDeviceID(int SeatBedDeviceID) {
            this.SeatBedDeviceID = SeatBedDeviceID;
        }

        public String getMac() {
            return Mac;
        }

        public void setMac(String Mac) {
            this.Mac = Mac;
        }

        public String getMacAddr() {
            return MacAddr;
        }

        public void setMacAddr(String MacAddr) {
            this.MacAddr = MacAddr;
        }

        public String getSeatBedID() {
            return SeatBedID;
        }

        public void setSeatBedID(String SeatBedID) {
            this.SeatBedID = SeatBedID;
        }

        public String getSerialNo() {
            return SerialNo;
        }

        public void setSerialNo(String SerialNo) {
            this.SerialNo = SerialNo;
        }

        public String getSuffererNo() {
            return SuffererNo;
        }

        public void setSuffererNo(String SuffererNo) {
            this.SuffererNo = SuffererNo;
        }

        public String getSuffererName() {
            return SuffererName;
        }

        public void setSuffererName(String SuffererName) {
            this.SuffererName = SuffererName;
        }

        public String getDevVoice() {
            return DevVoice;
        }

        public void setDevVoice(String DevVoice) {
            this.DevVoice = DevVoice;
        }

        public String getDevCode() {
            return DevCode;
        }

        public void setDevCode(String DevCode) {
            this.DevCode = DevCode;
        }

        public String getAreaID() {
            return AreaID;
        }

        public void setAreaID(String AreaID) {
            this.AreaID = AreaID;
        }

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String AreaCode) {
            this.AreaCode = AreaCode;
        }
    }
}
