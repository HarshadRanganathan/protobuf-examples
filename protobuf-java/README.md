## Java

Import the project using `build.gradle` file to add gradle support for the project.

On import, your IDE will automatically

-  download gradle using `gradle-wrapper`

-  download plugins and dependencies defined in `build.gradle`

Run `Build Project` to generate the java source files based on proto files available inside `src/main/proto` directory and automatically add them to your classpath.

Note: Generated source files will be available at `build/generated/source/proto/main/java` directory.

You can then run the java main program files available at `src/main/java` to work with the generated proto source files.