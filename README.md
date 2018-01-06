#Spring-Boot-2.0-Samples

《Spring Boot 2精髓：从构建小系统到架构分布式大系统》
配套代码



约定优先， 有很多约定的值
https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html



启动时，默认是8080 端口， 可以通过 application.yml 进行配置





curl 用于测试验证：
-d  参数   发起post 请求
curl "http://127.0.0.1:8080/javabean/update3.json" -d "id=12&name=jack"


-H  设置请求的http 头， 
curl "http://127.0.0.1:8080/javabean/update3.json" -d "id=12&name=jack" -H “Content-Type: application/json”

post 内容需要转义， 比如中文字符， 空格等， 可以使用--data-urlencode
curl "http://127.0.0.1:8080/javabean/update3.json"  --data-urlencode  "id=12&name=中文"

-G 发起get
curl -G "http://127.0.0.1:8080/javabean/update3.json"  --data-urlencode  "id=12&name=中文"

-XPUT 发起 put协议
curl -G "http://127.0.0.1:8080/javabean/update3.json"  --data-urlencode  "id=12&name=中文"

-F 上传文件
curl  "http://127.0.0.1:8080/javabean/update3.json"  -F "file=@xxxx.doc" -F "name=leo"







