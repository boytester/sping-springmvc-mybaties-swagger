#!/bin/bash
num=0
int=1
flag="spring.datasource.url=jdbc:mysql"
size=0
param="spring.datasource.url=jdbc:mysql://10.100.111.5:3306/jgcrm_test?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
cd /usr/local/tomcat/webapps/jgcrm/WEB-INF/classes
for row in $(wc -l application-test.properties)
    do 
      num=$row
      break      
    done

 while(($int<=$num))
    do
     r=$(sed -n "${int}p" application-test.properties | grep "${flag}")
       
       size=${#r}
      if [ 0 == $size ]; then
        let "int++" 
      else
         sed -i "${int}d" application-test.properties
         echo $param >> application-test.properties
         break 
      fi

    done
echo "spring.profiles.active=test" > application.properties
