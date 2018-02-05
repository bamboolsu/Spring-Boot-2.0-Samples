package com.bee.sample.ch2;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;  
  
import redis.clients.jedis.JedisCluster;  
  
/**  
 * 自定义redisTemplate  
 * @ClassName: XyyRedisTemplate   
 * @author wangqinghua  
 * @date 2017年7月24日 下午7:09:49  
 */  
@Component  
public class XyyRedisTemplate {  
    private static final Logger LOGGER    = LoggerFactory.getLogger(XyyRedisTemplate.class);  
  
    @Autowired  
    private JedisCluster        jedisCluster;  
  
  
    private static final String KEY_SPLIT = ":"; //用于隔开缓存前缀与缓存键值   
  
    /**  
     * 设置缓存   
     * @param prefix 缓存前缀（用于区分缓存，防止缓存键值重复）  
     * @param key    缓存key  
     * @param value  缓存value  
     */  
    public void set(String prefix, String key, String value) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
        LOGGER.debug("RedisUtil:set cache key={},value={}", prefix + KEY_SPLIT + key, value); 
        jedisCluster.set(prefix + KEY_SPLIT + key, value);  
 
    }  
  
    /**  
     * 设置缓存，并且自己指定过期时间  
     * @param prefix  
     * @param key  
     * @param value  
     * @param expireTime 过期时间  
     */  
    public void setWithExpireTime(String prefix, String key, String value, int expireTime) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
    	LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,  
                expireTime);  
        jedisCluster.setex(prefix + KEY_SPLIT + key, expireTime, value);  
        
    }  
  
    /**  
     * 设置缓存，并且由配置文件指定过期时间  
     * @param prefix  
     * @param key  
     * @param value  
     */  
    public void setWithExpireTime(String prefix, String key, String value) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
        int EXPIRE_SECONDS = Integer.valueOf("${jedis.master.connectionTimeout}");  
    	LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", prefix + KEY_SPLIT + key, value,  
                EXPIRE_SECONDS);  
        jedisCluster.setex(prefix + KEY_SPLIT + key, EXPIRE_SECONDS, value);  
        
    }  
  
    /**  
     * 获取指定key的缓存  
     * @param prefix  
     * @param key  
     */  
    public String get(String prefix, String key) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
        String value = jedisCluster.get(prefix + KEY_SPLIT + key);  
        LOGGER.debug("RedisUtil:get cache key={},value={}", prefix + KEY_SPLIT + key, value);  
        return value;  
    }  
  
    /**  
     * 删除指定key的缓存  
     * @param prefix  
     * @param key  
     */  
    public void deleteWithPrefix(String prefix, String key) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
    	LOGGER.debug("RedisUtil:delete cache key={}", prefix + KEY_SPLIT + key);  
        jedisCluster.del(prefix + KEY_SPLIT + key);  
        
    }  
      
    public void delete(String key) {  
    	LOGGER.debug(" >>>>> Rdetail is");  
    	LOGGER.debug("RedisUtil:delete cache key={}", key);  
        jedisCluster.del(key);  
        
    }  
  
}  
