package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static void main(final String[] args) throws Exception
    {
        multiTask();
        singleTask();
//        System.out.println(Runtime.getRuntime()
//                .availableProcessors());
    }

    public static void multiTask() throws Exception{
        ParallelTasks tasks = new ParallelTasks();
        final Runnable waitOneSecond = new Runnable() {
            public void run()
            {
                for(int i = 0; i < 1000000000; i++){
                    long a = i+System.currentTimeMillis();
                }
            }
        };

        for(int i = 0; i < 6; i++){
            tasks.add(waitOneSecond);
        }
        final long start = System.currentTimeMillis();
        tasks.go();
        System.err.println(System.currentTimeMillis() - start);
    }


    public static void singleTask(){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 1000000000; j++){
                long a = i+System.currentTimeMillis();
            }
        }
        System.err.println(System.currentTimeMillis() - start);
    }
}
