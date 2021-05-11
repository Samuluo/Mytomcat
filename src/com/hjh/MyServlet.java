package com.hjh;

import java.io.IOException;

public class MyServlet extends MyHttpServlet {

    @Override
    public void doGet(MyRequest request, MyResponce responce) throws Exception{
        responce.write("mytomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponce responce)throws Exception{
        responce.write("post tomcat");
    }
}
