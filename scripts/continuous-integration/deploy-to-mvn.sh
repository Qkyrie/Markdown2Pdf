#!/usr/bin/env bash
#if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
#    mvn deploy -P sign,build-extras --settings scripts/continuous-integration/mvnsettings.xml
#fi

if [ "$TRAVIS_BRANCH" = 'master' ] &&  [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    echo "deploying to maven repo"
    mvn deploy -P sign,build-extras --settings scripts/continuous-integration/mvnsettings.xml
fi