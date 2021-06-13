package com.exp.socket.discover.client;

import com.exp.socket.discover.Constant;
import com.exp.socket.discover.domain.ServerInfo;
import com.google.common.primitives.Bytes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/** @date 2021/6/13 16:01 */
public class UdpClient {
  public ServerInfo search(int timeout) throws InterruptedException, IOException {
    System.out.println("start search...");

    CountDownLatch receiveLatch = new CountDownLatch(1);
    Searcher searcher = listen(receiveLatch);
    sendBroadcast();
    receiveLatch.await(timeout, TimeUnit.MILLISECONDS);

    final List<ServerInfo> serverInfos = searcher.getServerInfosAndExit();
    if (!serverInfos.isEmpty()) {
      return serverInfos.get(0);
    }
    return null;
  }

  private Searcher listen(CountDownLatch receiveLatch) throws InterruptedException {
    System.out.println("UDPSearcher started.");
    CountDownLatch startDownLatch = new CountDownLatch(1);
    final Searcher searcher = new Searcher(Constant.UDP_CLIENT_PORT, startDownLatch, receiveLatch);
    searcher.start();
    startDownLatch.await();
    return searcher;
  }

  private void sendBroadcast() throws IOException {
    System.out.println("UDPSearcher start send broadcast...");
    final DatagramSocket datagramSocket = new DatagramSocket();

    final ByteBuffer sendBuffer = ByteBuffer.allocate(128);
    sendBuffer.put(Constant.UDP_HEADER);
    sendBuffer.putShort((short) 1);
    sendBuffer.putInt(Constant.UDP_CLIENT_PORT);

    final DatagramPacket sendPacket =
        new DatagramPacket(sendBuffer.array(), sendBuffer.position() + 1);
    sendPacket.setAddress(InetAddress.getByName("255.255.255.255"));
    sendPacket.setPort(Constant.UDP_SERVER_PORT);
    datagramSocket.send(sendPacket);
    datagramSocket.close();
    System.out.println("UDPSearcher send broadcast finished.");
  }
}

class Searcher extends Thread {
  private final int listenPort;
  private final CountDownLatch startDownLatch;
  private final CountDownLatch receiveDownLatch;

  private final List<ServerInfo> serverInfos = new ArrayList<>();
  private final byte[] buffer = new byte[128];
  private boolean done = false;
  private DatagramSocket datagramSocket;

  public Searcher(int listenPort, CountDownLatch startDownLatch, CountDownLatch receiveDownLatch) {
    super();
    this.listenPort = listenPort;
    this.startDownLatch = startDownLatch;
    this.receiveDownLatch = receiveDownLatch;
  }

  @Override
  public void run() {
    super.run();

    startDownLatch.countDown();

    try {
      datagramSocket = new DatagramSocket(listenPort);
      final DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

      while (!done) {
        datagramSocket.receive(receivePacket);

        final InetAddress address = receivePacket.getAddress();
        final int port = receivePacket.getPort();
        final int receivedLen = receivePacket.getLength();
        final byte[] receivedData = receivePacket.getData();
        final boolean isValid =
            receivedLen >= Constant.UDP_VERIFY_LEN
                && Bytes.indexOf(receivedData, Constant.UDP_HEADER) == 0;

        System.out.println(
            "UDPSearcher receive from " + address + ":" + port + " ==> isValid: " + isValid);

        if (!isValid) {
          continue;
        }

        final ByteBuffer receivedBuffer =
            ByteBuffer.wrap(buffer, Constant.UDP_HEADER.length, receivedLen);
        final short cmd = receivedBuffer.getShort();
        final int serverPort = receivedBuffer.getInt();
        if (cmd != 2 || serverPort <= 0) {
          System.out.println("UDPSearcher receive cmd: " + cmd + " serverPort:" + serverPort);
          continue;
        }

        final String sn =
            new String(
                receivedData, Constant.UDP_VERIFY_LEN, receivedLen - Constant.UDP_VERIFY_LEN);
        final ServerInfo serverInfo = new ServerInfo(address.getHostAddress(), serverPort, sn);
        serverInfos.add(serverInfo);
        receiveDownLatch.countDown();
      }
    } catch (Exception e) {
      close();
    }
    System.out.println("UDPSearcher listener finished.");
  }

  public List<ServerInfo> getServerInfosAndExit() {
    done = true;
    close();
    return serverInfos;
  }

  private void close() {
    if (Objects.nonNull(datagramSocket)) {
      datagramSocket.close();
      datagramSocket = null;
    }
  }
}
