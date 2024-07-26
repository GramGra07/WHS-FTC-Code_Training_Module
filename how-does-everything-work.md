# How does everything work?

There are a couple components to Android apps. These include the Gradle, actual code, and XML and setup files.

Best practice is to **not** modify the XML files that actually build your project and make it work. Gradle files on the other hand are meant to be modified.

## What is the Gradle?

The gradle is basically the file that tells the project everything you want to import. This allows the project to implement and import more complex things like Road Runner and FTC Dashboard. It is very important that anytime you modify these files, you make sure you only add to them or change versions slightly, as if something is broken, it compromises your project almost completely.&#x20;

Any new import you need from online will tell you **EXACTLY** where to put it and in which file, so please read it completely.&#x20;

### Common Mistakes

The common mistakes I see are the misplacing of lines of code in gradle files, incorrectly modifying existing files, or just accidentally deleting one on accident.

### How does it work?

You will perform a Gradle Sync to make sure your project is up to date with the imports and implementations in your gradle, which will make your imports switch from red to white when they haven't been synced yet. This allows for the project to "fetch" certain things from the internet and for you to use them in your code!
