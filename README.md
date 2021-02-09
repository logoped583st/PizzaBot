# Pizza Bot App created with Kotlin multiplatform

## Main Parts:
- buildSrc
- PizzaBotCore
- PizzaBotConsole
- PizzaBotAndroid
- iosApp
- PizzaBotWeb

### buildSrc
Module build with Kotlin dsl and Kotlin
This module contains general gradle build configs.

### PizzaBotCore
Module build wih KMP.
This module contains main logic for input data processing, path processing, unit tests. 

### PizzaBotConsole
Module build with Kotlin JVM.
This module is used for output in console mode.

### PizzaBotAndroid
Module build with Kotlin Android.
This module is used for output in the android device.

### iosApp
Module build with Swift.
This module is used for output in the ios device.

### PizzaBotWeb
Module build with Kotlin-React
This module is used for output in the browser.

## How to run
expected pattern format 5x5 (1, 3) (4, 5) 
### PizzaBotConsole
1. chmod +x ./pizzaBot.sh <br/> ./pizzaBot.sh "5x5 (3, 4) (5, 5)" or just simple ./pizzaBot.sh and input data via console.
2. open project in IntelijIdea, open com.logoped583st.pizza_console.Main.kt, click run button.
3. Run units tests: gradle :PizzaBotCore:allTests or platform specific like :PizzaBotCore:jvmTest (jvmTest,jsTest,iosX64Test)
### PizzaBotAndroid
1. Open project in IntelijIdea or in Android Studio. Choose PizzaBotAndroid configuration, click run.

### iosApp
1. Open project in xCode (version used for development 11.3.1). Click run.

### PizzaBotWeb
1. Execute gradle command: gradle :PizzaBotWeb:run, open browser with url localhost:8080

##Notes
Some code can be perceived wrong inside IDE, because multi module projects based on KMP not fully supported by IntelijIdea and Android studio,
issues example: 
- https://youtrack.jetbrains.com/issue/KT-43924
- https://youtrack.jetbrains.com/issue/KT-30285