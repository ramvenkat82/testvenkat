#!/usr/bin/env groovy
node{

    echo "Hello World from SCM"

    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'e67e3571-8b1b-4399-ad87-8e88f135cee6', url: 'https://ramvenkat82@github.com/ramvenkat82/testvenkat.git']]])

}