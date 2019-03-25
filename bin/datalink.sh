#!/usr/bin/env bash

#if [ -z "${SPARK_HOME}" ]; then
#
#fi

#SPARK_HOME=

CLASSPATH=
for i in $(ls `pwd`/lib/*.jar)
do
  CLASSPATH="${CLASSPATH}:${i}"
done

CLASS="io.dxer.datalink.spark.DataLinkSparkApp"

${SPARH_HOME}/bin/spark-submit --class "${CLASS}" --jars ${CLASSPATH}  "$@"

