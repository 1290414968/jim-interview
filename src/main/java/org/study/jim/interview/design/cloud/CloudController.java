package org.study.jim.interview.design.cloud;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:18
 * @Description:
 */
public class CloudController {
    private CloudService cloudService;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    public void uploadFile(String name){
        cloudService.uploadFile(name);
    }

    public static void main(String[] args) {
        new CloudController(new CloudService("ali")).uploadFile("test.zip");
    }
}
