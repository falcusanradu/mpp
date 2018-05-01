//package server;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Client extends Thread {
//
//    private static Socket socket;
//    private static DataInputStream din;
//    private static DataOutputStream dout;
//
//    public static void main(String[] args) throws IOException {
//
//        Client.socket = new Socket("127.0.0.1", 1342);
//        Client.din = new DataInputStream(socket.getInputStream());
//        Client.dout = new DataOutputStream(socket.getOutputStream());
//        while (true) {
//            System.out.println(din.readUTF());
//            dout.writeChars("ce trimit la server");
//            // citeste
//            //da inapoi
//        }
//    }
//
//}
