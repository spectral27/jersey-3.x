docker run --name mysqldocker \
--restart always \
-d -p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=dtb \
mysql
