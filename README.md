# This forked version was built for renaming operation of json key fields without chancing the value fields

Sample Usage:

> { "op": "rename", "path": "/oldname", "newkey": "newname" }

Base project is here:

https://github.com/java-json-tools/json-patch

## Versions

The current version is **1.11**.

## Using it in your project

With Gradle:

```groovy
dependencies {
    compile(group: "com.github.utekau", name: "json-patch", version: "1.11");
}
```

With Maven:

```xml
<dependency>
    <groupId>com.github.utekau</groupId>
    <artifactId>json-patch</artifactId>
    <version>1.11</version>
</dependency>
```
