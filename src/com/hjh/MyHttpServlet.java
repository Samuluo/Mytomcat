package com.hjh;

public abstract class MyHttpServlet {
    //定义好两个常量
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request, MyResponce responce) throws Exception;
    public abstract void doPost(MyRequest request,MyResponce responce) throws Exception;

    /**
     * 根据请求方式判断哪种处理方法
     * @param request
     * @param responce
     */
    public void service(MyRequest request,MyResponce responce) throws Exception {
        if(METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,responce);
        }else if(METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,responce);
        }
    }

}

