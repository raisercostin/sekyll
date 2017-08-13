//EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.createSrc := EclipseCreateSrc.All
EclipseKeys.withSource := true
EclipseKeys.eclipseOutput := Some("target2/eclipse")
unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil
unmanagedSourceDirectories in Test := (scalaSource in Test).value :: Nil
//to enable full stacktraces for ScalaTest
testOptions in Test += Tests.Argument("-oF")
