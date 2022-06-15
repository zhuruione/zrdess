package org.example.system;

public class MyResponseBody {
    public int code;
    public String info;
    public Object datas;

    public MyResponseBody() {
        code=0;
        info="null";
    }

    public MyResponseBody(int code, String info) {
        this.code = code;
        this.info = info;
    }

    public MyResponseBody(int code, String info, Object datas) {
        this.code = code;
        this.info = info;
        this.datas = datas;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObject() {
        return datas;
    }

    public void setObject(Object datas) {
        this.datas = datas;
    }

}
