# goggles

[![Join the chat at https://gitter.im/yakticus/goggles](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/yakticus/goggles?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

A scala.js library for creating visualizations using SVG

Initial implementation uses D3 underneath

## include in your build

```
"com.yakticus" %%% "goggles" % "0.1-SNAPSHOT"
```

Make sure to include sonatype snapshot repo:

```
resolvers += Resolver.sonatypeRepo("snapshots")
```

## examples

```
$ sbt
> project examples
> ~fastOptJS
```

Navigate in your browser to:

`http://localhost:12345/examples/target/scala-2.11/classes/index-dev.html`

You can browse the examples under the `examples` subproject.