package com.study.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;

/** @date 2021/6/12 21:41 */
public class Client {
  private static final int PORT = 20000;
  private static final int LOCAL_PORT = 20001;

  public static void main(String[] args) throws IOException {
    Socket socket = createSocket();
    initSocket(socket);

    socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), PORT), 3000);

    System.out.println("connected");
    System.out.println("client ====> " + socket.getLocalAddress() + ":" + socket.getLocalPort());
    System.out.println("server ====> " + socket.getInetAddress() + ":" + socket.getPort());

    send(socket);

    System.out.println("stopped!!!");
    socket.close();
  }

  public static void send(Socket socket) throws IOException {
    try (InputStream stdIn = System.in;
        InputStreamReader stdInputStreamReader = new InputStreamReader(stdIn);
        BufferedReader stdReader = new BufferedReader(stdInputStreamReader);
        OutputStream socketOutputStream = socket.getOutputStream();
        PrintStream socketPrint = new PrintStream(socketOutputStream);
        InputStream socketInputStream = socket.getInputStream();
        BufferedReader socketReader =
            new BufferedReader(new InputStreamReader(socketInputStream)); ) {
      boolean stop = false;
      do {
        String line = stdReader.readLine();
        socketPrint.println(line);

        String serverRes = socketReader.readLine();
        if ("bye".equalsIgnoreCase(serverRes)) {
          stop = true;
        } else {
          System.out.println("server response: " + serverRes);
        }
      } while (!stop);
    }
  }

  private static Socket createSocket() throws IOException {
    Socket socket = new Socket(Proxy.NO_PROXY);
    socket.bind(new InetSocketAddress(Inet4Address.getLocalHost(), LOCAL_PORT));
    return socket;
  }

  private static void initSocket(Socket socket) throws SocketException {
    // 读取超时时间
    socket.setSoTimeout(3000);

    // 是否复用未完全关闭的socket地址，对于指定bind操作后的socket有效
    socket.setReuseAddress(true);

    // 是否开启Nagle算法
    socket.setTcpNoDelay(false);

    // 是否需要在长时间无数据响应时发送确认数据（类似心跳包），时间大约2小时
    socket.setKeepAlive(true);

    // 对于close操作行为进行怎样的处理，默认false,0
    // false,0: 关闭时立即返回，系统接管输出流，将缓冲区的数据发送完成
    // true,0: 关闭时立即返回，抛弃缓冲区数据，直接发送RST结束命令到对方，并无需经过2MSL等待
    // true,200: 关闭时最长阻塞200毫秒，随后按第二种情况处理
    socket.setSoLinger(true, 20);

    // 是否让紧急数据内敛，默认false，紧急数据通过socket.sendUrgentData(1)发送
    // 为true时可以在业务层接收到
    // 不建议设置为true
    socket.setOOBInline(false);

    socket.setReceiveBufferSize(64 * 1024 * 1024);
    socket.setSendBufferSize(64 * 1024 * 1024);

    // 设置性能参数： 短链接、延迟、带宽的权重
    socket.setPerformancePreferences(1, 1, 1);
  }
}
