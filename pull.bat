@echo off
REM カレントディレクトリをこのbatファイルの居る場所に変更
cd /d %~dp0

git -C .\ pull origin master

pause
exit
