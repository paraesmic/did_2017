package it.polito.did.app_android;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class UDPCommunication extends AsyncTask<Void,String,Integer> {
    LampManager manager = LampManager.getInstance();
    private Runnable runnable;
    private int port = 4096;
    private DatagramSocket serverSocket = null;
    private InetAddress lamp_IP;


    public UDPCommunication(Runnable runnable) {
        this.runnable = runnable;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... progress) {
        this.runnable.run();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        Log.e("udpcommunication", " started");

        boolean ascolta = true;

        //da inviare
        String send_msg_string = "sono un pacchetto UDP";
        byte[] send_msg_data;

        //da ricevere
        String rec_msg_string;
        byte[] rec_msg_data = new byte[64000];
        DatagramPacket rec_packet = new DatagramPacket(rec_msg_data,rec_msg_data.length);

        try {
            if(serverSocket == null || serverSocket.isClosed()){
                serverSocket = new DatagramSocket(port);
                Log.e("UDPCommunication", "apro socket porta: " + port);
            }
            serverSocket.setSoTimeout(1000);
            }
            catch(SocketException e){
            e.printStackTrace();
        }

        while(ascolta){
        try{
            Log.e( "UDPCommunication", "Attendo pacchetto UDP... ");
            serverSocket.receive(rec_packet);
            String senderIP = rec_packet.getAddress().getHostAddress();
            String lamp_name = new String(rec_msg_data).trim();
            Log.e("UDP", "ricevuto broadcast UDP da: " + senderIP + " lampname:" + lamp_name);
            this.publishProgress("...RUNNABLE");
            if(lamp_name.contains("aladino")){
                manager.addLamp(senderIP,lamp_name);
            }

        }
        catch (SocketTimeoutException e) {
            this.publishProgress("TIMEDOUT");
            continue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
      /*  try{
            publishProgress("waiting for data");
            send_msg_data = send_msg_string.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(send_msg_data, send_msg_data.length, lamp_IP, port);
            socket.send(sendPacket);
            Log.e( "UDPCommunication", "Inviato UDP a: " + lamp_IP+ ", message: " + send_msg_string );
            publishProgress("packet sent");

        }  catch (IOException e) {
            e.printStackTrace();
        }*/

        return 0;
    }

}
