#!/usr/bin/env bash

#if [ -z "${SPARK_HOME}" ]; then
#
#fi

SPARK_HOME=

CLASSPATH=
for i in $(ls `pwd`/lib/*.jar)
do
  CLASSPATH="${CLASSPATH}:${i}"
done

${SPARH_HOME}/bin/spark-submit --master local[*] --jars ${CLASSPATH} $@   \
  --class io.dxer.datalink.spark.DataLinkSparkApp  $@

