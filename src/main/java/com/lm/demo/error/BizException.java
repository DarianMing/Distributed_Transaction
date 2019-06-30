package com.lm.demo.error;

public class BizException extends RuntimeException {

    public BizException () {
        super();
    }

    public BizException(String msg) {
        super(msg);
    }

    public BizException(Throwable e) {
        super(e);
    }

    public BizException(String msg , Throwable e) {
        super(msg , e);
    }

}
