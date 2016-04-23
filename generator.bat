:: rmdir /s /q src\com\sang\topic\data
:: rmdir /s /q src\com\sang\topic\model
 java -jar web/WEB-INF/lib/mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite

