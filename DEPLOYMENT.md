# Deploying the project

This document is intended for maintainers of this repository. 

## Pre-requisites for Maven Central deployments

- an account at https://oss.sonatype.org/ 
- `settings.xml` for Maven configured with a server block with id `ossrh` (see example below)
- a gpg key with signing capabilities (preferrably a subkey). If you want to select a specific (sub)key you can use a Maven profile

### settings.xml
```xml
<server>
  <id>ossrh-central</id>
  <username>user</username>
  <password>password</password>
</server>
<!-- (...) -->
<profiles>
    <profile>
        <id>minify-signing</id>
        <properties>
            <gpg.keyname>ABCDEFGH!</gpg.keyname>
        </properties>
    </profile>
</profiles>
```
### Checking if signing with gpg works

You can execute `mvn -P minify-signing package gpg:sign` to check if the signing works. You should get an output like
```text
[INFO] --- gpg:3.2.7:sign (default-cli) @ minify-maven-plugin ---
[INFO] Signer 'gpg' is signing 4 files with key 4FF41C5D!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
and you should have 8 `.asc` files in the `target` directory:
```text
minify-maven-plugin-1.7.10-SNAPSHOT-javadoc.jar.asc
minify-maven-plugin-1.7.10-SNAPSHOT-sources.jar.asc
minify-maven-plugin-1.7.10-SNAPSHOT.jar.asc
minify-maven-plugin-1.7.10-SNAPSHOT.pom.asc
minify-maven-plugin-1.7.10-javadoc.jar.asc
minify-maven-plugin-1.7.10-sources.jar.asc
minify-maven-plugin-1.7.10.jar.asc
minify-maven-plugin-1.7.10.pom.asc
```
You should be verify any file like this:
```shell
gpg --verify target/minify-maven-plugin-1.7.10-SNAPSHOT.jar.asc
```
and get an output like
```text
gpg: assuming signed data in 'target/minify-maven-plugin-1.7.10-SNAPSHOT.jar'
gpg: Signature made Mi 12 Dez 2024 07:09:19 CET
gpg:                using EDDSA key F1AA1D21D6C9FD73FFF9C5AD89ABA1774FF41C5D
gpg: Good signature from "Danny Developer (7P Mobility GmbH | Seven Principles AG) <danny.developer@7p-group.com>" [ultimate]
```

## Deploying a snapshot to Maven Central (OSSRH)

Currently the deployment is a manual process. Process:
1. Ensure that the project version ends with `SNAPSHOT`, e.g. `1.7.10-SNAPSHOT`
2. Run `mvn tidy:pom`
3. Check that the project compiles and all tests are green
4. Check that there are no uncommitted or unpushed changes
5. Execute `mvn deploy -DreleaseTargetAndDeploymentType=ossrh-snapshot -P minify-signing`

## Deploying a release to Maven Central (OSSRH)

Currently the deployment is a manual process. Process:
1. Ensure that the project version does not end with `SNAPSHOT`, i.e. it should be like `1.7.9`
2. Ensure that all documentation (`CHANGELOG.md`, `README.MD`) have the correct version strings and that all changes are documented
3. Run `mvn tidy:pom` (otherwise the release may fail)
4. Check that the project compiles and all tests are green
5. Check that there are no uncommitted or unpushed changes
6. Execute `mvn deploy -DreleaseTargetAndDeploymentType=ossrh-release -P minify-signing`
7. Tag the release with `minify-maven-plugin-${project.version}`, e.g. `minify-maven-plugin-1.7.9`
8. Push the tag
9. Log into https://oss.sonatype.org/ and close and release the staging repository (see https://central.sonatype.org/publish/release/)

### After releasing

1. Set the `pom.xml` version to the next snapshot version
2. Upload artifacts to GitHub releases
3. If there are any changes affecting site documentation, run `mvn clean site site:stage scm-publish:publish-scm`
4. Check that release is available at https://search.maven.org/artifact/com.7p-group/minify-maven-plugin

