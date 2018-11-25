package org.study.jim.interview.design.cloud;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:24
 * @Description:
 */
public class AliSdkAdapter implements  CloudSDK{
    AliSDK aliSDK;

    public AliSdkAdapter(AliSDK aliSDK) {
        this.aliSDK = aliSDK;
    }

    @Override
    public void putObject(String name) {
        aliSDK.setBuzz();
        aliSDK.doUpload(name);
    }
}
