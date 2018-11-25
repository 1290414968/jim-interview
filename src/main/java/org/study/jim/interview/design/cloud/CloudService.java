package org.study.jim.interview.design.cloud;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:18
 * @Description:
 */
public class CloudService {
    private CloudSDK cloudSDK;
    public CloudService(String cloudSDK) {
        this.cloudSDK = SdkFactory.create(cloudSDK);
    }
    public void uploadFile(String name) {
        cloudSDK.putObject(name);
    }
}
