package com.hjh;

import java.io.OutputStream;

public class MyResponce {
    private OutputStream outputStream;


    public MyResponce(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws Exception{
        StringBuilder builder = new StringBuilder();
        builder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<head>")
                .append("<title>")
                .append("fuck")
                .append("</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>"+ str +"</h1>")
                .append("</body>")
                .append("</html>");
        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }

}
