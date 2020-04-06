@echo off
setlocal enableextensions
pushd %~dp0

if exist ..\library del ..\library

cd ..
call gradlew shadowJar

if exist ..\library del ..\library /Q

cd build\libs

if exist ..\library del ..\library

for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

java -jar %jarloc% < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test

FC ACTUAL.TXT EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!