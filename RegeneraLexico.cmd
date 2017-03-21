echo off
echo ########################################################
echo Changing to src...
cd src
echo Done
del lexico\*.java lexico\*.class
echo generating Scaner... (Call to Jflex)
echo on
java -cp ../JFlex.jar JFlex.Main -d lexico lexico\lexico.flex
echo off
echo Done
echo ########################################################
Pause
exit


