##### MVP Wrap Library
Library to simplify working with multythreading in android project based on MVP arch pattern. 
You can find an example of using this library here: [sample](https://github.com/d-samoilov-nlt/mvpWrapLibrary/tree/master/app)

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.d-samoilov-nlt:mvpWrapLibrary:1.0'
	}
  ```
