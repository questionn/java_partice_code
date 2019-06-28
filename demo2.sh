#! /bin/sh
# backup.sh

#备份目录函数
backupdir(){
	dirtest
	echo "Backupping..."
	tar zcvf /tmp/backup.tar.gz $DIRECTORY
}

#恢复目录函数
restoredir(){
	dirtest
	echo "Restroing..."
	tar xzvf /tmp/backup.tar.gz
}

#验证目录函数
dirtest(){
	#输入要备份的目录名
	echo -e "Please enter the directory name of backup file:\c"
	#读目录名
	read DIRECTORY
	#判断是否是目录
	if [ ! -d $DIRECTORY ];	then
		echo "Sorry, $DIRECTORY is not a directory!"
		exit 1
	fi
	cd $DIRECTORY
}

clear
ANS=Y
while [ $ANS = Y -o $ANS = y ]
do
	echo "=============================="
	echo "=    Backup-Restore Menu     ="
	echo "=============================="
	echo "++++++++++++++++++++++++++++++"
	echo "+   1:Backup Directory       +"
	echo "+   2:Restore Directory      +"
	echo "+   0:Exit		   +"
	echo "++++++++++++++++++++++++++++++"
	echo -e "Please enter a choice(0--2):\c"

	read CHOICE
	case "$CHOICE" in
		1) backupdir;;
		2) restoredir;;
		0) exit 1;;
		*) echo "Invalid Choice!"
			exit 1;;
	esac
	if [ $? -ne 0 ];then
		echo "Program encounter error!"
		exit 2
	else
		echo "Operate successfully"
	fi
	echo -e "Would you like to continu? Y/y to continue,any other key to exit:\c"
	read ANS
	clear
done
