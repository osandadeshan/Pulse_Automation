echo off
title Pulse Automation
mvn gauge:execute -DspecsDir="specs\specifications\Update time records.spec"
pause

