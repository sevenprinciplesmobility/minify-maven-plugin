# Minify Maven Plugin

Minify Maven Plugin combines and minimizes your CSS and JavaScript files for faster page loading. The plugin is compatible with all current Maven versions.

## Key features

- JavaScript and CSS Minification: Automatically compresses JS and CSS files as part of the Maven build lifecycle.
- Enhanced Load Times: Reduces the size of web assets, which can lead to faster web application performance.
- Customizable: Provides options to configure the minification process to better fit your project's specific requirements.
- Maven Integration: Designed specifically for use within Maven projects, ensuring smooth workflow integration.

## Origins and background

Under the hood, it uses the [YUI Compressor]([https://github.com/yui/yuicompressor](https://github.com/yui/yuicompressor)) and [Google Closure Compiler](https://developers.google.com/closure/compiler/) but has a layer of abstraction around these tools which allows for other tools to be added in the future.

Forked from https://github.com/samaxes/minify-maven-plugin in 2023 as the original version is apparently unmaintained. For changes in the forked version and earlier please see https://github.com/sevenprinciples/minify-maven-plugin/blob/main/CHANGELOG.md

## Benefits

### Reduce HTTP Requests

> 80% of the end-user response time is spent on the front-end. Most of this time is tied up in downloading all the components in the page: images, stylesheets, scripts, etc. Reducing the number of components in turn reduces the number of HTTP requests required to render the page. This is the key to faster pages.
>
> Combined files are a way to reduce the number of HTTP requests by combining all scripts into a single script, and similarly combining all CSS into a single stylesheet. Combining files is more challenging when the scripts and stylesheets vary from page to page, but making this part of your release process improves response times.

### Compress JavaScript and CSS

> Minification/compression is the practice of removing unnecessary characters from code to reduce its size thereby improving load times. A JavaScript compressor, in addition to removing comments and white-spaces, obfuscates local variables using the smallest possible variable name. This improves response time performance because the size of the downloaded file is reduced.

## Usage

Configure your project's `pom.xml` to run the plugin during the project's build cycle.

```xml
<build>
  <plugins>
    <plugin>
      <groupId>com.7p-group</groupId>
      <artifactId>minify-maven-plugin</artifactId>
      <version>1.7.8</version>
      <executions>
        <execution>
          <id>default-minify</id>
          <configuration>
            <charset>UTF-8</charset>
            <cssSourceFiles>
              <cssSourceFile>file-1.css</cssSourceFile>
              <!-- ... -->
              <cssSourceFile>file-n.css</cssSourceFile>
            </cssSourceFiles>
            <jsSourceFiles>
              <jsSourceFile>file-1.js</jsSourceFile>
              <!-- ... -->
              <jsSourceFile>file-n.js</jsSourceFile>
            </jsSourceFiles>
            <jsEngine>CLOSURE</jsEngine>
          </configuration>
          <goals>
            <goal>minify</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

This plugin requires Java 11.

## License

This distribution is licensed under the terms of the Apache License, Version 2.0 (see LICENSE.txt).
