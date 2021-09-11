# java-core


# mvn archetype:generate -DgroupId=com.hello -DartifactId=hello-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -Dinteractive=false

cd hello-app

find .

find . -name App.java -exec cat {} \;

mvn package

java -cp target/hello-app-1.0-SNAPSHOT.jar com.hello.App

mvn exec:java -Dexec.mainClass="com.hello.App"
