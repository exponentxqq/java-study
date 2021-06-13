package com.exp.socket.discover.server;

import com.exp.socket.discover.Constant;
import com.google.common.primitives.Bytes;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.UUID;

/** @date 2021/6/13 14:40 */
public class UdpServer {
  private static Provider PROVIDER_INSTANCE;

  public void start(int port) {
    close();
    final String sn = UUID.randomUUID().toString();
    PROVIDER_INSTANCE = new Provider(sn, port);
    PROVIDER_INSTANCE.start();
  }

  public void close() {
    if (Objects.nonNull(PROVIDER_INSTANCE)) {
      PROVIDER_INSTANCE.close();
      PROVIDER_INSTANCE = null;
    }
  }
}

class Provider extends Thread {
  private final byte[] sn;
  private final int port;

  private boolean done = false;
  private DatagramSocket datagramSocket;

  private final byte[] buffer = new byte[128];

  public Provider(String sn, int port) {
    super();
    this.sn = sn.getBytes();
    this.port = port;
  }

  @Override
  public void run() {
    super.run();

    System.out.println("UDPProvider started.");

    try {
      datagramSocket = new DatagramSocket(Constant.UDP_SERVER_PORT);
      final DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

      while (!done) {
        datagramSocket.receive(receivePacket);

        final InetAddress clientIp = receivePacket.getAddress();
        final int clientPort = receivePacket.getPort();
        final int receivedLength = receivePacket.getLength();
        final byte[] receivedData = receivePacket.getData();
        final boolean isValid =
            receivedLength >= (Constant.UDP_HEADER.length + 2 + 4)
                && Bytes.indexOf(receivedData, Constant.UDP_HEADER) == 0;

        System.out.println(
            "UDPProvider receive from " + clientIp + ":" + clientPort + " ==> valid: " + isValid);

        if (!isValid) {
          continue;
        }

        int index = Constant.UDP_HEADER.length;
        final short cmd = (short) ((receivedData[index++] << 8) | (receivedData[index++] & 0xff));
        int responsePort = ByteBuffer.wrap(receivedData).position(index).getInt();

        if (cmd == 1 && responsePort > 0) {
          final ByteBuffer responseBuf = ByteBuffer.wrap(buffer);
          responseBuf.put(Constant.UDP_HEADER);
          responseBuf.putShort((short) 2);
          responseBuf.putInt(Constant.TCP_SERVER_PORT);
          responseBuf.put(sn);

          final DatagramPacket responsePacket =
              new DatagramPacket(
                  buffer, responseBuf.position() + 1, receivePacket.getAddress(), responsePort);
          datagramSocket.send(responsePacket);
          System.out.println(
              "UDPProvider response: "
                  + clientIp
                  + ":"
                  + responsePort
                  + " ==> dataLen:"
                  + (responseBuf.position() + 1));
        } else {
          System.out.println("UDPProvider receive cmd nonsupport; cmd:" + cmd + " port:" + port);
        }
      }
    } catch (Exception ignore) {
    } finally {
      close();
    }
  }

  public void close() {
    if (Objects.nonNull(datagramSocket)) {
      done = true;
      datagramSocket.close();
      datagramSocket = null;
    }
  }
}
