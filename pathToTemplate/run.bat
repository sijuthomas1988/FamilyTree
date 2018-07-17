@echo off

@REM The script path to reference the included JRE java file
SET SCRIPT_PATH="%JAVA_HOME%"

:APPEND_CLASSPATH
SET CLASSPATH="..\familytree.jar"

%SCRIPT_PATH%\jre\bin\java -classpath %CLASSPATH% com.project.acceptor.Application %*