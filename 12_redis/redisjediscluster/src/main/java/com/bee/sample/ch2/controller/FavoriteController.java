package com.bee.sample.ch2.controller;


import java.util.HashMap;  
import java.util.Map;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.ui.ModelMap;  
import org.springframework.util.StringUtils;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.servlet.ModelAndView;

import com.bee.sample.ch2.XyyRedisTemplate;  
  

  
/**  
 * Favorite控制层  
 * @ClassName: FavoriteController   
 * @author wujing  
 * @date 2017-07-13 15:09:50  
 */  
@RestController  
@RequestMapping("/favorite")  
public class FavoriteController{  
    private static final Logger LOGGER = LoggerFactory.getLogger(FavoriteController.class);  
      

    @Autowired  
    private RedisTemplate redisTemplate;  
    @Autowired  
    private XyyRedisTemplate xyyRedisTemplate;  
      
      
    // http://127.0.0.1:8080/favorite/detail/1
    @RequestMapping("/detail/{id}")  
    public String detail(@PathVariable Long id,ModelMap modelMap) {  
        try {
        	LOGGER.debug(" >>>>> Rdetail is");  
            /*Favorite tempFavorite = (Favorite) memCachedClient.get("favorite:"+id);  
            if(tempFavorite == null) {  
                tempFavorite = favoriteService.selectByPrimaryKey(id);  
                memCachedClient.set("favorite:"+id, tempFavorite);  
            }*/  
            /*ValueOperations<String, Favorite> operations = redisTemplate.opsForValue();  
            Favorite tempFavorite = operations.get("favorite:"+id);  
            if(tempFavorite == null) {  
                tempFavorite = favoriteService.selectByPrimaryKey(id);  
                operations.set("favorite:"+id, tempFavorite);  
            }*/ 
            
            /*ValueOperations<String, String> operations = redisTemplate.opsForValue();
            String value = operations.get("favorite:"+id);  
            if(StringUtils.isEmpty(value)) {   
                xyyRedisTemplate.set("favorite",String.valueOf(id), "leo favorite");  
            }else {  
            	LOGGER.debug("value is" + value);   
            }*/
             

            String value = xyyRedisTemplate.get("favorite1",String.valueOf(id));  
            if(StringUtils.isEmpty(value)) {   
                xyyRedisTemplate.set("favorite1",String.valueOf(id), "leo favorite1");  
            }else {  
            	LOGGER.debug("value is" + value);   
            }
        } catch (Exception e) {
            LOGGER.error("Favorite查询异常", e);  
        	return "falsed";  

        }  
        return "successfu";  
    }  
}  