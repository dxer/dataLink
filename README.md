# DataLink
> With just a few lines of SQL code you can effortlessly import/export data and complete other ETL operations.

DataLink是一个基于**Spark+SparkSQL**实现的Spark应用程序，实现了对SparkSQL原生sql语法的扩展，增加了`LoadTable`，`QueryASTable`、`InsertInto`等操作的支持，可以通过编写sql语句的方式来完成ETL操作。

## 编译

1. clone项目
```bash
git clone https://github.com/dxer/dataLink.git
```

2. 编译
```bash
cd dataLink
mvn clean package -Dmaven.test.skip=true 
# 或
mvn clean package
```

##  运行方式

支持三种运行模式，在运行时，只能指定一种运行模式：

- `-e`：直接运行
- `-f`：运行sql脚本

```sql
# -e模式
./datalink.sh -e "select phone from t_app_userinfo as user;"

# -f模式
./datalink.sh -f /home/hadoop/app/etl.sql
```

## 基本语法
```sql
-- 将csv文件加载到spark临时表
load data csv.`/home/vagrant/data/test.csv` as test;

-- 对test表进行操作
select * from test;
select sum(_c0) from test;
select count(1) from test;

-- 将test表数据以parquet格式导出到本地
insert overwrite local parquet.`/tmp/test` from test;

-- 将txt文本文件导入到表中，并配置grok对每行数据进行解析
load data txt.`/data/user.txt` options(grok.compile.pattern='%{name:name};%{age:age}',grok.add.pattern.name='.*', grok.add.pattern.age='\d+') as user;
select max(cast (age as int)) as maxAge from test;
```

## SQL扩展

### Connection相关操作
创建相关连接（JDBC）配置，供后续使用，支持创建临时connection（会话级别）和永久的connection配置信息，会将connection信息保存到zookeeper中，供不同的应用使用

**语法**

```mysql
create [temporary] connection <ConnectionType>.<name> (key=value);
```

相关参数解释：

- connectionType：connection类别
  - jdbc：jdbc类

- name：连接名称，供后面使用
- properties：
  - driver：数据库驱动
  - url：访问数据库url
  - user：访问数据库的用户名
  - password：访问数据库的密码


```mysql
-- 创建connection
create connection jdbc.oracle (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@192.168.1.101:1521:dcdb', user='test', password='test');

-- 创建临时connection
create temporary connection jdbc.oracle (driver='oracle.jdbc.driver.OracleDriver', url='jdbc:oracle:thin:@192.168.132.149:1521:dcdb', user='admin', password='admin');

-- 删除connection
drop connection jdbc.oracle;

-- 查看具体connection配置信息
show create connection jdbc.oracle;

-- 查看所有connections
show connections;
```



###  Load

加载数据到临时表

**语法**

```sql
load [local] <format>.<path> options(key=value) as <table>
```

相关参数解释：
- local：可选，设置local，表示将本地文件加载到临时表中，否则是hdfs中相关路径下的文件
- format：数据源格式，支持如下格式：
  - parquet：列式存储格式文件
  - json：json格式文件
  - csv/tsv：csv格式文件
    - delimiter：指定分隔符,csv默认分隔符为","，tsv默认分隔符为"\t"，text需要自定义
    - header：是否设置头部信息
    - inferSchema：推断数据类型
    - colNames：指定列名，中间使用`","`进行分割
  - txt: 文本文件
    - grok.compile.pattern：grok解析
    - grok.add.pattern.[pattern-name]: 添加grok pattern
  - jdbc：理论支持所有可以通过jdbc方式访问的数据库，需要提供jdbc驱动
    - driver：数据库驱动
    - url：访问数据库url
    - user：访问数据库的用户名
    - password：访问数据库的密码
  - hive：hive表
  - hbase：
    - hbase.zookeeper.quorum：zookeeper地址
    - spark.hbase.columns.mapping：hbase表和spark表列映射关系，可替代`spark.table.schema`和`hbase.table.schema`
    - hbase.table.name：hbase数据源表名
    - spark.table.name：加载的spark表名
    - spark.table.schema：加载的spark表的schema，需要与`hbase.table.schema`对应，并同时配置
    - hbase.table.schema：被加载的hbase表的schema，需要与`spark.table.schema`对应，并同时配置
- properties：对数据源的信息的补充，key/vaule键值对，如：a='b'
- table：目标表

例子：

```sql
# 通过connection加载数据到临时表
load oracle.`ods.t_province_code` as test;

# Pushdown模式
load oracle.`(select * from hadoop.t_province_code where P_CODE>'791') t_province_code_alias` as t_province_code;

# parquet文件(hdfs)
load parquet.`/user/hadoop/flow.snappy.parquet` as tmp_flow;

# json文件(local)
load local json.`/home/hadoop/test/111/t_province_code.json` as t_province_code;
```



### QueryASTable

将sql执行后的结果转成spark临时表

**语法**

```mysql
<select sql> as tmp_table
```

例子：

```sql
-- 将hive表加载到临时表
select * from hadoop.t_flow limit 10 as tmp_flow;
```



### InsertInto

将表中数据进行持久化

**语法：**

```mysql
insert [savemode] [local] <format>.<path> [properties] from <table | sql>
```
相关参数解释：
- saveMode：主要
  - overwrite：覆盖
  - append：追加
  - into：追加插入，默认
- local：将数据持久化到本地
- format：持久化的类型，支持如下类型：
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
  - hbase：将数据保存到hbase中

    - hbase.zookeeper.quorum：zookeeper地址
    - spark.hbase.columns.mapping：hbase表和spark表列映射关系，可替代`spark.table.schema`和`hbase.table.schema`
    - hbase.table.name：hbase数据源表名
    - spark.table.name：加载的spark表名
    - spark.table.schema：加载的spark表的schema，需要与`hbase.table.schema`对应，并同时配置
    - hbase.table.rowkey.field：指定rowkey所对的列，不设置的话，会自动去寻找名为`rowkey`的列
    - hbase.table.schema：被加载的hbase表的schema，需要与`spark.table.schema`对应，并同时配置
    - bulkload.enable：是否启用bulkload模式，默认不启动，当要插入的hbase表只有`rowkey`列的时候，必须启动
    - hbase.check.table：检查hbase表是否存在，默认`false`，在设置`true`的时候，如果hbase的表不存在，则会创建
    - hbase.table.family：列族名，默认为`info`
    - hbase.table.region.num：分区个数
    - hbase.table.startkey：预分区开始的key，当hbase表不存在的时候，需要创建hbase表时启用
    - hbase.table.endkey：预分区结束的key
- path：
- 
    例子：

```sql
# 将表中数据导入到本地文件中
insert into local json.`file:////home/hadoop/flow` from tmp_flow;

# 将表中数据导入到hdfs中
insert overwrite json.`/user/hadoop/flow/` from tmp_flow;

```


## 使用

```sql
sh datalink.sh -e "
load data txt.\`/data/user.txt\` 
options(grok.compile.pattern='%{name:a};%{age:b}', grok.add.pattern.name='.*', grok.add.pattern.age='\d+') as user;
select * from user;
select max(cast (age as int)) as maxAge from test;
"
```

## TODO
- 支持文件相关操作
