package com.study.socket.udp.unicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** @date 2021/6/12 23:52 */
public class Provider {
  public static void main(String[] args) throws IOException {
    System.out.println("UDPProvider started");

    DatagramSocket datagramSocket = new DatagramSocket(20000);

    byte[] buf = new byte[512];
    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

    datagramSocket.receive(receivePack);

    String ip = receivePack.getAddress().getHostAddress();
    int port = receivePack.getPort();
    int dataLength = receivePack.getLength();
    String data = new String(receivePack.getData(), 0, dataLength);

    System.out.println("UDPProvider receive from ip: " + ip + ":" + port + " ===> " + data);

    String response = "Receive data with length:" + dataLength;
    byte[] responseBytes = response.getBytes();

    DatagramPacket responsePacket =
        new DatagramPacket(
            responseBytes, response.length(), receivePack.getAddress(), receivePack.getPort());

    datagramSocket.send(responsePacket);

    System.out.println("UDPProvider Finished");
    datagramSocket.close();
  }
}
