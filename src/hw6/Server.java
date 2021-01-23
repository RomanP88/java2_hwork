package hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = null;
        Scanner sc = new Scanner(System.in);


        try (ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Сервер Стартует");
            clientSocket = serverSocket.accept();
            System.out.println("Подключен клиент: " + clientSocket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());


            Thread threadReader = new Thread(()->{
                try {
                    while(true){
                        outputStream.writeUTF(sc.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threadReader.setDaemon(true);
            threadReader.start();

            while (true){
                String str = inputStream.readUTF();
                if(str.equals(" /close")) {
                    System.out.println("Клиуент покинул чат");
                    outputStream.writeUTF(" /close");
                    break;
                } else {
                    System.out.println(str);
                }
            }

        } catch (IOException e){
            e.printStackTrace();

        } finally {
            try{
                clientSocket.close();
            } catch (IOException | NullPointerException e){
                e.printStackTrace();
            }
        }
    }
}
