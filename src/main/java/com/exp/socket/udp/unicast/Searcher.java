package com.exp.socket.udp.unicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/** @date 2021/6/12 23:52 */
public class Searcher {
  public static void main(String[] args) throws IOException {
    System.out.println("UDPSearcher started");

    DatagramSocket datagramSocket = new DatagramSocket();

    String request = "Hello world!";
    byte[] requestBytes = request.getBytes();

    DatagramPacket requestPacket = new DatagramPacket(requestBytes, requestBytes.length);
    requestPacket.setAddress(InetAddress.getLocalHost());
    requestPacket.setPort(20000);

    datagramSocket.send(requestPacket);
    System.out.println("send success");

    byte[] buf = new byte[512];
    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

    datagramSocket.receive(receivePack);

    String ip = receivePack.getAddress().getHostAddress();
    int port = receivePack.getPort();
    int dataLength = receivePack.getLength();
    String data = new String(receivePack.getData(), 0, dataLength);

    System.out.println("UDPSearcher receive from ip: " + ip + ":" + port + " ===> " + data);

    System.out.println("UDPSearcher Finished");
    datagramSocket.close();
  }
}
