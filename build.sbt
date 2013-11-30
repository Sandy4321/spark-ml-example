name := "spark ml examples"

version := "0.0.1"

scalaVersion := "2.9.3"

// additional libraries
libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.7.5",
  "com.google" % "bitcoinj" % "0.10",
  "com.sagesex" %% "json-rpc-client" % "0.0.1",
  "org.scala-lang" % "scala-actors" % "2.9.3",
  "org.apache.spark" %% "spark-core" % "0.8.0-incubating",
  "com.snowplowanalytics"  %% "scala-maxmind-geoip"  % "0.0.5",
)

resolvers ++= Seq(
   "JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
   "Spray Repository" at "http://repo.spray.cc/",
   "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
   "Akka Repository" at "http://repo.akka.io/releases/",
   "Twitter4J Repository" at "http://twitter4j.org/maven2/",
   "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
   "SnowPlow Repo" at "http://maven.snplow.com/releases/",
   "Twitter Maven Repo" at "http://maven.twttr.com/",
   "bitcoinj" at "http://distribution.bitcoinj.googlecode.com/git/releases",
   "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools"
)

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
    case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
    case PathList("org", "apache", xs @ _*) => MergeStrategy.first
    case PathList("org", "jboss", xs @ _*) => MergeStrategy.first
    case "about.html"  => MergeStrategy.rename
    case "reference.conf" => MergeStrategy.concat
    case _ => MergeStrategy.first
  }
}
