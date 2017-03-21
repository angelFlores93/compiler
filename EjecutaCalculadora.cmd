echo off
echo #######################################################
echo Changing to src folder..
cd src
echo Done
echo Running  Calculator   on (someFile.exp)
echo on
java -ea -cp .;..\introspector.jar Main ..\entrada.exp 
echo off
echo Done
Pause
exit

