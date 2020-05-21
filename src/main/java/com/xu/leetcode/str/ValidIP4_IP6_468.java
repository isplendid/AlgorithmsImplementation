package com.xu.leetcode.str;

/**
 * Created by sop on 2020/5/20.
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 链接：https://leetcode-cn.com/problems/validate-ip-address
\
 */
public class ValidIP4_IP6_468 {

    public String validIPAddress(String IP) {

        String[] IP4Arr = IP.split("\\.", -1);
        if(IP4Arr.length == 4){
            return isIP4Arr(IP4Arr);
        }

        String[] IP6Arr = IP.split(":", -1);
        if(IP6Arr.length == 8) {
            return isIP6Arr(IP6Arr);
        }
        return "Neither";
    }

    private String isIP4Arr(String[] IP4Arr){
        for(String ip:IP4Arr){
            if(ip.length()>3 || ip.length()<=0) {
                return "Neither";
            }
            for(int i=0; i<ip.length(); i++){
                if(!Character.isDigit(ip.charAt(i))){
                    return "Neither";
                }
            }
            int num = Integer.parseInt(ip);
            if(num>255 || String.valueOf(num).length()!= ip.length()){
                return "Neither";
            }
        }
        return "IPv4";
    }

    private String isIP6Arr(String[]  IP6Arr){

        for(String ip : IP6Arr){
            if(ip.length() > 4 || ip.length() <= 0){
                return "Neither";
            }
            for(int i = 0 ;i < ip.length();++i){
                char c = ip.charAt(i);
                if(!Character.isDigit(c) && !( 'a' <= c && c <= 'f') && !('A' <= c && c <= 'F')){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

}
