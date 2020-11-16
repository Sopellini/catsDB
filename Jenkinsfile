timeout(time: 1, unit: 'HOURS') {
    node() {
        checkout scm
        currentBuild.description = "Deployment to DEV workspace"
        env.packageVersion = 1.0//readMavenPom().version
        image = ""
        def stepsToRunBuild = ""
        def stepsToRunDeploy = ""

        environment = "dev"

        stepsToRunBuild = [ipInfo, mavenBuild]
        
        stepsToRunBuild.each { i -> "$i"() }
    }
}

def mavenBuild() {
    stage('Maven build') {
            try {
                    image = docker.image("a206166-filings-jenkins-agent:jenkinsagent_latest")
                    image.inside {
                        withMaven() {
                            sh "mvn clean install"
                        }
                    }
            } catch (ex) {
                error("${ex}")
            }
        }
}

def ipInfo() {
    stage('IP info') {
        sh "echo curl ifconfig.io"
    }
}
