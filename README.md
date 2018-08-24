# EasyETL
> With just a few lines of SQL code you can effortlessly import/export data and complete other ETL operations.


对SparkSQL原支持的sql语法进行扩展，支持`Load`，`QueryASTable`、`InsertInto`、`FileOperator`等操作。通过编写sql语句的方式来完成ETL相关操作。

## Connect

数据库连接

- name：连接名称，供后面使用
- properties：
  - driver：数据库驱动
  - url：访问数据库url
  - user：访问数据库的用户名
  - password：访问数据库的密码


```
# 创建connect
create connect oracle (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@192.168.132.149:1521:dcdb12', user='admin', password='admin'）;

# 删除connect
drop connect oracle;
```



##  Load

加载数据到临时表，支持如下格式数据

- parquet：列式存储格式文件
- json：json格式文件
- csv/tsv/text：csv格式文件
  - delimiter：指定分隔符,csv默认分隔符为","，tsv默认分隔符为"\t"，text需要自定义
  - header：是否设置头部信息
  - inferSchema：推断数据类型
  - colNames：指定列名，中间使用`","`进行分割
- jdbc：理论支持所有可以通过jdbc方式访问的数据库，需要提供jdbc驱动
  - driver：数据库驱动
  - url：访问数据库url
  - user：访问数据库的用户名
  - password：访问数据库的密码

例子：

```sql
#
load oracle.`ods.t_province_code` as ttt;

# Pushdown模式
load oracle.`(select * from hadoop.t_province_code where P_CODE>'791') t_province_code_alias` as t_province_code;

# parquet文件(hdfs)
load parquet.`/user/hadoop/flow.snappy.parquet` as tmp_flow;

# json文件(local)
load local json.`/home/hadoop/test/111/t_province_code.json` as t_province_code;
```



## QueryASTable

支持将sql执行后的结果转成临时表

例子：

```
select * from hadoop.t_flow limit 10 as tmp_flow;
```



## InsertInto

将表中数据进行持久化，支持如下方式：

- hive：将数据保存到临时表
- jdbc：将数据保存到关系型数据库
  - driver：数据库驱动
  - url：访问数据库url
  - user：访问数据库的用户名
  - password：访问数据库的密码
- csv/tsv/text：将数据保存到csv/tsc/text文件，可以设置以下参数
  - delimiter：指定分隔符
  - header：是否设置头部信息
  - colNames：指定列名，中间使用`","`进行分割
- json：将数据保存到json文件
- parquet：将数据保存到parquet文件，列式存储

例子：

```sql
# 将表中数据导入到本地文件中
insert into local json.`file:////home/hadoop/flow` from tmp_flow;

# 将表中数据导入到hdfs中
insert overwrite json.`/user/hadoop/flow/` from tmp_flow;

```



## FileOperator

HDFS相关操作

- put：上传文件
- get：下载文件
- del：删除文件
- ...

例子：

```sql
put src to dest;
put src overwrite dest;
get src to dest;
get src overwrite dest;
del src;
```



## 常规sql支持

多条sql中每条sql使用";"结束，并加上换行。

## 使用

```sql
spark2-submit --master yarn --deploy-mode client --class io.dxer.etl.ETLApp /home/womusic/app/dxer-etl-1.0-SNAPSHOT.jar -e "
select * from haifeng.wo_flow limit 10 as tmp_wo_flow;
save tmp_wo_flow as json.`/user/womusic/222`;"
```
