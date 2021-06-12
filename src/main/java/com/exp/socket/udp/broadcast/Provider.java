package com.exp.socket.udp.broadcast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Objects;
import java.util.UUID;
import lombok.SneakyThrows;

/** @date 2021/6/13 00:17 */
public class Provider {
  public static void main(String[] args) throws IOException {
    String sn = UUID.randomUUID().toString();
    ProviderHandler providerHandler = new ProviderHandler(sn);
    providerHandler.start();

    System.in.read();
    providerHandler.exit();
  }
}

class ProviderHandler extends Thread {
  private final String sn;
  private boolean done = false;
  private DatagramSocket datagramSocket;

  public ProviderHandler(String sn) {
    super();
    this.sn = sn;
  }

  public void exit() {
    done = true;
    close();
    System.out.println("UDPProvider[" + sn + "] closed");
  }

  @SneakyThrows
  @Override
  public void run() {
    super.run();

    System.out.println("UDPProvider[" + sn + "] started");

    try {
      datagramSocket = new DatagramSocket(20000);
      while (!done) {
        byte[] buf = new byte[512];
        DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(receivePacket);

        String ip = receivePacket.getAddress().getHostAddress();
        int port = receivePacket.getPort();
        int dataLength = receivePacket.getLength();
        String data = new String(receivePacket.getData(), 0, dataLength);
        System.out.println("UDPProvider receive from " + ip + ":" + port + ": " + data);

        int responsePort = MessageCreator.parsePort(data);
        System.out.println("parsed response port: " + responsePort);
        if (responsePort != -1) {
          String responseData = MessageCreator.build(sn);
          DatagramPacket responsePacket =
              new DatagramPacket(
                  responseData.getBytes(),
                  responseData.getBytes().length,
                  receivePacket.getAddress(),
                  responsePort);
          datagramSocket.send(responsePacket);
        }
      }
    } catch (Exception ignored) {

    } finally {
      exit();
    }
  }

  private void close() {
    if (Objects.nonNull(datagramSocket)) {
      datagramSocket.close();
      datagramSocket = null;
    }
  }
}
