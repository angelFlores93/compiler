echo off
echo ########################################################
echo Changing  to src 
cd src
echo Done
echo  Compiling  all...
echo on
REM javac      -cp .;..\introspector.jar   lexico\*.java  sintactico\*.java  asttree\*.java  Main.java
REM javac   -source 1.6 -target 1.6   -cp .;   lexico\*.java  sintactico\*.java  asttree\*.java  Main.java
"C:\Program Files\Java\jdk1.7.0_75\bin\javac"   -cp .;..\introspector.jar lexico\*.java  sintactico\*.java  asttree\*.java  Main.java
echo off
echo Done
cd ..
Pause
exit