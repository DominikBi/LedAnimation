#!/usr/bin/env bash
project="DominikBi/LedAnimation"
folder="/home/$(whoami)/.LedAnimation"
txt="${folder}/version.txt"

if [[ ! -e "${txt}" ]]; then
    mkdir -p "${folder}"
    touch "${txt}"
fi

rm -f "${folder}/bin.zip"

current=$(cat ${txt})
echo "Currently installed version is: ${current:-No Version installed locally}"

latest=$(curl -s "https://api.github.com/repos/${project}/releases/latest" \
| grep "tag_name" \
| cut -d : -f 2,3 \
| tr -d " " \
| tr -d "\"" \
| tr -d ",")
if [[ "$latest" = "" ]]; then
    echo Failed fetching latest version
elif [[ ${latest} != ${current} ]]; then
    echo "Latest version is ${latest}"
    if [[ "$current" = "" ]]; then
        echo "No local version installed! Installing version ${latest}"
    else
        echo "Upgrading to version ${latest}"
    fi
    url="https://api.github.com/repos/${project}/releases/tags/${latest}"
    echo "Downloading from ${url}..."
    binary=$(curl -s ${url} \
    | grep "browser_download_url.*zip" \
    | cut -d : -f 2,3 \
    | tr -d " " \
    | tr -d "\"")
    echo "Downloading binary from ${binary}..."
    if ! wget -q -P "${folder}" ${binary}; then
        echo "Download failed"
        exit 1
    fi
    echo ${latest} >> ${txt}

    rm -fv "${folder}/app.jar"
    rm -rfv "${folder}/bin/"
    rm -rfv "${folder}/web/"

    echo "Unpacking archive..."
    unzip -uq -d ${folder} "${folder}/bin.zip"
    rm "${folder}/bin.zip"

    echo "Successfully installed version ${latest}"
fi
echo "Starting Java Application"
java -Dmosaik.appname="LedAnimation" -jar "${folder}/app.jar"
