package com.xiaomin.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RoundRule_XM extends AbstractLoadBalancerRule {

	private int total = 0;//执行几次
	private int currentIndex = 0; // 当前机器
	
	@Override
	public Server choose(Object key) {
		ILoadBalancer lb = getLoadBalancer(); // 获取负载均衡接口对象
		if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers(); // 获取可用的服务列表
            List<Server> allList = lb.getAllServers(); // 获取所有列表

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);
            if (total < 5) {
            	server = upList.get(currentIndex);
            	total++;
			} else {
				currentIndex++;
				total = 0;
				// 机器下标不能大于机器数
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

            // 未找到服务，等待
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            // 是否可用
            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}

}
