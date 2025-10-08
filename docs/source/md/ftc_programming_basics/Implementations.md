(implement)=
# Implementations

Implementations are the sole time in which you can edit your `.gradle` files. These files are the basis of how your project is built and how it works. You can add implementations to your project in order to add functionality to your project.

About 90% of the time, you will be adding implementations to the `build.gradle` file in the `app` folder. This is the file that contains all the implementations for your project.

Rarely will you need to add anything to `build.dependencies` or `settings.gradle`. 

Most of the time, the site you are installing from will contain detailed instructions on how to add the implementation to your project.

Usually, you will have to perform a **gradle sync**. This is a process that downloads the implementations and sets up your project. If it doesn't force you to, press this button ![](gradleSync.png) and wait for it to load.

## Common Implementations

* [FTC Dashboard](https://acmerobotics.github.io/ftc-dashboard/)
* {ref}`rr` 
* {ref}`pp`
* {ref}`ocv`
* [FTC Lib](https://docs.ftclib.org/ftclib/installation)
* (my library) {ref}`gau`