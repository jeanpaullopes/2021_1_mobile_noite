package br.edu.uniritter.mobile.nossaprimeiraappnoite.service;

import android.util.Log;

import java.util.Calendar;

public class MinhaThread implements Runnable{

    private boolean rodando = false;


    @Override
    public void run() {
        Log.d("thread","deu run()");
        rodando = true;
        int id = 1;
        while (rodando) {
            try {
                Log.d("Thread",Calendar.getInstance().getTime().toString());
                NotificationService.criaNotificacao(++id,"hora atual:\n"+
                        Calendar.getInstance().getTime().toString());
                Thread.sleep(15000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
