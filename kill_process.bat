for /f "skip=1 usebackq" %%h in (`wmic process where "commandline like '%%site.Bootstrap'" get processid ^| findstr .`) do taskkill /F /T /PID %%h
