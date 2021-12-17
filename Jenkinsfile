node {
   def mvnHome
   def workspace = pwd()
   def project_name = 'demo-0.0.1-SNAPSHOT.jar'
   def new_project_name = 'demo.jar'
   def project_home = '/var/lib/jenkins/workspace/jenkinsDemo'
   //代码获取
   stage('Preparation') { // for display purposes
	  git branch: 'master',
	  url:'https://gitee.com/a-three/JenkinsDemo'
   }
   //构建
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "mvn -Dmaven.test.skip=true clean package"

      } else {
         bat(/mvn -Dmaven.test.skip=true clean package/)
      }
   }

   //移动
   stage('MV') {
     sh "mv ${project_home}/target/${project_name} /jenkins/jars/${new_project_name}"
   }

   //上传到服务器
//    stage('Upload VM') {
//      sh "scp -P ${vm_port} /usr/local/src/${project_name} ${vm_user}@${vm_port}:/usr/local/src/bk"
// 	 sh "ssh -p ${vm_port} ${vm_user}@${vm_ip} 'nohup java -jar /usr/local/src/${project_name} >> ${project_log} '"
//    }


  //运行JAR包
  stage('Run') {
	 //sh "if (ps -ef| grep java|grep ${project_name})then (ps -ef| grep java|grep ${project_name}| awk '{print \$2}'|xargs kill -9) fi"
     sh " 'nohup java -jar /jenkins/jars/${new_project_name}  &'"
  }
}