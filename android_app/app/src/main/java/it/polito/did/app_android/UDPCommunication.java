package it.polito.did.app_android;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class UDPCommunication extends AsyncTask<Void,String,Integer> {
    LampManager manager = LampManager.getInstance();
    private Runnable runnable;
    private int port = 4096;
    private DatagramSocket serverSocket = null;
    private InetAddress lamp_IP;
    private String prev_packet_string = " ";
    public boolean ascolta = true;
    public boolean send = false;
    public String send_msg_string = "vuoto";
    public byte[] send_msg_data = new byte[64000];


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
            Log.e("PROGRESS: ", "aggiorno UI");
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        Log.e("udpcommunication", " started");

        //da ricevere
        byte[] rec_msg_data = new byte[64000];
        DatagramPacket rec_packet = new DatagramPacket(rec_msg_data,rec_msg_data.length);
        byte[] send_msg_data;


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

        while(ascolta) {
            if (send) {
                send_msg_data = send_msg_string.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(send_msg_data, send_msg_data.length, lamp_IP, port);
                try {

                    serverSocket.send(sendPacket);
                    Log.e("UDPCommunication", "Inviato UDP a: " + lamp_IP + ", Msg: " + send_msg_string);

                } catch (IOException e) {
                    Log.e("UDPCommunication", "indirizzo di invio nullo");
                    e.printStackTrace();
                }
                send = false;
                this.publishProgress("UI");

            }


                Log.e("UDPCommunication", "Attendo pacchetto UDP... ");
                try {
                    serverSocket.receive(rec_packet);
                    String senderIP = rec_packet.getAddress().getHostAddress().trim();
                    String rec_msg_string = new String(rec_packet.getData(), rec_packet.getOffset(), rec_packet.getLength());
                    String[] lamp_info_array = rec_msg_string.split("\\-");


                    Log.e("UDP", "ricevuto UDP da: " + senderIP + " " + rec_msg_string);

                    if (lamp_info_array[0].contains("aladino") && prev_packet_string != rec_msg_string || prev_packet_string == " ") {
                        if(lamp_info_array[6].equals("1")){
                            for(int i=0; i<manager.getLamps().size();i++){
                                if(manager.getLamps().get(i).getIpAddress().equals(senderIP) && manager.getLamps().get(i).getNome().equals("Genius1")){
                                    manager.getLamps().get(i).setIpAddress(senderIP);
                                    manager.getLamps().get(i).setBattery(1);
                                    this.publishProgress("UI");
                                    Log.e("UDPCommunication", "cambiato stato batteria di: "  + manager.getLamps().get(i).getNome());
                                }
                            }
                        }
                        manager.addLamp(senderIP, lamp_info_array[7], lamp_info_array[1], Color.rgb(Integer.valueOf(lamp_info_array[2]), Integer.valueOf(lamp_info_array[3]), Integer.valueOf(lamp_info_array[4])), Integer.valueOf(lamp_info_array[5]),Integer.valueOf(lamp_info_array[6]));
                        manager.setBattery(senderIP, Integer.valueOf(lamp_info_array[6]));
                        prev_packet_string = rec_msg_string;
                        this.publishProgress("UI");
                    } else Log.e("UDPCommunication", "pacchetto duplicato o non aladino");

                    this.publishProgress("UI");
                } catch (SocketTimeoutException e) {
                    continue;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        return 0;
    }

    public void sendUDP(String msg, String ip){
        this.send = true;
        this.send_msg_string = msg;

        try {
            this.lamp_IP = InetAddress.getByName(ip);
            Log.e("sendUDP()", "lamp_IP: " + lamp_IP);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
