#!/usr/bin/env bash
#if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
#    openssl aes-256-cbc -K $encrypted_64f39d4087b6_key -iv $encrypted_64f39d4087b6_iv -in scripts/continuous-integration/codesigning.asc.enc -out scripts/continuous-integration/codesigning.asc -d
#    gpg --fast-import scripts/continuous-integration/signingkey.asc
#fi

if [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    echo "decrypting certificate"
    openssl aes-256-cbc -K $encrypted_64f39d4087b6_key -iv $encrypted_64f39d4087b6_iv -in scripts/continuous-integration/codesigning.asc.enc -out scripts/continuous-integration/codesigning.asc -d
    gpg --batch --import scripts/continuous-integration/codesigning.asc
fi