![Static Badge](https://img.shields.io/badge/Android-green) 
![Static Badge](https://img.shields.io/badge/Kotlin-mauve)
![Static Badge](https://img.shields.io/badge/latest%20release:-1.1.0-red)
![Static Badge](https://img.shields.io/badge/jitpackio-black)



## datastore: Cache your data in Your Android App

This developer-friendly library simplifies store your data into data store instead of deprecated shared preferences.

Key Features:

 - Effortless Integration: Add the library to your project with just a few lines in your gradle files.
 - ease of use: don't panic for implementing a code for store some data if you are familier with shared preference you can use this library easily
 - Flexible Functionality: Choose between saving or retrieving (string, integer, double, float, byte array, boolean, long, set of strings).

# Getting Started:

## Set up Gradle:
 - Add this at the end of your repositories (**settings.gradle**)
    ```
    repositories {
        ....
        maven {
            url = uri("https://jitpack.io")
        }
    }
    ```
 - Add the dependency 
 
     ```
      dependencies {
            implementation "com.github.MohamedKandel:datastore:latest-release"
        }
    ```
# Simple Usage:

The library provides several convenient methods for saving and retrieving data:<br/>

 - ```putString(context: Context, key: String, value: String)```<br/>
   This method allow to save string into data store.<br/>
 - ```getString(context: Context, key: String): String?```<br/> Read the string which saved using its key.
 - ```removeStringValue(context: Context, key: String)```<br/> Remove saved string using its key.
 
 - ```putInt(context: Context, key: String, value: Int)```<br/>
   This method allow to save integer into data store.<br/>
 - ```getInt(context: Context, key: String): Int?```<br/> Read the integer which saved using its key.
 - ```removeIntValue(context: Context, key: String)```<br/> Remove saved integer using its key.
   
 - ```putBoolean(context: Context, key: String, value: Boolean)```<br/>
   This method allow to save boolean into data store.<br/>
 - ```getBoolean(context: Context, key: String): Boolean?```<br/> Read the boolean which saved using its key.
 - ```removeBooleanValue(context: Context, key: String)```<br/> Remove saved boolean value using its key.
  
 - ```putDouble(context: Context, key: String, value: Double)```<br/>
   This method allow to save double into data store.<br/>
 - ```getDouble(context: Context, key: String): Double?```<br/> Read the double which saved using its key.
 - ```removeDoubleValue(context: Context, key: String)```<br/> Remove saved double value using its key.
 
 - ```putFloat(context: Context, key: String, value: Float)```<br/>
   This method allow to save float into data store.<br/>
 - ```getFloat(context: Context, key: String): Float?```<br/> Read the float which saved using its key.
 - ```removeFloatValue(context: Context, key: String)```<br/> Remove saved float value using its key.

- ```putLong(context: Context, key: String, value: Long)```<br/>
   This method allow to save long into data store.<br/>
 - ```getLong(context: Context, key: String): Long?```<br/> Read the long which saved using its key.
 - ```removeLongValue(context: Context, key: String)```<br/> Remove saved long value using its key.

- ```putByteArray(context: Context, key: String, value: ByteArray)```<br/>
   This method allow to save byte array into data store.<br/>
 - ```getByteArray(context: Context, key: String): ByteArray?```<br/> Read the byte array which saved using its key.
 - ```removeByteArrayValue(context: Context, key: String)```<br/> Remove saved byte array using its key.

 - ```putStringSet(context: Context, key: String, value: Set<String>)```<br/>
   This method allow to save string set into data store.<br/>
 - ```getStringSet(context: Context, key: String): Set<String>?```<br/> Read the string set which saved using its key.
 - ```removeStringSetValue(context: Context, key: String)```<br/> Remove saved string set using its key.

 - ```clearAll(context: Context)```<br/> clear all saved values in datastore
    <br/><br/>
    
    ***Remember: Always use any method from this library in lifecycle scope.***
   ### Example:
     ```
    class MainActivity : AppCompatActivity() {

      private lateinit var binding: ActivityMainBinding

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          enableEdgeToEdge()
          binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)

          val key = "Key1"

          val ds = DataStorage.getInstance(context = this, name = "Any name") // name is optional -by default is the package name- only context is the required parameter
          lifecycleScope.launch {
              ds.putString(this@MainActivity, key, "Great Work !")
          }
          binding.txtView.setOnClickListener {
              lifecycleScope.launch {
                  Log.d("Data from ds",ds.getString(this@MainActivity, key)?:"No value found")
              }
          }
      }
    }
    ```
# Compatibility:

This library is compatible with Android versions from API 24 (Android 7) to API 34 (Android 14).

# Contact:

Developed by Mohamed Kandeel. Feel free to reach out via email (mohamed.hossam7799@gmail.com) with suggestions or feature requests.

Thank you for choosing datastore!
