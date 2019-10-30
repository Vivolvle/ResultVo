# ResultVo
- 自用通用返回类型以及自定义异常
- 跨域还可以通过配置nginx的方式来解决
```
upstream common {
	server 139.196.120.124:9210 weight=1;
	keepalive 32;
    }

server {
    # 监听 80 端口
    listen 80;
    autoindex on;
    server_name test.vivolvle.cn;
    location / {
	root html;  
        index index.html;
    }
    ### 跨域配置
    location ^~ /adapter/ {
	add_header Access-Control-Allow-Origin *;
    	add_header Access-Control-Allow-Methods 'GET, POST, OPTIONS';
    	add_header Access-Control-Allow-Headers 'DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Authorization';	
	
	proxy_pass      http://common;
        client_max_body_size  2m;
    }
}

```
