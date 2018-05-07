package com.imooc.curator;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/7
 * Time: 10:56
 */
@Slf4j
public class ZKCurator {

    //zk客户端
    private CuratorFramework client = null;

    public ZKCurator(CuratorFramework client) {
        this.client = client;
    }

    public void init() {
        client = client.usingNamespace("zk-curator-connector");
    }

    public boolean isZKAlive() {
        return client.isStarted();
    }

}
