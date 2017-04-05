package com.dili.ping.server.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingUtil{
    private static final int timeOut = 3000; //超时应该在3钞以上
    public static boolean isReachable(String ip)
    {
        boolean status = false;
        if(ip != null)
        {
            try
            {
                status = InetAddress.getByName(ip).isReachable(timeOut);
            }
            catch(UnknownHostException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        return status;
    }
}