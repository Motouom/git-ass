#!/bin/bash

while true; do
    echo "Please enter the folder name (or 'quit' to exit):"
    read folder_name
    
    if [[ $folder_name == "quit" ]]; then
        break
    fi
    
    
    if [[ -z $folder_name ]]; then
        echo "Folder name cannot be empty"
        continue
    fi

    
    mkdir  ~/Desktop/$folder_name
	
    echo "Folder '$folder_name' created on the Desktop'!"



	echo "What is your project type?
	1. python
	2. bash
	"

	read response

	#making a choice
	case $response in
		1)

			#entering into the users folder
			cd ~/Desktop/$folder_name

			#installing python3 virtual env
			pip install virtualenv

			#creating a new virtual env
			echo "what is the name of the virtual environment you want to creat"
			read env_name
			virtualenv $env_name

			#activating the virtual environmet
			source $env_name/bin/activate
			;;

		2)

			cd ~/Desktop/$folder_name

			touch README
		;;
	esac
	#asking the user if he wants to carry out a new project.
	echo "do you want to work on a new project (yes/no)?"
	read answer
	case $answer in 
		yes)
			continue
	;;
		no)
			break
	;;
		esac

done
