package org.practice.strings;

public class DefangedIpVersion {
    public static void main(String[] args) {
        getDefangedVersionOfIPV1();
        getDefangedVersionOfIPV2();

    }

    private static void getDefangedVersionOfIPV2() {
        String ip = "1.1.1.1";
        String defangedVersionOfIp=getDefangedVersionV2(ip);
        System.out.println(defangedVersionOfIp);
    }

    private static String getDefangedVersionV2(String ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            if(ch=='.'){
                sb.append("[.]");
            }else {
                sb.append(ch);
            }
        }
        return new String(sb);
    }

    private static void getDefangedVersionOfIPV1(){
        String ip = "1.1.1.1";

        String output = ip.replaceAll("\\.","[.]");
        System.out.println(output);

    }
}
