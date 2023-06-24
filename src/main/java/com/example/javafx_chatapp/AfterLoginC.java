package com.example.javafx_chatapp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class AfterLoginC {

    @FXML
    private TextField Host;
    @FXML
    private TextField Port;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField Message;
    @FXML
    private TextField Username;

    PrintWriter Pw;
    @FXML
    protected void onConnect() throws IOException{
        String host=Host.getText();
        int port= Integer.parseInt(Port.getText());
        Socket s = new Socket(host,port);

        InputStream is = s.getInputStream();
        InputStreamReader isr= new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        OutputStream os = s.getOutputStream();
        Pw= new PrintWriter(os,true);
        new Thread(()->{
            while(true) {
                try {
                    String Response = br.readLine();
                    Platform.runLater(() -> {
                        listView.getItems().add(Response);
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();



    }

    @FXML
    public void onSubmit(){
        String message = Message.getText();
        String username = Username.getText();
        Pw.println(username + " : " +message);
        System.out.println(username + " : " +message);
    }

}
