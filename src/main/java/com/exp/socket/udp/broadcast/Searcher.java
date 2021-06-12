package com.exp.socket.udp.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import lombok.AllArgsConstructor;

/** @date 2021/6/13 00:31 */
public class Searcher {
  private static final int LISTEN_PORT = 30000;

  public static void main(String[] args) throws IOException, InterruptedException {
    Listener listen = listen();
    send();

    System.in.read();
    List<Device> devices = listen.getDevicesAndExit();
    System.out.println(devices.toString());
  }

  private static synchronized Listener listen() throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    Listener listener = new Listener(LISTEN_PORT, countDownLatch);
    listener.start();
    countDownLatch.await();
    return listener;
  }

  private static void send() throws IOException {
    System.out.println("UDPSearcher send broadcast started.");

    DatagramSocket datagramSocket = new DatagramSocket();
    String requestData = MessageCreator.build(LISTEN_PORT);
    DatagramPacket requestPacket =
        new DatagramPacket(requestData.getBytes(), requestData.getBytes().length);
    requestPacket.setAddress(InetAddress.getByName("255.255.255.255"));
    requestPacket.setPort(20000);

    datagramSocket.send(requestPacket);
    datagramSocket.close();

    System.out.println("UDPSearcher send broadcast finished.");
  }
}

@AllArgsConstructor
class Device {
  final int port;
  final String ip;
  final String sn;

  @Override
  public String toString() {
    return "Device{" + "port=" + port + ", ip='" + ip + '\'' + ", sn='" + sn + '\'' + '}';
  }
}

class Listener extends Thread {
  private final int listenPort;
  private final CountDownLatch countDownLatch;
  private final List<Device> devices = new ArrayList<>();
  private boolean done = false;
  private DatagramSocket datagramSocket;

  public Listener(int listenPort, CountDownLatch countDownLatch) {
    this.listenPort = listenPort;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    super.run();
    countDownLatch.countDown();

    try {
      datagramSocket = new DatagramSocket(listenPort);

      while (!done) {
        byte[] buf = new byte[512];
        DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(receivePacket);

        String ip = receivePacket.getAddress().getHostAddress();
        int port = receivePacket.getPort();
        int dataLength = receivePacket.getLength();
        String data = new String(receivePacket.getData(), 0, dataLength);
        System.out.println("UDPSearcher receive from " + ip + ":" + port + ":" + data);

        String sn = MessageCreator.parseSn(data);
        if (Objects.nonNull(sn)) {
          devices.add(new Device(port, ip, sn));
        }
      }
    } catch (Exception e) {

    } finally {
      close();
    }

    System.out.println("UDPSearcher listener finished.");
  }

  public List<Device> getDevicesAndExit() {
    done = true;
    close();
    return devices;
  }

  private void close() {
    if (Objects.nonNull(datagramSocket)) {
      datagramSocket.close();
      datagramSocket = null;
    }
  }
}
