package com.example.lab_final;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String key = request.getParameter("key");
        int value = Integer.parseInt(request.getParameter("value"));
        int mock = Integer.parseInt(request.getParameter("mock"));
        int sync = Integer.parseInt(request.getParameter("sync"));
        if(mock>=1){
            mock=1;
        }
        if(sync>=1){
            sync=1;
        }
        PrintWriter out = response.getWriter();
        if(request.getHeader("User-Agent").contains("Chrome")||request.getHeader("User-Agent").contains("Mozilla")){
        if(mock==1)
        {

            out.println("<html>");
            out.println("<body>");
            out.println("Mock=true");
            out.println("<br>| key: "+key.repeat(value));
            out.println("<br>| value: "+value);
            out.println("<br>| sync: "+sync);
            out.println("</body>");
            out.println("</html>");
        }else{
            if(sync==0)
                FileWriter(key,value);
            else
                FileWriter1(key,value);

            String content = new String(Files.readAllBytes(Paths.get("S:\\Master-anul1\\Java-Technologies\\Lab_final\\repository.txt")));
            TreeMap<String,String> ordered=new TreeMap<>();
            String[] parts=content.split("[ \n]");
            for(int i=0;i<parts.length;i++){
                if(i%3==0){
                    ordered.put(parts[i],parts[i+1]+" "+parts[i+2]);
                }
            }

            out.println("<html><body><pre>");
            for (Map.Entry<String, String> entry : ordered.entrySet()) {
                out.println(entry.getKey() + " " + entry.getValue());
            }
            out.println("</pre></body></html>");


            //out.println(stringOrderedByKey.firstEntry().getKey());
            //out.println(stringOrderedByKey.firstEntry().getValue());




        }
        }else{
            if(mock==1)
            {
                out.println("Mock=true");
                out.println("| key: "+key.repeat(value));
                out.println("| value: "+value);
                out.println("| sync: "+sync);

            }else{
                String content = new String(Files.readAllBytes(Paths.get("S:\\Master-anul1\\Java-Technologies\\Lab_final\\repository.txt")));


                out.println("<html><body><pre>");
                out.println(content);
                out.println("</pre></body></html>");
                if(sync==0)
                    FileWriter(key,value);
                else
                    FileWriter1(key,value);
            }
        }

        log("IP adress:  "+request.getRemoteAddr());
        log("<br>Method: "+request.getMethod());
        log("<br>User-Agent: "+request.getHeader("User-Agent"));
        log("<br>Accept-Language: "+request.getHeader("Accept-Language"));

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
    public void destroy() {
    }
    public void FileWriter(String key,int value) throws IOException {
        File file = new File("S:\\Master-anul1\\Java-Technologies\\Lab_final\\repository.txt");
        FileWriter fstream = new FileWriter(file,true);
        BufferedWriter out = new BufferedWriter(fstream);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        out.write(key.repeat(value)+" "+formatter.format(date));
        out.newLine();
        out.close();
    }
    public synchronized void FileWriter1(String key,int value) throws IOException {
        File file = new File("S:\\Master-anul1\\Java-Technologies\\Lab_final\\repository.txt");
        FileWriter fstream = new FileWriter(file,true);
        BufferedWriter out = new BufferedWriter(fstream);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        out.write(key.repeat(value)+" "+formatter.format(date));
        out.newLine();
        out.close();
    }
}