package com.princeli.demo.chapter1;

/**
 * @program: concurrent-demo
 * @description: ${description}
 * @author: ly
 * @create: 2019-01-09 14:11
 **/
public class Demo {

    PrintProcessor printProcessor;

    public Demo() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("mic");
        new Demo().doTest(request);

    }

    public void doTest(Request request){
        printProcessor.processorRequest(request);
    }
}
