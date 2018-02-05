package com.bee.sample.ch2; 
  
import java.util.HashSet;  
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;  
import org.springframework.context.annotation.Configuration;  
  
import redis.clients.jedis.HostAndPort;  
import redis.clients.jedis.JedisCluster;  
  
/**  
 * 生成JedisCluster对象  
 * @ClassName: JedisClusterConfig   
 * @author wangqinghua  
 * @date 2017年7月24日 下午7:08:03  
 */  
@Configuration  
public class JedisClusterConfig {  
	private static final Logger LOGGER    = LoggerFactory.getLogger(JedisClusterConfig.class);  
	
    @Value("${jedis.master.host}")
    private String host;
    @Value("${jedis.master.port}")
    private int port;
    @Value("${jedis.master.MinIdle}")
    private int minIdle;
    
    @Value("${jedis.cluster.connectionTimeout}")
    private int connectionTimeout;   
    @Value("${jedis.cluster.maxAttempts}")
    private int maxAttempts;  
    @Value("${jedis.cluster.soTimeout}")
    private int soTimeout;    
    @Value("${jedis.cluster.password}")
    private String password;
    
    
    
    @Bean  
    //@Singleton
    public JedisCluster getJedisCluster() {  
    	LOGGER.debug(">>>>> getJedisCluster. jedis.master.host is" + host  + "  jedis.master.port is: " + port);   
        HostAndPort node  = new HostAndPort(host, port);
        
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig(); 
        // 设置 poolConfig 参数
        poolConfig.setMinIdle(minIdle);
        
        return new JedisCluster(node, connectionTimeout, soTimeout, maxAttempts, password, poolConfig);  
    }
  
}  