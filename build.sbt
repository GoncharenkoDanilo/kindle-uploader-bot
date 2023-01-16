name := "kindle-uploader-bot"

version := "0.0.1"

lazy val `kindle-uploader-bot` = (project in file(".")).enablePlugins(JavaAppPackaging, DockerPlugin)

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.bot4s" %% "telegram-akka" % "5.6.2",
  "dev.zio" %% "zio" % "2.0.5",
  "dev.zio" %% "zio-logging" % "2.1.7",
  "io.d11" %% "zhttp" % "2.0.0-RC11",
  "org.asynchttpclient" % "async-http-client" % "2.12.3",
  "dev.zio" %% "zio-interop-cats" % "23.0.0.0",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.8.8",
  "dev.zio" %% "zio-config" % "3.0.7",
 "dev.zio" %% "zio-config-typesafe" % "3.0.7",
  "dev.zio" %% "zio-config-magnolia" % "3.0.7"
)

Universal / javaOptions ++= Seq(
  "-Dpidfile.path=/dev/null"
)

dockerBaseImage := "openjdk:11.0.15-jdk-oraclelinux8"
dockerUpdateLatest := true
dockerExposedPorts := Seq(9000)