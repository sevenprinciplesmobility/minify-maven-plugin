# Minify Maven Plugin

## 1.7.9 (December 12th, 2024)

* Library and Maven plugin updates
* Minimum Java version set to 11, as Google Closure Compiler requires it
* Automatic dependency updates using Dependabot
* Modernized Maven Site (Fluido skin update, `site.xml` structure)
* Improved documentation
* Deployment is now done using Maven `maven-deploy-plugin` instead of `maven-release-plugin`
* Fixed Maven build warnings
* Added plugin and configuration for publishing Maven Site to Github Pages (replacing the ancient github-site-plugin)
* Added documentation for project contributors to deploy the project at https://github.com/sevenprinciplesmobility/minify-maven-plugin/blob/main/DEPLOYMENT.md

## 1.7.8 (May 19th, 2023)

* Fixed [issue #1 - Sourcemap files contain absolute paths](https://github.com/sevenprinciplesmobility/minify-maven-plugin/issues/1)

## 1.7.7 (March 27th, 2023)

* Forked from https://github.com/samaxes/minify-maven-plugin
* Fixed incompatibility with Maven Compiler Plugin 3.9 and later (see https://github.com/samaxes/minify-maven-plugin/issues/174 )
* Updated all libraries to their latest versions

## 1.7.6

* `<skipMerge>true</skipMerge>` overwrites same file multiple times (#130, #131, #132).

## 1.7.5

* Add support for external bundle configuration (#57).
* Replace `prerequisites` with Maven Enforcer plugin.
* Remove the deprecated oss-parent from `pom.xml` (See [OSSRH Apache Maven Guide](http://central.sonatype.org/pages/apache-maven.html)).
* Change suffix handling to permit alternative naming schemes (#68).
* Add support for Google Closure Compiler's warning levels (#74).
* Use Google Closure Compiler lightweight message formatter for printing compiler errors (#109, #110).
* Clearer error message when target directory creation fails (#42, #87, #116).
* Add configuration for Google Closure Compiler extra annotations (#83, #117).
* Update Google Closure Compiler to v20161024 (#119, #121).
* Minified file should be in the same directory as the merged file (#73).
* Add ES6 support (#128).
* Update YUI Compressor to 2.4.8 (#111).
* Enable colorized error output for Google Closure Compiler.
* Add support for @define replacements (#127).

## 1.7.4

* Update Google Closure Compiler to v20140814 (#71).
* Add support for Closure Library dependencies sorting (#70).
* Add option to use default externs provided with the Google Closure Compiler (#67).

## 1.7.3

* Improve docs: missing information about file order (#45).
* Select the JVM default charset as the value for the `charset` option when none is defined (#48).
* Add a warning message to `nosuffix` option Javadoc (#50).
* Add support for JavaScript Source Maps (#41).
* Update Google Closure Compiler to v20140625.
* Add support for Google Closure Compiler `angular_pass` option (#60).
* Rename `yuiLinebreak` option to `yuiLineBreak`.
* Rename `yuiMunge` option to `yuiNoMunge`.
* Rename `yuiPreserveAllSemiColons` option to `yuiPreserveSemicolons`.
* Fail build when a specified source file is not found (#53).

## 1.7.2

* Update default `charset` value to `${project.build.sourceEncoding}`.
* Deprecate the option `debug`. `verbose` should be used instead.
* Change YUI option's names to clearly indicate that they are specific to YUI Compressor.
* Update Google Closure Compiler to v20130823.
* Add support for Google Closure Compiler `language` option (#24).
* Add support for Google Closure Compiler `compilation_level` option.
* Add support for Google Closure Compiler `externs` option (#22).
* Fail build with Google Closure Compiler on parse errors.

## 1.7.1

* Update Google Closure Compiler to v20130722.
* Preserve sub-directory structure when only minifying (#29).
* Delete transient `.tmp` file on spot in case of `nosuffix = true` (#32).
* Use annotations to generate the plugin descriptor file.

## 1.7

* Add `nosuffix` option to avoid the suffix `.min` on the minified output file name (#16).
* Option to use same subdirectory on target as in source (#17).
* Build should fail if compiler can't parse/compile source files (#19).
* Add `UTF-8` as the default charset.
* Log compression gains.
* Require Java SE 7 for better resource management. See [AutoCloseable](http://docs.oracle.com/javase/7/docs/api/java/lang/AutoCloseable.html) interface and [try-with-resources](http://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html) statements.

## 1.6.2

* Add `nosuffix` option to avoid the suffix `.min` on the minified output file name (Cherry picked from 31fe5c91bf2d24c29251595206c3c4ebada1c712).

## 1.6.1

* Preserve sub-directory structure when only minifying (Cherry picked from commit 924a23a373e6b9aa841af6b9e4300c670eb602aa).

## 1.6

* Add support for [Google Closure Compiler](https://developers.google.com/closure/compiler/) for JavaScript compression (#14).

## 1.5.2

* New goal parameter to log full source file paths and new FAQ entry pointing to the plugin goal parameters (#5).
* Option to skip the minify step (#11).
* Option to skip the merge step (#13).

## 1.5.1

* Cannot process the same file name of files in different directories (#2).
* CSS minification fails for base64 encoded background images (#3).

## 1.5

* Fix charset issue (#1).
* Update Maven site skin.
* Use `ExecutorService` to wait for all tasks to finish.
* Add support for CLI-based configuration and Maven 2.2.1. From [Configuring Plugin Goals in Maven 3](http://www.sonatype.com/people/2011/03/configuring-plugin-goals-in-maven-3/):

  > For many plugin parameters it is occasionally convenient to specify their values from the command line via system properties. In the past, this was limited to parameters of simple types like `String` or `Boolean`. The latest Maven release finally allows plugin users to configure collections or arrays from the command line via comma-separated strings. Take for example a plugin parameter like this:
  >
  > ```java
  > /** @parameter expression="${includes}" */
  > String[] includes;
  > ```
  >
  > This can be configured from the command line as follows:
  >
  > ```sh
  > mvn <goal> -Dincludes=Foo,Bar
  > ```
  >
  > Plugin authors that wish to enable CLI-based configuration of arrays/collections just need to add the `expression` tag to their parameter annotation. Note that if compatibility with older Maven versions is to be kept, the parameter type must not be an interface but a concrete collection class or an array to avoid another shortcoming in the old configurator.

## 1.4

* Move from http://code.google.com/p/maven-samaxes-plugin/ to https://github.com/samaxes/minify-maven-plugin.
* Add Maven Integration for Eclipse (M2E) lifecycle mapping metadata.
* Rename project from Maven Minify Plugin to Minify Maven Plugin:

  > Artifact Ids of the format maven-___-plugin are reserved for  
  > plugins in the Group Id org.apache.maven.plugins  
  > Please change your artifactId to the format ___-maven-plugin  
  > In the future this error will break the build.

## 1.3.5

* Lift restriction that prevented the final file name to be the same as an existing source file name.

## 1.3.4

* Update YUI Compressor to version 2.4.6.

## 1.3.3

* Add debug messages for wrong source file names and source directory paths.

## 1.3.2

* Add `cssTargetDir`, `jsTargetDir`, `suffix`, and `charset` parameters.

## 1.3.1

* Class `java.util.List` cannot be instantiated while running Maven minify goal with versions previous to 3.0.

## 1.3

* Change exclude/include patterns from a comma separated `String` to `List<String>`. Also included a custom file comparator that only compares the file name instead of the full file path.
* Update [YUI Compressor](http://yui.github.io/yuicompressor/) dependency to version 2.4.2.

## 1.2.1

* Don't crash with an `IndexOutOfBoundsException` when a source file does not exist.
* More accurate logging.
* Configure POM to inherit from Sonatype OSS Parent POM.

## 1.2

* Add exclude/include patterns, with the caveat that the developer must name their source files so their lexicographical order is correct for minifying.
* Don't minify a file type if the list of files to process is empty.
* Make JavaScript minify error messages clearer.
* Make file extensions configurable (e.g. it's now possible to save a JavaScript file as `*.jsp` or `*.php`).
* Compile against JDK 1.5 instead of JDK 1.6.
