package com.hjh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    /**
     * 开始运行服务器，定义服务端的接收程序，接收socket
     * @param port
     */
    public static void StartServer(int port) throws Exception {
        //定义服务端 套接字
        ServerSocket serverSocket = new ServerSocket(port);

        //定义客户端套接字
        Socket socket = null;

        //IO流操作
        while(true){
            socket = serverSocket.accept();

            //获取IO流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //定义请求和响应对象
            MyRequest request = new MyRequest(inputStream);
            MyResponce responce = new MyResponce(outputStream);


            String clazz = new MyMapping().getMapping().get(request.getRequestUrl());
            if(clazz != null){
                Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
                //根据myServerletClass创建对象
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request,responce);

            }
        }
    }

    public static void main(String[] args){
        try {
            StartServer(10086);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
