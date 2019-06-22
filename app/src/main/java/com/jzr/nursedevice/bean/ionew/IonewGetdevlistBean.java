package com.jzr.nursedevice.bean.ionew;

import java.util.List;

public class IonewGetdevlistBean {

    /**
     * Result : 1
     * Message : 操作成功
     * Data : [{"DevMac":"19A748FEFFD76B08","DevCode":null,"AreaID":null,"SuffererID":null,"SeatBedID":null,"SeatBedDeviceID":null},{"DevMac":"84EA20FEFF9FFD90","DevCode":null,"AreaID":null,"SuffererID":null,"SeatBedID":null,"SeatBedDeviceID":null}]
     */

    private int Result;
    private String Message;
    private List<DataBean> Data;

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

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * DevMac : 19A748FEFFD76B08
         * DevCode : null
         * AreaID : null
         * SuffererID : null
         * SeatBedID : null
         * SeatBedDeviceID : null
         */

        private String DevMac;
        private Object DevCode;
        private Object AreaID;
        private Object SuffererID;
        private Object SeatBedID;
        private Object SeatBedDeviceID;

        public String getDevMac() {
            return DevMac;
        }

        public void setDevMac(String DevMac) {
            this.DevMac = DevMac;
        }

        public Object getDevCode() {
            return DevCode;
        }

        public void setDevCode(Object DevCode) {
            this.DevCode = DevCode;
        }

        public Object getAreaID() {
            return AreaID;
        }

        public void setAreaID(Object AreaID) {
            this.AreaID = AreaID;
        }

        public Object getSuffererID() {
            return SuffererID;
        }

        public void setSuffererID(Object SuffererID) {
            this.SuffererID = SuffererID;
        }

        public Object getSeatBedID() {
            return SeatBedID;
        }

        public void setSeatBedID(Object SeatBedID) {
            this.SeatBedID = SeatBedID;
        }

        public Object getSeatBedDeviceID() {
            return SeatBedDeviceID;
        }

        public void setSeatBedDeviceID(Object SeatBedDeviceID) {
            this.SeatBedDeviceID = SeatBedDeviceID;
        }
    }
}
