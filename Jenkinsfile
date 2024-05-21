pipeline{
    agent any
    stages{
        stage('Test'){
            steps{
                echo "Hello World..!!"
                
            }

        }
        stage('Shell command'){
            steps{
                
                script{
                    sh 'mkdir sample'
                    sh 'if [ echo $? == 0 ] then {
                          echo "Command ran successfully"
                          break
                        }
                        else {
                          echo "Command failed" }'

                }
            }
        }
    }
}
