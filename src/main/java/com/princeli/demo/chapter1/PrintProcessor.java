package com.princeli.demo.chapter1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-09 14:05
 **/
public class PrintProcessor extends Thread implements RequestProcessor{

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();

    private final  RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

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
                System.out.println("print data" + request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
