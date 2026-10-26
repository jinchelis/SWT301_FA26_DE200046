@echo off
setlocal
chcp 65001 >nul

pushd "%~dp0"

set "MVN_CMD=mvn"
if exist "mvnw.cmd" set "MVN_CMD=.\mvnw.cmd"

echo ===== Running Selenium tests =====
call %MVN_CMD% clean test -Dheadless=true %*
set "TEST_EXIT=%ERRORLEVEL%"

echo ===== Generating HTML report =====
call %MVN_CMD% surefire-report:report-only -DlinkXRef=false
set "REPORT_EXIT=%ERRORLEVEL%"

if exist "target\reports\surefire.html" (
    start "" "target\reports\surefire.html"
) else if exist "target\site\surefire-report.html" (
    start "" "target\site\surefire-report.html"
) else (
    echo HTML report was not generated.
)

if exist "target\screenshots" (
    echo Screenshots: target\screenshots
)

popd

if not "%TEST_EXIT%"=="0" exit /b %TEST_EXIT%
exit /b %REPORT_EXIT%