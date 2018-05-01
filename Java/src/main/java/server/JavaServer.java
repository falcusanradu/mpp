//package server;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class JavaServer {
//    private static ServerSocket serverSocket;
//    private static Socket clientSocket;
//    private static DataInputStream din;
//    private static DataOutputStream dout;
//
//    public static void main(String[] args) throws IOException {
//        JavaServer.serverSocket = new ServerSocket(1342);
//        JavaServer.clientSocket = serverSocket.accept();
//
//        JavaServer.din = new DataInputStream(clientSocket.getInputStream());
//        JavaServer.dout = new DataOutputStream(clientSocket.getOutputStream());
//
//        while (true) {
//            //exemplu
//            din.readUTF();
//            String msg = din.readUTF(); /// iau de la client
//            System.out.println("ce am luat de la client");
//            System.out.println(msg);
//            dout.writeChars("ce dau la client");
////            dout.writeChars("asd"); /// dau la client
//        }
//    }
//}
