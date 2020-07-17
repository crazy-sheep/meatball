package bat.ke.qq.com.threadpool;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 源码学院-Fox
 * 只为培养BAT程序员而生
 * http://bat.ke.qq.com
 * 往期视频加群:516212256 暗号:6
 *
 */
public class BioServer {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);



        try {
            // 启动服务，绑定8080端口
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            System.out.println("开启服务");


            while (true){

                // 监听8080端口，获取客户端连接
                Socket socket = serverSocket.accept();// 阻塞

                System.out.println("建立新的链接"+socket);

                final InputStream inputStream = socket.getInputStream();

                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            try {
                                byte[] bytes = new byte[1024];
                                System.out.println("等待读取数据");
                                int data = inputStream.read(bytes); // 阻塞
                                if(data !=-1){
                                    System.out.println("读取数据"+new String(bytes,0,data));
                                }else {
                                    break;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }

}
