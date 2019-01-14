package com.princeli.demo.chapter1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-09 14:05
 **/
public class SaveProcessor extends Thread implements RequestProcessor{

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();


    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }


    @Override
    public void run() {
        while (true){
            Request request = null;
            try {
                request = linkedBlockingQueue.take();
                System.out.println("save data" + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
