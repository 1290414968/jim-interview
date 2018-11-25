package org.study.jim.interview.design.cloud;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:24
 * @Description:
 */
public class AWSSdkAdapter implements  CloudSDK{
    AWSSDK awssdk;
    public AWSSdkAdapter(AWSSDK awssdk) {
        this.awssdk = awssdk;
    }
    @Override
    public void putObject(String name) {
        awssdk.putObject(name);
    }
}
