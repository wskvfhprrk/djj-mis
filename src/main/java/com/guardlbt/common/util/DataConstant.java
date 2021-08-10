package com.guardlbt.common.util;

public class DataConstant {


    /**
     * 电子券批次状态
     * （1新建/2正在生产/3已生产）
     */
    public  enum CouponBatchStatus{

         NEW(1),
         PRODUCT(2),
         FINISH(3);
        private int value;
        private CouponBatchStatus(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    /**
     * 电子券状态
     * 状态（1库存、2锁定、3回收、4失效）
     */
    public enum CouponStatus{
        STORE(1),
        STORE_LOCK(2),
        RECYCLE(3),
        LOSE_EFFICACY(4);

        private int value;
        private CouponStatus(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

    }
}
