package UdpClientServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;


public class Server {
    public static int buffsize = 512;
    public static int port = 1234;


    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket dpreceive, dpsend;
        try {
            socket = new DatagramSocket(1234);
            dpreceive = new DatagramPacket(new byte[buffsize], buffsize);
            while(true) {
                socket.receive(dpreceive);
                String tmp = new String(dpreceive.getData(), 0 , dpreceive.getLength());
                System.out.println("Server received: " + tmp + " from " +
                        dpreceive.getAddress().getHostAddress() + " at port " +
                        socket.getLocalPort());
                if(tmp.equals("bye")) {
                    System.out.println("Server socket closed");
                    socket.close();
                    break;
                }

                StringTokenizer st = new StringTokenizer(tmp, ";");
                if(tmp.equals("Hello")) {

                    String result=TestAPI.getCountryData();
                    dpsend = new DatagramPacket(result.getBytes(), result.getBytes().length, dpreceive.getAddress(), dpreceive.getPort());
                    System.out.println("Server sent back " + tmp + " to client");
                    socket.send(dpsend);
                }else{

                    if(st.countTokens() == 2){
                        String result = TestAPI.getCitiesData(st.nextToken(),st.nextToken());

                        if(result.equals("")){
                            result = "Vui Lòng Kiểm Tra Input!!";
                        }
                        dpsend = new DatagramPacket(result.getBytes(), result.getBytes().length, dpreceive.getAddress(), dpreceive.getPort());
                        System.out.println("Server sent back " + tmp + " to client");
                        socket.send(dpsend);
                    }else{
                        if(st.countTokens() == 3){

                            String result=TestAPI.getAqiUsCity(st.nextToken(),st.nextToken(),st.nextToken());
                            if(result.equals("")){
                                result = "Vui Lòng Kiểm Tra Input!!";
                            }
                            dpsend = new DatagramPacket(result.getBytes(), result.getBytes().length, dpreceive.getAddress(), dpreceive.getPort());
                            System.out.println("Server sent back " + tmp + " to client");
                            socket.send(dpsend);
                        }
                        String result = TestAPI.getStatesData(st.nextToken());

                        if(result.equals("")){
                            result = "Vui Lòng Kiểm Tra Input!!";
                        }
                        dpsend = new DatagramPacket(result.getBytes(), result.getBytes().length, dpreceive.getAddress(), dpreceive.getPort());
                        System.out.println("Server sent back " + tmp + " to client\n");
                        socket.send(dpsend);
                    }



                }

            }
        } catch (IOException e) { System.err.println(e);}
    }

}
