MagicViews
==========
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.ivankocijan/MagicViews/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.ivankocijan/MagicViews)

Provides a simple way to set custom font in Android application. But, this is just a beginning. A lot of cool and awesome stuff is coming soon in this library.

![Screenshots](https://raw.github.com/ikocijan/MagicViews/master/screenshot.jpg)![Screenshots](https://raw.github.com/ikocijan/MagicViews/master/screenshoot_2.png)

## Usage

1) Add the library as a dependency to your ```build.gradle```

```groovy
compile 'com.ivankocijan:MagicViews:version@aar'
```

2) Add your application namespace to the root element in the XML
    <code>xmlns:app="http://schemas.android.com/apk/res-auto"</code> 

3) Specify path to fonts folder in onCreate method of your Application class (See example app). 

```java
   public class MyApplication extends Application {
   
        @Override
        public void onCreate() {
            super.onCreate();
            
             MagicViews.setFontFolderPath(this, "fontFolderPath");
        
        }
   
   }
   
   ```


4) Instead of TextView use <code>com.ivankocijan.magicviews.views.MagicTextView</code>

```xml
    <com.ivankocijan.magicviews.views.MagicTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:typeFace="cha_chicle.otf"/>
```

## Supported views
* TextView
* EditText
* Button
* CheckBox
* CheckedTextView
* PreferenceGroup
* Preference
* CheckboxPreference
* SwitchPreference
* EditTextPreference

## Supported Android versions
* 2.3 or higher

## Change log

V2.0.0

* Support for adding font folder path - Going through all assets to find appropriate font was too slow on some phones so as of this version you need to initialize MagicViews by telling the library where fonts will be located. You can do it by calling MagicViews.setFontFolderPath(Context ctx, String fontFolderPath) in onCreate method of your application class. This approach works approximately 70% faster. 
* Support for Android L - The library no longer clashes with new v7 and v4 libraries

## Contributing

Feedback and code contributions are very much welcomed. Just make a pull request with a short description of your changes. By making contributions to this project you give permission for your code to be used under the same [license](LICENSE).
    
