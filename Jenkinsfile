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
                    sh 'mkdir BUILD'
                    sh '''if [ $? -eq 0 ]; then 
                          echo "Command ran successfully"
                          
                        
                        else 
                          echo "Command failed" 
                         fi '''

                }
            }
        }
    }
}
