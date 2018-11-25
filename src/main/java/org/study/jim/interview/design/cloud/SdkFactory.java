package org.study.jim.interview.design.cloud;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:27
 * @Description:
 */
public class SdkFactory {
    private static Map<String,CloudSDK> sdkMap = new ConcurrentHashMap<>();
    static {
        sdkMap.put("ali",new AliSdkAdapter(new AliSDK()));
        sdkMap.put("aws",new AWSSdkAdapter(new AWSSDK()));
    }
    public static CloudSDK create(String sdkName){
        return sdkMap.get(sdkName);
    }
}
