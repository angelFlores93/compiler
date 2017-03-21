echo off
echo ########################################################
echo Changing to src...
cd src
echo Done
del sintactico\*.java sintactico\*.class
echo Changing to sintactico ...
cd sintactico
echo Done
echo generating Parser... (Call to yacc)
echo on
..\..\yacc -J -v -Jpackage=sintactico -Jclass=Sintactico -Jsemantic=Object sintactico.y
echo off
echo  Done
Pause
exit
