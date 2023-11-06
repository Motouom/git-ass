#!/bin/bash

while true; do
    echo "Please enter the folder name (or 'quit' to exit):"
    read folder_name
    
    if [[ $folder_name == "quit" ]]; then
        break
    fi
    
    
    if [[ -z $folder_name ]]; then
        echo "Folder name cannot be empty. Please try again."
        continue
    fi
    
    mkdir  ~/Desktop/$folder_name
    echo "Folder '$folder_name' created on the Desktop'!"
