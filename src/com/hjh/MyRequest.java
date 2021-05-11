package com.hjh;

import java.io.InputStream;

public class MyRequest {
    //请求方法   get \post
    private String requestMethod;
    //请求地址
    private String requestUrl;

    public MyRequest(InputStream inputStream) throws Exception{
        //缓冲空间
        byte[] buffer = new byte[1024];
        //读取数据的长度
        int len = 0;
        //定义请求的变量
        String str = null;

        if((len = inputStream.read(buffer))>0){
            str = new String(buffer,0,len);

        }
        //GET / http/1.1
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
}
