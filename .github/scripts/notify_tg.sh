#! /bin/bash

# add to secrets and remove
BOT_ID=576734993:AAFhJQALvnwzXR8ZWlLGkRaZePlUcGGwMmA
CHAT_ID=-1001174776301

BRANCH_NAME=${GITHUB_REF##*/}
curl -X POST https://api.telegram.org/bot${BOT_ID}/sendMessage -d chat_id=${CHAT_ID} \
-d "text=\`${GITHUB_ACTOR}\` *successfully* __pushed__ branch [${BRANCH_NAME//-/\\-}](https://github.com/${GITHUB_REPOSITORY}/tree/${BRANCH_NAME//-/\\-})" -d parse_mode=MarkdownV2
