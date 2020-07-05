#! /bin/bash

# add to secrets and remove
BOT_ID=576734993:AAFhJQALvnwzXR8ZWlLGkRaZePlUcGGwMmA
CHAT_ID=-1001174776301

curl -X POST https://api.telegram.org/bot${BOT_ID}/sendMessage -d chat_id=${CHAT_ID} \
-d "text=<${GITHUB_ACTOR}> successfully pushed branch <${GITHUB_REF##*/}>"
