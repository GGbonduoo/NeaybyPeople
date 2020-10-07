package com.example.neaybypeople;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SocketConnectThread implements Runnable {

    int port;
    String host;
    Socket client;
    ServerSocket server;
    double latitude;
    double longitude;

    public SocketConnectThread(int port,String host,double latitude,double longitude) throws IOException {
        this.port = port;
        this.host = host;
        this.latitude = latitude;
        this.longitude = longitude;


    }
    public void run(){
        try{
            client = new Socket(host,port);
            DataInputStream is = new DataInputStream(client.getInputStream());
            DataOutputStream os = new DataOutputStream(client.getOutputStream());
            os.writeUTF("xiaolin");
            String info = is.readUTF();
            Log.d("info",info);
            os.writeUTF("peoplenearby");
            os.writeDouble(latitude);
            os.writeDouble(longitude);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
